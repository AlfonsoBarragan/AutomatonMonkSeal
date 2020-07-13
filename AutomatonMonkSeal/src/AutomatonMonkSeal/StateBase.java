package AutomatonMonkSeal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alf
 */

/**
 * <h1>StateBase</h1>
 * The StateBase class gives the implementation of the states from the machine.
 * 
 * @author alf
 * @version 1.0
 * @since 2018-10-21
 */
public class StateBase {
    Map<String, TransitionBase> transitions;
    String autoTransitionState;
    Runnable entryCode;
    Runnable outputCode;
    Runnable endStateCode;
    boolean initial;

    /**
     * This is the constructor for the StateBase class.
     * @param entryCode The runnable code, that will execute when the machine 
     * enters the state.
     * @param exitCode The runnable code, that will execute when the machine 
     * exits the state.
     * @param endStateCode The runnable code, that will execute when the state 
     * was the last in all the sequence.
     * @param initial Boolean parameter that determines if the state is initial.
     */
    public StateBase(Runnable entryCode, Runnable exitCode, Runnable endStateCode, boolean initial) {
      autoTransitionState   = null;
      transitions           = new HashMap<String, TransitionBase>();
      this.outputCode       = exitCode;
      this.entryCode        = entryCode;
      this.endStateCode     = endStateCode;
      this.initial          = initial;
    }
    /**
     * This is the constructor for the StateBase class.
     * @param entryCode The runnable code, that will execute when the machine 
     * enters the state.
     * @param exitCode The runnable code, that will execute when the machine 
     * exits the state.
     * @param endStateCode The runnable code, that will execute when the state 
     * was the last in all the sequence.
     * @param initial Boolean parameter that determines if the state is initial.
     * @param transitions The map String - Transition that stores all the 
     * transitions with origin this state.
     */
    public StateBase(Runnable entryCode, Runnable exitCode, Runnable endStateCode, boolean initial, Map<String, TransitionBase> transitions) {
      autoTransitionState   = null;
      this.transitions      = transitions;
      this.outputCode       = exitCode;
      this.entryCode        = entryCode;
      this.endStateCode     = endStateCode;
      this.initial          = initial;
    }
    
    /**
     * Getter method for the initial attribute of the state.
     * @return boolean True if the state was initial, false otherwise.
     */
    public boolean getInitial(){
        return this.initial;
    } 
    
    /**
     * Setter method for the initial attribute of the state.
     * @param initial boolean variable to assign to the state
     */
    public void setInitial(boolean initial){
        this.initial = initial;
    }
    
    /**
     * This method add a new transition to the map of transitions in this state.
     * @param trans The new transition to add.
     */
    public void addTransition(TransitionBase trans) {
      transitions.put(trans.evtName, trans);
    }

    /**
     * This method executes the entry code of the state
     */
    public void runEntryCode() {
      if (entryCode != null) {
        entryCode.run();
      }
    }

    /**
     * This method executes the exit code of the state
     */
    public void runExitCode() {
      if (outputCode != null) {
        outputCode.run();
      }
    }
    
    /**
     * This method executes the end state code of the state
     */
    public void runEndStateCode() {
        endStateCode.run();
    }

    /**
     * Getter method for the transitions attribute of the state.
     * @return Map<String, TransitionBase> The map of all transitions from this
     * state.
     */
    public Map<String, TransitionBase> getTransitions() {
        return transitions;
    }

    /**
     * Setter method for the transitions attribute of the state.
     * @param transitions The new map string - transitionbase to assign to the
     * state.
     */
    public void setTransitions(Map<String, TransitionBase> transitions) {
        this.transitions = transitions;
    }

    /**
     * Getter method for the entryCode attribute of the state.
     * @return Runnable executable code that will triggers at the entrance in
     * the state.
     */
    public Runnable getEntryCode() {
        return entryCode;
    }

    /**
     * Setter method for the entryCode attribute of the state.
     * @param entryCode The new entry code that triggers at the entrance in the
     * state.
     */
    public void setEntryCode(Runnable entryCode) {
        this.entryCode = entryCode;
    }

    /**
     * Getter method for the outputCode attribute of the state.
     * @return Runnable executable code that will triggers at the exit in
     * the state.
     */
    public Runnable getOutputCode() {
        return outputCode;
    }
    
    /**
     * Setter method for the outputCode attribute of the state.
     * @param outputCode The new output code that triggers at the exit of the
     * state.
     */
     
    public void setOutputCode(Runnable outputCode) {
        this.outputCode = outputCode;
    }
    
    /**
     * Getter method for the endStateCode attribute of the state.
     * @return Runnable executable code that will triggers at the final of the
     * sequence to analyze if this was the last state.
     */
    public Runnable getEndStateCode() {
        return endStateCode;
    }

    /**
     * Setter method for the endStateCode attribute of the state.
     * @param endStateCode The new end State code that will triggers at the 
     * final of the sequence to analyze if this was the last state.
     */
    public void setEndStateCode(Runnable endStateCode) {
        this.endStateCode = endStateCode;
    }
    
    
  }
