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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOAddPecivo extends AbstractSO {

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
            if (pecivo.getNazivPeciva().equals(p.getNazivPeciva())) {
                throw new Exception("Vec postoji pecivo s tim nazivom!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        // vratimo prepared statement sa generisanim kljucem
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        // uzmemo taj generisani kljuc
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long pecivoID = tableKeys.getLong(1);

        // setujemo ga za nase pecivo
        Pecivo p = (Pecivo) ado;
        p.setPecivoID(pecivoID);

        // dodajemo sastojak po sastojak naseg peciva
        // nakon sto setujemo da je iz naseg peciva
        for (Sastojak sastojak : p.getSastojci()) {
            sastojak.setPecivo(p);
            DBBroker.getInstance().insert(sastojak);
        }

    }

}
