/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1.alisonguillen;

import java.util.Scanner;
import java.util.Random;

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
                    int n, m;
                    System.out.print("Ingrese cantidad de columnas: ");
                    n = rd.nextInt();
                    System.out.print("Ingrese cantidad de filas: ");
                    m = rd.nextInt();

                    int[][] matriz = new int[n][m];
                    generarMatriz(matriz);
                    imprimirMatriz(matriz);
                    encontrarNumeroEquilibrado(matriz);
                    break;
              case 2:
                  int n2, m2;
                  System.out.println("Ingrese cantidad de columnas");
                  n2 = rd.nextInt();
                  System.out.println("Ingrese cantidad de filas");
                  m2 = rd.nextInt();
                  
                  
                  break;
                  
                 case 4:
                    System.out.println("salir ");
                    respuesta = 4;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } 
    }

    public static void generarMatriz(int[][] matriz) {
        Random ran = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ran.nextInt(5) + 2;
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
    }

public static void encontrarNumeroEquilibrado(int[][] matriz) {
    int filae = 0;
    int columnae= 0;
    int mindif = Integer.MAX_VALUE;

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            int filasum= 0;
            int columnasum = 0;
            for (int k = 0; k < matriz.length; k++) {
                if (k != i) {
                    filasum+= matriz[k][j];
                }
            }
            for (int k = 0; k < matriz[i].length; k++) {
                if (k != j) {
                    columnasum += matriz[i][k];
                }
            }

            int dif = filasum - columnasum;
            if (dif < 0) {
                dif = -dif; 
            }

            if (dif < mindif) {
                mindif = dif;
                filae = i;
                columnae = j;
            }
        }
    }
    System.out.println("El punto de equilibrio esta en [" + filae + "][" + columnae + "] = " +
            matriz[filae][columnae] + " porque su suma en horizontal es " +
            sumarFila(matriz, filae, columnae) + " y su suma en vertical es " +
            sumarColumna(matriz, filae, columnae) + ".");
}

    public static int sumarFila(int[][] matriz, int fila, int columna) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (i != fila) {
                suma += matriz[i][columna];
            }
        }
        return suma;
    }

    public static int sumarColumna(int[][] matriz, int fila, int columna) {
        int suma = 0;
        for (int j = 0; j < matriz[fila].length; j++) {
            if (j != columna) {
                suma += matriz[fila][j];
            }
        }
        return suma;
    }

public static void encontrarNumeroSolitario(int[][] matriz) {
    int numsolitario = 0;
    int isoledad = Integer.MAX_VALUE;

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            int sumatot = sumarAlrededor(matriz, i, j);
            if (sumatot < isoledad) {
                isoledad = sumatot;
                numsolitario = matriz[i][j];
            }
        }
    }

    System.out.println("El digito mas solitario es " + numsolitario + " con un indice de soledad de " + isoledad);
}

public static int sumarAlrededor(int[][] matriz, int fila, int columna) {
    int suma = 0;
    int valoractual = matriz[fila][columna];
    if (fila > 0) {
        suma += matriz[fila - 1][columna];
    }
    if (fila < matriz.length - 1) {
        suma += matriz[fila + 1][columna];
    }

    // Izquierda
    if (columna > 0) {
        suma += matriz[fila][columna - 1];
    }

    // Derecha
    if (columna < matriz[fila].length - 1) {
        suma += matriz[fila][columna + 1];
    }

    return suma;
}
}
                