/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.serviceImpl;

import com.example.mybatis02.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mybatis02.repository.ClienteMyBatisRepository;
import com.example.mybatis02.service.ClienteService;

/**
 *
 * @author Micaela
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteMyBatisRepository clienteMyBatisRepository;
    
 @Override
    public List<Cliente> findAll() {
        return clienteMyBatisRepository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return clienteMyBatisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
        return clienteMyBatisRepository.delete(id);
    }

    @Override
    public int insert(Cliente cliente) {
        return clienteMyBatisRepository.insert(cliente);
    }

    @Override
    public int update(Cliente cliente) {
        return clienteMyBatisRepository.update(cliente);
    }
}
