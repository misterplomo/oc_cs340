import java.util.Scanner;
import java.util.Stack;

public class infixtoprofix {
private Stack<String> stack;
private String infixExp;
private String postfixExp = "";
public infixtoprofix(String exp){
String str = "";
infixExp = exp;
stack = new Stack<String>();
for (int i=0;i<infixExp.length();i++){
str = infixExp.substring(i,i+1);
if(str.matches("[a-zA-Z]|\\d"))
postfixExp += str;
else if (isOperator(str)){
if (stack.isEmpty()){
stack.push(str);
}

else{
String stackTop = stack.peek();
while (getPrecedence(stackTop,str, stackTop).equals(stackTop)&& !(stack.isEmpty())){
postfixExp += stack.pop();
if (!(stack.isEmpty()))
stackTop = stack.peek();
}
stack.push(str);
}
}
}
while(!(stack.isEmpty()))
postfixExp += stack.pop();
System.out.println("The postfix form of the expression you entered is: " + postfixExp);
}
private boolean isOperator(String ch){
String operators = "*/%+-";
if (operators.indexOf(ch) != -1)
return true;
else
return false;
}
private String getPrecedence(String op1, String op2, String op3){
String multiplicativeOps = "*/%";
String additiveOps = "+-";
String paranthesisOps = "{}";
if ((multiplicativeOps.indexOf(op1) != -1) && (additiveOps.indexOf(op2) != -1))
return op1;
else if ((multiplicativeOps.indexOf(op2) != -1) && (additiveOps.indexOf(op1) != -1))
return op2;
else if((multiplicativeOps.indexOf(op1) != -1) && (multiplicativeOps.indexOf(op2) != -1))
return op1;
else if((paranthesisOps.indexOf(op3) != -1) && (multiplicativeOps.indexOf(op2) != -1))
	return op3;
else 
return op1;
}
public static void main(String[] args){
System.out.println("Enter an expression in the Infix form:");
Scanner scanner = new Scanner(System.in);
String expression = scanner.nextLine();
new infixtoprofix(expression);
}
}

