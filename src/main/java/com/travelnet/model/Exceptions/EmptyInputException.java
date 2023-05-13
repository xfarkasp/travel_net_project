package com.travelnet.model.Exceptions;

public class EmptyInputException extends Exception{
    public EmptyInputException(){};
    public EmptyInputException(String errorMessage){
        super(errorMessage);
    }
    public EmptyInputException(String errorMessage, Throwable error){
        super(errorMessage, error);
    }
}
