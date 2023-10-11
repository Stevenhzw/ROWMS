package sv.edu.udb.www.models;
import jakarta.persistence.NoResultException;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.EmpresasEntity;

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


    public List<EmpresasEntity> buscarEmpresas(String filtro) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            // Utiliza una consulta JPQL con un filtro
            Query consulta = em.createQuery("SELECT e FROM EmpresasEntity e " +
                    "WHERE LOWER(e.nombreEmpresa) LIKE :filtro " +
                    "OR LOWER(e.idEmpresa) LIKE :filtro " +
                    "OR LOWER(e.correoEmpresa) LIKE :filtro " +
                    "OR LOWER(e.direccionEmpresa) LIKE :filtro " +
                    "OR LOWER(e.descripcionEmpresa) LIKE :filtro ");
            consulta.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

            List<EmpresasEntity> listaEmpresasFiltrada = consulta.getResultList();
            return listaEmpresasFiltrada;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al ejecutar la consulta JPQL: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public EmpresasEntity obtenerEmpresa(String correo, String contraseña) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EmpresasEntity empresa = em.createNamedQuery("EmpresasEntity.findByCorreoEmpresa", EmpresasEntity.class)
                    .setParameter("correoEmpresa", correo)
                    .getSingleResult();

            if (empresa != null && empresa.getContraseñaEmpresa().equals(contraseña)) {
                return empresa;
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
