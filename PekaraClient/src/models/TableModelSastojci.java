/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Sastojak;
import domain.Pecivo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelSastojci extends AbstractTableModel {

    private ArrayList<Sastojak> lista;
    private String[] kolone = {"Rb", "Naziv sastojka"};
    private int rb = 0;

    public TableModelSastojci() {
        lista = new ArrayList<>();
    }

    public TableModelSastojci(Pecivo s) {
        try {
            lista = ClientController.getInstance().getAllSastojak(s);
        } catch (Exception ex) {
            Logger.getLogger(TableModelSastojci.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        Sastojak s = lista.get(row);

        switch (column) {
            case 0:
                return s.getRbSastojka();
            case 1:
                return s.getNazivSastojka();

            default:
                return null;
        }
    }

    public void dodajSastojak(Sastojak s) {
        rb = lista.size();
        s.setRbSastojka(++rb);
        lista.add(s);
        fireTableDataChanged();
    }

    public boolean postojiSastojak(Sastojak s) {
        for (Sastojak sastojak : lista) {
            if (sastojak.getNazivSastojka().equals(s.getNazivSastojka())) {
                return true;
            }
        }
        return false;
    }

    public void obrisiSastojak(int row) {
        lista.remove(row);

        rb = 0;
        for (Sastojak sastojak : lista) {
            sastojak.setRbSastojka(++rb);
        }

        fireTableDataChanged();
    }

    public ArrayList<Sastojak> getLista() {
        return lista;
    }

    public ArrayList<Sastojak> vratiSastojke(ArrayList<Sastojak> sastojci) {
        lista = sastojci;
        return lista;
    }
}
