
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
	private static JButton toErr;
	private static JButton clearButton;
	private static JButton backspaceButton;
	private static JButton Add_Button;
	private static JButton Sub_Button;
	private static JButton Times_Button;
	private static JButton Div_Button;

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
		numbox_label.setHorizontalAlignment(MyTextField.CENTER);
		numbox_label.setFont(new Font("Dialog", 1, 24));

		//error box
		errbox = new MyTextField();
		addComponent(frame, errbox, 1,1,3,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		errbox.setFont(new Font("Dialog", 1, 30));

		//Label for error box
		JLabel errbox_label = new JLabel("Uncertainty");
		addComponent(frame, errbox_label, 1, 0, 1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		errbox_label.setHorizontalAlignment(MyTextField.CENTER);
		errbox_label.setFont(new Font("Dialog", 1, 24));

		//Add borders
		Border border = BorderFactory.createLineBorder(Color.black);
		numbox.setBorder(border);
		errbox.setBorder(border);

		Dimension dim = new Dimension(100, 50);


		//Clear button (Clears memory)
		clearButton = new JButton("C");
		clearButton.setPreferredSize(dim);
		clearButton.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, clearButton, 2,0,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for (int i = 0; i == Control.inputArr.length; i ++) {
					Control.inputArr[i] = 0;
				}
				numbox.setText("");
				errbox.setText("");
				Control.errStatus = false;
				clearButton.setFocusPainted(false);
			}
		});




		//Backspace
		backspaceButton = new JButton("Back");
		backspaceButton.setPreferredSize(dim);
		backspaceButton.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, backspaceButton, 2,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		backspaceButton.setMargin(insets);
		backspaceButton.addActionListener(new ActionListener() {
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
				backspaceButton.setFocusPainted(false);
			}
		});


		//Button to change to error entry	
		toErr = new JButton("Error");
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
		Add_Button = new JButton("+");
		addOperationButton(Add_Button, "ADD", 2, 3, 1, 1);


		//Subtraction Button
		Sub_Button = new JButton("-");
		addOperationButton(Sub_Button, "MINUS", 3, 3, 1, 1);


		//Multiplication Button
		Times_Button = new JButton("X");
		addOperationButton(Times_Button, "TIMES", 4, 3, 1, 1);

		//Division Button
		Div_Button = new JButton("\u00F7");
		addOperationButton(Div_Button, "DIVIDE", 5, 3, 1, 1);


		//Equals button
		final JButton Equals_Button = new JButton("=");
		addOperationButton(Equals_Button, "EQUALS", 6, 3, 1, 1);


		//Set up number pad
		JButton Num1_Button = new JButton("1");
		addInputButton(Num1_Button, 5, 0, 1, 1);

		JButton Num2_Button = new JButton("2");
		addInputButton(Num2_Button, 5, 1, 1, 1);

		JButton Num3_Button = new JButton("3");
		addInputButton(Num3_Button, 5, 2, 1, 1);

		JButton Num4_Button = new JButton("4");
		addInputButton(Num4_Button, 4, 0, 1, 1);

		JButton Num5_Button = new JButton("5");
		addInputButton(Num5_Button, 4, 1, 1, 1);

		JButton Num6_Button = new JButton("6");
		addInputButton(Num6_Button, 4, 2, 1, 1);

		JButton Num7_Button = new JButton("7");
		addInputButton(Num7_Button, 3, 0, 1, 1);

		JButton Num8_Button = new JButton("8");
		addInputButton(Num8_Button, 3, 1, 1, 1);

		JButton Num9_Button = new JButton("9");
		addInputButton(Num9_Button, 3, 2, 1, 1);

		JButton Num0_Button = new JButton("0");
		addInputButton(Num0_Button, 6, 1, 1, 1);


		JButton Dec_Button = new JButton(".");
		addInputButton(Dec_Button, 6, 0, 1, 1);


		JButton NegButton = new JButton("\u00B1");
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
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,anchor, fill, insets, 0,0);
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

	private static void addOperationButton(JButton currentButton, String op, int gridx, int gridy, int gridwidth, int gridheight) {
		currentButton.setFont(new Font("Dialog", 1, 30));
		addComponent(frame, currentButton, gridx, gridy, gridwidth, gridheight, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		switch (op) {
		case "EQUALS": 
			addEqualsButton(currentButton);
			break;
		case "ADD":
			addPlusButton(currentButton);
			break;
		case "MINUS":
			addMinusButton(currentButton);
			break;
		case "TIMES":
			addTimesButton(currentButton);
			break;
		case "DIVIDE":
			addDivideButton(currentButton);
			break;
		}
	}

	private static void addPlusButton(JButton currentButton) {
		currentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doAdd = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
				toErr.setBorder(UIManager.getBorder("Button.border"));
				currentButton.setFocusPainted(false);
			}
		});
	}

	private static void addMinusButton(JButton currentButton) {
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
	}

	private static void addTimesButton(JButton currentButton) {
		currentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doTimes = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
				toErr.setBorder(UIManager.getBorder("Button.border"));
				currentButton.setFocusPainted(false);
			}
		});
	}

	private static void addDivideButton(JButton currentButton) {
		currentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Control.inputArr[0] = Double.parseDouble(numbox.getText());
				Control.inputArr[1] = Double.parseDouble(errbox.getText());
				numbox.setText("");
				errbox.setText("");
				Control.doDiv = true;
				numbox.requestFocusInWindow();
				Control.errStatus = false;
				toErr.setBorder(UIManager.getBorder("Button.border"));
				currentButton.setFocusPainted(false);
			}
		});
	}

	private static void addEqualsButton(JButton currentButton) {
		currentButton.addActionListener(new ActionListener() {
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
				currentButton.setFocusPainted(false);
			}
		});
	}
}
