package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.inject.Inject;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.models.UsuariosModel;
import sv.edu.udb.www.utils.JsfUtil;
import java.util.List;

@ManagedBean
@RequestScoped
public class UsuariosBean {

    private int contador = 0;

    UsuariosModel modelo = new UsuariosModel();

    public UsuariosModel getUsuariosModel() {
        return modelo;
    }

    private UsuariosEntity usuario;
    private List<UsuariosEntity> listaUsuarios;

    public UsuariosBean() {
        usuario = new UsuariosEntity();
    }
    public UsuariosEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    @Inject
    private LoginBean loginBean;

    /*public List<UsuariosEntity> getListaUsuarios(){
        return modelo.listarUsuarios();
    }
     */

    public int getContador() {
        contador++;
        return contador;
    }

    public String registrarNuevoAplicante(){
        usuario.setEmpresaAfiliada(null);
        usuario.setEstado("1");
        usuario.setRol("Aplicante");
        usuario.setFoto(null);

        if (modelo.insertarUsuario(usuario) != 1) {
            JsfUtil.setErrorMessage("error", "El usuario no se ha podido registrar.");
            return null;

        } else {
            JsfUtil.setFlashMessage("exito", "Usuario registrado exitosamente");
            //Forzando la redirección en el cliente

            loginBean.setCorreo(usuario.getCorreo());
            loginBean.setContraseña(usuario.getContraseña());
            loginBean.iniciarSesion();
            return "index?faces-redirect=true";
        }
    }

    public String registrarNuevoDependiente(String idEmpresa){
        usuario.setEmpresaAfiliada(null);
        usuario.setEstado("1");
        usuario.setRol("dependiente");
        usuario.setEmpresaAfiliada(idEmpresa);
        usuario.setFoto(null);

        if (modelo.insertarUsuario(usuario) != 1) {
            JsfUtil.setErrorMessage("error", "El usuario no se ha podido registrar.");
            return null;

        } else {
            JsfUtil.setFlashMessage("exito", "Usuario registrado exitosamente");
            //Forzando la redirección en el cliente
            return "index?faces-redirect=true";
        }
    }

}