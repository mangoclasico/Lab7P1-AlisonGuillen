/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1.alisonguillen;

import java.util.Scanner;
/**
 *
 * @author Dell i7
 */
public class Lab7P1AlisonGuillen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        int respuesta = 1;

        while (respuesta != 4) {
            System.out.println("\nMenu");
            System.out.println("1. Numero equilibrado");
            System.out.println("2. Numero solitario");
            System.out.println("3. Intercambio de filas y/o columnas");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opcion: ");

            int opcionmenu = rd.nextInt();
            rd.nextLine(); 

            switch (opcionmenu) {
                case 1:
                    System.out.println("Ingrese cantidad de filas: ");
                    int filas = rd.nextInt();
                    System.out.println("Ingrese cantidad de columnas: ");
                    int col = rd.nextInt();
    }
    
        }
    }
}
