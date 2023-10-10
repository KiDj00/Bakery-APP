/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipPeciva;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.TipPeciva;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllTipPeciva extends AbstractSO {

    private ArrayList<TipPeciva> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipPeciva)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipPeciva!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> tipoviPeciva = DBBroker.getInstance().select(ado);
        lista = (ArrayList<TipPeciva>) (ArrayList<?>) tipoviPeciva;
    }

    public ArrayList<TipPeciva> getLista() {
        return lista;
    }

}
