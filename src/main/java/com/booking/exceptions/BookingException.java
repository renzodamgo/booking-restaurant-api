package com.booking.exceptions;

import com.booking.dtos.ErrorDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Exception guarda información de errores
@Getter
public class BookingException extends Exception{
    private final String code;
    private final int resonseCode;
    private final List<ErrorDto> errorList = new ArrayList<>();

    public BookingException(String code, int responseCode,String message){

        super(message);
        this.code = code;
        this.resonseCode = responseCode;
    }

    public BookingException(String code, int responseCode,String message ,List<ErrorDto> errorList){

        super(message);
        this.code = code;
        this.resonseCode = responseCode;
        this.errorList.addAll(errorList);
    }
}
