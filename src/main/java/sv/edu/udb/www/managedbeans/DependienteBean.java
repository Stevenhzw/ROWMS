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
    private List<UsuariosEntity> listaDependientes;

    private String filtro;
    private List<UsuariosEntity> listaDependientesFiltrada;

    public DependienteBean() {
        listaDependientesFiltrada = modelo.listarDependientes();
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
        // Actualiza la lista de dependientes filtrada cada vez que cambia el filtro
        listaDependientesFiltrada = modelo.buscarDependientes(filtro);
    }

    public List<UsuariosEntity> getListaDependientesFiltrada() {
        return listaDependientesFiltrada;
    }




    public List<UsuariosEntity> getListaDependientes() {
        // Llama al método en el modelo para obtener la lista de empresas
        // Por ejemplo, podrías usar EmpresaModel.listarEmpresas()
        return modelo.listarDependientes();
    }
}
