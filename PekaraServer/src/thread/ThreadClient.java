/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Racun;
import domain.Pecivo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Korisnik
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_ADMINISTRATOR:
                    ServerController.getInstance().addAdministrator((Administrator) request.getData());
                    break;

                case Operation.ADD_PECIVO:
                    ServerController.getInstance().addPecivo((Pecivo) request.getData());
                    break;
                case Operation.ADD_RACUN:
                    ServerController.getInstance().addRacun((Racun) request.getData());
                    break;
                case Operation.DELETE_PECIVO:
                    ServerController.getInstance().deletePecivo((Pecivo) request.getData());
                    break;
                case Operation.DELETE_ADMINISTRATOR:
                    ServerController.getInstance().deleteAdministrator((Administrator) request.getData());
                    break;
                case Operation.UPDATE_ADMINISTRATOR:
                    ServerController.getInstance().updateAdministrator((Administrator) request.getData());
                    break;
                case Operation.UPDATE_PECIVO:
                    ServerController.getInstance().updatePecivo((Pecivo) request.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_PECIVO:
                    response.setData(ServerController.getInstance().getAllPeciva());
                    break;
                case Operation.GET_ALL_RACUN:
                    response.setData(ServerController.getInstance().getAllRacun());
                    break;
                case Operation.GET_ALL_STAVKA_RACUNA:
                    response.setData(ServerController.getInstance().getAllStavkaRacuna());
                    break;
                case Operation.GET_ALL_SASTOJAK:
                    response.setData(ServerController.getInstance().getAllSastojak((Pecivo) request.getData()));
                    break;
                    case Operation.GET_ALL_SASTOJCI:
                    response.setData(ServerController.getInstance().getAllSastojci());
                    break;
                case Operation.GET_ALL_TIP_PECIVO:
                    response.setData(ServerController.getInstance().getAllTipPeciva());
                    break;
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) request.getData();
                    Administrator ulogovani = ServerController.getInstance().login(administrator);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
