package calculator;

import static calculator.Operation.*;

public class StackComputing {
	CalculatorStack cs;
	
	public StackComputing() {
		cs = new CalculatorStack(4);
	}
	
	public void execute(Operation operation) {
		switch (operation) {
		case PLUS:
			plus();
			break;
		case MINUS:
			minus();
			break;
		case TIMES:
			times();
			break;
		case DIVIDES:
			divides();
			break;
		case ENTER:
			enter(5);
			break;
		case CLEAR:
			clear();
			break;
		case CHS:
			chs(5);
			break;
		case CLEARSTACK:
			clearstack();
			break;
		}
	}
	
	private int plus() {
		int temp = cs.pop() + cs.pop();
		
		return cs.push(temp);
	}
	
	private int minus() {
		int temp = cs.pop() - cs.pop();
		
		return cs.push(temp);
	}
	
	private int times() {
		int temp = cs.pop() * cs.pop();
		
		return cs.push(temp);
	}
	
	private int divides() {
		int temp = cs.pop() / cs.pop();
		
		return cs.push(temp);
	}
	
	private int enter(int push) {
		return cs.push(push);
	}
	
	private void clear() {
		cs.pop();
	}
	
	private void chs(int replacement) {
		cs.pop();
		cs.push(replacement);
	}
	
	private void clearstack() {
		for (int i = 0; i < 5; i++) 
			cs.push(0);
	}
}