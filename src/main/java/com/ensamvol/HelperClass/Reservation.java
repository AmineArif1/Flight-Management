package com.ensamvol.HelperClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    private String FirstName;
    private String LastName;
    private String Birth;
    private String Number;
    private String Email;
    private Integer Bags;
    private Integer WeightBags;
    private String Passport;
}
