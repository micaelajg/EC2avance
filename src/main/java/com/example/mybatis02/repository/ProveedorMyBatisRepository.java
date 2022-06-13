/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.repository;

import com.example.mybatis02.model.Cliente;
import com.example.mybatis02.model.Proveedor;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Micaela
 */
@Mapper
public interface ProveedorMyBatisRepository {
    @Insert("INSERT INTO proveedor(nombre, telefono, direccion) VALUES(#{nombre},#{telefono},#{direccion})")
    public int insert(Proveedor proveedor);
    
    @Insert("UPDATE proveedor SET  nombre=#{nombre}, telefono=#{telefono}, direccion=#{direccion} WHERE idproveedor=#{idproveedor}")
    public int update(Proveedor proveedor);
    
    @Delete("DELETE FROM proveedor WHERE idproveedor=#{id}")
    public int delete(long id);
    
    @Select("SELECT *FROM proveedor WHERE idproveedor=#{id}")
    public Proveedor findById(long id);
    
    @Select("SELECT *FROM proveedor")
    public List<Proveedor> findAll();   
}
