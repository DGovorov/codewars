package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Instructions
 * Given a mathematical expression as a string you must return the result as a number.
 * <p>
 * Numbers
 * Number may be both whole numbers and/or decimal numbers. The same goes for the returned result.
 * <p>
 * Operators
 * You need to support the following mathematical operators:
 * Multiplication *
 * Division /
 * Addition +
 * Subtraction -
 * <p>
 * Operators are always evaluated from left-to-right, and * and / must be evaluated before + and -.
 * Parentheses
 * You need to support multiple levels of nested parentheses, ex. (2 / (2 + 3.33) * 4) - -6
 * <p>
 * Whitespace
 * There may or may not be whitespace between numbers and operators.
 * <p>
 * An addition to this rule is that the minus sign (-) used for negating numbers and parentheses will never be separated
 * by whitespace. I.e., all of the following are valid expressions.
 * <p>
 * 1-1    // 0
 * 1 -1   // 0
 * 1- 1   // 0
 * 1 - 1  // 0
 * 1- -1  // 2
 * 1 - -1 // 2
 * <p>
 * 6 + -(4)   // 2
 * 6 + -( -4) // 10
 * <p>
 * And the following are invalid expressions
 * <p>
 * 1 - - 1    // Invalid
 * 1- - 1     // Invalid
 * 6 + - (4)  // Invalid
 * 6 + -(- 4) // Invalid
 * <p>
 * Validation
 * <p>
 * You do not need to worry about validation - you will only receive valid mathematical expressions following the above rules.
 * Created by Dim on 27.07.2016.
 */
public class MathEvaluator {

    private List<String> list = new ArrayList<>();

    public double calculate(String expression) {
        expression = openBrackets(expression);
        expression = spaceOutSigns(expression);
        initList(expression);

        boolean didFix = true;
        while (didFix) {
            didFix = fixSpacedMinus();
        }
        List<String> signs = new ArrayList<String>() {{
            add("*");
            add("/");
        }};
        doOperations(signs);

        signs = new ArrayList<String>() {{
            add("+");
            add("-");
        }};
        doOperations(signs);

        return getNumber(0);
    }

    private void doOperations(List<String> signs) {
        boolean didCalculations = true;
        while (didCalculations) {
            for (int i = 0; i < list.size(); i++) {
                if (signs.contains(list.get(i))) {
                    double result = binOperation(i, list.get(i));
                    list.remove(i + 1);
                    list.remove(i);
                    list.remove(i - 1);
                    list.add(i - 1, String.valueOf(result));
                    break;
                }
                if (i == list.size() - 1) {
                    didCalculations = false;
                }
            }
        }
    }

    private double binOperation(int index, String sign) {
        switch (sign) {
            case "+":
                return doSum(index);
            case "-":
                return doSubtraction(index);
            case "*":
                return doMultiplication(index);
            case "/":
                return doDivision(index);
            default:
                throw new RuntimeException("Unknown sign: " + sign);
        }
    }

    private double doSum(int index) {
        return getNumber(index - 1) + getNumber(index + 1);
    }

    private double doMultiplication(int index) {
        return getNumber(index - 1) * getNumber(index + 1);
    }

    private double doDivision(int index) {
        return getNumber(index - 1) / getNumber(index + 1);
    }

    private double doSubtraction(int index) {
        return getNumber(index - 1) - getNumber(index + 1);
    }

    private Double getNumber(int index) {
        String s = list.get(index);
        if (isNumber(s)) {
            return Double.valueOf(list.get(index));
        } else {
            throw new RuntimeException("Can't get a number: " + s + "\n" + list);
        }
    }

    /**
     * Method creates a new instance of MathEvaluator to calculate result within brackets, and then replace brackets
     * with resulting value of its contains.
     *
     * @param expression to open brackets
     * @return modified expression without brackets
     */
    private String openBrackets(String expression) {
        int withinBrackets = 0;
        int leftBracket = 0;
        int rightBracket;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                if (withinBrackets < 1) {
                    leftBracket = i;
                }
                withinBrackets++;
            }
            if (expression.charAt(i) == ')') {
                if (withinBrackets == 1) {
                    MathEvaluator evaluator = new MathEvaluator();
                    rightBracket = i;
                    String interior = expression.substring(leftBracket, rightBracket + 1);
                    double braSum = evaluator.calculate(interior.substring(1, interior.length() - 1).trim());
                    expression = expression.replace(interior, String.valueOf(braSum));
                    i = leftBracket;
                }
                withinBrackets--;
            }
        }
        return expression;
    }

    private void initList(String expression) {
        String[] array = expression.split("\\s+");
        list = new ArrayList<>(Arrays.asList(array));
    }

    private boolean fixSpacedMinus() {
        boolean fixed = false;
        for (int i = 1; i < list.size() - 1; i++) {
            String current = list.get(i);
            String prev = list.get(i - 1);
            String next = list.get(i + 1);
            if ((isSign(prev) || prev.isEmpty()) && current.equals("-") && isNumber(next)) {
                Double changed = Double.valueOf(next) * -1;
                list.remove(i + 1);
                list.remove(i);
                list.add(i, String.valueOf(changed));
                if (prev.isEmpty()) {
                    list.remove(i - 1);
                }
                fixed = true;
            }
        }
        return fixed;
    }

    private String spaceOutSigns(String expression) {
        expression = expression.replace("-", " - ");
        expression = expression.replace("+", " + ");
        expression = expression.replace("*", " * ");
        expression = expression.replace("/", " / ");
        return expression;
    }

    private boolean isSign(String str) {
        List<String> signs = new ArrayList<String>() {{
            add("*");
            add("/");
            add("-");
            add("+");
        }};
        return signs.contains(str);
    }

    private boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

}