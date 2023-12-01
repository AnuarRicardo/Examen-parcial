// importamos la clase "ArrayList" desde el paquete "java.util" esto es importante por que la clase empresa utiliza "ArrayList" para almacenar su inventario de autos.
import java.util.ArrayList;

class Empresa { // le declaramos la clase "Empresa" con dos variables privadas "Inventario" que es un "ArrayList" de objeto "Auto" y "factura" que es un objeto de la clase factura.
    private ArrayList<Auto> inventario;
    private Factura factura;

public Empresa(ArrayList<Auto> inventario) { // le definimos un constructor publico que toma el "ArrayList" de autos como parametro, Este constructor asigna este arraylist a "Inventario".
       this.inventario = inventario; // y crea una nueva instancia de la clase "factura".
       this.factura = new Factura();
   }
public void mostrarInventario() { // definimos un metodo publico llamado "mostrarInventario" que imprime por consola la informacion del inventario actual de la empresa.
        System.out.println("Inventario actual:");
        for (int i = 0; i < inventario.size(); i++) { // Usamos el bucle "for" para iterar sobre el ArrayList de autos y mostrar detalles como el modelo, precio y cantidad disponible.
        Auto auto = inventario.get(i);
        System.out.println(i + ": " + auto.getModelo() + " - Precio: $" + auto.getPrecio() + " USD - Cantidad: " + auto.getCantidadDisponible());
       }
    }

public double calcularInventarioInicial() { // definimos un metodo publico llamado "calcularinventario" que calculca y devuelve el valor del inventario multiplicando el precio de cada auto.
       double total = 0.0;                  // por la cantidad disponible y sumando los valores.
       for (Auto auto : inventario) {
       total += auto.getPrecio() * auto.getCantidadDisponible();
        }
        return total; // el return se utiliza para devolver el resultado del calculo del valor total del inventario.
    }
public void realizarCompra(int indice, int cantidad) { // definimos un metodo publico "realizarcompra" este metodo toma un indice y una cantidad como parametros.
        if (indice >= 0 && indice < inventario.size()) { // si el indice es valido, obtiene el auto que le corresponde del inventario y lo pasa al metodo "agregarcompra" de la factura.
            Auto autoComprado = inventario.get(indice);
            factura.agregarCompra(autoComprado, cantidad);
        } else {
            System.out.println("Indice de inventario no valido."); // y si no es valido le imprimimos mensaje al usuario "indice de inventario no valido"
        }
    }

public void realizarVenta(int indice, int cantidad) { // Otra vez definimos otro metodo publico llamado "realizar venta" que toma un indice y una cantidad como parametros.
       if (indice >= 0 && indice < inventario.size()) {// si el indice es valido obtiene el auto correspondiente del inventario. 
          Auto autoVendido = inventario.get(indice);// realiza la venta utilizando el método "sumarInventario" y muestra un mensaje indicando la venta realizada.
          autoVendido.sumarInventario(cantidad);
          System.out.println("Venta realizada: " + autoVendido.getModelo() + " - Cantidad: " + cantidad);
       } else {
           System.out.println("Indice de inventario no valido."); // y igual si no es valido, le imprimimos mensaje al usuario "indice de inventario no valido"
       }
 }

    public void mostrarFactura() { // Se define un metodo publico llamado "mostrarFactura" que invoca el metodo "mostrarFactura" de la instancia de la clase Factura almacenada en el miembro factura. 
        factura.mostrarFactura(); // este metodo mostrará la factura asociada a las compras realizadas.
    }
}
