/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudtienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author yulia
 */
public class DaoProducto {
    
    Connection con; 
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
        List<productos> lista=new ArrayList<>();
        String sql="select * from producto";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                productos p=new productos();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setCantidad(rs.getInt(4));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public boolean insertar(productos pr){
        String sql="insert into producto(nombre,precio,cantidad) values (?,?,?)";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getCantidad());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(productos pr){
        String sql="update producto set nombre=?,precio=?,cantidad=? where id=?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getCantidad());
            ps.setInt(4, pr.getId());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public void buscar(productos pr){
        String sql="select * from producto where id=?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pr.getId());
            rs=ps.executeQuery();
            if(rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setCantidad(rs.getInt(4));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    public boolean eliminar(productos pr){
        String sql="delete from producto where id=?";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pr.getId());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
