package com.GabreuDev.AteMil.Handlers;

public class InvalidIdException extends BusinessException{
    public InvalidIdException(String objeto) {
        super("id do objeto %s", objeto);
    }
}
