package sv.edu.udb.www.models;

//Este he cambiado

import jakarta.persistence.NoResultException;
import sv.edu.udb.www.entities.AplicantesEntity;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.UsuariosEntity;
public class UsuariosModel {

    public UsuariosEntity obtenerUsuario(String correo, String contraseña) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            UsuariosEntity usuario = em.createNamedQuery("UsuariosEntity.findByCorreo", UsuariosEntity.class)
                    .setParameter("correo", correo)
                    .getSingleResult();

            if (usuario != null && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            } else {
                return null;  // Retorna null si no se encuentra un usuario o la contraseña no coincide
            }
        } catch (NoResultException e) {
            return null;  // Retorna null si no se encuentra un usuario
        } finally {
            em.close();
        }
    }

    public int insertarUsuario(UsuariosEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.persist(usuario); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }


    public List<AplicantesEntity> listarAplicaciones_Usuario(String dui){
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery(
                        "SELECT a FROM AplicantesEntity a WHERE a.duiAplicante = :dui", AplicantesEntity.class)
                .setParameter("dui", dui)
                .getResultList();
    }




}
