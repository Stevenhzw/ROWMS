package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "estados", schema = "rowms_bd", catalog = "")
public class EstadosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEstado", nullable = false, length = 11)
    private String idEstado;
    @Basic
    @Column(name = "nombreEstado", nullable = false, length = 100)
    private String nombreEstado;

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadosEntity that = (EstadosEntity) o;

        if (idEstado != null ? !idEstado.equals(that.idEstado) : that.idEstado != null) return false;
        if (nombreEstado != null ? !nombreEstado.equals(that.nombreEstado) : that.nombreEstado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstado != null ? idEstado.hashCode() : 0;
        result = 31 * result + (nombreEstado != null ? nombreEstado.hashCode() : 0);
        return result;
    }
}
