/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Producto {
    private int cantidad;
//    final int cantidadTotal;
    private String nombre;
//    private String categoria;
    private Categoria categoria;
    private int vendidos; //Porque quiero saber sobre todos los productos
    
    public Producto(String nombre,int cantidad){
        this.nombre = nombre.toLowerCase();
        this.categoria = null;
        this.vendidos = 0;
        this.cantidad = cantidad;//No sé si hacer que el constructor se lo agregue
    }

    public void setVendidos(int vendidos) {
        this.vendidos = this.vendidos + vendidos;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVendidos() {
        return vendidos;
    }
    
    public boolean equals(Producto producto){
        boolean igual = false;
        if(nombre.equals(producto.getNombre())){
            igual = true;
        }
        return igual;
    }
    
    
    
}
