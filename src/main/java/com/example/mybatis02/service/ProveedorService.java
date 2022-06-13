/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.service;

import com.example.mybatis02.model.Proveedor;
import java.util.List;

/**
 *
 * @author Micaela
 */
public interface ProveedorService {
    public List<Proveedor> findAll();
    public Proveedor findById(long id);
    public int deleteById(long id);
    public int insert(Proveedor proveedor);
    public int update(Proveedor proveedor);
}
