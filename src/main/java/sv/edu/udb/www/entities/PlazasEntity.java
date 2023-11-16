package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plazas", schema = "rowms_bd", catalog = "")
@NamedQueries({
        @NamedQuery(name = "PlazasEntity.findAll", query = "SELECT e FROM PlazasEntity e")
})
public class PlazasEntity {

    @Id
    @Column(name = "idPlaza", nullable = false, length = 7)
    private String idPlaza;
    @Basic
    @Column(name = "nombrePlaza", nullable = false, length = 100)
    private String nombrePlaza;
    @Basic
    @Column(name = "descripcionPlaza", nullable = false, length = 100)
    private String descripcionPlaza;
    @Basic
    @Column(name = "direccionPlaza", nullable = false, length = 100)
    private String direccionPlaza;
    @Basic
    @Column(name = "empresaAfiliada", nullable = false, length = 100)
    private String empresaAfiliada;
    @Basic
    @Column(name = "salarioPlaza", nullable = false, precision = 0)
    private double salarioPlaza;
    @Basic
    @Column(name = "requisitoPlaza", nullable = false, length = 100)
    private String requisitoPlaza;
    @Basic
    @Column(name = "tipoPlaza", nullable = false, length = 100)
    private String tipoPlaza;
    @Basic
    @Column(name = "rubroPlaza", nullable = false, length = 100)
    private String rubroPlaza;
    @Basic
    @Column(name = "cargoPlaza", nullable = false, length = 100)
    private String cargoPlaza;
    @Basic
    @Column(name = "estadoPlaza", nullable = false, length = 100)
    private String estadoPlaza;
    @Basic
    @Column(name = "motivoRechazoPlaza", nullable = true, length = 200)
    private String motivoRechazoPlaza;

    public String getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(String idPlaza) {
        this.idPlaza = idPlaza;
    }

    public String getNombrePlaza() {
        return nombrePlaza;
    }

    public void setNombrePlaza(String nombrePlaza) {
        this.nombrePlaza = nombrePlaza;
    }

    public String getDescripcionPlaza() {
        return descripcionPlaza;
    }

    public void setDescripcionPlaza(String descripcionPlaza) {
        this.descripcionPlaza = descripcionPlaza;
    }

    public String getDireccionPlaza() {
        return direccionPlaza;
    }

    public void setDireccionPlaza(String direccionPlaza) {
        this.direccionPlaza = direccionPlaza;
    }

    public String getEmpresaAfiliada() {
        return empresaAfiliada;
    }

    public void setEmpresaAfiliada(String empresaAfiliada) {
        this.empresaAfiliada = empresaAfiliada;
    }

    public double getSalarioPlaza() {
        return salarioPlaza;
    }

    public void setSalarioPlaza(double salarioPlaza) {
        this.salarioPlaza = salarioPlaza;
    }

    public String getRequisitoPlaza() {
        return requisitoPlaza;
    }

    public void setRequisitoPlaza(String requisitoPlaza) {
        this.requisitoPlaza = requisitoPlaza;
    }

    public String getTipoPlaza() {
        return tipoPlaza;
    }

    public void setTipoPlaza(String tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }

    public String getRubroPlaza() {
        return rubroPlaza;
    }

    public void setRubroPlaza(String rubroPlaza) {
        this.rubroPlaza = rubroPlaza;
    }

    public String getCargoPlaza() {
        return cargoPlaza;
    }

    public void setCargoPlaza(String cargoPlaza) {
        this.cargoPlaza = cargoPlaza;
    }

    public String getEstadoPlaza() {
        return estadoPlaza;
    }

    public void setEstadoPlaza(String estadoPlaza) {
        this.estadoPlaza = estadoPlaza;
    }

    public String getMotivoRechazoPlaza() {
        return motivoRechazoPlaza;
    }

    public void setMotivoRechazoPlaza(String motivoRechazoPlaza) {
        this.motivoRechazoPlaza = motivoRechazoPlaza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlazasEntity that = (PlazasEntity) o;

        if (Double.compare(salarioPlaza, that.salarioPlaza) != 0) return false;
        if (idPlaza != null ? !idPlaza.equals(that.idPlaza) : that.idPlaza != null) return false;
        if (nombrePlaza != null ? !nombrePlaza.equals(that.nombrePlaza) : that.nombrePlaza != null) return false;
        if (descripcionPlaza != null ? !descripcionPlaza.equals(that.descripcionPlaza) : that.descripcionPlaza != null)
            return false;
        if (direccionPlaza != null ? !direccionPlaza.equals(that.direccionPlaza) : that.direccionPlaza != null)
            return false;
        if (empresaAfiliada != null ? !empresaAfiliada.equals(that.empresaAfiliada) : that.empresaAfiliada != null)
            return false;
        if (requisitoPlaza != null ? !requisitoPlaza.equals(that.requisitoPlaza) : that.requisitoPlaza != null)
            return false;
        if (tipoPlaza != null ? !tipoPlaza.equals(that.tipoPlaza) : that.tipoPlaza != null) return false;
        if (rubroPlaza != null ? !rubroPlaza.equals(that.rubroPlaza) : that.rubroPlaza != null) return false;
        if (cargoPlaza != null ? !cargoPlaza.equals(that.cargoPlaza) : that.cargoPlaza != null) return false;
        if (estadoPlaza != null ? !estadoPlaza.equals(that.estadoPlaza) : that.estadoPlaza != null) return false;
        if (motivoRechazoPlaza != null ? !motivoRechazoPlaza.equals(that.motivoRechazoPlaza) : that.motivoRechazoPlaza != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPlaza != null ? idPlaza.hashCode() : 0;
        result = 31 * result + (nombrePlaza != null ? nombrePlaza.hashCode() : 0);
        result = 31 * result + (descripcionPlaza != null ? descripcionPlaza.hashCode() : 0);
        result = 31 * result + (direccionPlaza != null ? direccionPlaza.hashCode() : 0);
        result = 31 * result + (empresaAfiliada != null ? empresaAfiliada.hashCode() : 0);
        temp = Double.doubleToLongBits(salarioPlaza);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisitoPlaza != null ? requisitoPlaza.hashCode() : 0);
        result = 31 * result + (tipoPlaza != null ? tipoPlaza.hashCode() : 0);
        result = 31 * result + (rubroPlaza != null ? rubroPlaza.hashCode() : 0);
        result = 31 * result + (cargoPlaza != null ? cargoPlaza.hashCode() : 0);
        result = 31 * result + (estadoPlaza != null ? estadoPlaza.hashCode() : 0);
        result = 31 * result + (motivoRechazoPlaza != null ? motivoRechazoPlaza.hashCode() : 0);
        return result;
    }


}
