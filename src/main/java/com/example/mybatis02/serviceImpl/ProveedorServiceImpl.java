/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.serviceImpl;

import com.example.mybatis02.model.Proveedor;
import com.example.mybatis02.repository.ProveedorMyBatisRepository;
import com.example.mybatis02.service.ProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Micaela
 */
@Service
public class ProveedorServiceImpl implements ProveedorService{
    @Autowired
    private ProveedorMyBatisRepository proveedorMyBatisRepository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorMyBatisRepository.findAll();
    }

    @Override
    public Proveedor findById(long id) {
        return proveedorMyBatisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
       return proveedorMyBatisRepository.delete(id);
    }

    @Override
    public int insert(Proveedor proveedor) {
       return proveedorMyBatisRepository.insert(proveedor);
    }

    @Override
    public int update(Proveedor proveedor) {
        return proveedorMyBatisRepository.update(proveedor);
    }
 
}

