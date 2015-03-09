package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static calculator.Operation.*;

public class CalculatorFrame extends JFrame {
	StackComputing sc;
	NumField nf1, nf2, nf3, nf4;
	NumField[] nf = { nf1, nf2, nf3, nf4 };
	
	public CalculatorFrame(StackComputing sc) {
		super("Calculator");
		this.sc = sc;
		
		setSize(400, 370);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		nf1 = new NumField(32);
		nf2 = new NumField(32);
		nf3 = new NumField(32);
		nf4 = new NumField(32);

		mainPanel.add(nf1);
		mainPanel.add(nf2);
		mainPanel.add(nf3);
		mainPanel.add(nf4);
		
		OprKey oprEnter = new OprKey(sc, ENTER, "Enter", this);
		OprKey oprCHS = new OprKey(sc, CHS, "CHS", this);
		OprKey oprCLX = new OprKey(sc, CLEAR, "CLX", this);
		OprKey oprCSTK = new OprKey(sc, CLEARSTACK, "CSTK", this);
		OprKey oprPlus = new OprKey(sc, PLUS, "+", this);
		OprKey oprMinus = new OprKey(sc, MINUS, "-", this);
		OprKey oprTimes = new OprKey(sc, TIMES, "*", this);
		OprKey oprDivides = new OprKey(sc, DIVIDES, "/", this);
		
		oprPlus.setPreferredSize(new Dimension(74, 30));
		oprMinus.setPreferredSize(new Dimension(74, 30));
		oprTimes.setPreferredSize(new Dimension(74, 30));
		oprDivides.setPreferredSize(new Dimension(74, 30));
		
		
		mainPanel.add(oprEnter);
		mainPanel.add(oprCHS);
		mainPanel.add(oprCLX);
		mainPanel.add(oprCSTK);
		mainPanel.add(oprPlus);
		mainPanel.add(oprMinus);
		mainPanel.add(oprTimes);
		mainPanel.add(oprDivides);
		mainPanel.add(new NumKey(sc, "1", this));
		mainPanel.add(new NumKey(sc, "2", this));
		mainPanel.add(new NumKey(sc, "3", this));
		mainPanel.add(new NumKey(sc, "4", this));
		mainPanel.add(new NumKey(sc, "5", this));
		mainPanel.add(new NumKey(sc, "6", this));
		mainPanel.add(new NumKey(sc, "7", this));
		mainPanel.add(new NumKey(sc, "8", this));
		mainPanel.add(new NumKey(sc, "9", this));
		mainPanel.add(new NumKey(sc, "0", this));
		
		add(mainPanel, BorderLayout.CENTER);

		setVisible(true);
	}
	
	public class NumField extends JTextField {
		
		public NumField(int cols) {
			super(cols);
			
			setText("0");
			setHorizontalAlignment(JTextField.RIGHT);
			setEnabled(false);
		}

	}
	
	public NumField[] getFields() {
		NumField[] nfRet = new NumField[4];
		
		nfRet[0] = nf1;
		nfRet[1] = nf2;
		nfRet[2] = nf3;
		nfRet[3] = nf4;
		
		return nfRet;
	}
}
