package com;

import com.clases.ProductoElectrodomestico;
import com.clases.Televisor;
import com.clases.ComputadorPortatil;
import com.clases.TiendaElectronica;

public class Aplicacion {
    public static void main(String[] args) {
        System.out.println("Sistema de Inventario - Tienda Electronica");

        //Crear tienda
        TiendaElectronica tienda = new TiendaElectronica();

        //Crear productos y agregarlo al inventario
        System.out.println("Agregando productos al inventario: ");

        //Crear televisores
        Televisor tv1 = new Televisor("Smart Tv Samsung", 599.99, 10, "55 pulgadas", "4K Ultra HD");
        Televisor tv2 = new Televisor("Smart Tv LG", 499.99, 8, "50 pulgadas", "Full HD");
        Televisor tv3 = new Televisor("Smart Tv Sony", 699.99, 5, "65 pulgadas", "4K Ultra HD");

        //Crea computadores portatiles
        ComputadorPortatil portatil1 = new ComputadorPortatil("Dell Inspiron", 899, 6, "Dell", "16 gb", "un-numero-de-serie 002");
        ComputadorPortatil portatil2 = new ComputadorPortatil("HP Pavilion", 789, 12, "HP", "8 gb", "un-numero-de-serie 003");
        ComputadorPortatil portatil3 = new ComputadorPortatil("MacBook Air", 1599, 3, "Apple", "8 gb", "un-numero-de-serie 004");
        
        //Agregar Productos a la tienda
        tienda.agregarProducto(tv1);
        tienda.agregarProducto(tv2);
        tienda.agregarProducto(tv3);

        tienda.agregarProducto(portatil1);
        tienda.agregarProducto(portatil2);
        tienda.agregarProducto(portatil3);
    
        //Mostrar todos los productos
        tienda.mostrarTodosLosProductos();

        //Realizar ventas
        System.out.println("Realizando Venta");

        //Venta 1
        tienda.realizarVenta("Smart Tv Samsung", 3);

        //Venta 2
        tienda.realizarVenta("HP Pavilion", 2);

        //Venta 3
        tienda.realizarVenta("MacBook Air", 1);

        //Venta 4 - más de lo disponible en TV
        System.out.println();
        tienda.realizarVenta("Smart Tv LG", 20);

        //Venta 5 - todos los Smart TV Sony
        System.out.println();
        tienda.realizarVenta("Smart Tv Sony", 5);

        //Venta 6 - vender cuando se agotó un producto
        System.out.println();
        tienda.realizarVenta("Smart Tv Sony", 1);

        //Mostrar inventario actualizado
        System.out.println("Inventario actualizado después de las ventas");
        tienda.mostrarTodosLosProductos();

        //Buscar producto específico
        System.out.println("Busqueda producto");
        ProductoElectrodomestico productoEncontrado = tienda.buscaProductoPorNombre("Dell Inspiron");

        if(productoEncontrado != null){
            System.out.println("Producto encontrado: ");
            productoEncontrado.mostrarInformacion();
        }else{
            System.out.println("Producto no encontrado");
        }

        //Crear producto sin especificar cantidad (se pone en 0 automáticamente)
        ProductoElectrodomestico productoSinStock = new ProductoElectrodomestico("Producto de prueba", 99.99);

        System.out.println("Producto creado con constructor sobrecargado: ");
        productoSinStock.mostrarInformacion();


    }
    
}
