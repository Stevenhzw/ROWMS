package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "rowms_bd", catalog = "")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dui", nullable = false, length = 9)
    private String dui;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Basic
    @Column(name = "edad", nullable = false)
    private int edad;
    @Basic
    @Column(name = "genero", nullable = false, length = 100)
    private String genero;
    @Basic
    @Column(name = "foto", nullable = true, length = 300)
    private String foto;
    @Basic
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @Basic
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    @Basic
    @Column(name = "expLaboral", nullable = false, length = 100)
    private String expLaboral;
    @Basic
    @Column(name = "gradoAcademico", nullable = false, length = 100)
    private String gradoAcademico;
    @Basic
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    @Basic
    @Column(name = "contraseña", nullable = false, length = 100)
    private String contraseña;
    @Basic
    @Column(name = "empresaAfiliada", nullable = true, length = 100)
    private String empresaAfiliada;
    @Basic
    @Column(name = "estado", nullable = false, length = 100)
    private String estado;
    @Basic
    @Column(name = "rol", nullable = false, length = 100)
    private String rol;

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getExpLaboral() {
        return expLaboral;
    }

    public void setExpLaboral(String expLaboral) {
        this.expLaboral = expLaboral;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmpresaAfiliada() {
        return empresaAfiliada;
    }

    public void setEmpresaAfiliada(String empresaAfiliada) {
        this.empresaAfiliada = empresaAfiliada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (edad != that.edad) return false;
        if (dui != null ? !dui.equals(that.dui) : that.dui != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (foto != null ? !foto.equals(that.foto) : that.foto != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (expLaboral != null ? !expLaboral.equals(that.expLaboral) : that.expLaboral != null) return false;
        if (gradoAcademico != null ? !gradoAcademico.equals(that.gradoAcademico) : that.gradoAcademico != null)
            return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (contraseña != null ? !contraseña.equals(that.contraseña) : that.contraseña != null) return false;
        if (empresaAfiliada != null ? !empresaAfiliada.equals(that.empresaAfiliada) : that.empresaAfiliada != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dui != null ? dui.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + edad;
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (expLaboral != null ? expLaboral.hashCode() : 0);
        result = 31 * result + (gradoAcademico != null ? gradoAcademico.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (contraseña != null ? contraseña.hashCode() : 0);
        result = 31 * result + (empresaAfiliada != null ? empresaAfiliada.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        return result;
    }
}
