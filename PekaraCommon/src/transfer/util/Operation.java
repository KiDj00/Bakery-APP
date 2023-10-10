/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Korisnik
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int ADD_ADMINISTRATOR = 1;
    public static final int DELETE_ADMINISTRATOR = 2;
    public static final int UPDATE_ADMINISTRATOR = 3;
    public static final int GET_ALL_ADMINISTRATOR = 4;

    public static final int ADD_PECIVO = 5;
    public static final int DELETE_PECIVO = 6;
    public static final int UPDATE_PECIVO = 7;
    public static final int GET_ALL_PECIVO = 8;

    public static final int GET_ALL_SASTOJAK = 9;
    public static final int GET_ALL_SASTOJCI=10;

    public static final int ADD_RACUN = 11;
    public static final int GET_ALL_RACUN = 12;

    public static final int GET_ALL_STAVKA_RACUNA = 13;
    
    public static final int GET_ALL_TIP_PECIVO = 14;

}
