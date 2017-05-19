package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Action_listener.Define_marking;
import Action_listener.Save_marking;

public class Marking extends JDialog {

	private JPanel contentPane;
	ArrayList<JTextField> textPosY= new ArrayList<JTextField>();
	ArrayList<String> PosY= new ArrayList<String>();
	int nb_lane;
	Param param;
	
	

	public Param getParam() {
		return param;
	}

	public Marking(int nb_lane,Param param) {
		this.nb_lane=nb_lane;
		this.param=param;
		
		this.setTitle("Marking");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		ArrayList<JLabel> lblPosY= new ArrayList<JLabel>();
		ArrayList<GridBagConstraints> gbc_lblPosY= new ArrayList<GridBagConstraints>();
		ArrayList<GridBagConstraints> gbc_textPosY= new ArrayList<GridBagConstraints>();
		int i;
		for(i=0; i<nb_lane-1;i++){
			lblPosY.add(i, new JLabel("posY"+(i+1)+"="));
			gbc_lblPosY.add(i, new GridBagConstraints()); 
			gbc_lblPosY.get(i).insets = new Insets(0, 0, 5, 5);
			gbc_lblPosY.get(i).anchor = GridBagConstraints.EAST;
			gbc_lblPosY.get(i).gridx = 1;
			gbc_lblPosY.get(i).gridy = i+1;
			contentPane.add(lblPosY.get(i), gbc_lblPosY.get(i));
			
			textPosY.add(i, new JTextField());
			textPosY.get(i).setText(Integer.toString((Integer.parseInt(param.getR())/nb_lane)*(i+1)));
			gbc_textPosY.add(i, new GridBagConstraints());
			gbc_textPosY.get(i).insets = new Insets(0, 0, 5, 0);
			gbc_textPosY.get(i).fill = GridBagConstraints.HORIZONTAL;
			gbc_textPosY.get(i).gridx = 2;
			gbc_textPosY.get(i).gridy = i+1;
			contentPane.add(textPosY.get(i), gbc_textPosY.get(i));
			textPosY.get(i).setColumns(10);
		}
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new Save_marking(this));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 3;
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = i+2;
		contentPane.add(btnSave, gbc_btnSave);
		
		this.setVisible(true);

		
	}

	public int getNb_lane() {
		return nb_lane;
	}

	public void setNb_lane(int nb_lane) {
		this.nb_lane = nb_lane;
	}

	public ArrayList<JTextField> getTextPosY() {
		return textPosY;
	}

	public void setTextPosY(ArrayList<JTextField> textPosY) {
		this.textPosY = textPosY;
	}

	public ArrayList<String> getPosY() {
		return PosY;
	}

	public void setPosY(ArrayList<String> posY) {
		PosY = posY;
	}

}
