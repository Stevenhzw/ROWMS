package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.EmpresasEntity;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.models.DependientesModel;
import sv.edu.udb.www.models.EmpresasModel;
import sv.edu.udb.www.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class EmpresaBean {

    EmpresasModel modelo = new EmpresasModel();
    private List<UsuariosEntity> listaEmpresas;

    private String filtro;
    private List<EmpresasEntity> listaEmpresasFiltrada;

    public EmpresaBean() {
        listaEmpresasFiltrada = modelo.listarEmpresas();
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
        // Actualiza la lista de dependientes filtrada cada vez que cambia el filtro
        listaEmpresasFiltrada = modelo.buscarEmpresas(filtro);
    }

    public List<EmpresasEntity> getListaEmpresasFiltrada() {
        return listaEmpresasFiltrada;
    }

    public List<EmpresasEntity> getListaEmpresas() {
        // Llama al método en el modelo para obtener la lista de empresas
        // Por ejemplo, podrías usar EmpresaModel.listarEmpresas()
        return modelo.listarEmpresas();
    }
}
