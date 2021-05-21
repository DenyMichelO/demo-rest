package bo.edu.ucb.ingsoft.demo.rest.dto;

public class Veterinario {
    private Integer veterinario_id;
    private String nombre;
    private String apellido;
    private String email;
    private String departamento;
    private String lugar_formacion;

    public Veterinario() {

    }

    public Integer getVeterinario_id() {
        return veterinario_id;
    }

    public void setVeterinario_id(Integer veterinario_id) {
        this.veterinario_id = veterinario_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLugar_formacion() {
        return lugar_formacion;
    }

    public void setLugar_formacion(String lugar_formacion) {
        this.lugar_formacion = lugar_formacion;
    }
}
