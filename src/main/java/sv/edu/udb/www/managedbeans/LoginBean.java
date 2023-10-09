package sv.edu.udb.www.managedbeans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.utils.JpaUtil;

@Named
@RequestScoped
public class LoginBean {
    private String correo;
    private String contraseña;

    public String iniciarSesion() {
        EntityManager em = JpaUtil.getEntityManager();
        UsuariosEntity usuario = em.createNamedQuery("UsuariosEntity.findByCorreo", UsuariosEntity.class)
                .setParameter("correo", correo)
                .getSingleResult();

        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            return "inicio?faces-redirect=true"; // Reemplaza "inicio" con el nombre de tu página de inicio
        } else {
            return "error?faces-redirect=true"; // Reemplaza "error" con el nombre de tu página de error
        }
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
