package cz.itnetwork.evidencepojistencuv3;

import java.util.Objects;

/**
 *
 * @author Josef Valdman
 */
public class Pojistenec {

    private String jmeno;
    private String prijmeni;
    private long telefon;
    private short vek;

    public Pojistenec(String jmeno, String prijmeni, long telefon, short vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.vek = vek;
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the prijmeni
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @return the telefon
     */
    public long getTelefon() {
        return telefon;
    }

    /**
     * @return the vek
     */
    public short getVek() {
        return vek;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " " + vek + " " + telefon;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pojistenec other = (Pojistenec) obj;
        if (this.telefon != other.telefon) {
            return false;
        }
        if (this.vek != other.vek) {
            return false;
        }
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        return Objects.equals(this.prijmeni, other.prijmeni);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.jmeno);
        hash = 41 * hash + Objects.hashCode(this.prijmeni);
        hash = 41 * hash + (int) (this.telefon ^ (this.telefon >>> 32));
        hash = 41 * hash + this.vek;
        return hash;
    }
}
