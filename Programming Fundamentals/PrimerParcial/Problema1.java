/**
 * Este programa permite al usuario ingresar las horas trabajadas y el pago de un trabajador y calcular su pago neto, bruto y el impuesto
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 06/09/16
 * 
 * Entradas: Horas trabajadas y pago por hora
 * Proceso: Calcula pago bruto, impuesto y pago neto
 * Salidas: Pago bruto, impuesto y pago neto
 */
import java.util.Scanner;
public class Problema1
{
   public static void main(String args[])
   {
       // crear scanner
       Scanner entrada = new Scanner(System.in);
       
       // entradas
       System.out.print("Ingrese el pago por hora del trabajador: ");
       double pago = entrada.nextDouble();
       System.out.print("Ingrese el número de horas trabajadas a la semana: ");
       int horas = entrada.nextInt();
       
       // proceso
       double pagoBruto = horas * pago;
       double impuesto = pagoBruto * 0.35;
       double pagoNeto = pagoBruto - impuesto;
       
       // salidas
       System.out.println("Pago bruto: " + pagoBruto);
       System.out.println("Impuesto retenido al trabajador: " + impuesto);
       System.out.println("Pago neto: " + pagoNeto);
   } // fin de main
} // fin de la clase
