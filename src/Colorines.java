import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Colorines extends Thread {
    private int numColor = 0;
    private ArrayList<String> colores;
    public static int coloresTotales = 0;
    private static Semaphore sem = new Semaphore(1);

    public Colorines(String name, ArrayList<String>colores) {
        super(name);
        this.numColor = numColor;
        start();
    }

    @Override
    public void run() {
        for (String color :colores){
            if (color.equalsIgnoreCase(getName())){
                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
                coloresTotales++;
                sem.release();
                numColor++;
            }
        }
        System.out.println("Soy el color " + getName() + " y aparezco " + numColor + " veces.");
    }
}
