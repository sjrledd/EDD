package examenfinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) {

        String texto = "";
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("matriz.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            String linea;
            String delimiter = ",";

            String matriz[][] = new String[3][3];
            int numlinea = 0;
            while (((linea = br.readLine()) != null)) {

                String a[] = linea.split(delimiter);
                System.arraycopy(a, 0, matriz[numlinea], 0, a.length);
                numlinea++;
            }
            System.out.println("MATRIZ");
            System.out.println("------");
            for (String[] matriz1 : matriz) {
                for (String item : matriz1) {
                    System.out.print(item + " ");
                }
                System.out.println("");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            System.out.println("\n");
            FileReader lector = new FileReader("matriz.txt");
            BufferedReader contenido = new BufferedReader(lector);

            while ((texto = contenido.readLine()) != null) {
                System.out.println(texto);
            }
        } catch (IOException e) {
            System.out.println("Error al leer");
        }
    }
}