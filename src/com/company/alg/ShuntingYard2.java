package com.company.alg;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ShuntingYard2 {

    public static void main(String[] args) {
        System.out.println(evalPostfix(postfix("10 + 2 * 6")));
        System.out.println(evalPostfix(postfix("100 * 2 + 12")));
        System.out.println(evalPostfix(postfix("100 * ( 2 + 12 )")));
        System.out.println(evalPostfix(postfix("100 * ( 2 + 12 ) / 14")));
        System.out.println(evalPostfix(postfix("3 + 4 * 2 / ( 7 - 5 )")));
        System.out.println(evalPostfix(postfix("3 + 4 * 2 / ( 7 - 5 ) ^ 3")));
    }

    private static String postfix(String infix) {
        StringBuilder output = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for (String token : infix.split("\\s")) {
            // operator
            if (ops.containsKey(token)) {
                while (!stack.isEmpty() && isHigerPrec(token, stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(token);
                // left parenthesis
            } else if (token.equals("(")) {
                stack.push(token);
                // right parenthesis
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else {
                output.append(token).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }
        System.out.println(output.toString());
        return output.toString();
    }

    private static boolean isHigerPrec(String op, String sub) {
        return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
    }

    public static double evalPostfix(String exp) {
        double res;
        String[] tokens = exp.split("\\s");
        Deque<Double> list = new LinkedList<>();
        double operand1;
        double operand2;
        for (String token : tokens) {
            if (!ops.containsKey(token)) {
                list.push(Double.valueOf(token));
            } else {
                operand1 = list.pop();
                operand2 = list.pop();

                Operator operator = ops.get(token);
                switch (operator) {
                    case ADD:
                        list.push(operand2 + operand1);
                        break;
                    case SUBTRACT:
                        list.push(operand2 - operand1);
                        break;
                    case MULTIPLY:
                        list.push(operand2 * operand1);
                        break;
                    case DIVIDE:
                        list.push(operand2 / operand1);
                        break;
                    case POWER:
                        list.push(Math.pow(operand2, operand1));
                        break;
                    default:
                        System.out.println("Invalid operator order!");
                }
            }
        }
        res = list.pop();
        return res;
    }

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4), POWER(5);
        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    private static Map<String, Operator> ops = new HashMap<>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
        put("^", Operator.POWER);
    }};
}
