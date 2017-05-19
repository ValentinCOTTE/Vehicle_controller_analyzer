package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Action_listener.Exit;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Error_message extends JDialog {

	public Error_message(String message) {
		this.setTitle("ERROR");

		setBounds(100, 100, message.length()*12, 80);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblMessage = new JLabel(message);
			lblMessage.setForeground(Color.RED);
			lblMessage.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gbc_lblMessage = new GridBagConstraints();
			gbc_lblMessage.gridwidth = 2;
			gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
			gbc_lblMessage.gridx = 0;
			gbc_lblMessage.gridy = 0;
			getContentPane().add(lblMessage, gbc_lblMessage);
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new Exit(this));
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 2;
		getContentPane().add(btnOk, gbc_btnOk);
		this.setVisible(true);
	}
}