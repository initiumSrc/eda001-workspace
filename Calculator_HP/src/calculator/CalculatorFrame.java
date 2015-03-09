package calculator;

import java.awt.BorderLayout;
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
		
		setSize(400, 350);
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
		
		OprKey oprEnter = new OprKey(sc, ENTER, "Enter", nf);
		OprKey oprCHS = new OprKey(sc, CHS, "CHS", nf);
		OprKey oprCLX = new OprKey(sc, CLEAR, "CLX", nf);
		OprKey oprCSTK = new OprKey(sc, CLEARSTACK, "CSTK", nf);
		
		mainPanel.add(oprEnter);
		mainPanel.add(oprCHS);
		mainPanel.add(oprCLX);
		mainPanel.add(oprCSTK);
		mainPanel.add(new NumKey(nf1, "1"));
		mainPanel.add(new NumKey(nf1, "2"));
		mainPanel.add(new NumKey(nf1, "3"));
		mainPanel.add(new NumKey(nf1, "4"));
		mainPanel.add(new NumKey(nf1, "5"));
		mainPanel.add(new NumKey(nf1, "6"));
		mainPanel.add(new NumKey(nf1, "7"));
		mainPanel.add(new NumKey(nf1, "8"));
		mainPanel.add(new NumKey(nf1, "9"));
		mainPanel.add(new NumKey(nf1, "0"));
		
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
		
		public void refreshField() {
			
		}
		
	}
	
	/* public NumField[] getFields() {
		NumField[] nfRet = new NumField[4];
		
		nfRet[0] = nf1;
		nfRet[1] = nf2;
		nfRet[2] = nf3;
		nfRet[3] = nf4;
		
		return nfRet;
	} */
}
