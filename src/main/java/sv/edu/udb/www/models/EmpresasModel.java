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

            Query consulta = em.createQuery("SELECT e FROM EmpresasEntity e");

            List<EmpresasEntity> listaEmpresas = consulta.getResultList();
            em.close();
            return listaEmpresas;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int eliminarEmpre(String idEmpresa) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            EmpresasEntity emp = em.find(EmpresasEntity.class, idEmpresa);
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



    public int insertarEmpresa(EmpresasEntity empresa) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.persist(empresa); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }


    public EmpresasEntity obtenerEmpresaPorId(String idEmpresa) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(EmpresasEntity.class, idEmpresa);
        } finally {
            em.close();
        }
    }

    public EmpresasEntity actualizarEmpresa(EmpresasEntity empresa) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        EmpresasEntity empresaActualizada = null;

        try {
            transaction.begin();
            // Obtener la entidad persistente de la base de datos
            EmpresasEntity entidadPersistente = em.find(EmpresasEntity.class, empresa.getIdEmpresa());

            if (entidadPersistente != null) {
                // Actualizar los campos de la entidad persistente con los valores del objeto recibido
                entidadPersistente.setNombreEmpresa(empresa.getNombreEmpresa());
                entidadPersistente.setDescripcionEmpresa(empresa.getDescripcionEmpresa());
                entidadPersistente.setFotoEmpresa(empresa.getFotoEmpresa());
                entidadPersistente.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
                entidadPersistente.setDescripcionEmpresa(empresa.getDescripcionEmpresa());
                entidadPersistente.setCorreoEmpresa(empresa.getCorreoEmpresa());
                entidadPersistente.setContraseñaEmpresa(empresa.getContraseñaEmpresa());
                entidadPersistente.setEstadoEmpresa(empresa.getEstadoEmpresa());
                entidadPersistente.setRol(empresa.getRol());
                // Actualiza los demás campos de la entidad de manera similar

                // Actualizar la entidad persistente en el contexto de persistencia
                empresaActualizada = em.merge(entidadPersistente);
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

        return empresaActualizada;
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
