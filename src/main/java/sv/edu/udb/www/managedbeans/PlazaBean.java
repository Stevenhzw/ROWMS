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

    public List<PlazasEntity> getPlazasFiltradasEstado5() {
        // Filtra las plazas con estado 5
        return modelo.listarPlazas().stream()
                .filter(plaza -> "5".equals(plaza.getEstadoPlaza()))
                .collect(Collectors.toList());
    }

    public List<PlazasEntity> getPlazasFiltradasEstado3() {
        // Filtra las plazas con estado 3
        return modelo.listarPlazas().stream()
                .filter(plaza -> "3".equals(plaza.getEstadoPlaza()))
                .collect(Collectors.toList());
    }

    public List<PlazasEntity> getPlazasFiltradasEstado4() {
        // Filtra las plazas con estado 4
        return modelo.listarPlazas().stream()
                .filter(plaza -> "4".equals(plaza.getEstadoPlaza()))
                .collect(Collectors.toList());
    }


    public PlazasEntity getPlaza() {
        return plaza;
    }

    public void setPlazaEntity(PlazasEntity plaza) {
        this.plaza = plaza;
    }

    public String guardarPlaza() {
        plaza.setEstadoPlaza("5");
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

    public String cargarPlazaOperaciones(String idPlaza) {
        this.plaza = modelo.obtenerPlazaPorId(idPlaza);
        return "OperacionesPlaza";
    }

    public String aceptarPlaza() {

        if (modelo.aceptandoPlaza(plaza) != null) {
            JsfUtil.setFlashMessage("exito", "Plaza aceptada");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo aceptar la plaza");
        }
        return "EstadoPlaza";
    }




    public String eliminarPlaza(String idPlaza) {
        if (modelo.eliminarPlaza(idPlaza) > 0) {
            JsfUtil.setFlashMessage("exito", "Plaza eliminada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a esta plaza");
        }
        return "CrearPlaza";
    }

    /*public String aceptarPlaza(String idPlaza) {
        // 1. Obtener la plaza correspondiente a partir del idPlaza
        PlazasEntity plaza = modelo.obtenerPlazaPorId(idPlaza);

        // Verificar si la plaza existe
        if (plaza != null) {
            // 2. Actualizar el estado de la plaza para indicar que ha sido aceptada
            plaza.setEstadoPlaza("3"); // Reemplaza "EstadoAceptado" con el valor adecuado

            // Guardar los cambios en la base de datos
            if (modelo.actualizarPlaza(plaza) != null) {
                // 3. Mostrar un mensaje de éxito
                JsfUtil.setFlashMessage("exito", "Plaza aceptada exitosamente");

                // Puedes redirigir a una página específica después de aceptar la plaza
                return "ListarUsuarios";
            } else {
                JsfUtil.setErrorMessage(null, "Error al actualizar la plaza");
            }
        } else {
            JsfUtil.setErrorMessage(null, "Plaza no encontrada");
        }

        // En caso de errores, puedes redirigir a la misma página o a una página de error
        return "ListarUsuarios";
    }*/

    public String rechazarPlaza(String idPlaza) {
        // Lógica para rechazar la plaza
        // ...

        JsfUtil.setFlashMessage("exito", "Plaza rechazada exitosamente");
        return "nombreDeTuPagina"; // Puedes redirigir a una página específica después de rechazar la plaza
    }


    public String actualizarPlaza() {
        if (modelo.actualizarPlaza(plaza) != null) {
            JsfUtil.setFlashMessage("exito", "Plaza actualizada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo actualizar la plaza");
        }
        return "CrearPlaza";
    }

}