/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Racun;
import domain.Sastojak;
import domain.Pecivo;
import domain.StavkaRacuna;
import domain.TipPeciva;
import java.util.ArrayList;
import so.administrator.SOAddAdministrator;
import so.administrator.SODeleteAdministrator;
import so.administrator.SOUpdateAdministrator;
import so.administrator.SOGetAllAdministrator;
import so.login.SOLogin;
import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.sastojak.SOGetAllSastojak;
import so.pecivo.SOAddPecivo;
import so.pecivo.SODeletePecivo;
import so.pecivo.SOGetAllPecivo;
import so.pecivo.SOUpdatePecivo;
import so.sastojak.SOGetAllSastojci;
import so.stavkaRacuna.SOGetAllStavkaRacuna;
import so.tipPeciva.SOGetAllTipPeciva;

/**
 *
 * @author KKorisnik
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getAdmin();
    }

    public void addAdministrator(Administrator administrator) throws Exception {
        (new SOAddAdministrator()).templateExecute(administrator);
    }

    public void addRacun(Racun racun) throws Exception {
        (new SOAddRacun()).templateExecute(racun);
    }

    public void addPecivo(Pecivo pecivo) throws Exception {
        (new SOAddPecivo()).templateExecute(pecivo);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        (new SODeleteAdministrator()).templateExecute(administrator);
    }

    public void deletePecivo(Pecivo pecivo) throws Exception {
        (new SODeletePecivo()).templateExecute(pecivo);
    }

    public void updateAdministrator(Administrator administrator) throws Exception {
        (new SOUpdateAdministrator()).templateExecute(administrator);
    }

    public void updatePecivo(Pecivo peciva) throws Exception {
        (new SOUpdatePecivo()).templateExecute(peciva);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Pecivo> getAllPeciva() throws Exception {
        SOGetAllPecivo so = new SOGetAllPecivo();
        so.templateExecute(new Pecivo());
        return so.getLista();
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        SOGetAllRacun so = new SOGetAllRacun();
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public ArrayList<StavkaRacuna> getAllStavkaRacuna() throws Exception {
        SOGetAllStavkaRacuna so = new SOGetAllStavkaRacuna();
        so.templateExecute(new StavkaRacuna());
        return so.getLista();
    }

    public ArrayList<Sastojak> getAllSastojak(Pecivo p) throws Exception {
        SOGetAllSastojak so = new SOGetAllSastojak();

        Sastojak sastojak = new Sastojak();
        sastojak.setPecivo(p);

        so.templateExecute(sastojak);
        return so.getLista();
    }

    public ArrayList<Sastojak> getAllSastojci() throws Exception {
        SOGetAllSastojci so = new SOGetAllSastojci();
        so.templateExecute(new Sastojak());
        return so.getLista();
    }

    public ArrayList<TipPeciva> getAllTipPeciva() throws Exception {
        SOGetAllTipPeciva so = new SOGetAllTipPeciva();
        so.templateExecute(new TipPeciva());
        return so.getLista();
    }

}
