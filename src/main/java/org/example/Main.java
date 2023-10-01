package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String rutaInicial;

        // Si se pasa como parametro la ruta la usa sino la ruta en que nos encontramos.
        rutaInicial = args.length >= 1 ? args[0] : ".";
        File fichero = new File(rutaInicial);

        // Existe la ruta
        if(fichero.exists()) {
            if(fichero.isFile()) {
                System.out.println(fichero.getName() + "es un fichero");
            } else {
                // Se trata de un directorio
                System.out.println("Es un directorio: " + fichero.getCanonicalPath());
                File[] contenidoRuta = fichero.listFiles();
                for(File ff: contenidoRuta) {
                    String infoFichero = ff.isFile() ? "[ ]" : "[/]";
                    System.out.printf("%6s %s\n", infoFichero, ff.getName());
                }
            }
        } else {
            System.out.println("La ruta no existe: " + fichero.getAbsolutePath());
            System.exit(0);
        }
    }
}