package com.travelnet.model.Exceptions;

/**
 * The type Empty input exception.
 * Is thrown, when inputs are empty
 *
 */
public class EmptyInputException extends Exception{
    /**
     * Instantiates a new Empty input exception.
     */
    public EmptyInputException(){};

    /**
     * Instantiates a new Empty input exception.
     *
     * @param errorMessage the error message
     */
    public EmptyInputException(String errorMessage){
        super(errorMessage);
    }

    /**
     * Instantiates a new Empty input exception.
     *
     * @param errorMessage the error message
     * @param error        the error
     */
    public EmptyInputException(String errorMessage, Throwable error){
        super(errorMessage, error);
    }
}
