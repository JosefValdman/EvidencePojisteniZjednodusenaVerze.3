package cz.itnetwork.evidencepojistencuv3;

import java.util.List;
import java.util.Scanner;

/**
 * UI - načítání a vracení dat
 *
 * @author Josef Valdman
 */
public class SpravaPojistencu {

    private Scanner sc = new Scanner(System.in);
    private DatabazePojistencu databaze = new DatabazePojistencu();
    private List<Pojistenec> evidence;
    boolean jeSpravne; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu

    private boolean jeDatabazePrazdna() {
        return databaze.jePrazdna();
    }

    private String zjistiJmeno() { // jméno
        System.out.println("Zadejte jméno pojištěného: ");
        return sc.nextLine().trim();
    }

    private String zjistiPrijmeni() { // příjmení
        System.out.println("Zadejte příjmení: ");
        return sc.nextLine().trim();
    }

    private short zjistiVek() {
        jeSpravne = false; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
        System.out.println("Zadejte věk: ");
        short vek = 0;
        while (!jeSpravne) {
            try {
                vek = Short.parseShort(sc.nextLine().trim());
                if (vek > 0 && vek <= 130) {
                    jeSpravne = true; //Nastavení booleanu jeSpravne na true, které ukončení zacyklení cyklu while
                } else {
                    System.out.println("Prosím zadejte znovu Váš věk.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Zadaná hodnota není číslo, prosím zadejte znovu.");
            }
        }
        return vek;
    }

    private long zjistiTelefon() {
        jeSpravne = false; //Kontolní boolean, který slouží k potvrzení zadání správného vstupu
        System.out.println("Zadejte telefoní číslo: ");
        long telefon = 0;
        while (!jeSpravne) {
            try {
                telefon = Long.parseLong(sc.nextLine().trim());
                if (telefon > 100000000) {
                    jeSpravne = true; //Nastavení booleanu jeSpravne na true, které ukončení zacyklení cyklu while
                } else {
                    System.out.println("Minimální délka je 9 číslic, prosím zadejte znovu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadaná hodnota není číslo, prosím zadejte znovu.");
            }
        }
        return telefon;
    }

    public void pridejPojisteneho() {
        String jmeno = "";
        while (jmeno.isEmpty()) {
            jmeno = zjistiJmeno();
        }
        String prijmeni = "";
        while (prijmeni.isEmpty()) {
            prijmeni = zjistiPrijmeni();
        }
        long telefon = zjistiTelefon();
        short vek = zjistiVek();
        String zprava = databaze.pridejPojisteneho(jmeno, prijmeni, telefon, vek);
        System.out.println(zprava);
        sc.nextLine();
    }

    // Předchozí verze vyhledáváni přesně podle jména a příjmeni
/*    public void vyhledejPojisteneho() {
        if (!jeDatabazePrazdna()) {
            String jmeno = zjistiJmeno();
            String prijmeni = zjistiPrijmeni();
            System.out.printf("Hledáte jmeno: %s, příjmení: %s.\n\n", jmeno, prijmeni);
            evidence = databaze.najdiPojisteneho(jmeno, prijmeni);
            if (evidence.isEmpty()) {
                System.out.println("\nNení v Evidenci!");
            }
            evidence.forEach(System.out::println);
        }
        System.out.println(doplnText());
        sc.nextLine();
    }
 */

    public void vyhledejPojisteneho() {
        if (!jeDatabazePrazdna()) {
            String jmeno = zjistiJmeno();
            String prijmeni = zjistiPrijmeni();
            System.out.printf("Hledáte jmeno: %s, příjmení: %s.\n\n", jmeno, prijmeni);
            String test;
            if (jmeno.isEmpty() || prijmeni.isEmpty()) {
                if (!jmeno.isEmpty()) {
                    test = jmeno;
                } else {
                    test = prijmeni;
                }
                evidence = databaze.najdiPojisteneho(test);
            } else {
                evidence = databaze.najdiPojisteneho(jmeno, prijmeni);
            }
            if (evidence.isEmpty()) {
                System.out.println("\nNení v Evidenci!");
            }
            evidence.forEach(System.out::println);
        }
        System.out.println(doplnText());
        sc.nextLine();
    }

    public void vypisVsechnyPojistene() {
        if (!jeDatabazePrazdna()) {
            System.out.println();
            evidence = databaze.najdiPojistene();
            evidence.forEach(System.out::println);
        }
        System.out.println(doplnText());
        sc.nextLine();
    }

    private String doplnText() {
        if (jeDatabazePrazdna()) {
            return "\nDatabáze je prázdna.Pokračujte libovolnou klávesou...";
        }
        return "\nPokračujte libovolnou klávesou...";
    }
}
