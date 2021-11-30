package PDA2Stack;

import java.util.ArrayList;
import java.util.HashMap;

public class State {

    private String identifier;
    private PushdownAutomata parentInstance;
    private HashMap<String, ArrayList<Transition>> transitions;

    State(String identifier, PushdownAutomata parentInstance){
        this.identifier = identifier;
        this.parentInstance = parentInstance;
        this.transitions = new HashMap<>();
    }

    public String getIdentifier(){
        return identifier;
    }

    public State setInitialState(){
        this.parentInstance.setInitialState(this);
        return this;
    }

    public State setFinalState(){
        this.parentInstance.addFinalState(this);
        return this;
    }

    public State addTransitions(Transition... transitions){
        for(Transition t: transitions)
            addTransition(t);
        return this;
    }

    private void addTransition(Transition transition){
        String input = transition.getOn();
        if(!transitions.containsKey(input))
            transitions.put(input,new ArrayList<Transition>());
        transitions.get(input).add(transition);
    }

    HashMap<String, ArrayList<Transition>> getTransitions(){
        return transitions;
    }

    boolean isFinalState(){
        return this.parentInstance.isFinalState(this);
    }


}
