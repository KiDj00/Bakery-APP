/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class SOGetAllSastojci extends AbstractSO {

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
