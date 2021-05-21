package bo.edu.ucb.ingsoft.demo.rest.dto;

public class PublicidadEmpresa {

    private Integer tarifa_id;
    private String cantidad_meses;
    private String precio;

    private Integer empresacli_id;
    private String nombre_empresa;
    private String num_telef;
    private String email;

    private Integer empresa_id;
    private String nombre_anuncio;
    private String marca_producto;

    public PublicidadEmpresa(){

    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public Integer getTarifa_id() {
        return tarifa_id;
    }

    public void setTarifa_id(Integer tarifa_id) {
        this.tarifa_id = tarifa_id;
    }

    public String getCantidad_meses() {
        return cantidad_meses;
    }

    public void setCantidad_meses(String cantidad_meses) {
        this.cantidad_meses = cantidad_meses;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getEmpresacli_id() {
        return empresacli_id;
    }

    public void setEmpresacli_id(Integer empresacli_id) {
        this.empresacli_id = empresacli_id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNum_telef() {
        return num_telef;
    }

    public void setNum_telef(String num_telef) {
        this.num_telef = num_telef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getNombre_anuncio() {
        return nombre_anuncio;
    }

    public void setNombre_anuncio(String nombre_anuncio) {
        this.nombre_anuncio = nombre_anuncio;
    }
}
