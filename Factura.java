// importamos la clase "ArrayList" desde el paquete "java.util" esto es importante por que la clase factura utiliza "ArrayList" para almacenar los autos comprados.
import java.util.ArrayList;

class Factura { // como siempre, declaramos una clase "factura" con dos variables privadas "autoscomprados", que es un "ArrayList" de objetos tipo "auto" y "total" que es un double para representar el total de la factura.
    private ArrayList<Auto> autosComprados;
    private double total;

public Factura() {// definimos un constructor publico que inicializa la lista de autos comprados como un nuevo "ArrayList" y establece el total en 0.0 al momento de crear la instancia de la clase "factura".
        this.autosComprados = new ArrayList<>();
        this.total = 0.0;
    }

public void agregarCompra(Auto auto, int cantidad){ // definimos otro metodo llamado "agregarcompra" que toma un objeto "auto" y una cantidad como parametros, verifica si hay suficiente inventario disponible para la compra.
       if (auto.getCantidadDisponible() >= cantidad) { // y si es así, agrega el auto a la lista autosComprados, actualiza el total de la factura y realiza la resta correspondiente en el inventario del auto.
          autosComprados.add(auto);
          total += auto.getPrecio() * cantidad;
          auto.restarInventario(cantidad);
          System.out.println("Compra realizada: " + auto.getModelo() + " - Cantidad: " + cantidad);
       } else {
           System.out.println("No hay suficiente inventario disponible para la compra.");// y si no hay suficiente inventario, se le imprime un mensaje al usuario "no hay suficiente inventario para la compra".
        }
    }

public void mostrarFactura() {//Se define un método publico llamado "mostrarFactura", que imprime por consola la informacion detallada de la factura, incluyendo el modelo, precio y cantidad disponible para cada auto comprado, asi como el total de la factura.
       System.out.println("Factura:");// se imprime el encabezado de la factura indicando que esta mostrando la factura.
       for (Auto auto : autosComprados) { // el "for" se utiliza para iterar sobre la lista de autos comprados e imprimir la informacion de cada auto en la factura.
         System.out.println(auto.getModelo() + " - Precio: $" + auto.getPrecio() + " USD - Cantidad: " + auto.getCantidadDisponible());// el "auto" es una instancia de la clase "auto", "getmodelo" es un metodo de la clase "auto" que devuelve el modelo del automovil. 
     }                                                                                                                                // "auto" es una instancia de la clase "auto", "getcantidaddisponible" es un metodo de la clase "auto" que devuelve la cantidad disponible del automovil.
       System.out.println("Total: $" + total + " USD");                                                                              // "getprecio" es un metodo de la clase Auto que devuelve el precio del automóvil, auto.getPrecio() obtiene el precio del automovil.
                                                                                                                                     
    }
}
