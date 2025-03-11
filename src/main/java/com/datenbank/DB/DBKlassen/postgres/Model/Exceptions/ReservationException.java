package com.datenbank.DB.DBKlassen.postgres.Model.Exceptions;

public class ReservationException extends Exception{
    public ReservationException(){
        super();
    }

    public ReservationException(String message){
        super(message);
    }
}
