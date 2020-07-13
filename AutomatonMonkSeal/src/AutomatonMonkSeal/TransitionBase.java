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

    /**
     * Getter method for the evtName attribute of the TransitionBase
     * @return String The name identificative for the event that provoques the 
     * transition.
     */
    public String getEventName(){
      return this.evtName;
    }    
    
    /**
     * Getter method for the startState attribute of the TransitionBase
     * @return String The name that identify the state that the transition 
     * comes from.
     */
    public String getStartState(){
      return this.startState;
    }    
    
    /**
     * Getter method for the endState attribute of the TransitionBase
     * @return The name that identifies the state that the transition goes to.
     */
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

