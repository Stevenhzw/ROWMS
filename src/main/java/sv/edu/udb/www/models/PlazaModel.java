package sv.edu.udb.www.models;
import jakarta.persistence.NoResultException;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.PlazasEntity;



public class PlazaModel {



    public List<PlazasEntity> listarPlazas() {
        EntityManager em = JpaUtil.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT e FROM PlazasEntity e");

            List<PlazasEntity> listaPlazas = consulta.getResultList();
            em.close();
            return listaPlazas;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int insertarPlaza(PlazasEntity plaza) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.persist(plaza); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }


    public PlazasEntity obtenerPlazaPorId(String idPlaza) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(PlazasEntity.class, idPlaza);
        } finally {
            em.close();
        }
    }

    public int eliminarPlaza(String idPlaza) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            PlazasEntity emp = em.find(PlazasEntity.class, idPlaza);
            if (emp != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(emp);
                tran.commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public PlazasEntity actualizarPlaza(PlazasEntity plaza) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        PlazasEntity plazaActualizada = null;

        try {
            transaction.begin();
            // Obtener la entidad persistente de la base de datos
            PlazasEntity entidadPersistente = em.find(PlazasEntity.class, plaza.getIdPlaza());

            if (entidadPersistente != null) {
                // Actualizar los campos de la entidad persistente con los valores del objeto recibido

                entidadPersistente.setNombrePlaza(plaza.getNombrePlaza());
                entidadPersistente.setDescripcionPlaza(plaza.getDescripcionPlaza());

                plazaActualizada = em.merge(entidadPersistente);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the exception for debugging purposes
        } finally {
            em.close();
        }

        return plazaActualizada;
    }
}
