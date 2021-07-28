package com.proyectofinal.inventario.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.rmi.MarshalException;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "El nombre no debe estar en blanco")
    @NotNull(message = "El nombre no debe ser nulo")
    @Size(max = 50, message = "El nombre no debe de superar los 50 caracteres")
    private String nombre;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "La direccion no debe estar en blanco")
    @NotNull(message = "La direccion no debe ser nulo")
    @Size(max = 50, message = "La direccion no debe de superar los 50 caracteres")
    private String direccion;

    @Column(length = 25, nullable = false)
    @NotBlank(message = "La ciudad no debe estar en blanco")
    @NotNull(message = "La ciudad no debe ser nulo")
    @Size(max = 25, message = "La ciudad no debe de superar los 50 caracteres")
    private String ciudad;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "El email no debe estar en blanco")
    @NotNull(message = "El email no debe ser nulo")
    @Size(max = 50, message = "El email no debe de superar los 50 caracteres")
    private String email;

    @Column(length = 16, nullable = false)
    @NotBlank(message = "El telefono no debe estar en blanco")
    @NotNull(message = "El telefono no debe ser nulo")
    @Size(max = 16, message = "El telefono no debe de superar los 50 caracteres")
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String direccion, String ciudad, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
