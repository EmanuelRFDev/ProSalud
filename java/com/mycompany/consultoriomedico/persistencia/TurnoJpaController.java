
package com.mycompany.consultoriomedico.persistencia;

import com.mycompany.consultoriomedico.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Doctor;
import logica.Paciente;
import logica.Turno;

public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioDoctorlogico_PU");
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor doctor = turno.getDoctor();
            if (doctor != null) {
                doctor = em.getReference(doctor.getClass(), doctor.getId());
                turno.setDoctor(doctor);
            }
            Paciente pacien = turno.getPacien();
            if (pacien != null) {
                pacien = em.getReference(pacien.getClass(), pacien.getId());
                turno.setPacien(pacien);
            }
            em.persist(turno);
            if (doctor != null) {
                doctor.getListaTurnos().add(turno);
                doctor = em.merge(doctor);
            }
            if (pacien != null) {
                pacien.getListaTurnos().add(turno);
                pacien = em.merge(pacien);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getId_turno());
            Doctor doctorOld = persistentTurno.getDoctor();
            Doctor doctorNew = turno.getDoctor();
            Paciente pacienOld = persistentTurno.getPacien();
            Paciente pacienNew = turno.getPacien();
            if (doctorNew != null) {
                doctorNew = em.getReference(doctorNew.getClass(), doctorNew.getId());
                turno.setDoctor(doctorNew);
            }
            if (pacienNew != null) {
                pacienNew = em.getReference(pacienNew.getClass(), pacienNew.getId());
                turno.setPacien(pacienNew);
            }
            turno = em.merge(turno);
            if (doctorOld != null && !doctorOld.equals(doctorNew)) {
                doctorOld.getListaTurnos().remove(turno);
                doctorOld = em.merge(doctorOld);
            }
            if (doctorNew != null && !doctorNew.equals(doctorOld)) {
                doctorNew.getListaTurnos().add(turno);
                doctorNew = em.merge(doctorNew);
            }
            if (pacienOld != null && !pacienOld.equals(pacienNew)) {
                pacienOld.getListaTurnos().remove(turno);
                pacienOld = em.merge(pacienOld);
            }
            if (pacienNew != null && !pacienNew.equals(pacienOld)) {
                pacienNew.getListaTurnos().add(turno);
                pacienNew = em.merge(pacienNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turno.getId_turno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId_turno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Doctor doctor = turno.getDoctor();
            if (doctor != null) {
                doctor.getListaTurnos().remove(turno);
                doctor = em.merge(doctor);
            }
            Paciente pacien = turno.getPacien();
            if (pacien != null) {
                pacien.getListaTurnos().remove(turno);
                pacien = em.merge(pacien);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
