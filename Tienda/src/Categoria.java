
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class Categoria {

    private String categoria;
    private ArrayList<Producto> productos;//Todos los productos que sean de esa categoría

    /*Así puedo conseguir sus ventas de cada uno*/

    public Categoria(String nombreCat) {
        this.categoria = nombreCat.toLowerCase();
        this.productos = new ArrayList<>();//productos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void addProd(Producto producto) {

        productos.add(producto);
    }

    public boolean equals(Categoria categoria) {
        boolean eleccion = false;
        if (this.categoria.equals(categoria.getCategoria())) {
            eleccion = true;
        }
        return eleccion;
    }

    public void top() {
        int indice;
//        productos.sort(Comparator.comparing((producto) -> producto.getVendidos()));
        productos.sort(Comparator.comparing(Producto::getVendidos).reversed());
        

        if (productos.size() < 5) {
            indice = productos.size();
        } else {
            indice = 5;
        }
        for (int i = 0; i < indice; i++) {
//            System.out.println(">ESTE<"+productos.get(i).getNombre());
            System.out.println((i + 1) + "." + productos.get(i).getNombre());
        }
    }
}
