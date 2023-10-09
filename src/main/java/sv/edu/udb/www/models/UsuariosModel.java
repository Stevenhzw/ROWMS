package sv.edu.udb.www.models;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.UsuariosEntity;
public class UsuariosModel {

    public UsuariosEntity obtenerUsuario(String correo) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Recupero el objeto desde la BD a través del método find
            UsuariosEntity usuario = em.find(UsuariosEntity.class, correo);
            em.close();
            return usuario;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
}
