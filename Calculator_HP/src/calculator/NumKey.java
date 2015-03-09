package calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import calculator.CalculatorFrame.NumField;

public class NumKey extends JButton implements ActionListener {
	private NumField nf;
	private String label;
	
	public NumKey(NumField nf, String label) {
		super(label);
		this.nf = nf;
		this.label = label;
		setPreferredSize(new Dimension(125, 30));
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (nf.getText().equals("0"))
			nf.setText(label);
		else 
			nf.setText(nf.getText() + label);
	}
}