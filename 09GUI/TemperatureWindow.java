import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemperatureWindow {

	private JFrame frame;
	private JTextField t0;
	private JTextField t1;
	private JLabel lblFarenheit;
	private JLabel lblCelcius;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureWindow window = new TemperatureWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TemperatureWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		t0 = new JTextField();
		t0.setBounds(42, 186, 130, 26);
		frame.getContentPane().add(t0);
		t0.setColumns(10);

		t1 = new JTextField();
		t1.setBounds(406, 186, 130, 26);
		frame.getContentPane().add(t1);
		t1.setColumns(10);

		JButton btnNewButton = new JButton("Convert to Celcius");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = t0.getText();
				try {
					t1.setText(Integer.toString((int)Temperature.FtoC(Double.parseDouble(temp))));
				}
				catch( Exception ex) {

				}
			}
		});
		btnNewButton.setBounds(213, 242, 171, 29);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Temperature Window");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(179, 62, 305, 57);
		frame.getContentPane().add(lblNewLabel);

		lblFarenheit = new JLabel("Farenheit:");
		lblFarenheit.setBounds(42, 158, 84, 16);
		frame.getContentPane().add(lblFarenheit);

		lblCelcius = new JLabel("Celcius:");
		lblCelcius.setBounds(406, 158, 61, 16);
		frame.getContentPane().add(lblCelcius);

		btnNewButton_1 = new JButton("Convert to Farenheit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = t1.getText();
				try {
					t0.setText(Integer.toString((int)Temperature.CtoF(Double.parseDouble(temp))));
				}
				catch(Exception ex) {

				}
			}
		});
		btnNewButton_1.setBounds(213, 290, 171, 29);
		frame.getContentPane().add(btnNewButton_1);


	}
}
