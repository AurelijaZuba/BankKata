package com.codurance.bankkata;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Clock {
    public String today() {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormatter.format(new Date());
    }
}
