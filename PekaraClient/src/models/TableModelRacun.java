/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Administrator;
import domain.Racun;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelRacun extends AbstractTableModel {

    private ArrayList<Racun> lista;
    private String[] kolone = {"ID", "Vreme", "Cena", "Kolicinski rabat", "Konacna cena", "Admin"};


    public TableModelRacun() {
        try {
            lista = ClientController.getInstance().getAllRacun();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAdministratori.class.getName()).log(Level.SEVERE, null, ex);
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
        Racun r = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH.mm");

        switch (column) {
            case 0:
                return r.getRacunID();
            case 1:
                return sdf.format(r.getDatumVreme());
            case 2:
                return r.getCena();
            case 3:
                return r.getKolicinskiRabat();
            case 4:
                return r.getKonacnaCena();
            case 5:
                return r.getAdministrator().toString();
            default:
                return null;
        }
    }


}
