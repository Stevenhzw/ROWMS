package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas", schema = "rowms_bd", catalog = "")
public class EmpresasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmpresa", nullable = false, length = 7)
    private String idEmpresa;
    @Basic
    @Column(name = "nombreEmpresa", nullable = false, length = 100)
    private String nombreEmpresa;
    @Basic
    @Column(name = "descripcionEmpresa", nullable = false, length = 100)
    private String descripcionEmpresa;
    @Basic
    @Column(name = "fotoEmpresa", nullable = true, length = 300)
    private String fotoEmpresa;
    @Basic
    @Column(name = "telefonoEmpresa", nullable = false, length = 9)
    private String telefonoEmpresa;
    @Basic
    @Column(name = "direccionEmpresa", nullable = false, length = 100)
    private String direccionEmpresa;
    @Basic
    @Column(name = "correoEmpresa", nullable = false, length = 100)
    private String correoEmpresa;
    @Basic
    @Column(name = "contraseñaEmpresa", nullable = false, length = 100)
    private String contraseñaEmpresa;
    @Basic
    @Column(name = "estadoEmpresa", nullable = false, length = 100)
    private String estadoEmpresa;

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public String getFotoEmpresa() {
        return fotoEmpresa;
    }

    public void setFotoEmpresa(String fotoEmpresa) {
        this.fotoEmpresa = fotoEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public String getContraseñaEmpresa() {
        return contraseñaEmpresa;
    }

    public void setContraseñaEmpresa(String contraseñaEmpresa) {
        this.contraseñaEmpresa = contraseñaEmpresa;
    }

    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpresasEntity that = (EmpresasEntity) o;

        if (idEmpresa != null ? !idEmpresa.equals(that.idEmpresa) : that.idEmpresa != null) return false;
        if (nombreEmpresa != null ? !nombreEmpresa.equals(that.nombreEmpresa) : that.nombreEmpresa != null)
            return false;
        if (descripcionEmpresa != null ? !descripcionEmpresa.equals(that.descripcionEmpresa) : that.descripcionEmpresa != null)
            return false;
        if (fotoEmpresa != null ? !fotoEmpresa.equals(that.fotoEmpresa) : that.fotoEmpresa != null) return false;
        if (telefonoEmpresa != null ? !telefonoEmpresa.equals(that.telefonoEmpresa) : that.telefonoEmpresa != null)
            return false;
        if (direccionEmpresa != null ? !direccionEmpresa.equals(that.direccionEmpresa) : that.direccionEmpresa != null)
            return false;
        if (correoEmpresa != null ? !correoEmpresa.equals(that.correoEmpresa) : that.correoEmpresa != null)
            return false;
        if (contraseñaEmpresa != null ? !contraseñaEmpresa.equals(that.contraseñaEmpresa) : that.contraseñaEmpresa != null)
            return false;
        if (estadoEmpresa != null ? !estadoEmpresa.equals(that.estadoEmpresa) : that.estadoEmpresa != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpresa != null ? idEmpresa.hashCode() : 0;
        result = 31 * result + (nombreEmpresa != null ? nombreEmpresa.hashCode() : 0);
        result = 31 * result + (descripcionEmpresa != null ? descripcionEmpresa.hashCode() : 0);
        result = 31 * result + (fotoEmpresa != null ? fotoEmpresa.hashCode() : 0);
        result = 31 * result + (telefonoEmpresa != null ? telefonoEmpresa.hashCode() : 0);
        result = 31 * result + (direccionEmpresa != null ? direccionEmpresa.hashCode() : 0);
        result = 31 * result + (correoEmpresa != null ? correoEmpresa.hashCode() : 0);
        result = 31 * result + (contraseñaEmpresa != null ? contraseñaEmpresa.hashCode() : 0);
        result = 31 * result + (estadoEmpresa != null ? estadoEmpresa.hashCode() : 0);
        return result;
    }
}
