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
public class Pecivo extends AbstractDomainObject {

    private Long pecivoID;
    private String nazivPeciva;
    private double cena;
    private String opis;
    private TipPeciva tipPeciva;
    private ArrayList<Sastojak> sastojci;

    @Override
    public String toString() {
        return nazivPeciva + " (Cena po komadu: " + cena + "din)";
    }

    public Pecivo(Long pecivoID, String nazivPeciva, double cena, String opis,
            TipPeciva tipPeciva, ArrayList<Sastojak> sastojci) {
        this.pecivoID = pecivoID;
        this.nazivPeciva = nazivPeciva;
        this.cena = cena;
        this.opis = opis;
        this.tipPeciva = tipPeciva;
        this.sastojci = sastojci;
    }

    public Pecivo() {
    }

    @Override
    public String nazivTabele() {
        return " pecivo ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return " JOIN TIPPECIVA TP ON (TP.TipPecivaID = P.TipPecivaID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            TipPeciva tp = new TipPeciva(rs.getLong("TipPecivaID"),
                    rs.getString("Naziv"));

            Pecivo p = new Pecivo(rs.getLong("PecivoID"), rs.getString("NazivPeciva"),
                    rs.getDouble("CenaPoKomadu"), rs.getString("Opis"), tp, null);

            lista.add(p);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivPeciva, CenaPoKomadu, Opis, TipPecivaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " PecivoID = " + pecivoID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivPeciva + "', " + cena + ", "
                + "'" + opis + "', " + tipPeciva.getTipPecivaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " NazivPeciva = '" + nazivPeciva + "', "
                + "cenaPoKomadu = " + cena + ", opis = '" + opis + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getPecivoID() {
        return pecivoID;
    }

    public void setPecivoID(Long pecivoID) {
        this.pecivoID = pecivoID;
    }

    public String getNazivPeciva() {
        return nazivPeciva;
    }

    public void setNazivPeciva(String nazivPeciva) {
        this.nazivPeciva = nazivPeciva;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public TipPeciva getTipPeciva() {
        return tipPeciva;
    }

    public void setTipPeciva(TipPeciva tipPeciva) {
        this.tipPeciva = tipPeciva;
    }

    public ArrayList<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }

}
