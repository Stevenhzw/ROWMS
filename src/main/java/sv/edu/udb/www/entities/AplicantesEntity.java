package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "aplicantes", schema = "rowms_bd", catalog = "")
public class AplicantesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_aplicantes", nullable = false)
    private int idAplicantes;
    @Basic
    @Column(name = "Dui_aplicante", nullable = false, length = 10)
    private String duiAplicante;
    @Basic
    @Column(name = "Plaza_aplicada", nullable = false, length = 7)
    private String plazaAplicada;
    @Basic
    @Column(name = "Estado_aplicacion", nullable = false, length = 100)
    private String estadoAplicacion;


    public int getIdAplicantes() {
        return idAplicantes;
    }

    public void setIdAplicantes(int idAplicantes) {
        this.idAplicantes = idAplicantes;
    }

    public String getDuiAplicante() {
        return duiAplicante;
    }

    public void setDuiAplicante(String duiAplicante) {
        this.duiAplicante = duiAplicante;
    }

    public String getPlazaAplicada() {
        return plazaAplicada;
    }

    public void setPlazaAplicada(String plazaAplicada) {
        this.plazaAplicada = plazaAplicada;
    }

    public String getEstadoAplicacion() {
        return estadoAplicacion;
    }

    public void setEstadoAplicacion(String estadoAplicacion) {
        this.estadoAplicacion = estadoAplicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AplicantesEntity that = (AplicantesEntity) o;

        if (idAplicantes != that.idAplicantes) return false;
        if (duiAplicante != null ? !duiAplicante.equals(that.duiAplicante) : that.duiAplicante != null) return false;
        if (plazaAplicada != null ? !plazaAplicada.equals(that.plazaAplicada) : that.plazaAplicada != null)
            return false;
        if (estadoAplicacion != null ? !estadoAplicacion.equals(that.estadoAplicacion) : that.estadoAplicacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAplicantes;
        result = 31 * result + (duiAplicante != null ? duiAplicante.hashCode() : 0);
        result = 31 * result + (plazaAplicada != null ? plazaAplicada.hashCode() : 0);
        result = 31 * result + (estadoAplicacion != null ? estadoAplicacion.hashCode() : 0);
        return result;
    }

}
