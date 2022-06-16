package edu.unca.csci202;

import java.util.Scanner;
import java.util.Stack;


public class RPNCalculator {
	private Stack<Double> stack;
	
	
	public RPNCalculator() {
		stack = new Stack<Double>();
	}
	private void clear() {
		stack.clear();
	}
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("numbers");
			
			String line = scan.nextLine();
			System.out.println(":::>");
			if (line.equalsIgnoreCase("q")) {
				break;
			}
			System.out.println(process(line));
			
		}
		
	}
	
	private void add() {
		double operand_2 = stack.pop();
		double operand_1 = stack.pop();
		stack.push(operand_1 + operand_2);
		
	}
	private void subtract() {
		double operand_2 = stack.pop();
		double operand_1 = stack.pop();
		stack.push(operand_1 - operand_2);
		
	}
	private void multiply() {
		double operand_2 = stack.pop();
		double operand_1 = stack.pop();
		stack.push(operand_1 * operand_2);
		
	}
	private void divide() {
		double operand_2 = stack.pop();
		double operand_1 = stack.pop();
		stack.push(operand_1 / operand_2);
		
	}
	private String process(String input) {
		clear();
		String[] line_arr = input.split(" ");
		
		for(int i = 0; i < line_arr.length;i++) {
			try {
			if (line_arr[i].equals("+")) {
				add();
			} else if(line_arr[i].equals("-")) {
				subtract();
			}else if (line_arr[i].equals("*")) {
				multiply();
			}else if (line_arr[i].equals("/")) {
				divide();
			} else {
				try {
					double x = Double.parseDouble(line_arr[i]);
					stack.push(x);
					
				}catch (NumberFormatException e) {
					System.out.println("Invalid input: unrecognizable character");
					return "NaN";
				}
			}
			} catch (java.util.EmptyStackException e) {
				System.out.println("Not enough operands.");
				return "NaN";
			}
		}
		double output = stack.pop();
		if (stack.size() > 0) {
			System.out.println();
		}
		return "" + output;
	}
	public void run_tests() {
		String [] tests = {
				"3 4 +",
				"3 2 + 5 -",
				"3 4 / 5 + 6 8 +",
				"3 5 *"
		};
		for (int i = 0; i < tests.length; i++) {
		System.out.println(process(tests[i]));
		}
	}
}