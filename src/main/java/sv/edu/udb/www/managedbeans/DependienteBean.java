package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.models.DependientesModel;
import sv.edu.udb.www.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class DependienteBean {
    DependientesModel modelo = new DependientesModel();

    private UsuariosEntity usuario;
    private List<UsuariosEntity> listaDependientes;

    public DependienteBean() {
        usuario = new UsuariosEntity();
    }
    public List<UsuariosEntity> getUsuarios() {
        return modelo.listarDependientes();
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuarioEntity(UsuariosEntity usuario) {
        this.usuario = usuario;
    }



}
