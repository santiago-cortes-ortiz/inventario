package com.proyectofinal.inventario.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categorias")
@ApiModel
public class Categoria {

    @Id
    @ApiModelProperty(
            value = "Id de la categoria",
            name = "id",
            dataType = "Integer",
            example = "1"
    )
    private Long id;

    @NotNull(message = "El nombre no debe ser nulo")
    @NotBlank(message = "El nombre no debe estar en blnaco")
    @Size(max = 50, message = "El nombre no debe de superar los 50 caracteres")
    @Column( length = 50, nullable = false)
    @ApiModelProperty(
            value = "Nombre del tipo de categoria",
            name = "nombre",
            dataType = "String",
            example = "Tecnologia"
    )
    private String nombre;

    public Categoria() {
    }

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
