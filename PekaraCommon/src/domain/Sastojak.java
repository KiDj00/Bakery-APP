/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class Sastojak extends AbstractDomainObject {

    private Pecivo pecivo;
    private int rbSastojka;
    private String nazivSastojka;

    public Sastojak(Pecivo pecivo, int rbSastojka, String nazivSastojka) {
        this.pecivo = pecivo;
        this.rbSastojka = rbSastojka;
        this.nazivSastojka = nazivSastojka;
    }

    public Sastojak() {
    }

    @Override
    public String nazivTabele() {
        return " sastojak ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return " JOIN PECIVO P ON (P.PECIVOID = S.PECIVOID) "
                + "JOIN TIPPECIVA TP ON (TP.TipPecivaID = P.TipPecivaID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            TipPeciva tp = new TipPeciva(rs.getLong("TipPecivaID"),
                    rs.getString("Naziv"));

            Pecivo p = new Pecivo(rs.getLong("PecivoID"), rs.getString("NazivPeciva"),
                    rs.getDouble("CenaPoKomadu"), rs.getString("Opis"), tp, null);

            Sastojak s = new Sastojak(p, rs.getInt("Rb"), rs.getString("NazivSastojka"));

            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (PecivoID, Rb, NazivSastojka) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " PecivoID = " + pecivo.getPecivoID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + pecivo.getPecivoID() + ", " + rbSastojka + ", "
                + "'" + nazivSastojka + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE P.PECIVOID = " + pecivo.getPecivoID();
    }

    public Pecivo getPecivo() {
        return pecivo;
    }

    public void setPecivo(Pecivo pecivo) {
        this.pecivo = pecivo;
    }

    public int getRbSastojka() {
        return rbSastojka;
    }

    public void setRbSastojka(int rbSastojka) {
        this.rbSastojka = rbSastojka;
    }

    public String getNazivSastojka() {
        return nazivSastojka;
    }

    public void setNazivSastojka(String nazivSastojka) {
        this.nazivSastojka = nazivSastojka;
    }

}
