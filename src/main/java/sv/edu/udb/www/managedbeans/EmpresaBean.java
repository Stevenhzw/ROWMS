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

    private EmpresasEntity empresa;
    EmpresasModel modelo = new EmpresasModel();
    private List<EmpresasEntity> listaEmpresas;

    public EmpresaBean() {
        empresa = new EmpresasEntity();
    }

    //Guardar un empleado en la base de datos
    public String guardarEmpresa(){
        //INDICAR EL JSFIntroPU donde se ubica UnsupportedElement JsfUtil;
        if (modelo.insertarEmpresa(empresa) != 1) {
            JsfUtil.setErrorMessage(null, "Error: no se pudo insertar al empresa");
        } else {
            JsfUtil.setFlashMessage("exito", "empresa registrada exitosamente");
            //Forzando la redirección en el cliente
        }
        return "empresa";
    }

    public String cargarEmpresa(String idEmpresa) {
        this.empresa = modelo.obtenerEmpresaPorId(idEmpresa);
        return "editarEmpresa"; // Redirige a una página de edición
    }

    public String verEmpresa(String idEmpresa) {
        this.empresa = modelo.obtenerEmpresaPorId(idEmpresa);
        return "verEmpresa"; // Redirige a una página de edición
    }

    public String actualizarEmpresa() {
        if (modelo.actualizarEmpresa(empresa) != null) {
            JsfUtil.setFlashMessage("exito", "Empresa actualizada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo actualizar la empresa");
        }
        return "empresa"; // Redirige de vuelta a la lista de empresas
    }


    public String eliminarEmpresa(String idEmpresa) {

        if (modelo.eliminarEmpre(idEmpresa) > 0) {
            JsfUtil.setFlashMessage("exito", "Empresa eliminada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a esta empresa");
        }
        // Redirige a la misma página después de eliminar
            return "empresa";
        }
    public EmpresasModel getEmpresasModel() {
        return modelo;
    }




    public List<EmpresasEntity> getListaEmpresas() {
        return modelo.listarEmpresas();
    }

















    public List<EmpresasEntity> getEmpresas() {
        return modelo.listarEmpresas();
    }

    public EmpresasEntity getEmpresa() {
        return empresa;
    }



}
