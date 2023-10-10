/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class Racun extends AbstractDomainObject {
    
    private Long racunID;
    private Date datumVreme;
    private double cena;
    private double kolicinskiRabat;
    private double konacnaCena;
    private Administrator administrator;
    private ArrayList<StavkaRacuna> stavkeRacuna;

    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    public Racun(Long racunID, Date datumVreme, double cena, double kolicinskiRabat, double konacnaCena,
            Administrator administrator, ArrayList<StavkaRacuna> stavkeRacuna) {
        this.racunID = racunID;
        this.datumVreme = datumVreme;
        this.cena = cena;
        this.kolicinskiRabat = kolicinskiRabat;
        this.konacnaCena = konacnaCena;
        this.administrator = administrator;
        this.stavkeRacuna = stavkeRacuna;
    }

    public Racun() {
    }
    
    @Override
    public String nazivTabele() {
        return " racun ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = R.ADMINISTRATORID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Racun r = new Racun(rs.getLong("racunID"), rs.getTimestamp("Vreme"), 
                    rs.getDouble("Cena"), rs.getDouble("KolicinskiRabat"), 
                    rs.getDouble("KonacnaCena"), a, null);

            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Vreme, Cena, KolicinskiRabat, KonacnaCena, AdministratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " racunID = " + racunID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', " + cena + ", "
                + kolicinskiRabat + ", " + konacnaCena + ", " + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getRacunID() {
        return racunID;
    }

    public void setRacunID(Long racunID) {
        this.racunID = racunID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getKolicinskiRabat() {
        return kolicinskiRabat;
    }

    public void setKolicinskiRabat(double kolicinskiRabat) {
        this.kolicinskiRabat = kolicinskiRabat;
    }

    public double getKonacnaCena() {
        return konacnaCena;
    }

    public void setKonacnaCena(double konacnaCena) {
        this.konacnaCena = konacnaCena;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    
}
