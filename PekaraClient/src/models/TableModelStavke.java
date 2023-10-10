/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelStavke extends AbstractTableModel {

    private ArrayList<StavkaRacuna> lista;
    private String[] kolone = {"Rb", "Pecivo", "Kolicina", "Cena"};
    private int rb = 0;

    public TableModelStavke() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        StavkaRacuna sr = lista.get(row);


        switch (column) {
            case 0:
                return sr.getRbStavke();
            case 1:
                return sr.getPecivo();
            case 2:
                return sr.getKolicinaStavke();
            case 3:
                return sr.getCenaStavke();

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaRacuna sr) {

        for (StavkaRacuna stavkaRacuna : lista) {
            if (sr.getPecivo().getPecivoID().equals(stavkaRacuna.getPecivo().getPecivoID())) {
                stavkaRacuna.setKolicinaStavke(stavkaRacuna.getKolicinaStavke() + sr.getKolicinaStavke());
                stavkaRacuna.setCenaStavke(stavkaRacuna.getCenaStavke() + sr.getCenaStavke());
                fireTableDataChanged();
                return;
            }
        }

        rb = lista.size();
        sr.setRbStavke(++rb);
        lista.add(sr);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaRacuna sr : lista) {
            sr.setRbStavke(++rb);
        }

        fireTableDataChanged();
    }

    public ArrayList<StavkaRacuna> getLista() {
        return lista;
    }

    public double getUkupnaCena() {
        double ukupnaCena = 0;
        for (StavkaRacuna stavkaRacuna : lista) {
            ukupnaCena += stavkaRacuna.getCenaStavke();
        }
        return ukupnaCena;
    }

    public int getUkupnaKolicina() {
        int ukupnaKolicina = 0;
        for (StavkaRacuna stavkaRacuna : lista) {
            ukupnaKolicina += stavkaRacuna.getKolicinaStavke();
        }
        return ukupnaKolicina;
    }

}
