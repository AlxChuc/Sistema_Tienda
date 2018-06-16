
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tienda tienda = new Tienda();
        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        int value, cantidad;
        String cadena;

        System.out.println("\tTienda");

        do {
            /*Tiene más funciones pero 
            no me dio tiempo de implementarlas*/
            System.out.println("1.Agregar almacén\n"
                    + "2.Agregar producto nuevo a almacén\n"
                    + "3.Agregar más cantidad a la tienda\n"
                    + "4.Revisar cantidad stock en almacén\n"
                    + "5.Resurtir almacén\n"
                    + "6.Agregar categorías en la tienda\n"
                    + "7.agregar categoría del producto en tienda\n"
                    + "8.Top 5 ventas en tienda\n"
                    + "9.Vender\n"
                    + "0.Salir");
            int valor = scan.nextInt();
            switch (valor) {
                case 1:
                    tienda.addAlmacen(new Almacen());
                    break;
                case 2:
                    tienda.mostrarAlmacenes();
                    System.out.println("Seleccione un almacén: ");
                    value = scan.nextInt();
                    scan.nextLine();
                    boolean x = true;
                    do {
                        System.out.print("Ingrese producto: ");
                        cadena = scan.nextLine();
                        System.out.println("Ingrese cantidad: ");
                        int quantity = scan.nextInt();
                        tienda.getAlmacen(value - 1).addProducto(new Producto(cadena, quantity));

                        tienda.addProducto(new Producto(cadena, 0));
                        System.out.println("¿Desea agregar otro producto? 1.Sí 0.No");
                        value = scan.nextInt();
                        scan.nextLine();
                        if (value != 1) {
                            x = false;
                        }
                    } while (x);

                    break;
                case 3:
                    tienda.mostrarProductos();
                    System.out.print("Seleccione un producto: ");
                    value = scan.nextInt();
                    System.out.println("Cuantos quiere? ");
                    cantidad = scan.nextInt();
                    tienda.traerProducto(value - 1, cantidad);

                    tienda.seleccionarAlmacen(value - 1);
                    break;

                case 4:
                    tienda.mostrarAlmacenes();
                    System.out.print("Seleccione un almacén: ");
                    value = scan.nextInt();
                    System.out.print("Ingrese el número máximo de stock: ");
                    int value2 = scan.nextInt();
                    System.out.println("");
                    tienda.getAlmacen(value - 1).reorden(value2);
//                    scan.nextLine();

                    break;
                case 5:
                    tienda.mostrarAlmacenes();
                    System.out.print("Elija un almacén: ");
                    value = scan.nextInt();
                    tienda.getAlmacen(value - 1).mostrarProductos();
                    System.out.print("Elija un producto: ");
                    value2 = scan.nextInt();
                    System.out.println("¿Cuánto desea agregar? ");
                    int cantidad2 = scan.nextInt();
                    tienda.getAlmacen(value - 1).resurtir(value2 - 1, cantidad2);
                    break;

                case 6:
                    boolean bandera = true;
                    do {
                        scan.nextLine();
                        System.out.print("Nueva categoría: ");
                        cadena = scan.nextLine();
                        tienda.addCategoria(new Categoria(cadena));
                        System.out.println("¿Desea agregar otra categoría? 1.Sí 0.No");
                        value = scan.nextInt();
                        if (value != 1) {
                            bandera = false;
                        }
                    } while (bandera);

                    break;
                case 7:
                    tienda.mostrarProductos();
                    System.out.print("Elija un producto: ");
                    value = scan.nextInt();
                    tienda.mostrarCategorias();
                    System.out.print("Categoría para el producto: ");
                    value2 = scan.nextInt();
                    Categoria aux2 = tienda.getCategoria(value2-1);
                    tienda.getProducto(value-1).setCategoria(aux2);
                    aux2.addProd(tienda.getProducto(value-1));
                    break;
                case 8:
                    tienda.mostrarCategorias();
                    System.out.println("Elija una categoría: ");
                    value2 = scan.nextInt();
                    aux2 = tienda.getCategoria(value2-1);
                    aux2.top();
                    break;
                case 9: 
                    tienda.mostrarProductos();
                    System.out.println("¿Qué quiere comprar? ");
                    value = scan.nextInt();
                    Producto prod = tienda.getProducto(value-1);
                    System.out.println("¿Cuántos quiere comprar? ");
                    value = scan.nextInt();
                    tienda.vender(prod, value);
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Comando inválido");
                    break;
            }
            System.out.println("");
        } while (exit);
        System.out.println();
    }

}
