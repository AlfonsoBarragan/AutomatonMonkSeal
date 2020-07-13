/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomatonExceptions;

/**
 *
 * @author alf
 */
public class DuplicatedStateException extends Exception{
    
    public DuplicatedStateException(String message, Throwable cause){
        super(message, cause);
    }
    
}
