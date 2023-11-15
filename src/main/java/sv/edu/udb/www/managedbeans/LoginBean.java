package sv.edu.udb.www.managedbeans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import sv.edu.udb.www.entities.EmpresasEntity;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.models.EmpresasModel;
import sv.edu.udb.www.models.UsuariosModel;
import sv.edu.udb.www.utils.JpaUtil;
import sv.edu.udb.www.utils.JsfUtil;
import java.io.Serializable;


@Named
@SessionScoped
public class LoginBean implements Serializable {

    UsuariosModel modelo = new UsuariosModel();
    EmpresasModel modeloE = new EmpresasModel();
    private UsuariosEntity usuario2;
    private String correo;
    private String contraseña;
    private UsuariosEntity usuarioAutenticado;
    private EmpresasEntity empresaAutenticada;
    private boolean sesionIniciada = false;

    public LoginBean() {
        usuario2 = new UsuariosEntity();
    }

    public String iniciarSesion() {
        UsuariosEntity usuario = modelo.obtenerUsuario(correo, contraseña);

        if (usuario != null) {
            usuarioAutenticado = usuario;
            sesionIniciada = true;
            return "index?faces-redirect=true";
        } else {
            EmpresasEntity empresa = modeloE.obtenerEmpresa(correo, contraseña);
            if (empresa != null){
                empresaAutenticada = empresa;
                sesionIniciada = true;
                return "index?faces-redirect=true";
            }else {
                JsfUtil.setErrorMessage(null, "Correo o contraseña incorrectos");
                return null;
            }
        }
    }

    public String cerrarSesion() {

        sesionIniciada = false;
        usuarioAutenticado = null;
        empresaAutenticada = null;

        return "index?faces-redirect=true";
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

    public UsuariosEntity getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public EmpresasEntity getEmpresaAutenticada() {
        return empresaAutenticada;
    }

    public UsuariosEntity getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(UsuariosEntity usuario2) {
        this.usuario2 = usuario2;
    }
}
