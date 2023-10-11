package sv.edu.udb.www.models;
import jakarta.persistence.NoResultException;
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
}
