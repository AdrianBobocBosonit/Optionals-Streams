import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) throws IOException {

        List<Persona> listaPersonas = OpenFile();

        System.out.println();
        System.out.println();
        for (Persona p: listaPersonas) {
            System.out.println(p.getNombre() + "-" + p.getPoblacion() + "-" + p.getEdad());
        }

        System.out.println();
        System.out.println();

        /*listaPersonas.stream().filter(personas -> personas.getEdad() < 25 )
                .filter(personas -> personas.getEdad() != 0)
                .map(personas -> personas.getNombre()+"-"+personas.getPoblacion()+"-"+personas.getEdad())
                .forEach(System.out::println);*/



        listaPersonas.stream().filter(personas -> personas.getEdad() < 25 )
                .filter(personas -> personas.getEdad() != 0)
                .map(personas -> "Nombre: " + Optional.ofNullable(personas.getNombre()).orElse("Unknown")+
                        " |Poblacion: " + Optional.ofNullable(personas.getPoblacion()).orElse("Unknown")+
                        " |Edad: " + Optional.ofNullable(personas.getEdad()).orElse(0))
                .forEach(System.out::println);
    }

    public static List<Persona> OpenFile() throws FileNotFoundException {
        List<Persona> peopleList = new ArrayList<>();
        File f = new File("Text1.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] person = s.split(":");
            Persona p=  new Persona();
            p.setNombre(person[0].isEmpty()?null:person[0]);
            p.setPoblacion(person[1].isEmpty()?null:person[1]);
            p.setEdad(person.length>2?Integer.parseInt(person[2]):0);
            peopleList.add(p);
        }
        return peopleList;
    }
}
