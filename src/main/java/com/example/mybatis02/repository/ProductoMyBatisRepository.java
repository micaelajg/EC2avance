/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis02.repository;

import com.example.mybatis02.model.Producto;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Micaela
 */
@Mapper
public interface ProductoMyBatisRepository {
     @Insert("INSERT INTO producto(descripcion,idproveedor, preciocosto, precioventa) VALUES(#{descripcion},#{idproveedor},#{preciocosto},#{precioventa})")
    public int insert(Producto proveedor);
    
    @Insert("UPDATE producto SET  descripcion=#{descripcion}, preciocosto=#{preciocosto},precioventa=#{precioventa} WHERE idproducto=#{idproducto}")
    public int update(Producto proveedor);
    
    @Delete("DELETE FROM producto WHERE idproducto=#{id}")
    public int delete(long id);
    
    @Select("SELECT *FROM producto WHERE idproducto=#{id}")
    public Producto findById(long id);
    
    @Select("SELECT *FROM producto")
    public List<Producto> findAll();
    
    @Select("SELECT c.idproveedor as proveeedor, p.descripcion as producto, p.preciocosto, p.precioventa from producto as p"+
            "inner join proveedor as c on p.idproveedor = c.idcategoria")
    public List<Map<String,Object>> findAll2();
    
    
}  

