## Requerimientos

1. Crea un proyecto Java llamado “inventario_para_tienda”.
2. Dentro del proyecto agrega el paquete llamado _com.clases_.
3. Dentro del paquete com.clases crea una clase base llamada _ProductoElectrodomestico_ con las siguientes características:
_Atributos:_
- nombre: El nombre del producto.
- precio: El precio del producto.
- cantidadDisponible: La cantidad disponible en el inventario.
_Constructores:_
- Implementa un constructor que inicialice los tres atributos.
- Sobrecarga un constructor que inicializa nombre y precio. Pone por defecto a cantidadDisponible en 0.
_Métodos:_
- Implementa getters y setters para todos los atributos.
- _mostrarInformacion()_: Imprime los detalles del producto.
4. Dentro del paquete com.clases crea una clase base llamada Televisor con las siguientes características:
- La clase Televisor hereda de la clase _ProductoElectrodomestico_.
- Agrega atributos adicionales específicos para televisores, como tamañoPantalla y resolución.
- Implementa un constructor para inicializar los atributos de la clase Televisor.
- Sobrescribe el método _mostrarInformacion()_ para mostrar la información específica del televisor.
5. Dentro del paquete com.clases crea una clase base llamada _ComputadoraPortatil_ con las siguientes características:
- La clase _ComputadoraPortatil_ hereda de la clase ProductoElectrodomestico.
- Agrega atributos adicionales específicos para computadoras, como marca, memoriaRAM y numeroSerie.
- Implementa un constructor para inicializar los atributos de la clase _ComputadoraPortatil_.
- Sobrescribe el método _mostrarInformacion()_ para mostrar la información específica de la computadora.
6. Dentro del paquete _com.clases_ crea una clase base llamada _TiendaElectronica_ con las siguientes características:
- Agrega el atributo listaDeProductos para almacenar los productos en el inventario. Debe de ser un ArrayList<Producto>.
- Implementa métodos para agregar un producto al inventario, mostrar todos los productos disponibles y buscar un producto por su nombre.
- Implementa un método para realizar una venta, que reduce la cantidad disponible del producto vendido. Si la _cantidadDisponible_ del producto ha llegado a cero no reducir la cantidad pero mostrar un mensaje con “Producto agotado”.
7. Ahora crea un archivo de _Aplicacion.java_ en el paquete com. Dentro de este archivo deberás de cumplir con los siguientes requisitos:
- Instancia objetos de diferentes tipos de productos electrónicos y agrégalos al inventario de la tienda.
- Realiza algunas ventas y verifica que la cantidad disponible de los productos se actualice correctamente.
- Muestra todos los productos disponibles en el inventario para verificar que se agregaron correctamente.