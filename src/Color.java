import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Color {
    static ArrayList<String> colores = new ArrayList<>();
    public static void main(String[] args) {
     String opcion;
     do {
         menu();
         opcion = recogerString();
         realizarAccion(opcion);
     }while (!opcion.equals("4"));
     Colorines rojo = new Colorines("Rojo",colores);
     Colorines verde = new Colorines("Verde", colores);
     Colorines azul = new Colorines("Azul", colores);

        try {
            rojo.join();
            verde.join();
            azul.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    private static void realizarAccion(String opcion) {
        switch (opcion){
            case "1" -> colores.add("Rojo");
            case "2" -> colores.add("Verde");
            case "3" -> colores.add("Azul");
        }
    }

    private static String recogerString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer");

        }
        return "error";
    }

    private static void menu() {
        System.out.println("Selecciona un color, cuando no quieras seleccionar mas, le das a salir.");
        System.out.println("1. Rojo");
        System.out.println("2. Azul");
        System.out.println("3. Verde");
        System.out.println("4. salir");
    }
}