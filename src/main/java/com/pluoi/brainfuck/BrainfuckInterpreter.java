package com.pluoi.brainfuck;

import java.util.Scanner;

public class BrainfuckInterpreter {

    private final int length = 65535;
    private final byte[] memory = new byte[length];
    private final Scanner ob = new Scanner(System.in);
    private final String programm;
    private int pointer;
    private int looper = 0;

    /**
     * Creates a new Brainfuck Interpreter.
     *
     * @param program The Brainfuck Source Code
     */
    public BrainfuckInterpreter(String program) {
        this.programm = program;
    }

    /**
     * Executes the Brainfuck Programm.
     */
    public void start() {
        String[] split = this.programm.split("");

        for (int i = 0; i < split.length; i++) {

            switch (split[i]) {
                case ">":
                    if (pointer == (length - 1)) pointer = 0;
                    else pointer++;
                    break;
                case "<":
                    if (pointer == 0) pointer = length - 1;
                    else pointer--;
                    break;
                case "+":
                    memory[pointer]++;
                    break;
                case "-":
                    memory[pointer]--;
                    break;
                case ".":
                    System.out.print((char) memory[pointer]);
                    break;
                case ",":
                    memory[pointer] = (byte) ob.next().charAt(0);
                    break;
                case "[":
                    if (memory[pointer] != 0) continue;

                    i++;

                    while (looper > 0 || !split[i].equals("]")) {
                        if (split[i].equals("[")) looper++;
                        else if (split[i].equals("]")) looper--;
                        i++;
                    }

                    break;
                case "]":
                    if (memory[pointer] == 0) continue;

                    i--;

                    while (looper > 0 || !split[i].equals("[")) {
                        if (split[i].equals("]")) looper++;
                        else if (split[i].equals("[")) looper--;
                        i--;
                    }

                    i--;
                    break;
            }
        }
    }
}
