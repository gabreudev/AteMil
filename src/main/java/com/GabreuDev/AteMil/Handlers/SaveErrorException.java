package com.GabreuDev.AteMil.Handlers;

public class SaveErrorException extends BusinessException{

    public SaveErrorException(String objeto) {
        super("Erro ao salvar o %s", objeto);
    }
}
