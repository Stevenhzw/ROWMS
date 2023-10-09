package sv.edu.udb.www.models;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EmpresasModel {
    public List<EmpresasEntity> listarEmpresas() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            // Utiliza una consulta JPQL para obtener la lista de empresas
            Query consulta = em.createQuery("SELECT e FROM EmpresasEntity e");
            List<EmpresasEntity> listaEmpresas = consulta.getResultList();
            return listaEmpresas;
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la consulta
            e.printStackTrace();
            return null;
        } finally {
            em.close(); // Cierra el EntityManager cuando hayas terminado
        }
    }
}
