import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) throws IOException {
            //Establecer el nombre del archivo a leer (tiene que estar en la base del proyecto)
        String nombreArchivo = "Text1.txt";

            //Declarar una variable BufferedReader
        BufferedReader br = null;

            //Se declara una lista de personas vacia
        List<Persona> listaPersonas = new ArrayList<>();

            //Se declara un objeto "Persona" vacio
        Persona persona = null;


        br = new BufferedReader(new FileReader(nombreArchivo));
        String texto = br.readLine();
        while (texto != null) {
            persona = new Persona();

            System.out.println(texto);

            String[] textoSplited = texto.split(":");

            if (textoSplited[0].isEmpty()) {
                persona.setNombre("unknown");
            } else {
                persona.setNombre(textoSplited[0]);
            }

            if (textoSplited[1].isEmpty()) {
                persona.setPoblacion("unknown");
            } else {
                persona.setPoblacion(textoSplited[1]);
            }

            if (textoSplited.length < 3) {
                persona.setEdad(0);
            } else {
                persona.setEdad(Integer.valueOf(textoSplited[2]));
            }

            listaPersonas.add(persona);

            texto = br.readLine();
        }
        System.out.println();
        System.out.println();
        for (Persona p: listaPersonas) {
            System.out.println(p.getNombre() + "-" + p.getPoblacion() + "-" + p.getEdad());
        }

        System.out.println();
        System.out.println();

        listaPersonas.stream().filter(personas -> personas.getEdad() < 25 )
                .filter(personas -> personas.getEdad() != 0)
                .map(personas -> personas.getNombre()+"-"+personas.getPoblacion()+"-"+personas.getEdad())
                .forEach(System.out::println);
    }
}
