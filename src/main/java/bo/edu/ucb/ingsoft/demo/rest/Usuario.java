package bo.edu.ucb.ingsoft.demo.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer userId;
    public String user;
    public String password;
    public String nombres;
    public String apellidos;
    public String email;
    public Integer telefono;

    public Usuario(){

    }
}
