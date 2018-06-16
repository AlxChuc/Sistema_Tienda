
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Almacen {
    private ArrayList<Producto> productos;
//    private ArrayList<Categoria> categorias;

    public Almacen() {
        this.productos =  new ArrayList<>();//productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void addProducto(Producto producto){
        if(!existencia(producto)){
            productos.add(producto);
        }else{
            System.out.println("Ya existe");
        }
        
    }
    
    public void mostrarProductos(){
        System.out.println("\tProductos en este almacén");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i+1)+"."+productos.get(i).getNombre());
        }
    }
    
    public void reorden(int cantidadProducto){
        List<Producto> lista = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getCantidad() <= cantidadProducto){
                System.out.println(productos.get(i).getNombre()+": "+ productos.get(i).getCantidad());
                lista.add(productos.get(i));
            }
        }
    }
    /**
     * @param producto qué producto quieres
     * @param cantidad  cuántos quieres
     */
    public void resurtir(int producto,int cantidad){//Checas el reorden, si necesitas algo, resurtes
        if(validar(producto)){
            int aux = productos.get(producto).getCantidad() + cantidad;
            productos.get(producto).setCantidad(aux);
        }else{
            System.out.println("Inválido");
        }
    }
    
    private boolean validar(int valor){
        return (valor>=0 && valor <productos.size());
    }
    
    private boolean existencia(Producto producto){
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).equals(producto)){
                return true;
            }
        }
        return false;
    }
}
