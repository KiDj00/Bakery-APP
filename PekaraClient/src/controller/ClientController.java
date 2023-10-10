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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Korisnik
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void addAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.ADD_ADMINISTRATOR, administrator);
    }

    public void addPecivo(Pecivo pecivo) throws Exception {
        sendRequest(Operation.ADD_PECIVO, pecivo);
    }

    public void addRacun(Racun racun) throws Exception {
        sendRequest(Operation.ADD_RACUN, racun);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.DELETE_ADMINISTRATOR, administrator);
    }

    public void deletePeciva(Pecivo pecivo) throws Exception {
        sendRequest(Operation.DELETE_PECIVO, pecivo);
    }

    public void updateAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.UPDATE_ADMINISTRATOR, administrator);
    }


    public void updatePecivo(Pecivo pecivo) throws Exception {
        sendRequest(Operation.UPDATE_PECIVO, pecivo);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }

    public ArrayList<Pecivo> getAllPecivo() throws Exception {
        return (ArrayList<Pecivo>) sendRequest(Operation.GET_ALL_PECIVO, null);
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        return (ArrayList<Racun>) sendRequest(Operation.GET_ALL_RACUN, null);
    }

    public ArrayList<StavkaRacuna> getAllStavkaRacuna() throws Exception {
        return (ArrayList<StavkaRacuna>) sendRequest(Operation.GET_ALL_STAVKA_RACUNA, null);
    }

    public ArrayList<Sastojak> getAllSastojak(Pecivo p) throws Exception {
        return (ArrayList<Sastojak>) sendRequest(Operation.GET_ALL_SASTOJAK, p);
    }
    
     public ArrayList<Sastojak> getAllSastojci() throws Exception {
        return (ArrayList<Sastojak>) sendRequest(Operation.GET_ALL_SASTOJCI,null);
    }


    public ArrayList<TipPeciva> getAllTipPeciva() throws Exception {
        return (ArrayList<TipPeciva>) sendRequest(Operation.GET_ALL_TIP_PECIVO, null);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
