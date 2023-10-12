package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.PlazasEntity;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.models.DependientesModel;
import sv.edu.udb.www.models.PlazaModel;
import sv.edu.udb.www.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class PlazaBean {
    PlazaModel modelo = new PlazaModel();

    private PlazasEntity plaza;

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



}
