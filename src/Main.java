import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        for (int x = 1000; x < 10000; x++) {
            list.add(String.valueOf(x));
        }

        Collections.shuffle(list);

        String[] array = list.toArray(new String[0]);
        ArrayList<String> newListNum = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            newListNum.add(array[i]);
        }

        // Elegir un índice aleatorio para el mensaje secreto  kyxent-Immortal-Dev
        Random random = new Random();
        int secretIndex = random.nextInt(10); // del 0 al 9

        // Mostrar los números, uno con mensaje secreto
        for (int i = 0; i < newListNum.size(); i++) {
            String num = newListNum.get(i);
            if (i == secretIndex) {
                System.out.println(num + " <- ESTE TIENE EL MENSAJE SECRETO 🔐");
            } else {
                System.out.println(num);
            }
        }
    }
}
