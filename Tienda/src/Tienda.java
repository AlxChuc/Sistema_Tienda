
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class Tienda {

    private ArrayList<Producto> productosTienda;
    private ArrayList<Categoria> categorias;
    private ArrayList<Almacen> almacenes;

    public Tienda() {
        this.productosTienda = new ArrayList<>();//productsTienda;
        this.categorias = new ArrayList<>();//categorias;
        this.almacenes = new ArrayList<>();
    }

    public void addAlmacen(Almacen almacen) {
        almacenes.add(almacen);
    }

    public void addProducto(Producto producto) {
        if (!existencia(producto)) {
            productosTienda.add(producto);
        }
    }

    public void addCategoria(Categoria categoria) {
        if (!existencia(categoria)) {
            categorias.add(categoria);
        } else {
            System.out.println("Ya existe");
        }
    }

    public void mostrarProductos() {
        for (int i = 0; i < productosTienda.size(); i++) {
            System.out.println((i + 1) + "." + productosTienda.get(i).getNombre() + ": "
                    + productosTienda.get(i).getCantidad());
        }
    }

    public void mostrarAlmacenes() {
        for (int i = 0; i < almacenes.size(); i++) {
            System.out.println((i + 1) + ".Almacen " + (i + 1));
        }
    }

    public Almacen seleccionarAlmacen(int indice) {
        if (validar(indice, almacenes)) {
            return almacenes.get(indice);
        } else {
            System.out.println("inválido");
            return null;
        }
    }

    public Producto getProducto(int indice) {
        if (validar(indice, productosTienda)) {
            return productosTienda.get(indice);
        } else {
            System.out.println("Inválido");
            return null;
        }
    }

    public Almacen getAlmacen(int indice) {
        Almacen retorna = null;
        if (validar(indice, almacenes)) {
            retorna = almacenes.get(indice);
        }
        return retorna;
    }

    public Categoria getCategoria(int indice) {
        Categoria retorna = null;
        if (validar(indice, categorias)) {
            retorna = categorias.get(indice);
        }
        return retorna;
    }

    public void traerProducto(int indice, int cantidad1) {
        int cantidad = cantidad1;
        int variable = 0;
        Producto misProd = getProducto(indice);
        ArrayList<Producto> prodAlmacen;
        if (misProd != null) {//Para elegir el producto que se quiere
            int resto;
            for (int i = 0; i < almacenes.size(); i++) {
                prodAlmacen = almacenes.get(i).getProductos();//Productos en un almacén
                for (int j = 0; j < prodAlmacen.size(); j++) {

                    if (prodAlmacen.get(j).getNombre().equals(misProd.getNombre())) {
                        if( prodAlmacen.get(j).getCantidad() >= cantidad){
                            variable = variable + cantidad;
                            misProd.setCantidad(variable);
                            prodAlmacen.get(j).setCantidad(prodAlmacen.get(j).getCantidad() - cantidad);
                            cantidad = 0;
                        }else{
                            variable = variable + prodAlmacen.get(j).getCantidad();
                            misProd.setCantidad(variable);
                            cantidad = cantidad - prodAlmacen.get(j).getCantidad();
                            prodAlmacen.get(j).setCantidad(0);
                        }
//                        Producto nuevo = prodAlmacen.get(j);
//                        cantidad = quitarProductos(nuevo, cantidad);
                        
//                        productosTienda.get(i)
                    }
                }
            }
            misProd.setCantidad(cantidad1-cantidad);
        } else {
            System.out.println("inválido");
        }
    }

    private boolean validar(int numero, ArrayList arreglos) {
        if (numero >= 0 && numero < arreglos.size()) {
            return true;
        } else {
            return false;
        }
    }

//    private int quitarProductos(Producto producto, int cantidad) {
//        int aux;
//        if (producto.getCantidad() >= cantidad) {
//            aux = ;
//            producto.setCantidad(producto.getCantidad() - cantidad);
//        } else {
//            aux = cantidad - producto.getCantidad();
//            producto.setCantidad(0);
//        }
//        return aux;
//    }

    private boolean existencia(Object obj) {
        if (obj != null && obj instanceof Producto) {
            Producto producto = (Producto) obj;
            for (int i = 0; i < productosTienda.size(); i++) {
                if (productosTienda.get(i).equals(producto)) {
                    return true;
                }
            }
        }

        if (obj != null && obj instanceof Categoria) {
            Categoria categoria = (Categoria) obj;
            for (int i = 0; i < categorias.size(); i++) {
                if (categorias.get(i).equals(categoria)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarCategorias() {
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + "." + categorias.get(i).getCategoria());
        }
    }

    public void vender(Producto producto, int cantidad) {
        int in = 0;
        for (int i = 0; i < cantidad; i++) {
            if (producto.getCantidad() > 0) {
                in++;
                System.out.println("Vendido");
                int aux = producto.getCantidad() - in;
                producto.setVendidos(in);
                producto.setCantidad(aux);

            } else {
                System.out.println("Producto agotado en tienda");
            }
        }
    }
}
