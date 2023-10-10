/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Pecivo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelPecivo extends AbstractTableModel implements Runnable {

    private ArrayList<Pecivo> lista;
    private String[] kolone = {"ID", "Tip peciva", "Naziv peciva", "Cena po komadu"};
    private String parametar = "";

    public TableModelPecivo() {
        try {
            lista = ClientController.getInstance().getAllPecivo();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPecivo.class.getName()).log(Level.SEVERE, null, ex);
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
        Pecivo s = lista.get(row);

        switch (column) {
            case 0:
                return s.getPecivoID();
            case 1:
                return s.getTipPeciva();
            case 2:
                return s.getNazivPeciva();
            case 3:
                return s.getCena() + "din";

            default:
                return null;
        }
    }

    public Pecivo getSelectedPecivo(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelPecivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllPecivo();
            if (!parametar.equals("")) {
                ArrayList<Pecivo> novaLista = new ArrayList<>();
                for (Pecivo s : lista) {
                    if (s.getNazivPeciva().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(s);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
