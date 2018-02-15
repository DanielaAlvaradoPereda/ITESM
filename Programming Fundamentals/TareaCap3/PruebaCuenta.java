/**
 * Este programa permite al usuario crear objetos de la clase Cuenta y manipular el saldo de cada cuenta
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 05/09/16
 * 
 * Entradas: Montos a depostar o retirar de las cuentas
 * Proceso: Llama a los metodos depositar y retirar para que realicen los procesos
 * Salidas: Los saldos de las cuentas despues de cada operacion
 */
import java.util.Scanner;
public class PruebaCuenta
{
    public static void main(String[] args)
    {
        // crear dos objetos Cuenta
        Cuenta cuenta1 = new Cuenta("Jane Green", 50.00);
        Cuenta cuenta2 = new Cuenta("John Blue", -7.53);
        
        // obtener saldos
        System.out.println("Saldo de " + cuenta1.obtenerNombre() + ": " + cuenta1.obtenerSaldo());
        System.out.println("Saldo de " + cuenta2.obtenerNombre() + ": " + cuenta2.obtenerSaldo());
        
        Scanner entrada = new Scanner(System.in);
        
        // depositar a cuenta1
        System.out.println("\nEscriba el monto a depositar para cuenta1");
        double montoDeposito = entrada.nextDouble();
        System.out.println("Sumando " + montoDeposito + " al saldo de cuenta1");
        cuenta1.depositar(montoDeposito);
        
        // obtener saldos
        System.out.println("\nSaldo de " + cuenta1.obtenerNombre() + ": " + cuenta1.obtenerSaldo());
        System.out.println("Saldo de " + cuenta2.obtenerNombre() + ": " + cuenta2.obtenerSaldo());
        
        // depositar a cuenta2
        System.out.println("\nEscriba el monto a depositar para cuenta2");
        montoDeposito = entrada.nextDouble();
        System.out.println("Sumando " + montoDeposito + " al saldo de cuenta2");
        cuenta2.depositar(montoDeposito);
        
        // obtener saldos
        System.out.println("\nSaldo de " + cuenta2.obtenerNombre() + ": " + cuenta1.obtenerSaldo());
        System.out.println("Saldo de " + cuenta2.obtenerNombre() + ": " + cuenta2.obtenerSaldo());
        
        // retirar de cuenta1
        System.out.println("\nEscriba el monto a retirar para cuenta1");
        double montoRetiro = entrada.nextDouble();
        System.out.println("Restando " + montoRetiro + " al saldo de cuenta1");
        cuenta1.retirar(montoRetiro);
        
        // obtener saldos
        System.out.println("\nSaldo de " + cuenta2.obtenerNombre() + ": " + cuenta1.obtenerSaldo());
        System.out.println("Saldo de " + cuenta2.obtenerNombre() + ": " + cuenta2.obtenerSaldo());
        
        // retirar de cuenta2
        System.out.println("\nEscriba el monto a retirar para cuenta2");
        montoRetiro = entrada.nextDouble();
        System.out.println("Restando " + montoRetiro + " al saldo de cuenta2");
        cuenta2.retirar(montoRetiro);
        
        // obtener saldos
        System.out.println("\nSaldo de " + cuenta2.obtenerNombre() + ": " + cuenta1.obtenerSaldo());
        System.out.println("Saldo de " + cuenta2.obtenerNombre() + ": " + cuenta2.obtenerSaldo());
    } // fin de main
} // find de la clase
