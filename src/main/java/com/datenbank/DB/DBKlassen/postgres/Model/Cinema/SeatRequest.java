package com.datenbank.DB.DBKlassen.postgres.Model.Cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SeatRequest{
    private Integer seatNumber;
    
    private Character seatRow;
}
