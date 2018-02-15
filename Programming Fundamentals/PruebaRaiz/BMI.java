
/**
 * Write a description of class BMI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class BMI
{
    public static void main()
    {
        double w, h;
        double bmi;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduzca su peso en kilogramos: ");
        w = entrada.nextDouble();
        System.out.println("Introduzca su altura en metros: ");
        h = entrada.nextDouble();
        
        bmi = w/(Math.pow(h,2.0));
        
        if(bmi<18.5)
        {
            System.out.println("El IMC calculado con los datos introducidos (" + bmi + ") está dentro de la categoría de bajo peso");
        }
        if(bmi>=18.5&&bmi<25)
        {
            System.out.println("El IMC calculado con los datos introducidos (" + bmi + ") está dentro de la categoría normal");
        }
        if(bmi>=25&&bmi<30)
        {
            System.out.println("El IMC calculado con los datos introducidos (" + bmi + ") está dentro de la categoría de sobrepeso");
        }
        if(bmi>=30)
        {
            System.out.println("El IMC calculado con los datos introducidos (" + bmi + ") está dentro de la categoría de obesidad");
        }
    }
}
