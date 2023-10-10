package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.EmpresasEntity;
import sv.edu.udb.www.utils.JpaUtil;
import sv.edu.udb.www.entities.UsuariosEntity;

import java.util.List;

public class DependientesModel {
    public List<UsuariosEntity> listarDependientes() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            System.out.println("Iniciando consulta JPQL...");
            // Utiliza una consulta JPQL para obtener la lista de empresas
            Query consulta = em.createQuery("SELECT e FROM UsuariosEntity e");

            List<UsuariosEntity> listaDependientes = consulta.getResultList();
            System.out.println("Consulta JPQL completada con éxito. Número de resultados: " + listaDependientes.size());
            return listaDependientes;
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la consulta
            e.printStackTrace();
            System.err.println("Error al ejecutar la consulta JPQL: " + e.getMessage());
            return null;
        } finally {
            em.close(); // Cierra el EntityManager cuando hayas terminado
        }
    }



    public List<UsuariosEntity> buscarDependientes(String filtro) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            // Utiliza una consulta JPQL con un filtro
            Query consulta = em.createQuery("SELECT e FROM UsuariosEntity e " +
                    "WHERE LOWER(e.nombre) LIKE :filtro " +
                    "OR LOWER(e.dui) LIKE :filtro " +
                    "OR LOWER(e.correo) LIKE :filtro " +
                    "OR LOWER(e.apellido) LIKE :filtro " +
                    "OR LOWER(e.rol) LIKE :filtro " +
                    "OR LOWER(e.direccion) LIKE :filtro");
            consulta.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

            List<UsuariosEntity> listaDependientesFiltrada = consulta.getResultList();
            return listaDependientesFiltrada;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al ejecutar la consulta JPQL: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
