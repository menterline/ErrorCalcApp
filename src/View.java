
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Insets;
import java.awt.event.*;

import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class View {


	private static final Insets insets = new Insets(0,0,0,0);
	private static JFrame frame;
	private static MyTextField numbox;
	private static MyTextField errbox;
	
	public static void main(String[] args) {

		frame = new JFrame("Error Propagation Calculator");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());



		//make text fields
		//box to enter value
		numbox = new MyTextField();
		addComponent (frame, numbox, 0, 1, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		numbox.setFont(new Font("Dialog", 1, 30));

		//Label for Number box
		JLabel numbox_label = new JLabel("Number");
		addComponent(frame, numbox_label, 0, 0, 1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		numbox_label.setHorizontalAlignment(MyTextField.RIGHT);
		numbox_label.setFont(new Font("Dialog", 1, 32));

		//error box
		errbox = new MyTextField();
		addComponent(frame, errbox, 1,1,3,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		errbox.setFont(new Font("Dialog", 1, 30));

		//Label for error box
		JLabel errbox_label = new JLabel("Uncertainty");
		addComponent(frame, errbox_label, 1, 0, 1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		errbox_label.setHorizontalAlignment(MyTextField.RIGHT);
		errbox_label.setFont(new Font("Dialog", 1, 32));

		//Add borders
		Border border = BorderFactory.createLineBorder(Color.black);
		numbox.setBorder(border);
		errbox.setBorder(border);

        Dimension dim = new Dimension(100, 50);


        //Clear button (Clears memory)
		final JButton ClearButton = new JButton("C");
        ClearButton.setPreferredSize(dim);
        ClearButton.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, ClearButton, 2,0,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for (int i = 0; i == Control.inputArr.length; i ++) {
					Control.inputArr[i] = 0;
				}
				numbox.setText("");
				errbox.setText("");
				Control.errStatus = false;
				ClearButton.setFocusPainted(false);
			}
		});




		//Backspace
		final JButton BackspaceButton = new JButton("Back");
        BackspaceButton.setPreferredSize(dim);
        BackspaceButton.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, BackspaceButton, 2,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		BackspaceButton.setMargin(insets);
		BackspaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean errStatus = Control.errStatus;
				if (numbox.getText().length() != 0) {
					if (errStatus == false) {
						String curText = numbox.getText();
						numbox.setText(curText.substring(0,curText.length()-1));
					}
					if (errStatus == true) {
						String curText = errbox.getText();
						errbox.setText(curText.substring(0,curText.length()-1));
					}
				}
				else {
					numbox.setText("");
				}
                BackspaceButton.setFocusPainted(false);
			}
		});


		//Button to change to error entry
		final JButton toErr = new JButton("Error");
		toErr.setFont(new Font("Dialog", 1, 30));
		toErr.setPreferredSize(dim);
		addComponent(frame, toErr, 2, 2,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		toErr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.errStatus = !Control.errStatus;
				if (Control.errStatus) {
					toErr.setBorder(BorderFactory.createLoweredBevelBorder());
				}
				else {
					toErr.setBorder(UIManager.getBorder("Button.border"));
				}
                toErr.setFocusPainted(false);
			}
		});

		//Addition Button
		final JButton Add_Button = new JButton("+");
        Add_Button.setPreferredSize(dim);
		Add_Button.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, Add_Button, 2,3,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Add_Button.setMargin(insets);
		Add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doAdd = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
				toErr.setBorder(UIManager.getBorder("Button.border"));
                Add_Button.setFocusPainted(false);
			}
		});


		//Subtraction Button
		final JButton Sub_Button = new JButton("-");
		Sub_Button.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, Sub_Button, 3,3,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Sub_Button.setMargin(insets);
		Sub_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doMinus = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
                toErr.setBorder(UIManager.getBorder("Button.border"));
                Sub_Button.setFocusPainted(false);
			}
		});

		//Multiplication Button
		final JButton Mult_Button = new JButton("X");
		Mult_Button.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, Mult_Button, 4,3,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Mult_Button.setMargin(insets);
		Mult_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doTimes = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
                toErr.setBorder(UIManager.getBorder("Button.border"));
                Mult_Button.setFocusPainted(false);
			}
		});
		//Division Button
		final JButton Div_Button = new JButton("\u00F7");
		Div_Button.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, Div_Button, 5,3,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Div_Button.setMargin(insets);
		Div_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doDiv = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
                toErr.setBorder(UIManager.getBorder("Button.border"));
                Div_Button.setFocusPainted(false);
			}
		});
		//Equals button
		final JButton Equals_Button = new JButton("=");
		Equals_Button.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, Equals_Button, 6,3,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Equals_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[2] = Double.parseDouble(numbox.getText());
				Control.inputArr[3] = Double.parseDouble(errbox.getText());
				numbox.setText((Double.toString(Control.doOperation(Control.inputArr)[0])));
				errbox.setText((Double.toString(Control.doOperation(Control.inputArr)[1])));
				Control.doAdd = false;
				Control.doMinus = false;
				Control.doTimes = false;
				Control.doDiv = false;
                toErr.setBorder(UIManager.getBorder("Button.border"));
                Equals_Button.setFocusPainted(false);
			}
		});


		//Set up number pad
		final JButton Num1_Button = new JButton("1");
		addInputButton(Num1_Button, 5, 0, 1, 1);
	
		final JButton Num2_Button = new JButton("2");
		addInputButton(Num2_Button, 5, 1, 1, 1);

		final JButton Num3_Button = new JButton("3");
		addInputButton(Num3_Button, 5, 2, 1, 1);

		final JButton Num4_Button = new JButton("4");
		addInputButton(Num4_Button, 4, 0, 1, 1);

		final JButton Num5_Button = new JButton("5");
		addInputButton(Num5_Button, 4, 1, 1, 1);

		final JButton Num6_Button = new JButton("6");
		addInputButton(Num6_Button, 4, 2, 1, 1);

		final JButton Num7_Button = new JButton("7");
		addInputButton(Num7_Button, 3, 0, 1, 1);
		
		final JButton Num8_Button = new JButton("8");
		addInputButton(Num8_Button, 3, 1, 1, 1);

		final JButton Num9_Button = new JButton("9");
		addInputButton(Num9_Button, 3, 2, 1, 1);

		final JButton Num0_Button = new JButton("0");
		addInputButton(Num0_Button, 6, 1, 1, 1);

		
		final JButton Dec_Button = new JButton(".");
		addInputButton(Dec_Button, 6, 0, 1, 1);
		

		final JButton NegButton = new JButton("\u00B1");
		NegButton.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, NegButton, 6,2,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		NegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean errStatus = Control.errStatus;
				if (errStatus == false) {
					String curr = numbox.getText();
				    	if (curr.charAt(0) != '-') {
						numbox.setText('-' + curr);
					}
					if (curr.charAt(0) == '-') {
						numbox.setText(curr.substring(1, curr.length()));
					}
				}
				if (errStatus == true) {
					String curr = errbox.getText();
				    	if (curr.charAt(0) != '-') {
						errbox.setText('-' + curr);
					}
					if (curr.charAt(0) == '-') {
						errbox.setText(curr.substring(1, curr.length()));
					}

				}
                NegButton.setFocusPainted(false);
			}
		});


		frame.setSize(550,650);
		frame.setVisible(true);


	}
	//General Method for adding components to GridBagLayout
	private static void addComponent(Container container, Component component, int gridy, int gridx,
			int gridwidth, int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0,0);
		container.add(component, gbc);
	}
	
	private static void addInputButton(JButton currentButton, int gridx, int gridy, int gridwidth, int gridheight) {
		Font btnFont = new Font("Dialog", 1, 30);
		currentButton.setFont(btnFont);
		addComponent(frame, currentButton, gridx, gridy, gridwidth, gridheight, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		currentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean errStatus = Control.errStatus;
				if (errStatus == false) {
					numbox.append(currentButton.getText());
				}
				if (errStatus == true) {
					errbox.append(currentButton.getText());
				}
				currentButton.setFocusPainted(false);
			}
		});
	}
}
