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
public class TipPeciva extends AbstractDomainObject {

    private Long tipPecivaID;
    private String nazivTipaPeciva;

    @Override
    public String toString() {
        return nazivTipaPeciva;
    }

    public TipPeciva(Long tipPecivaID, String nazivTipaPeciva) {
        this.tipPecivaID = tipPecivaID;
        this.nazivTipaPeciva = nazivTipaPeciva;
    }

    public TipPeciva() {
    }

    @Override
    public String nazivTabele() {
        return " tipPeciva ";
    }

    @Override
    public String alijas() {
        return " tp ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            TipPeciva tp = new TipPeciva(rs.getLong("TipPecivaID"),
                    rs.getString("Naziv"));

            lista.add(tp);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " tipPecivaID = " + tipPecivaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTipPecivaID() {
        return tipPecivaID;
    }

    public void setTipPecivaID(Long tipPecivaID) {
        this.tipPecivaID = tipPecivaID;
    }

    public String getNazivTipaPeciva() {
        return nazivTipaPeciva;
    }

    public void setNazivTipaPeciva(String nazivTipaPeciva) {
        this.nazivTipaPeciva = nazivTipaPeciva;
    }

}
