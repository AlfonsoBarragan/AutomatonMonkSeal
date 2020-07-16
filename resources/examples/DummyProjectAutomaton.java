/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DummyProjectAutomaton;

import AutomatonExceptions.DuplicatedStateException;
import AutomatonExceptions.InitialStateException;
import AutomatonExceptions.NoStateException;
import AutomatonExceptions.NoTransitionException;
import AutomatonMonkSeal.StateMachineBase;
import AutomatonMonkSeal.StateBase;
import AutomatonMonkSeal.TransitionBase;

/**
 *
 * @author alf
 */
public class DummyProjectAutomaton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InitialStateException, DuplicatedStateException, NoTransitionException, NoStateException {
        
        
        Runnable entr_state_sol = () -> {
            System.out.println("ENTER IN STATE SOLICITATES");
        };
        
        
        Runnable entr_state_rec = () -> {
            System.out.println("ENTER IN STATE RECEIVES");

        };
        
        
        Runnable entr_state_dec = () -> {
            System.out.println("ENTER IN STATE DECODIFIES");
            
        };
        
        
        Runnable entr_state_sho = () -> {
            System.out.println("ENTER IN STATE SHOW");

        };
        
                
        Runnable exit_state_sol = () -> {
            System.out.println("EXIT OF STATE SOLICITATES");
        };
        
        
        Runnable exit_state_rec = () -> {
            System.out.println("EXIT OF STATE RECEIVES");
        };
        
        
        Runnable exit_state_dec = () -> {
            System.out.println("EXIT OF STATE DECODIFIES");
        };
        
        
        Runnable exit_state_sho = () -> {
            System.out.println("EXIT OF STATE SHOW");
        };
        
                
        Runnable end_state_sol = () -> {
            System.out.println("END STATE WAS SOLICITATES");
        };
        
        
        Runnable end_state_rec = () -> {
            System.out.println("END STATE WAS RECEIVES");
        };
        
        
        Runnable end_state_dec = () -> {
            System.out.println("END STATE WAS DECODIFIES");
        };
        
        
        Runnable end_state_sho = () -> {
            System.out.println("END STATE WAS SHOW");
        };
        
        TransitionBase sol_to_rec = new TransitionBase("go to rec", "SOL", "REC");
        TransitionBase rec_to_dec = new TransitionBase("go to dec", "REC", "DEC");
        TransitionBase dec_to_sho = new TransitionBase("go to sho", "DEC", "SHO");
        TransitionBase sho_to_sol = new TransitionBase("go to sol", "SHO", "SOL");
        
        StateMachineBase smb = new StateMachineBase("DataBehaviour");

        smb.addState("SOL", entr_state_sol, exit_state_sol, end_state_sol, true);
        smb.addState("REC", entr_state_rec, exit_state_rec, end_state_rec, false);
        smb.addState("DEC", entr_state_dec, exit_state_dec, end_state_dec, false);
        smb.addState("SHO", entr_state_sho, exit_state_sho, end_state_sho, false);
        
        smb.addTransition(sol_to_rec);
        smb.addTransition(rec_to_dec);
        smb.addTransition(dec_to_sho);
        smb.addTransition(sho_to_sol);

        smb.addEvent("go to rec");
        
    }
    
}
