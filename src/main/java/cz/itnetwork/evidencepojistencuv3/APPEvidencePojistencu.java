package cz.itnetwork.evidencepojistencuv3;

import java.util.Scanner;

/**
 *
 * @author Josef Valdman
 */
public class APPEvidencePojistencu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SpravaPojistencu ui = new SpravaPojistencu();
        String prikaz = "";
        while (!prikaz.equals("4")) {
            // Menu
            System.out.println("--------------------------------");
            System.out.println("Evidence Pojištěných");
            System.out.println("--------------------------------\n");
            System.out.println("Vyberte si akci: ");
            System.out.println("1 - Přidat nového pojištěnce");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");

            prikaz = sc.nextLine().trim();

            switch (prikaz) {
                case "1":
                    //1 - Přidat nového pojištěnce
                    ui.pridejPojisteneho();
                    break;
                case "2":
                    //2 - Vypsat všechny pojištěné
                    ui.vypisVsechnyPojistene();
                    break;
                case "3":
                    //3 - Vyhledat pojištěného
                    ui.vyhledejPojisteneho();
                    break;
                case "4":
                    //4 - Konec
                    System.out.println("Zavírám ");
                    //System.exit(0);
                    break;
                default:
                    System.out.println("Neplatná volba, zopakujte prosim volbu.");
                    break;
            }
        }
    }
}
