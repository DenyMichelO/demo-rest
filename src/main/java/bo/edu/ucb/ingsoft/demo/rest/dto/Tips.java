package bo.edu.ucb.ingsoft.demo.rest.dto;

public class Tips {
    private Integer tips_id;
    private Integer imagen_id;
    private Integer veterinario_id;
    private String titulo;
    private String descripcion;

    public Tips(){

    }

    public Integer getTips_id() {
        return tips_id;
    }

    public void setTips_id(Integer tips_id) {
        this.tips_id = tips_id;
    }

    public Integer getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(Integer imagen_id) {
        this.imagen_id = imagen_id;
    }

    public Integer getVeterinario_id() {
        return veterinario_id;
    }

    public void setVeterinario_id(Integer veterinario_id) {
        this.veterinario_id = veterinario_id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
