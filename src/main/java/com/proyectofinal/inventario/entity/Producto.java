package com.proyectofinal.inventario.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @Column(name = "id_producto")
    private Long idPrudcto;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El nombre no debe ser nulo")
    @NotBlank(message = "El nombre no debe estar en blnaco")
    @Size(max = 50, message = "El nombre no debe de superar los 50 caracteres")
    private String nombre;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private String unidadPeso;

    public Producto() {
    }

    public Producto(Long id, Categoria categoria, String nombre, Double peso, String unidadPeso) {
        this.idPrudcto = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.peso = peso;
        this.unidadPeso = unidadPeso;
    }

    public Long getId() {
        return idPrudcto;
    }

    public void setId(Long id) {
        this.idPrudcto = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(String unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + idPrudcto +
                ", categoria=" + categoria +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", unidadPeso='" + unidadPeso + '\'' +
                '}';
    }
}
