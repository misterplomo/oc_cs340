import java.util.Scanner;
import java.util.Stack;

public class infixtoprofix {
	private Stack<String> stack;
	private String infixExp;
	private String postfixExp = "";

	public infixtoprofix(String exp) {
		String str = "";
		infixExp = exp;
		stack = new Stack<String>();
		for (int i = 0; i < infixExp.length(); i++) {
			str = infixExp.substring(i, i + 1);
			if (str.matches("[a-zA-Z]|\\d"))	// Operand
				postfixExp += str;
			else if (str.equals("("))			// Open Parenthesis
				stack.push(str);
			else if (str.equals(")")) {		// Close Parenthesis
				while (!(stack.isEmpty())) {
					String stackTop = stack.pop();
					if (!stackTop.equals("("))
						postfixExp += stackTop;
					else
						break;
				}
			}
			else if (isOperator(str))		// Operator (opThis)
				if (stack.isEmpty())
					stack.push(str);
				else {
					while (!(stack.isEmpty())){
						String stackTop = stack.pop();
						if (stackTop.equals("(")){
							stack.push(stackTop);
							break;
						}
						else if (isOperator(stackTop))
							if (getPrecedence(stackTop, str) == str) {
								stack.push(stackTop);
								break;
							} 
							else
								postfixExp += stackTop;

					}

					stack.push(str);
				}

		}
		while (!(stack.isEmpty()))				// No more items
			postfixExp += stack.pop();
		System.out.println("The postfix form of the expression you entered is: "
				+ postfixExp);
	}

	private boolean isOperator(String ch) {
		String operators = "*/%+-";
		if (operators.indexOf(ch) != -1)
			return true;
		else
			return false;
	}

	private String getPrecedence(String op1, String op2) {
		String multiplicativeOps = "*/%";
		String additiveOps = "+-";
		if ((multiplicativeOps.indexOf(op1) != -1)
				&& (additiveOps.indexOf(op2) != -1))
			return op1;
		else if ((multiplicativeOps.indexOf(op2) != -1)
				&& (additiveOps.indexOf(op1) != -1))
			return op2;
		else if ((multiplicativeOps.indexOf(op1) != -1)
				&& (multiplicativeOps.indexOf(op2) != -1))
			return op1;
		else
			return op1;
	}

	public static void main(String[] args) {
		System.out.println("Enter an expression in the Infix form:");
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		infixtoprofix a = new infixtoprofix(expression);
	}
}
