import crypto.*;

import iostring.ReadWrite;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static String percorso;

    public static void main(String[] args) throws IOException {
        inputPercorso();
        ReadWrite ciao = new ReadWrite(percorso);

        String menu = ciao.readAll();
        label:
        while (true) {
            String res = inputMenu("Scegli che cosa vorresti fare [a=cripta/b=decripta/c=stampa/]: ");
            switch (res) {
                case "a":
                    menu = algoSelect().crypt(menu);
                    break;
                case "b":
                    menu = algoSelect().decrypt(menu);
                    break;
                case "c":
                    menu = (menu);
                    break;    
                case "d":
                    break label;
                default:
                    System.out.println("Hai inserito un opzione inesistente!");
            }
            ciao.write(menu);
        }
    }

    private static MenuCrittazione algoSelect() {
        MenuCrittazione value;
        String res = inputMenu("Seleziona il metodo di crittazione: [a=algo. Caesar/b=xorAlgo. XOR/c=torna indietro]: ");

        value = switch (res) {
            case "a" -> new Caesar();
            case "b" -> new XOR();
        };

        return value;
    }

    private static String inputMenu(String menuString) {
        Scanner console = new Scanner(System.in);
        String res;
        while (true) {
            System.out.print(menuString);
            res = console.nextLine();
            if (res.length() != 1) continue;

            boolean isNumeric = Character.isAlphabetic(res.charAt(0));
            if (!isNumeric) continue;

            break;
        }
        return res.toLowerCase();
    }

    private static void inputPercorso(){
        Scanner console = new Scanner(System.in);
        System.out.print("Path del file: ");
        percorso = console.nextLine();
    }
}
