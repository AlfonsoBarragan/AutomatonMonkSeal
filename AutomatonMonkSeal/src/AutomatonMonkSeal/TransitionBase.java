package AutomatonMonkSeal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alf
 */
public class TransitionBase {
    String evtName;
    String startState;
    String endState;

    /**
     * Create a transition object that responds to the given event when in
     * the given start state, and puts the machine into the end state provided.
     * @param evtName name of the event thar provokes the transition.
     * @param startState name of the original event that the machine comes from.
     * @param endState name of the new state that the machines goes to.
     */
    public TransitionBase(String evtName, String startState, String endState) {
      this.evtName = evtName;
      this.startState = startState;
      this.endState = endState;
    }

    public String getEventName(){
      return this.evtName;
    }    
    
    public String getStartState(){
      return this.startState;
    }    
    
    public String getEndState(){
      return this.endState;
    }

    /**
     * Override this to have machine execute code immediately before following a
     * state transition.
     */
    public void doBeforeTransition() {
    }

    /**
     * Override this to have machine execute code immediately after following a
     * state transition.
     */
    public void doAfterTransition() {
    }
 }

