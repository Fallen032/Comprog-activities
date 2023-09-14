import java.util.Scanner;
import java.util.Stack;

public class PEMDASCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an equation: ");
        String expression = scanner.nextLine();

        try {
            double result = calculate(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double calculate(String input) throws Exception {
        input = input.replaceAll(" ", "").toLowerCase();

        if (!input.matches("^[0-9+\\-*/().^]*$")) {
            throw new Exception("Invalid characters in the input.");
        }

        return evaluate(input);
    }

    private static double evaluate(String expression) throws Exception {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar >= '0' && currentChar <= '9') {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() &&
                       (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--; 
                operands.push(Double.parseDouble(numBuilder.toString()));
            } else if (currentChar == '(') {
                operators.push(currentChar);
            } else if (currentChar == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop();
            } else if (isOperator(currentChar)) {
                while (!operators.isEmpty() && precedence(currentChar) <= precedence(operators.peek())) {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(currentChar);
            }
        }

        while (!operators.isEmpty()) {
            operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
        }

        if (operands.size() == 1) {
            return operands.pop();
        } else {
            throw new Exception("Invalid expression");
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    private static double applyOperator(char operator, double operand2, double operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                return 0;
        }
    }
}
