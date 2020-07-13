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
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import AutomatonExceptions.InitialStateException;
import AutomatonExceptions.DuplicatedStateException;
import AutomatonExceptions.NoStateException;
import AutomatonExceptions.NoTransitionException;


/**
 * <h1>StateMachineBase</h1>
 * The StateMachineBase class gives a generical implementation of finite states
 * machines in order to extend to a more complex automatic systems.
 *
 * @author Alfonso Barragán
 * @version 1.0
 * @since 2018-10-21
 */
public class StateMachineBase {

    protected String name;
    protected String currentState;
    protected String lastState;
    public Map<String, StateBase> states;

    /**
     * This is the constructor for the class, this constructor was overloaded in
     * order to use the most convenient version depending on the case.
     *
     * @param name This is the name of the machine.
     * @attribute states This is a map String - State object, that contains every
     * state of the machine.
     * @see StateBase
     * @attribute currentState String that contains the name of the actual state of
     * the machine.
     * @attribute lastState String that contains the name of the last state of the
     * machine.
     */
    public StateMachineBase(String name) {
        this.name = name;
        this.states = new HashMap<>();
        this.currentState = "";
        this.lastState = "";
    }

    /**
     * This is a setter method for the name attribute of the machine.
     *
     * @param name The new name to set to the machine.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This is a setter method for the lastState attribute of the machine.
     * @param lastState The name of the last state visited.
     */
    public void setLastState(String lastState){
        this.lastState = lastState;
    }

    /**
     * This is a getter method for the name attribute of the machine.
     * 
     * @return String the actual name of the machine.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This is a getter method for the states attribute of the machine.
     * 
     * @see StateBase
     * @return HashMap<String, StateBase> The hash map that contains the states and his names.
     */
    public Map<String, StateBase> getStates() {
        return this.states;
    }

    /**
     * This is a getter method for the current state that has the machine.
     * 
     * @return String The name of the actual state.
     */
    public String getCurrentState() {
        return this.currentState;
    }

    /**
     * This is a getter method for the anterior state that had the machine.
     * 
     * @return String The name of the last state.
     */
    public String getLastState() {
        return this.lastState;
    }

    /**
     * This method adds an state to the machine, this requires the entry code,
     * the exit code and the end state code, and if the state was the initial
     * state.
     * @param state The name of the new state to add to the machine's state map.
     * @param entryCode The code that the machine executes when it enters in this state.
     * @param exitCode The code that the machine executes when it exits in this state.
     * @param endStateCode The code that the machine executes when it ends to read the sequeance.
     * @param initial Boolean variable that indicates if the state is initial.
     * @throws InitialStateException Exception throwed if the machine already has an initial state.
     * @see InitialStateException
     * @throws DuplicatedStateException Exception throwed if the mahcine already has the state in its map.
     * @see DuplicatedStateException
     */
    public void addState(String state, Runnable entryCode, Runnable exitCode, Runnable endStateCode, boolean initial) throws InitialStateException, DuplicatedStateException {
        
        try{
            if (!states.containsKey(state)) {
                states.put(state, new StateBase(entryCode, exitCode, endStateCode, initial));
            } else {
                throw new RuntimeException();
            }
            
        } catch (RuntimeException re){
            throw new DuplicatedStateException(String.format("DuplicatedStateException: The state %s cannot be included in the map of states, because it is already.", state), re);
        }
            
        try{
            if (initial) {
                if (!getCurrentState().equals("") && getStates().get(getCurrentState()).getInitial()){
                    throw new RuntimeException();

                }else{
                    setState(state);
                }
            }
        } catch (RuntimeException re){
            throw new InitialStateException(String.format("InitialException: The state %s cannot be initial because state %s is already initial.", state, getCurrentState()), re);
        }
    }


    /**
     * This method set up the initial state of the machine, in order of execute
     * it the first of all states.
     * @param state The state to set up the machine.
     */
    public void setState(String state) {
        setState(state, true);
    }

    
    /**
     * This method is used to updated the state of the machine while it 
     * transitionates over a sequence. When changes the state, it triggers
     * the code to execute.
     * @param state The new state that the machines goes to.
     * @param triggerEvent  A boolean that determines if the machine triggers
     * the code or not.
     */
    public void setState(String state, boolean triggerEvent) {
        boolean runExtraCode = !state.equals(currentState);
        if (runExtraCode && !currentState.equals("")) {
            states.get(currentState).runExitCode();
        }

        currentState = state;

        if (runExtraCode) {
            states.get(currentState).runEntryCode();
        }

        if (triggerEvent) {
        }
    }

    /**
     * This method its used to add the transitions to the states of the machine.
     * @param trans Its an object from class TransitionBase, that will be added to 
 the correspondent start state of the transition.
     * @see TransitionBase
     * @throws NoStateException If no exists the start state of the transition,
     * this exception will trigger.
     * @see NoStateException
     */
    public void addTransition(TransitionBase trans) throws NoStateException {
        StateBase st = states.get(trans.startState);

        try{
            if (states.get(trans.startState) == null) {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException nsee){
            throw new NoStateException(String.format("The state %s is not in the machine's map of states", trans.startState), nsee);
        }

        st.addTransition(trans);
    }

    /**
     * This method will add an event/element to the machine in order to make it
     * trigger a transition and execute some code.
     * @param evtName Identifier of the event that triggers the transition.
     * @throws NoTransitionException This exception will triggers if there isn't
     * any transition in the state for the given event.
     * @see NoTransitionException
     */
    public void addEvent(String evtName) throws NoTransitionException {
        StateBase state = states.get(currentState);
        
        try{
            if (state.transitions.containsKey(evtName)) {

                TransitionBase trans = state.transitions.get(evtName);
                setLastState(trans.startState);
                setState(trans.endState, false);

                if (states.get(trans.endState).autoTransitionState != null) {
                    addEvent("(auto)");
                }
            } else {
                throw new NoSuchElementException();
            }
        } catch(NoSuchElementException nsee){
            throw new NoTransitionException(String.format("No transition from state %s with event %s was found", currentState, evtName), nsee);
        }
    }

    /**
     * This method makes the machine evaluate a complete sequence of events.
     * @param seq A vector of events to evaluate by the machine
     * @throws NoTransitionException This exception will triggers if there isn't
     * any transition in the state for the given event.
     * @see NoTransitionException
     */
    public void evaluateSequence(String[] seq) throws NoTransitionException {
        for (String element : seq) {
            this.addEvent(element);
        }
    }

}
