/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkaRacuna;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaRacuna;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllStavkaRacuna extends AbstractSO {

    private ArrayList<StavkaRacuna> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaRacuna)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaRacuna!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> stavkeRacuna = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaRacuna>) (ArrayList<?>) stavkeRacuna;
    }

    public ArrayList<StavkaRacuna> getLista() {
        return lista;
    }

}
