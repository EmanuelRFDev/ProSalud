
package com.mycompany.consultoriomedico.persistencia;

import com.mycompany.consultoriomedico.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Doctor;

public class DoctorJpaController implements Serializable {

    public DoctorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public DoctorJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioDoctorlogico_PU");
    }
    
    public void create(Doctor doctorlogo) {
        if (doctorlogo.getListaTurnos() == null) {
            doctorlogo.setListaTurnos(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedListaTurnos = new ArrayList<Turno>();
            for (Turno listaTurnosTurnoToAttach : doctorlogo.getListaTurnos()) {
                listaTurnosTurnoToAttach = em.getReference(listaTurnosTurnoToAttach.getClass(), listaTurnosTurnoToAttach.getId_turno());
                attachedListaTurnos.add(listaTurnosTurnoToAttach);
            }
            doctorlogo.setListaTurnos(attachedListaTurnos);
            em.persist(doctorlogo);
            for (Turno listaTurnosTurno : doctorlogo.getListaTurnos()) {
                Doctor oldDoctorOfListaTurnosTurno = listaTurnosTurno.getDoctor();
                listaTurnosTurno.setDoctor(doctorlogo);
                listaTurnosTurno = em.merge(listaTurnosTurno);
                if (oldDoctorOfListaTurnosTurno != null) {
                    oldDoctorOfListaTurnosTurno.getListaTurnos().remove(listaTurnosTurno);
                    oldDoctorOfListaTurnosTurno = em.merge(oldDoctorOfListaTurnosTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Doctor doctorlogo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor persistentDoctor = em.find(Doctor.class, doctorlogo.getId());
            List<Turno> listaTurnosOld = persistentDoctor.getListaTurnos();
            List<Turno> listaTurnosNew = doctorlogo.getListaTurnos();
            List<Turno> attachedListaTurnosNew = new ArrayList<Turno>();
            for (Turno listaTurnosNewTurnoToAttach : listaTurnosNew) {
                listaTurnosNewTurnoToAttach = em.getReference(listaTurnosNewTurnoToAttach.getClass(), listaTurnosNewTurnoToAttach.getId_turno());
                attachedListaTurnosNew.add(listaTurnosNewTurnoToAttach);
            }
            listaTurnosNew = attachedListaTurnosNew;
            doctorlogo.setListaTurnos(listaTurnosNew);
            doctorlogo = em.merge(doctorlogo);
            for (Turno listaTurnosOldTurno : listaTurnosOld) {
                if (!listaTurnosNew.contains(listaTurnosOldTurno)) {
                    listaTurnosOldTurno.setDoctor(null);
                    listaTurnosOldTurno = em.merge(listaTurnosOldTurno);
                }
            }
            for (Turno listaTurnosNewTurno : listaTurnosNew) {
                if (!listaTurnosOld.contains(listaTurnosNewTurno)) {
                    Doctor oldDoctorOfListaTurnosNewTurno = listaTurnosNewTurno.getDoctor();
                    listaTurnosNewTurno.setDoctor(doctorlogo);
                    listaTurnosNewTurno = em.merge(listaTurnosNewTurno);
                    if (oldDoctorOfListaTurnosNewTurno != null && !oldDoctorOfListaTurnosNewTurno.equals(doctorlogo)) {
                        oldDoctorOfListaTurnosNewTurno.getListaTurnos().remove(listaTurnosNewTurno);
                        oldDoctorOfListaTurnosNewTurno = em.merge(oldDoctorOfListaTurnosNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = doctorlogo.getId();
                if (findDoctor(id) == null) {
                    throw new NonexistentEntityException("The doctorlogo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor doctorlogo;
            try {
                doctorlogo = em.getReference(Doctor.class, id);
                doctorlogo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The doctorlogo with id " + id + " no longer exists.", enfe);
            }
            List<Turno> listaTurnos = doctorlogo.getListaTurnos();
            for (Turno listaTurnosTurno : listaTurnos) {
                listaTurnosTurno.setDoctor(null);
                listaTurnosTurno = em.merge(listaTurnosTurno);
            }
            em.remove(doctorlogo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Doctor> findDoctorEntities() {
        return findDoctorEntities(true, -1, -1);
    }

    public List<Doctor> findDoctorEntities(int maxResults, int firstResult) {
        return findDoctorEntities(false, maxResults, firstResult);
    }

    private List<Doctor> findDoctorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Doctor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Doctor findDoctor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Doctor.class, id);
        } finally {
            em.close();
        }
    }

    public int getDoctorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Doctor> rt = cq.from(Doctor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
