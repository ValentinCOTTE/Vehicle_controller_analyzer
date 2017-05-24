package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Action_listener.Continue_without_saving;
import Action_listener.Save_set;
import Principal.Application;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Save extends JDialog {
	private JTextField txtName;
	Application app;
	Param param;
	
	public Save(Application app, Param param) {
		this.app=app;
		this.param=param;
		
		this.setTitle("Saving...");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 450, 136);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblIfYouWant = new JLabel("If you want, you can save current settings");
			GridBagConstraints gbc_lblIfYouWant = new GridBagConstraints();
			gbc_lblIfYouWant.gridwidth = 3;
			gbc_lblIfYouWant.insets = new Insets(0, 0, 5, 5);
			gbc_lblIfYouWant.gridx = 0;
			gbc_lblIfYouWant.gridy = 1;
			getContentPane().add(lblIfYouWant, gbc_lblIfYouWant);
		}
		
		JLabel lblSaveName = new JLabel("Save name :");
		GridBagConstraints gbc_lblSaveName = new GridBagConstraints();
		gbc_lblSaveName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaveName.gridx = 0;
		gbc_lblSaveName.gridy = 3;
		getContentPane().add(lblSaveName, gbc_lblSaveName);
		
		
		String defaultName="untitled";
		File test=new File("resources/saves/"+defaultName+".ser");
		int i=1;
		while(test.exists()){
			defaultName="untitled"+i;
			i++;
			test=new File("resources/saves/"+defaultName+".ser");
		}
				
		txtName = new JTextField();
		txtName.setText(defaultName);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 3;
		getContentPane().add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JButton btnContinueWithout = new JButton("Continue without saving");
		btnContinueWithout.addActionListener(new Continue_without_saving(this.app,this.param,this));
		GridBagConstraints gbc_btnContinueWithout = new GridBagConstraints();
		gbc_btnContinueWithout.insets = new Insets(0, 0, 5, 5);
		gbc_btnContinueWithout.gridx = 1;
		gbc_btnContinueWithout.gridy = 4;
		getContentPane().add(btnContinueWithout, gbc_btnContinueWithout);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new Save_set(this.app, this.param, this, this.param.extract()));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 4;
		getContentPane().add(btnSave, gbc_btnSave);
		
		this.setVisible(true);
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

}
