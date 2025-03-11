package com.datenbank.DB.DBKlassen.postgres.Model.Exceptions;

public class CinemaModifyException extends Exception{

    public CinemaModifyException(String message){
        super(message);
    }

    public CinemaModifyException(){
        super();
    }
}
