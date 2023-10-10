/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sastojak;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Sastojak;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllSastojak extends AbstractSO {

    private ArrayList<Sastojak> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Sastojak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Sastojak!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> sastojci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Sastojak>) (ArrayList<?>) sastojci;
    }

    public ArrayList<Sastojak> getLista() {
        return lista;
    }

}
