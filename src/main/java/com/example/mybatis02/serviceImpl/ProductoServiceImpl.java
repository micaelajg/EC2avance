/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.serviceImpl;

import com.example.mybatis02.model.Producto;
import com.example.mybatis02.repository.ProductoMyBatisRepository;
import com.example.mybatis02.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Micaela
 */
@Service
public class ProductoServiceImpl  implements ProductoService{

    @Autowired
    private ProductoMyBatisRepository productoMyBatisRepository;
    @Override
    public List<Producto> findAll() {
       return productoMyBatisRepository.findAll(); 
    }

    @Override
    public Producto findById(long id) {
        return productoMyBatisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
    return productoMyBatisRepository.delete(id);
    }

    @Override
    public int insert(Producto producto) {
        return productoMyBatisRepository.insert(producto);
    }

    @Override
    public int update(Producto producto) {
        return productoMyBatisRepository.update(producto);
    }
}
