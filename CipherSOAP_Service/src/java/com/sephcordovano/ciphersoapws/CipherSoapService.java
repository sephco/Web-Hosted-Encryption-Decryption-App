package com.sephcordovano.ciphersoapws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CipherSoapService")
public class CipherSoapService {
    final int UPPER_BOUND = 126; // Upper bound of total shift
    final int LOWER_BOUND = 32;  // Lower bound of total shift
    @WebMethod(operationName = "cipher")
    public String cipher(@WebParam(name = "txt") String txt,
            @WebParam(name = "shift") int shift) 
            throws CipherArgumentException { // Throw back to calling method (client)
        String result = ""; // Encryption/decrption string to be returned
        try{
            validateArguments(txt, shift);  // Validate arguments 
        } catch (CipherArgumentException cae){
            throw cae; // Throw argument up the chain towards client
        }
        for(int i = 0; i < txt.length(); i++){  // Loop through each char of String
            char c = txt.charAt(i);  // Assign that character to c
            int uni = (int) c;  // Cast c to integer and assign to uni
            uni += shift;  // Increase unicode value by shift amount
            if (uni > UPPER_BOUND) { // If uni is above the uppper bound
                uni -= UPPER_BOUND; // Then decrease upper bound amount 
                uni += 31; // Add 31 to 'wrap' back to beginning of our use set
            }
            result += (char) uni;  // Cast back to char and add it to result string
        } 
        return result;
    }
    
    @WebMethod(operationName = "decipher")
    public String decipher(@WebParam(name = "txt") String txt,
            @WebParam(name = "shift") int shift)
            throws CipherArgumentException { // Throw back to calling method (client)
        String result = ""; // Encryption/decrption string to be returned
        try{
            validateArguments(txt, shift);  // Validate arguments 
        } catch (CipherArgumentException cae){
            throw cae; // Throw argument up the chain towards client
        }   
        for(int i = 0; i < txt.length(); i++){  // Loop through each char of String
            char c = txt.charAt(i);  // Assign that charcter to c
            int uni = (int) c;  // Cast c to integer and assign to uni
            uni -= shift;  // Decrease unicode value by shift amount
            if (uni < LOWER_BOUND){ // If uni is below the lower bound
                uni += UPPER_BOUND; // Then increase upper bound amount
                uni -= 31; // Subtract 31 to 'wrap' back to end of our use set
            }
            result += (char) uni;  // Cast back to char and add it to result string
        } 
        return result;
    }
    
    // This exception gets thrown up the stack for client to handle/catch
    public void validateArguments(String txt, int shift) throws CipherArgumentException{
        if(txt == null || txt.length() == 0) // Validate text is not null
            throw new CipherArgumentException("You must enter text to proceed.", new CipherFaultBean());
        else if (shift < 1 || shift > 94)  // Validate number is within range
            throw new CipherArgumentException("You must enter a number from 1 to 94.", new CipherFaultBean());
    }
}
