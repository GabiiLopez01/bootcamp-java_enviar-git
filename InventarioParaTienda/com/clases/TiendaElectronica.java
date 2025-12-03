package com.clases;

import java.util.ArrayList;

//Clase Tienda Electrónica que gestiona inventario de productos
public class TiendaElectronica {
    //ArrayList para almacenar los productos del inventario
    private ArrayList<ProductoElectrodomestico> listaDeProductos;

    //Constructor para inicializar lista de productos vacía
    public TiendaElectronica(){
        listaDeProductos = new ArrayList<ProductoElectrodomestico>();
    }
    
    //Metodo para agregar un producto al inventario
    public void agregarProducto(ProductoElectrodomestico producto) {
        listaDeProductos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    //Método para mostrar los productos disponibles en el inventario
    public void mostrarTodosLosProductos(){
        System.out.println("Inventario de la Tienda");

    if(listaDeProductos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
    }

    //Recorrer listado de producto y mostrar producto
        for(int i = 0; i < listaDeProductos.size(); i++){
            ProductoElectrodomestico producto = listaDeProductos.get(i);
            producto.mostrarInformacion();
        }
    }

    //Método para buscar un producto por su nombre
    public ProductoElectrodomestico buscaProductoPorNombre(String nombreProducto) {
        for (int i = 0; i < listaDeProductos.size(); i++) {
            ProductoElectrodomestico producto = listaDeProductos.get(i);

        //Comparar nombres (ignorando mayúsculas/minusculas)
        if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
            return producto;
        }
    }
        //Producto no encontrado
        return null; 
    }

    //Metodo para realizar una venta - Reduce la cantidad disponible del producto
    public void realizarVenta(String nombreProducto, int cantidad) {
        //Buscar producto
        ProductoElectrodomestico producto = buscaProductoPorNombre(nombreProducto);

    //Verificar si el producto existe
        if (producto == null) {
            System.out.println("Producto no encontrado: " + nombreProducto);
            return;
        }

        //Verificar si hay stock disponible
        if (producto.getCantidadDisponible() == 0) {
            System.out.println("Producto agotado: " + nombreProducto);
            return;
        }

        //Verificar si hay suficiente cantidad
        if (producto.getCantidadDisponible() < cantidad) {
            System.out.println("Stock insuficiente. Disponible: " + producto.getCantidadDisponible() +
            " , Solicitado: " + cantidad);
            return;
    }

    //Realizar la venta - reducir la cantidad
    int nuevaCantidad = producto.getCantidadDisponible() - cantidad;
    producto.setCantidadDisponible(nuevaCantidad);

    System.out.println("Venta realizada: " + cantidad + "x " + nombreProducto);
    System.out.println(" Cantidad restante: " + nuevaCantidad);
    
}
//Getter para obtener la lista de productos

public ArrayList<ProductoElectrodomestico> getListaDeProductos(){
    return listaDeProductos;

    }
} 
