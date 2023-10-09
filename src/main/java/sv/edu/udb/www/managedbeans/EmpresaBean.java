package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.models.EmpresasModel;

import java.util.List;
@ManagedBean
@RequestScoped
public class EmpresaBean {

    EmpresasModel modelo = new EmpresasModel();
    private List<EmpresasEntity> listaEmpresas;

    public List<EmpresasEntity> getListaEmpresas() {
        // Llama al método en el modelo para obtener la lista de empresas
        // Por ejemplo, podrías usar EmpresaModel.listarEmpresas()
        return modelo.listarEmpresas();
    }
}
