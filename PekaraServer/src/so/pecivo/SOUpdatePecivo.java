/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pecivo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Sastojak;
import domain.Pecivo;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOUpdatePecivo extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pecivo)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pecivo!");
        }

        Pecivo p = (Pecivo) ado;

        if (p.getCena() < 30 || p.getCena() > 15000) {
            throw new Exception("Cena peciva mora biti izmedju 30din i 15000din!");
        }

        if (p.getSastojci().isEmpty()) {
            throw new Exception("Pecivo mora imati barem jedan sastojak!");
        }

        ArrayList<Pecivo> peciva = (ArrayList<Pecivo>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Pecivo pecivo : peciva) {
            if (!pecivo.getPecivoID().equals(p.getPecivoID())) {
                if (pecivo.getNazivPeciva().equals(p.getNazivPeciva())) {
                    throw new Exception("Vec postoji pecivo s tim nazivom!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        // prvo updatujemo slatkis
        DBBroker.getInstance().update(ado);

        // obrisemo stare sastojke
        Pecivo s = (Pecivo) ado;
        // sledeca linija koda ce da izvrsi naredbu
        // DELETE FROM SASTOJAK WHERE SLATKISID = nasID
        // cime se brisu SVI sastojci naseg slatkisa ODJEDNOM !!!
        DBBroker.getInstance().delete(s.getSastojci().get(0));

        // dodamo nove
        for (Sastojak sastojak : s.getSastojci()) {
            DBBroker.getInstance().insert(sastojak);
        }

    }

}
