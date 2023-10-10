package porudzbenicaForm;

import pecivaForm.NovoPecivoForma;
import controller.ClientController;
import domain.Administrator;
import domain.Pecivo;
import domain.Racun;
import domain.StavkaRacuna;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelStavke;
import session.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
/**
 *
 * @author Korisnik
 */
public class DodajRacunForma extends javax.swing.JDialog {

    Administrator a;
    int ukupnaKolicina;
    double ukupnaCena;
    double rabat;

    /**
     * Creates new form PorudzbenicaForma
     */
    public DodajRacunForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        srediFormu();
        a=Session.getInstance().getUlogovani();
        this.getContentPane().setBackground(new Color(51, 153, 255));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCena = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbPeciva = new javax.swing.JComboBox();
        txtKolicina = new javax.swing.JFormattedTextField();
        txtCenaStavke = new javax.swing.JFormattedTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        lblRabat = new javax.swing.JLabel();
        txtKonacnaCena = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Porudzbenica");
        setBackground(new java.awt.Color(51, 153, 255));

        txtCena.setBackground(new java.awt.Color(51, 153, 255));
        txtCena.setForeground(new java.awt.Color(255, 255, 255));
        txtCena.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cena:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kolicinski rabat:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Konacna cena:");

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Peciva:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kolicina:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cena stavke:");

