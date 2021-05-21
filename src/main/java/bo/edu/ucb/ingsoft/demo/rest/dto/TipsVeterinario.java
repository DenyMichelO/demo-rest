package bo.edu.ucb.ingsoft.demo.rest.dto;

public class TipsVeterinario {



    private Integer tips_id;
    private String titulo;
    private String descripcion;

    private Integer veterinario_id;
    private String nombre;
    private String apellido;

    private Integer imagen_id;
    private String nombre_imagen;
    private String url;

    public TipsVeterinario(){

    }

    public Integer getTips_id() {
        return tips_id;
    }

    public void setTips_id(Integer tips_id) {
        this.tips_id = tips_id;
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

    public Integer getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(Integer imagen_id) {
        this.imagen_id = imagen_id;
    }

    public String getNombre_imagen() {
        return nombre_imagen;
    }

    public void setNombre_imagen(String nombre_imagen) {
        this.nombre_imagen = nombre_imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
