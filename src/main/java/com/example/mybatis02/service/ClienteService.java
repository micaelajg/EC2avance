/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.service;

import com.example.mybatis02.model.Cliente;
import java.util.List;

/**
 *
 * @author Micaela
 */
public interface ClienteService {
  public List<Cliente> findAll();
    public Cliente findById(long id);
    public int deleteById(long id);
    public int insert(Cliente cliente);
    public int update(Cliente cliente);
}
