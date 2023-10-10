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
public class StavkaRacuna extends AbstractDomainObject {

    private Racun racun;
    private int rbStavke;
    private int kolicinaStavke;
    private double cenaStavke;
    private Pecivo pecivo;

    public StavkaRacuna(Racun racun, int rbStavke, int kolicinaStavke, double cenaStavke, Pecivo pecivo) {
        this.racun = racun;
        this.rbStavke = rbStavke;
        this.kolicinaStavke = kolicinaStavke;
        this.cenaStavke = cenaStavke;
        this.pecivo = pecivo;
    }

    public StavkaRacuna() {
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicinaStavke() {
        return kolicinaStavke;
    }

    public void setKolicinaStavke(int kolicinaStavke) {
        this.kolicinaStavke = kolicinaStavke;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Pecivo getPecivo() {
        return pecivo;
    }

    public void setPecivo(Pecivo pecivo) {
        this.pecivo = pecivo;
    }

    @Override
    public String nazivTabele() {
        return " stavkaRacuna ";
    }

    @Override
    public String alijas() {
        return " sr ";
    }

    @Override
    public String join() {
        return " JOIN RACUN R USING (RACUNID) "
                + "JOIN PECIVO P USING (PECIVOID) "
                + "JOIN TIPPECIVA TP ON (TP.TipPecivaID = P.TipPecivaID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = R.ADMINISTRATORID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Racun r = new Racun(rs.getLong("racunID"), rs.getTimestamp("Vreme"), 
                    rs.getDouble("cena"), rs.getDouble("KolicinskiRabat"), 
                    rs.getDouble("KonacnaCena"), a, null);
            
            TipPeciva tp = new TipPeciva(rs.getLong("TipPecivaID"),
                    rs.getString("Naziv"));

            Pecivo p = new Pecivo(rs.getLong("PecivoID"), rs.getString("NazivPeciva"),
                    rs.getDouble("CenaPoKomadu"), rs.getString("Opis"), tp, null);
            
            StavkaRacuna sr = new StavkaRacuna(r, rs.getInt("RB"), 
                    rs.getInt("Kolicina"), rs.getDouble("Cena"), p);

            lista.add(sr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (RacunID, RB, Kolicina, Cena, PecivoID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " RacunID = " + racun.getRacunID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + racun.getRacunID() + ", " + rbStavke + ", "
                + kolicinaStavke + ", " + cenaStavke + ", " + pecivo.getPecivoID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE R.RACUNID = " + racun.getRacunID();
    }

}