        cmbPeciva.setBackground(new java.awt.Color(51, 153, 255));
        cmbPeciva.setForeground(new java.awt.Color(255, 255, 255));
        cmbPeciva.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        cmbPeciva.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPecivaItemStateChanged(evt);
            }
        });

        txtKolicina.setBackground(new java.awt.Color(51, 153, 255));
        txtKolicina.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtKolicina.setForeground(new java.awt.Color(255, 255, 255));
        txtKolicina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtKolicina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKolicinaKeyReleased(evt);
            }
        });

        txtCenaStavke.setBackground(new java.awt.Color(51, 153, 255));
        txtCenaStavke.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtCenaStavke.setForeground(new java.awt.Color(255, 255, 255));
        txtCenaStavke.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnDodaj.setForeground(new java.awt.Color(51, 153, 255));
        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setForeground(new java.awt.Color(51, 153, 255));
        btnObrisi.setText("Obrisi stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        jLabel10.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPeciva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKolicina)
                                    .addComponent(txtCenaStavke, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbPeciva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCenaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        lblRabat.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblRabat.setForeground(new java.awt.Color(255, 255, 255));
        lblRabat.setText("0%");

        txtKonacnaCena.setBackground(new java.awt.Color(51, 153, 255));
        txtKonacnaCena.setForeground(new java.awt.Color(255, 255, 255));
        txtKonacnaCena.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSacuvaj.setForeground(new java.awt.Color(51, 153, 255));
        btnSacuvaj.setText("Sacuvaj račun");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Račun");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kreiraj");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/porudzbenicaForm/manji logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblRabat, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKonacnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblRabat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKonacnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPecivaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPecivaItemStateChanged

        if (cmbPeciva.getSelectedItem() != null && !txtKolicina.getText().isEmpty()) {
            Pecivo p = (Pecivo) cmbPeciva.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());
            txtCenaStavke.setText(String.valueOf(p.getCena() * kolicina));
        }
    }//GEN-LAST:event_cmbPecivaItemStateChanged

    private void txtKolicinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKolicinaKeyReleased

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {

            if (txtKolicina.getText().isEmpty()) {
                txtKolicina.setText("");
                return;
            }

            Pecivo p = (Pecivo) cmbPeciva.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());

            txtCenaStavke.setText(String.valueOf(p.getCena() * kolicina));

        } else {
            txtKolicina.setText("");
            txtCenaStavke.setText("0.00");
        }
    }//GEN-LAST:event_txtKolicinaKeyReleased

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti kolicinu!");
            return;
        }

        Pecivo s = (Pecivo) cmbPeciva.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        double cenaStavke = Double.parseDouble(txtCenaStavke.getText());

        StavkaRacuna sr = new StavkaRacuna(null, -1, kolicina, cenaStavke, s);

        TableModelStavke tm = (TableModelStavke) tblStavke.getModel();

        tm.dodajStavku(sr);

        ukupnaCena = tm.getUkupnaCena();
        ukupnaKolicina = tm.getUkupnaKolicina();

        txtCena.setText(String.valueOf(ukupnaCena));

        if (ukupnaKolicina < 10) {
            lblRabat.setText("0%");
            rabat = 0;
            txtKonacnaCena.setText(String.valueOf(ukupnaCena));
        }

        if (ukupnaKolicina >= 10 && ukupnaKolicina < 20) {
            lblRabat.setText("10%");
            rabat = 10;
            txtKonacnaCena.setText(String.valueOf(ukupnaCena * 0.9));
        }

        if (ukupnaKolicina >= 20) {
            lblRabat.setText("20%");
            rabat = 20;
            txtKonacnaCena.setText(String.valueOf(ukupnaCena * 0.8));
        }

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblStavke.getSelectedRow();

        if (row >= 0) {
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
            tm.obrisiStavku(row);

            ukupnaCena = tm.getUkupnaCena();
            ukupnaKolicina = tm.getUkupnaKolicina();

            txtCena.setText(String.valueOf(ukupnaCena));

            if (ukupnaKolicina < 10) {
                lblRabat.setText("0%");
                rabat = 0;
                txtKonacnaCena.setText(String.valueOf(ukupnaCena));
            }

            if (ukupnaKolicina >= 10 && ukupnaKolicina < 20) {
                lblRabat.setText("10%");
                rabat = 10;
                txtKonacnaCena.setText(String.valueOf(ukupnaCena * 0.9));
            }

            if (ukupnaKolicina >= 20) {
                lblRabat.setText("20%");
                rabat = 20;
                txtKonacnaCena.setText(String.valueOf(ukupnaCena * 0.8));
            }

        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        try {
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
            double konacnaCena = Double.parseDouble(txtKonacnaCena.getText());

            Racun r = new Racun(null, new Date(), ukupnaCena, rabat, konacnaCena, a, tm.getLista());

            ClientController.getInstance().addRacun(r);
            resetujFormu();
            JOptionPane.showMessageDialog(this, "Uspesno sacuvan racun!");
        } catch (Exception ex) {
            Logger.getLogger(DodajRacunForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbPeciva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRabat;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCena;
    private javax.swing.JFormattedTextField txtCenaStavke;
    private javax.swing.JFormattedTextField txtKolicina;
    private javax.swing.JTextField txtKonacnaCena;
    // End of variables declaration//GEN-END:variables

    private void resetujFormu() {
        txtCenaStavke.setText("0.00");
        txtCena.setText("0.00");
        txtKonacnaCena.setText("0.00");
        lblRabat.setText("0%");
        txtKolicina.setText("");
        TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
        tm.getLista().clear();
        tm.fireTableDataChanged();
        ukupnaCena = 0;
        ukupnaKolicina = 0;
        rabat = 0;
    }

    public void popuniPeciva() {
        try {
            ArrayList<Pecivo> peciva = ClientController.getInstance().getAllPecivo();

            cmbPeciva.removeAllItems();

            for (Pecivo pecivo : peciva) {
                cmbPeciva.addItem(pecivo);
            }

        } catch (Exception ex) {
            Logger.getLogger(NovoPecivoForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void srediFormu() {
        popuniPeciva();
        tblStavke.setModel(new TableModelStavke());
        txtCenaStavke.setEditable(false);
        txtCena.setEditable(false);
        txtKonacnaCena.setEditable(false);
        txtCenaStavke.setText("0.00");
        txtCena.setText("0.00");
        txtKonacnaCena.setText("0.00");
    }
}