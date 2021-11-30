package PDA2Stack;

public class Transition {

    private String input;
    private String stackAPop;
    private String stackAPush;
    private String stackBPop;
    private String stackBPush;
    private State nextState;

    public static final String E = "EPSILON";

    public static Transition on(String input){
         return new Transition(input);
    }

    public Transition popStackA(String pop){
        this.stackAPop = pop;
        return this;
    }

    public Transition popStackB(String pop){
        this.stackBPop = pop;
        return this;
    }

    public Transition pushStackA(String push){
        this.stackAPush = push;
        return this;
    }

    public Transition pushStackB(String push){
        this.stackBPush = push;
        return this;
    }

    public Transition nextState(State nextState){
        this.nextState = nextState;
        return this;
    }

    public String getStackAPop() {
        return stackAPop;
    }

    public String getStackAPush() {
        return stackAPush;
    }

    public String getStackBPop() {
        return stackBPop;
    }

    public String getStackBPush() {
        return stackBPush;
    }

    public State getNextState() {
        return nextState;
    }

    public String getOn(){
        return input;
    }

    public String toString(){
        return "[ "+input+", "+stackAPop+" -> "+stackAPush+" | "+stackBPop+" -> "+stackBPush+" | "+nextState.getIdentifier()+" ]";
    }

    private Transition(String input){
        this.input = input;
    }

}
