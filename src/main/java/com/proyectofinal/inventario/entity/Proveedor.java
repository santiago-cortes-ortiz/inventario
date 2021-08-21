package com.proyectofinal.inventario.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.rmi.MarshalException;
import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_proveedor")
    private Long idProveedor;

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


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ordenes",
            joinColumns = @JoinColumn(name = "id_proveedor"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos;

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String direccion, String ciudad, String email, String telefono) {
        this.idProveedor = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return idProveedor;
    }

    public void setId(Long id) {
        this.idProveedor = id;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + idProveedor +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
