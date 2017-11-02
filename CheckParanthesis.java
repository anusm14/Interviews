import java.lang.*;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
public class CheckParanthesis {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Boolean value = checkBalanceParantheis(scan.nextLine());
		System.out.println(" Balance Paranthesis :" + value);
		
		
	}

	
	static boolean checkBalanceParantheis(String expression)
	{
	Stack<Character> stack = new Stack<Character>();
	
	for (int i = 0; i < expression.length();i++)
	{
		char bracket = expression.charAt(i);
		
		if(bracket=='(' || bracket == '{' || bracket=='[')
		{
			stack.push(bracket);
		}
		else if(bracket==')' || bracket=='}'||bracket==']')
		{		
			try{
				
			
			char top = stack.peek();
			
		
			if(stack.empty() || !ArePair(top,bracket))
				return false;
			else
				stack.pop();
			}
			catch(EmptyStackException e)
			{
				
			}
				
		}
	}
	return stack.isEmpty()?true:false;

	
	
	
	}
	
	static boolean ArePair(char opening,char closing)
	{
	if(opening == '(' && closing == ')') return true;
	else if(opening == '{' && closing == '}') return true;
	else if(opening == '[' && closing == ']') return true;
	return false;
	}
}
