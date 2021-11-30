/**
 *
 * Team: Code Panthers
 * Program: Checking acceptance for list of input strings in two stack PDA
 *
 *
 * Member 1:
 * ------------
 * Name: Shivalika Singh
 * Enrollment No.: E19CSE420
 * Batch: EB01
 *
 *
 * Member 2:
 * ------------
 * Name: Anirban Roy Mukherjee
 * Enrollment No.: E19CSE097
 * Batch: EB03
 *
 *
 */


import PDA2Stack.PushdownAutomata;
import PDA2Stack.State;
import PDA2Stack.Transition;

public class Main {

    private static void example1(String[] testcases){

        /**
         *
         * Example 1:::  2 stack PDA that accepts language L = a^n b^n c^n  | n >= 0
         *
         * Diagram:
         *
         *
         *                    E, (E => Z0)            E, (E => E)             E, (E => E)             E, (Z0 => E)
         *           .------.    (E => Z1)   .------.    (E => E)    .------.    (E => E)    .------.    (Z1 => E)   .======.
         *    ======>|  q0  |===============>|  q1  |===============>|  q2  |===============>|  q3  |===============>|| q4 ||
         *           '------'                '------'                '------'                '------'                "======"
         *                                    |    ^                  |    ^                  |    ^
         *                                    |    |                  |    |                  |    |
         *                                    '----'                  '----'                  '----'
         *                                  a, (E => a)             b, (E => E)             c, (a => E)
         *                                     (E => E)                (E => b)                (b => E)
         *
         *
         */


        PushdownAutomata example1 = new PushdownAutomata();

        State q0 = example1.addState("q0").setInitialState();
        State q1 = example1.addState("q1");
        State q2 = example1.addState("q2");
        State q3 = example1.addState("q3");
        State q4 = example1.addState("q4").setFinalState();

        q0.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA("Z0")
                        .popStackB(Transition.E).pushStackB("Z1")
                        .nextState(q1)

        );

        q1.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q2),

                Transition.on("a")
                        .popStackA(Transition.E).pushStackA("a")
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q1)

        );

        q2.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q3),

                Transition.on("b")
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB("b")
                        .nextState(q2)

        );

        q3.addTransitions(

                Transition.on(Transition.E)
                        .popStackA("Z0").pushStackA(Transition.E)
                        .popStackB("Z1").pushStackB(Transition.E)
                        .nextState(q4),

                Transition.on("c")
                        .popStackA("a").pushStackA(Transition.E)
                        .popStackB("b").pushStackB(Transition.E)
                        .nextState(q3)

        );

        for(String s: testcases)
            System.out.println(s+" -> "+example1.evaluate(s));

    }

    private static void example2(String[] testcases){

        /**
         *
         * Example 2:::  2 stack PDA that accepts language L = a^n b^m a^n b^m   | n >= 0 and m >= 0
         *
         * Diagram:
         *
         *
         *                    E, (E => Z0)            E, (E => E)             E, (E => E)             E, (E => E)             E, (Z0 => E)
         *           .------.    (E => Z1)   .------.    (E => E)    .------.    (E => E)    .------.    (E => E)    .------.    (Z1 => E)   .======.
         *    ======>|  q0  |===============>|  q1  |===============>|  q2  |===============>|  q3  |===============>|  q4  |===============>|| q5 ||
         *           '------'                '------'                '------'                '------'                '------'                "======"
         *                                    |    ^                  |    ^                  |    ^                  |    ^
         *                                    |    |                  |    |                  |    |                  |    |
         *                                    '----'                  '----'                  '----'                  '----'
         *                                  a, (E => a)             b, (E => E)             a, (a => E)             b, (E => E)
         *                                     (E => E)                (E => b)                (E => E)                (b => E)
         *
         *
         */


        PushdownAutomata example2 = new PushdownAutomata();

        State q0 = example2.addState("q0").setInitialState();
        State q1 = example2.addState("q1");
        State q2 = example2.addState("q2");
        State q3 = example2.addState("q3");
        State q4 = example2.addState("q4");
        State q5 = example2.addState("q5").setFinalState();

        q0.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA("Z0")
                        .popStackB(Transition.E).pushStackB("Z1")
                        .nextState(q1)

        );

        q1.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q2),

                Transition.on("a")
                        .popStackA(Transition.E).pushStackA("a")
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q1)

        );

        q2.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q3),

                Transition.on("b")
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB("b")
                        .nextState(q2)

        );

        q3.addTransitions(

                Transition.on(Transition.E)
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q4),

                Transition.on("a")
                        .popStackA("a").pushStackA(Transition.E)
                        .popStackB(Transition.E).pushStackB(Transition.E)
                        .nextState(q3)

        );

        q4.addTransitions(

                Transition.on(Transition.E)
                        .popStackA("Z0").pushStackA(Transition.E)
                        .popStackB("Z1").pushStackB(Transition.E)
                        .nextState(q5),

                Transition.on("b")
                        .popStackA(Transition.E).pushStackA(Transition.E)
                        .popStackB("b").pushStackB(Transition.E)
                        .nextState(q4)

        );

        for(String s: testcases)
            System.out.println(s+" -> "+example2.evaluate(s));

    }

    public static void main(String[] args) {

        String[] testCases1 = new String[]{
                "abbaabc",
                "ccbbaa",
                "bcaaca",
                "aaaaaaabbbbbbbccccccc",
                "abc",
                "aabbcc",
                "bacbac",
                "abc",
                "",
                "abbccc",
                "aaabbc",
                "aaaabbbbcccc",
                "aaaabbbb",
                "bbbbcccc",
                "abbaac",
                "bbaacc",
                "aaabbbbccc",
                "abbcabbc",
                "abbbbbbc",
                "aaaaaaabc",
                "abccccccc"

                //..... More test cases to add here
        };

        System.out.println("EXAMPLE 1: \n----------------");
        example1(testCases1);
        System.out.println();



        String[] testCases2 = new String[]{
                "aabbaabb",
                "aaaabbbaaaabbb",
                "aaaaabbbbbaaaaabbbbbb",
                "aaabbbaaabbb",
                "aaabbaabb",
                "abbabb",
                "abababab",
                "",
                "aabbbaaabb",
                "abbabba",
                "bbbaaabbbaaa",
                "abbbbabbbb",
                "bbbbbbbb",
                "aaaaaaaa",
                "aaaaa",
                "bbbbbbb",
                "aaaababbbb",
                "abbbaaab",
                "aaaabbbbaaabbb",
                "abab",
                "baba"

                //..... More test cases to add here
        };

        System.out.println("EXAMPLE 2: \n----------------");
        example2(testCases2);
        System.out.println();

    }
}