package com.pluoi.brainfuck;

public class Main {

    /**
     * Example Input: ++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.
     *
     * @param args Brainfuck Programm
     * @throws Exception When no Programm is given.
     */
    public static void main(String[] args) throws Exception {

        if (args.length != 1) throw new Exception("No Parameters");

        BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter(args[0]);
        brainfuckInterpreter.start();
    }
}
