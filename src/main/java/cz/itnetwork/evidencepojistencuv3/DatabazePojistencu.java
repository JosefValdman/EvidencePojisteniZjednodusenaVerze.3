package cz.itnetwork.evidencepojistencuv3;

import java.util.ArrayList;
import java.util.List;

/**
 * Správa Databáze Pojištěnců
 *
 * @author Josef Valdman
 */
public class DatabazePojistencu {

    private List<Pojistenec> databaze;

    public DatabazePojistencu() {
        databaze = new ArrayList<>();
    }

    public boolean jePrazdna() {
        return databaze.isEmpty();
    }

    /**
     * *Přidání pojištěného* Pokud je Databáze prázdná, přidá rovnou.Pokud ne
     * porovná s uloženými
     */
    public String pridejPojisteneho(String jmeno, String prijmeni, long telefon, short vek) {
        if (databaze.isEmpty()) {
            databaze.add(new Pojistenec(jmeno, prijmeni, telefon, vek));
            return "\nData byla uložena. Pokračujte libovolnou klávesou...";
        } else {
            Pojistenec zaznam = new Pojistenec(jmeno, prijmeni, telefon, vek);

            for (int i = 0; i < databaze.size(); i++) {
                if (!databaze.get(i).equals(zaznam)) {
                    databaze.add(zaznam);
                    return "\nData byla uložena. Pokračujte libovolnou klávesou...";
                }
            }
            return "\nJiž je v Evidenci. Pokračujte libovolnou klávesou...";
        }
    }

    /**
     * Vrací kopii Databáze
     */
    public List<Pojistenec> najdiPojistene() {
        return new ArrayList<>(databaze);
    }

    // Předchozí verze vyhledáváni přesně podle jména a příjmeni
/*    public List<Pojistenec> najdiPojisteneho(String jmeno, String prijmeni) {
        List<Pojistenec> nalezene = new ArrayList<>();
        for (Pojistenec pojistenec : databaze) {
            if (pojistenec.getJmeno().equalsIgnoreCase(jmeno) && pojistenec.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                nalezene.add(pojistenec);
            }
        }
        return nalezene;
    }
*/
    /**
     * Vyhledávání Jména a Příjmení podle rovnosti nebo počátečních písmen.
     */
    public List<Pojistenec> najdiPojisteneho(String jmeno, String prijmeni) {
        List<Pojistenec> nalezene = new ArrayList<>();
        for (Pojistenec pojistenec : databaze) {
            if (pojistenec.getJmeno().equalsIgnoreCase(jmeno) && pojistenec.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                nalezene.add(pojistenec);
            } else if (pojistenec.getJmeno().toLowerCase().startsWith(jmeno.toLowerCase()) && pojistenec.getPrijmeni().toLowerCase().startsWith(prijmeni.toLowerCase())) {
                nalezene.add(pojistenec);
            }
        }
        return nalezene;
    }

    /**
     * Vyhledávání Jména nebo Příjmení podle rovnosti nebo počátečních písmen.
     */
    public List<Pojistenec> najdiPojisteneho(String test) {
        List<Pojistenec> nalezene = new ArrayList<>();
        for (Pojistenec pojistenec : databaze) {
            if (pojistenec.getJmeno().equalsIgnoreCase(test)
                    || pojistenec.getJmeno().toLowerCase().startsWith(test.toLowerCase())) {
                nalezene.add(pojistenec);
            } else if (pojistenec.getPrijmeni().equalsIgnoreCase(test)
                    || pojistenec.getPrijmeni().toLowerCase().startsWith(test.toLowerCase())) {
                nalezene.add(pojistenec);
            }
        }
        return nalezene;
    }

}
