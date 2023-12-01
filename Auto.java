// se le declara clase llamada auto
class Auto {
    private String modelo; // le declaramos 3 variables privadas, estas variables representan las caracteriticas de un auto
    private double precio;
    private int cantidadDisponible;

    public Auto(String modelo, double precio, int cantidadDisponible) { // le definimos un constructor publico con el nombre de auto que tiene 3 parametros.  
        this.modelo = modelo;                                          // este constructor se utiliza para crear instancias de la clase y asigna valores proporcionados a las variables.
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getModelo() { // le definimos tres metodos publicos(getters) para que obtengamos los valores de las variables.  
        return modelo;          // estos metodos permiten acceder a la informacion del objeto "auto" desde fuera de la clase.
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void restarInventario(int cantidad) { // le definimos un metodo "restarInventario" este metodo permite que se reste la cantidad que vale el auto en el inventario.
        if (cantidadDisponible >= cantidad) {   // primero verifica si hay suficiente en el inventario para restar, y si no es asi, imprimimos un mensaje al usuario indicandole que no hay suficiente inventario. 
            cantidadDisponible -= cantidad;
        } else {
            System.out.println("No hay suficiente inventario disponible.");
        }
    }

    public void sumarInventario(int cantidad) { // OK, aqui definimos un metodo publico "SumarInventario" este metodo permite sumar la cantidad especificada al invetario del automovil.
        cantidadDisponible += cantidad;
    }

    @Override // Aqui sobre sobreescribimos el metodo "toString" de la clase "object" para que se represente de cadena del objeto "auto" este metodo influye en el model,calidad y precio.
    public String toString() {
        return "Auto [modelo=" + modelo + ", precio=" + precio + ", cantidadDisponible=" + cantidadDisponible + "]"; 
    } // el @Override es opcional pero es buena practica, ya que ayudamos al compilador a verificar que el metodo realmente está sobrescribiendo un método existente en la clase padre
      //  lo que puede evitar errores sutiles que podrían ocurrir si el desarrollador no está sobrescribiendo el método que pretendía sobrescribir.
      // consideramos que el @Override es opcional en el sentido estrictamente necesaria desde el punto de vista del compilador.
}     //  Puedes sobrescribir un método de una clase padre sin usar @Override, y el código seguirá siendo válido en términos de compilación.