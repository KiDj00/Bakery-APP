/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pecivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pecivo;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllPecivo extends AbstractSO {

    private ArrayList<Pecivo> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pecivo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pecivo!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> peciva = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pecivo>) (ArrayList<?>) peciva;
    }

    public ArrayList<Pecivo> getLista() {
        return lista;
    }

}
