package sv.edu.udb.www.models;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.EmpresasEntity;
import sv.edu.udb.www.entities.UsuariosEntity;

public class EmpresasModel {
    public List<EmpresasEntity> listarEmpresas() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            System.out.println("Iniciando consulta JPQL...");
            // Utiliza una consulta JPQL para obtener la lista de empresas
            Query consulta = em.createQuery("SELECT e FROM EmpresasEntity e");

            List<EmpresasEntity> listaEmpresas = consulta.getResultList();
            System.out.println("Consulta JPQL completada con éxito. Número de resultados: " + listaEmpresas.size());
            return listaEmpresas;
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la consulta
            e.printStackTrace();
            System.err.println("Error al ejecutar la consulta JPQL: " + e.getMessage());
            return null;
        } finally {
            em.close(); // Cierra el EntityManager cuando hayas terminado
        }
    }

}
