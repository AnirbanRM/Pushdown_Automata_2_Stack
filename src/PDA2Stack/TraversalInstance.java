package PDA2Stack;

import java.util.ArrayList;
import java.util.HashMap;

public class TraversalInstance implements Cloneable{

    State currentState;
    Stack<String> stackA;
    Stack<String> stackB;

    TraversalInstance(State initialState){
        stackA = new Stack<>();
        stackB = new Stack<>();
        this.currentState = initialState;
    }

    private TraversalInstance(State currentState, Stack<String> stackA, Stack<String> stackB){
        this.currentState = currentState;
        this.stackA = stackA;
        this.stackB = stackB;
    }

    @Override
    public TraversalInstance clone() {
        return new TraversalInstance(currentState,stackA.clone(),stackB.clone());
    }

    public boolean traverse(String[] input, int currentPosition){

        boolean traversalBoolean = false;

        if(currentPosition==input.length && currentState.isFinalState())
            return true;

        HashMap<String, ArrayList<Transition>> transitions = currentState.getTransitions();

        if(transitions.get(Transition.E)!=null) {
            for (Transition t : transitions.get(Transition.E)) {

                TraversalInstance newInst = this.clone();

                if (!t.getStackAPop().equals(Transition.E)) {
                    if (newInst.stackA.peek().equals(t.getStackAPop()))
                        newInst.stackA.pop();
                    else
                        continue;
                }
                if (!t.getStackAPush().equals(Transition.E))
                    newInst.stackA.push(t.getStackAPush());


                if (!t.getStackBPop().equals(Transition.E)) {
                    if (newInst.stackB.peek().equals(t.getStackBPop()))
                        newInst.stackB.pop();
                    else
                        continue;
                }
                if (!t.getStackBPush().equals(Transition.E))
                    newInst.stackB.push(t.getStackBPush());

                newInst.currentState = t.getNextState();
                if (newInst.currentState != null)
                    traversalBoolean = traversalBoolean || newInst.traverse(input, currentPosition);
            }
        }

        if(currentPosition==input.length)
            return traversalBoolean;

        if(transitions.get(input[currentPosition])!=null) {
            for (Transition t : transitions.get(input[currentPosition])) {

                TraversalInstance newInst = this.clone();

                if (!t.getStackAPop().equals(Transition.E)) {
                    if (newInst.stackA.peek().equals(t.getStackAPop()))
                        newInst.stackA.pop();
                    else
                        continue;
                }
                if (!t.getStackAPush().equals(Transition.E))
                    newInst.stackA.push(t.getStackAPush());


                if (!t.getStackBPop().equals(Transition.E)) {
                    if (newInst.stackB.peek().equals(t.getStackBPop()))
                        newInst.stackB.pop();
                    else
                        continue;
                }
                if (!t.getStackBPush().equals(Transition.E))
                    newInst.stackB.push(t.getStackBPush());

                newInst.currentState = t.getNextState();
                if (newInst.currentState != null)
                    traversalBoolean = traversalBoolean || newInst.traverse(input, currentPosition + 1);
            }
        }

        return traversalBoolean;
    }
}
