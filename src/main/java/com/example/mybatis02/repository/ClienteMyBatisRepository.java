/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.repository;

import com.example.mybatis02.model.Cliente;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Micaela
 */
@Mapper
public interface ClienteMyBatisRepository {
    @Insert("INSERT INTO cliente(nombre, telefono, direccion) VALUES(#{nombre},#{telefono},#{direccion})")
    public int insert(Cliente cliente);
    
    @Insert("UPDATE cliente SET  nombre=#{nombre}, telefono=#{telefono}, direccion=#{direccion} WHERE idcliente=#{idcliente}")
    public int update(Cliente cliente);
    
    @Delete("DELETE FROM cliente WHERE idcliente=#{id}")
    public int delete(long id);
    
    @Select("SELECT *FROM cliente WHERE idcliente=#{id}")
    public Cliente findById(long id);
    
    @Select("SELECT *FROM cliente")
    public List<Cliente> findAll();     
}
