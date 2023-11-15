package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.PlazasEntity;

import sv.edu.udb.www.models.PlazaModel;
import sv.edu.udb.www.utils.JsfUtil;
import java.util.List;

@ManagedBean
@RequestScoped
public class PlazaBean {

    private PlazasEntity plaza;
    PlazaModel modelo = new PlazaModel();



    private List<PlazasEntity> listaPlazas;


    public PlazaBean() {
        plaza = new PlazasEntity();
    }

    public List<PlazasEntity> getPlazas() {
        return modelo.listarPlazas();
    }

    public PlazasEntity getPlaza() {
        return plaza;
    }

    public void setPlazaEntity(PlazasEntity plaza) {
        this.plaza = plaza;
    }

    public String guardarPlaza(){
        //INDICAR EL JSFIntroPU donde se ubica UnsupportedElement JsfUtil;
        if (modelo.insertarPlaza(plaza) != 1) {
            JsfUtil.setErrorMessage(null, "Error: no se pudo insertar la plaza, revisa que los campos esten correctos");
        } else {
            JsfUtil.setFlashMessage("exito", "Plaza registrada exitosamente");

        }
        return "empresa";
    }


    public PlazaModel getPlazaModel() {
        return modelo;
    }

    public String cargarPlaza(String idPlaza) {
        this.plaza = modelo.obtenerPlazaPorId(idPlaza);
        return "EditarPlaza"; // Redirige a una página de edición
    }

    public String eliminarPlaza(String idPlaza) {

        if (modelo.eliminarPlaza(idPlaza) > 0) {
            JsfUtil.setFlashMessage("exito", "Plaza eliminada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a esta plaza");
        }
        // Redirige a la misma página después de eliminar
        return "CrearPlaza";
    }

    public String actualizarPlaza() {
        if (modelo.actualizarPlaza(plaza) != null) {
            JsfUtil.setFlashMessage("exito", "Plaza actualizada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo actualizar la plaza");
        }
        return "empresa"; // Redirige de vuelta a la lista de empresas
    }

}
