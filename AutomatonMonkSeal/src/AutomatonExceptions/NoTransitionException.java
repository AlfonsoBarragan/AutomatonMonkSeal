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
public class NoTransitionException extends Exception {
    public NoTransitionException(String message, Throwable cause){
        super(message, cause);
    }
}
