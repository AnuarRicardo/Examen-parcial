//importamos las clases "Scanner","ArrayList","InputMismatchException" todas estas clases son importantes para el programa
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProgramaEmpresaAutos { // Se declara la clase principal ProgramaEmpresaAutos y su metodo main, que es el punto de entrada del programa.
    public static void main(String[] args) {
        Auto toyotaYaris = new Auto("Toyota Yaris Sedan", 20000.0, 10);
        Auto rush = new Auto("RUSH MANUAL HZ", 37500.0, 5);
        Auto hilux = new Auto("HILUX 2.4 MEC DC BAS 4X4", 25000.0, 8);
        Auto corollaCross = new Auto("COROLLA CROSS HEV FULL", 40000.0, 15);
        Auto landCruiser = new Auto("LAND CRUISER LC300 DIE AUT", 56000.0, 3);
        Auto prado = new Auto("PRADO TXL LTD AUT TELA", 35000.0, 7);
        Auto hyundaiTucson = new Auto("HYUNDAI Tucson 1.6 TGDI Nline", 28000.0, 12);
        Auto hyundaiI20 = new Auto("HYUNDAI i20 Active 1.0 TGDI", 34000.0, 20);
        Auto mitsubishiL200 = new Auto("Mitsubishi L200 GLS Mid 4x4", 32000.0, 9);
        Auto mitsubishiXpander = new Auto("Mitsubishi Xpander Cross", 38600.0, 6);
        Auto mitsubishiL200HighPower = new Auto("Mitsubishi L200 High Power Limited 4x4", 45400.0, 4);
        Auto kiaPicanto = new Auto("Kia Picanto", 13000.0, 18);
        Auto kiaSorento = new Auto("Kia Sorento", 28900.0, 11);
        Auto kiaSoluto = new Auto("Kia Soluto", 15000.0, 14);
//creamos instancias de la clase auto para representar diferentes modelos de autos, y se almacenan en un ArrayList llamado inventarioInicial. Luego se crea una instancia de la clase Empresa usando este inventario.
        
        ArrayList<Auto> inventarioInicial = new ArrayList<>();
        inventarioInicial.add(toyotaYaris);
        inventarioInicial.add(rush);
        inventarioInicial.add(hilux);
        inventarioInicial.add(corollaCross);
        inventarioInicial.add(landCruiser);
        inventarioInicial.add(prado);
        inventarioInicial.add(hyundaiTucson);
        inventarioInicial.add(hyundaiI20);
        inventarioInicial.add(mitsubishiL200);
        inventarioInicial.add(mitsubishiXpander);
        inventarioInicial.add(mitsubishiL200HighPower);
        inventarioInicial.add(kiaPicanto);
        inventarioInicial.add(kiaSorento);
        inventarioInicial.add(kiaSoluto);

        Empresa empresa = new Empresa(inventarioInicial);

        empresa.mostrarInventario();// Se muestra el inventario inicial de la empresa utilizando el metodo "mostrarInventario" y se calcula e imprime el inventario inicial total usando el metodo "calcularInventarioInicial".
        double inventarioInicialTotal = empresa.calcularInventarioInicial();
        System.out.println("Inventario Inicial Total: $" + inventarioInicialTotal + " USD");

        Scanner lector = new Scanner(System.in);
        char deseaContinuar;
        int intentos = 0;// aqui inicializamos el contador de intentos (que es cero).
        do { // Se utiliza un bucle do-while para permitir al usuario realizar compras. 
            try {
                System.out.println("Ingrese el numero del auto que desea comprar: ");
                int indiceCompra = lector.nextInt();
                System.out.println("Ingrese la cantidad que desea comprar: ");
                int cantidadCompra = lector.nextInt();
                empresa.realizarCompra(indiceCompra, cantidadCompra);
                intentos = 0; // Restablecer el numero de intentos si la entrada es exitosa
            } catch (InputMismatchException e) {// Se manejan excepciones para asegurarse de que el usuario ingrese valores numericos validos.
                System.out.println("Error: Ingrese un valor numérico válido.");
                lector.nextLine();
                intentos++;// aqui aumentan los intentos.
            }

            if (intentos >= 3) {
                System.out.println("Demasiados intentos incorrectos. Saliendo del programa.");// Se establece un límite de intentos, y si se supera ese límite, el programa se cierra.
                System.exit(0);
            }

            System.out.println("¿Desea realizar otra compra? (s/n): ");
            deseaContinuar = lector.next().charAt(0);// La expresion "lector.next" se utiliza para leer la proxima entrada del usuario como una cadena de texto. 
                                                     // Luego "charAt(0)" se utiliza para obtener el primer caracter de esa cadena, Despues de imprimir el mensaje, el programa espera que el usuario ingrese una respuesta.
        } while (deseaContinuar == 's' || deseaContinuar == 'S');

        empresa.mostrarFactura();

    
        System.out.println("Realizando venta al usuario...");
        empresa.realizarVenta(0, 1); // simulamos una venta al usuario, donde se realiza la venta de un auto (en este caso, el primer auto en el inventario) al usuario.

        empresa.mostrarInventario();// aqui en este metodo mostramos el inventario despues de la venta, junto con el calculo del inventario final total.
        double inventarioFinalTotal = empresa.calcularInventarioInicial();
        System.out.println("Inventario Final Total: $" + inventarioFinalTotal + " USD");

        
        lector.close();// aqui cerramos usamos el "lector.close" para cerrar el scanner.
    }
}
