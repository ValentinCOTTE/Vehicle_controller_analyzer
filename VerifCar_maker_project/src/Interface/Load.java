package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Action_listener.Delete;
import Action_listener.Load_set;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.io.File;

public class Load extends JDialog {
	Param param;

	public Load(Param param) {
		this.param=param;
		File repertoire=new File("resources/saves");

		String [] listefichiers;
		listefichiers=repertoire.list();

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


		setBounds(100, 100, 450, 30*listefichiers.length);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);



		int i;
		for(i=0;i<listefichiers.length;i++){
			if(listefichiers[i].endsWith(".ser")==true){

				JButton btnLoadthissave = new JButton(listefichiers[i].substring(0,listefichiers[i].length()-4));
				btnLoadthissave.addActionListener(new Load_set("resources/saves/"+listefichiers[i], param, this));
				GridBagConstraints gbc_btnLoadthissave = new GridBagConstraints();
				gbc_btnLoadthissave.gridwidth = 2;
				gbc_btnLoadthissave.insets = new Insets(0, 0, 0, 5);
				gbc_btnLoadthissave.gridx = 0;
				gbc_btnLoadthissave.gridy = i;
				getContentPane().add(btnLoadthissave, gbc_btnLoadthissave);
				{
					JButton btnDelete = new JButton("DELETE");
					btnDelete.addActionListener(new Delete("resources/saves/"+listefichiers[i], this));
					GridBagConstraints gbc_btnDelete = new GridBagConstraints();
					gbc_btnDelete.gridx = 2;
					gbc_btnDelete.gridy = i;
					getContentPane().add(btnDelete, gbc_btnDelete);
				}
			}
		}
		this.setVisible(true);

	}


	@Override
	public void repaint(){
		File repertoire=new File("resources/saves");

		String [] listefichiers;
		listefichiers=repertoire.list();

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


		setBounds(100, 100, 450, 30*listefichiers.length);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);



		int i;
		for(i=0;i<listefichiers.length;i++){
			if(listefichiers[i].endsWith(".ser")==true){

				JButton btnLoadthissave = new JButton(listefichiers[i].substring(0,listefichiers[i].length()-4));
				btnLoadthissave.addActionListener(new Load_set("resources/saves/"+listefichiers[i], param, this));
				GridBagConstraints gbc_btnLoadthissave = new GridBagConstraints();
				gbc_btnLoadthissave.gridwidth = 2;
				gbc_btnLoadthissave.insets = new Insets(0, 0, 0, 5);
				gbc_btnLoadthissave.gridx = 0;
				gbc_btnLoadthissave.gridy = i;
				getContentPane().add(btnLoadthissave, gbc_btnLoadthissave);
				{
					JButton btnDelete = new JButton("DELETE");
					btnDelete.addActionListener(new Delete("resources/saves/"+listefichiers[i], this));
					GridBagConstraints gbc_btnDelete = new GridBagConstraints();
					gbc_btnDelete.gridx = 2;
					gbc_btnDelete.gridy = i;
					getContentPane().add(btnDelete, gbc_btnDelete);
				}
			}
		}
		this.setVisible(true);
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

}
