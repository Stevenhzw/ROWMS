package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.PlazasEntity;
import sv.edu.udb.www.models.PlazaModel;
import sv.edu.udb.www.utils.JsfUtil;

import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@RequestScoped
public class PlazaBean{

    private PlazasEntity plaza;
    PlazaModel modelo = new PlazaModel();

    private List<PlazasEntity> listaPlazas;

    public PlazaBean() {
        plaza = new PlazasEntity();
    }

    public List<PlazasEntity> getPlazas() {
        return modelo.listarPlazas();
    }

    public List<PlazasEntity> getPlazasFiltradasEstado5() {
        // Filtra las plazas con estado 5
        return modelo.listarPlazas().stream()
                .filter(plaza -> "5".equals(plaza.getEstadoPlaza()))
                .collect(Collectors.toList());
    }

    public PlazasEntity getPlaza() {
        return plaza;
    }

    public void setPlazaEntity(PlazasEntity plaza) {
        this.plaza = plaza;
    }

    public String guardarPlaza() {
        if (modelo.insertarPlaza(plaza) != 1) {
            JsfUtil.setErrorMessage(null, "Error: no se pudo insertar la plaza, revisa que los campos estén correctos");
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
        return "EditarPlaza";
    }

    public String eliminarPlaza(String idPlaza) {
        if (modelo.eliminarPlaza(idPlaza) > 0) {
            JsfUtil.setFlashMessage("exito", "Plaza eliminada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a esta plaza");
        }
        return "CrearPlaza";
    }

    public String actualizarPlaza() {
        if (modelo.actualizarPlaza(plaza) != null) {
            JsfUtil.setFlashMessage("exito", "Plaza actualizada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo actualizar la plaza");
        }
        return "empresa";
    }
}
