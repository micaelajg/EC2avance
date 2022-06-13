/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Micaela
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class Proveedor {
    private int idproveedor;
    private String nombre;
    private String telefono;
    private String direccion;
}
