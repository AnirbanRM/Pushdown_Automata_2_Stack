package PDA2Stack;

import java.util.HashMap;
import java.util.HashSet;

public class PushdownAutomata {

    private HashMap<String,State> states;
    private State initialState;
    private HashSet<State> finalStates;

    public PushdownAutomata(){
        states = new HashMap<>();
        initialState = null;
        finalStates = new HashSet<>();
    }

    public State addState(String stateIdentifier) {
        if(this.states.containsKey(stateIdentifier))
            throw new RuntimeException("State with same identifier already exists!");
        State t = new State(stateIdentifier,this);
        this.states.put(stateIdentifier,t);
        return t;
    }

    void setInitialState(State initialState){
        if(this.initialState!=null)
            throw new RuntimeException("Initial State is already defined!");
        this.initialState = initialState;
    }

    void addFinalState(State s){
        finalStates.add(s);
    }

    boolean isFinalState(State s){
        return finalStates.contains(s);
    }

    public boolean evaluate(String input){

        String[] tokens = new String[input.length()];

        for(int i = 0; i<input.length(); i++)
            tokens[i] = String.valueOf(input.charAt(i));

        TraversalInstance instance = new TraversalInstance(this.initialState);
        return instance.traverse(tokens,0);

    }



}
