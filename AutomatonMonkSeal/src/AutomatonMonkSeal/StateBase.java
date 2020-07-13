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
public class StateBase {
    Map<String, TransitionBase> transitions;
    String autoTransitionState;
    Runnable entryCode;
    Runnable outputCode;
    Runnable endStateCode;
    boolean initial;

    public StateBase(Runnable entryCode, Runnable exitCode, Runnable endStateCode, boolean initial) {
      autoTransitionState   = null;
      transitions           = new HashMap<String, TransitionBase>();
      this.outputCode       = exitCode;
      this.entryCode        = entryCode;
      this.endStateCode     = endStateCode;
      this.initial          = initial;
    }
    
    public StateBase(Runnable entryCode, Runnable exitCode, Runnable endStateCode, boolean initial, Map<String, TransitionBase> transitions) {
      autoTransitionState   = null;
      this.transitions      = transitions;
      this.outputCode       = exitCode;
      this.entryCode        = entryCode;
      this.endStateCode     = endStateCode;
      this.initial          = initial;
    }
    
    public boolean getInitial(){
        return this.initial;
    } 
    
    public void setInitial(boolean initial){
        this.initial = initial;
    }
    
    public void addTransition(TransitionBase trans) {
      transitions.put(trans.evtName, trans);
    }

    public void runEntryCode() {
      if (entryCode != null) {
        entryCode.run();
      }
    }

    public void runExitCode() {
      if (outputCode != null) {
        outputCode.run();
      }
    }
    
    public void runEndStateCode() {
        endStateCode.run();
    }

    public Map<String, TransitionBase> getTransitions() {
        return transitions;
    }

    public void setTransitions(Map<String, TransitionBase> transitions) {
        this.transitions = transitions;
    }

    public String getAutoTransitionState() {
        return autoTransitionState;
    }

    public void setAutoTransitionState(String autoTransitionState) {
        this.autoTransitionState = autoTransitionState;
    }

    public Runnable getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(Runnable entryCode) {
        this.entryCode = entryCode;
    }

    public Runnable getOutputCode() {
        return outputCode;
    }

    public void setOutputCode(Runnable outputCode) {
        this.outputCode = outputCode;
    }

    public Runnable getEndStateCode() {
        return endStateCode;
    }

    public void setEndStateCode(Runnable endStateCode) {
        this.endStateCode = endStateCode;
    }
    
    
  }
