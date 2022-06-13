/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.service;

import com.example.mybatis02.model.Producto;
import java.util.List;

/**
 *
 * @author Micaela
 */
public interface ProductoService {
     public List<Producto> findAll();
    public Producto findById(long id);
    public int deleteById(long id);
    public int insert(Producto producto);
    public int update(Producto producto); 
}
