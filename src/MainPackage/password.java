package MainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class password extends JPanel implements ActionListener {
	private static String OK = "ok";
	private static String HELP = "help";

	private JFrame controllingFrame;
	private JPasswordField passwordField;

	public password(JFrame J) {

		controllingFrame = J;

		passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);

		JLabel label = new JLabel("Password: ");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setLabelFor(passwordField);

		JComponent buttonPane = createButtonPanel();
		JButton okButton = new JButton("OK");
		add(okButton);
		okButton.setActionCommand(OK);
		okButton.addActionListener(this);

		JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		textPane.add(label);
		textPane.add(passwordField);
		add(textPane);
		add(buttonPane);
		JButton helpButton = new JButton("Help");
		add(helpButton);
		helpButton.setActionCommand(HELP);
		helpButton.addActionListener(this);
	}
	
	
	
	
	
	
	protected JComponent createButtonPanel() {
		JPanel p = new JPanel(new GridLayout(0, 1));

		return p;
	}
	
	
	
	
	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };

		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctPassword);
		}

		Arrays.fill(correctPassword, '0');

		return isCorrect;
	}

	protected void resetFocus() {
		passwordField.requestFocusInWindow();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (OK.equals(cmd)) {
			char[] input = passwordField.getPassword();
			if (isPasswordCorrect(input)) {
				JOptionPane.showMessageDialog(controllingFrame,
						"That is the correct password.");
			} else {
				JOptionPane.showMessageDialog(controllingFrame,
						"Incorrect.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			Arrays.fill(input, '0');

			passwordField.selectAll();
			resetFocus();
		} else {
			JOptionPane
					.showMessageDialog(
							controllingFrame,
							"You can get the password by searching this example's\n"
									+ "source code for the string \"correctPassword\".\n"
									+ "Or look at the section How to Use Password Fields in\n"
									+ "the components section of The Java Tutorial.");
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Password");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final password newContentPane = new password(frame);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				newContentPane.resetFocus();
			}
		});

		frame.pack();
		frame.setVisible(true);
	}}
	
	