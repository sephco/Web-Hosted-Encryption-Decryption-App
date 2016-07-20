package com.sephcordovano.ciphersoapws;

public class CipherFaultBean {
    private String message;
    private static final String DEFAULT_MESSAGE = "Unknown argument exception";
    
    public CipherFaultBean(){
        message = DEFAULT_MESSAGE;
    }
    public CipherFaultBean(String msg){
        if(msg != null)
            message = msg;
        else 
            message = DEFAULT_MESSAGE;
    }
    
    public String getMessage(){
        return message;
    } 
}
