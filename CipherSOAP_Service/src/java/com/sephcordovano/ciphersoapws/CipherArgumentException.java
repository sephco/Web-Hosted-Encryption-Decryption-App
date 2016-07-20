package com.sephcordovano.ciphersoapws;

import javax.xml.ws.WebFault;

//@WebFault(name = "InvalidParamException")
public class CipherArgumentException extends Exception {
    private CipherFaultBean faultBean;
    
    public CipherArgumentException(String msg, CipherFaultBean faultInfo){
        super(msg);
        faultBean = faultInfo;
    }
    
    public CipherArgumentException(String msg, CipherFaultBean faultInfo, Throwable cause){
        super(msg, cause);
        faultBean = faultInfo;
    }
    
    public CipherFaultBean getFaultInfo(){
        return faultBean;
    }
}
