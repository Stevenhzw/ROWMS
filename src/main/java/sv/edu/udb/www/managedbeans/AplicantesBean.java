package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.AplicantesEntity;
import sv.edu.udb.www.models.PlazaModel;
import sv.edu.udb.www.utils.JsfUtil;

@ManagedBean
@RequestScoped
public class AplicantesBean {

    PlazaModel modelo = new PlazaModel();
    private AplicantesEntity aplicante;

    public AplicantesBean() {
        aplicante = new AplicantesEntity();
    }

    public String aplicarPlaza(String idPlaza, String dui){
        aplicante.setEstadoAplicacion("En Espera");
        aplicante.setDuiAplicante(dui);
        aplicante.setPlazaAplicada(idPlaza);

        if (modelo.validarPlaza(aplicante) != 0) {
            JsfUtil.setFlashMessage("error", "Ya has aplicado a esta plaza.");
            return null;

        } else if (modelo.aplicarPlaza(aplicante) != 1) {
            JsfUtil.setErrorMessage("error", "Error, no has podido aplicar a la plaza.");
            return null;

        } else {
            JsfUtil.setFlashMessage("exito", "Plaza aplicada exitosamente");
            //Forzando la redirección en el cliente

            return "index?faces-redirect=true";
        }
    }


}
