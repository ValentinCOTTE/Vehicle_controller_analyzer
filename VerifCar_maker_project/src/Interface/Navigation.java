package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Action_listener.Save_navigation;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Navigation extends JDialog {
	private ArrayList<JTextField> txtP=new ArrayList<JTextField>();

	ArrayList<JComboBox> comboBox = new ArrayList<JComboBox>();
	ArrayList<JComboBox> comboBox_2=new ArrayList<JComboBox>();

	public ArrayList<JComboBox> getComboBox() {
		return comboBox;
	}

	public void setComboBox(ArrayList<JComboBox> comboBox) {
		this.comboBox = comboBox;
	}

	public ArrayList<JComboBox> getComboBox_2() {
		return comboBox_2;
	}

	public void setComboBox_2(ArrayList<JComboBox> comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}

	Param param;
	Car car;

	public Navigation(Param param,Car car) {

		this.param=param;
		this.car=car;

		ArrayList<String> num_lane=new ArrayList<String>();
		for(int i=0;i<Integer.parseInt(param.getNb_lane());i++){
			num_lane.add(i,""+(i+1));
		}


		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("Navigation points of Car "+car.getIndex());

		setBounds(100+(car.getIndex()*20), 100, 450, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblPosx = new JLabel("posX");
		GridBagConstraints gbc_lblPosx = new GridBagConstraints();
		gbc_lblPosx.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosx.gridx = 2;
		gbc_lblPosx.gridy = 0;
		getContentPane().add(lblPosx, gbc_lblPosx);

		JLabel lblLaneinf = new JLabel("lane_inf");
		GridBagConstraints gbc_lblLaneinf = new GridBagConstraints();
		gbc_lblLaneinf.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaneinf.gridx = 3;
		gbc_lblLaneinf.gridy = 0;
		getContentPane().add(lblLaneinf, gbc_lblLaneinf);

		JLabel lblLanesup = new JLabel("lane_sup");
		GridBagConstraints gbc_lblLanesup = new GridBagConstraints();
		gbc_lblLanesup.insets = new Insets(0, 0, 5, 0);
		gbc_lblLanesup.gridx = 4;
		gbc_lblLanesup.gridy = 0;
		getContentPane().add(lblLanesup, gbc_lblLanesup);

		ArrayList<JLabel> lblP= new ArrayList<JLabel>();
		ArrayList<GridBagConstraints> gbc_lblP = new ArrayList<GridBagConstraints>();

		ArrayList<GridBagConstraints> gbc_txtP = new ArrayList<GridBagConstraints>();

		ArrayList<GridBagConstraints> gbc_comboBox = new ArrayList<GridBagConstraints>();

		ArrayList<GridBagConstraints> gbc_comboBox_5 = new ArrayList<GridBagConstraints>();

		int y;
		for(y=0;y<Integer.parseInt(car.getTxtNavigationpoints().getText());y++){
			lblP.add(y, new JLabel("P"+(y+1)));
			gbc_lblP.add(y, new GridBagConstraints());
			gbc_lblP.get(y).anchor = GridBagConstraints.EAST;
			gbc_lblP.get(y).insets = new Insets(0, 0, 5, 5);
			gbc_lblP.get(y).gridx = 1;
			gbc_lblP.get(y).gridy = y+1;
			getContentPane().add(lblP.get(y), gbc_lblP.get(y));

			txtP.add(y, new JTextField());
			try{
				txtP.get(y).setText(param.getCar_list().get(car.getIndex()).getNavigation_posX().get(y));
			}
			catch(IndexOutOfBoundsException e){
				txtP.get(y).setText("");
			}
			gbc_txtP.add(y, new GridBagConstraints());
			gbc_txtP.get(y).insets = new Insets(0, 0, 5, 5);
			gbc_txtP.get(y).fill = GridBagConstraints.HORIZONTAL;
			gbc_txtP.get(y).gridx = 2;
			gbc_txtP.get(y).gridy = y+1;
			getContentPane().add(txtP.get(y), gbc_txtP.get(y));
			txtP.get(y).setColumns(10);

			comboBox.add(y, new JComboBox());
			for(int i=0;i<Integer.parseInt(param.getNb_lane());i++){
				comboBox.get(y).addItem(num_lane.get(i));
			}
			try{
				comboBox.get(y).setSelectedItem(param.getCar_list().get(car.getIndex()).getNavigation_laneInf().get(y));
			}
			catch(IndexOutOfBoundsException e){
				//do nothing
			}

			gbc_comboBox.add(y, new GridBagConstraints());
			gbc_comboBox.get(y).insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.get(y).fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.get(y).gridx = 3;
			gbc_comboBox.get(y).gridy = y+1;
			getContentPane().add(comboBox.get(y), gbc_comboBox.get(y));

			comboBox_2.add(y, new JComboBox());
			for(int i=0;i<Integer.parseInt(param.getNb_lane());i++){
				comboBox_2.get(y).addItem(num_lane.get(i));
			}
			try{
				comboBox_2.get(y).setSelectedItem(param.getCar_list().get(car.getIndex()).getNavigation_laneSup().get(y));
			}
			catch(IndexOutOfBoundsException e){
				//do nothing
			}

			gbc_comboBox_5.add(y, new GridBagConstraints());
			gbc_comboBox_5.get(y).insets = new Insets(0, 0, 5, 0);
			gbc_comboBox_5.get(y).fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_5.get(y).gridx = 4;
			gbc_comboBox_5.get(y).gridy = y+1;
			getContentPane().add(comboBox_2.get(y), gbc_comboBox_5.get(y));

		}
		txtP.get(y-1).setText(param.getL());
		txtP.get(y-1).setEditable(false);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new Save_navigation(this));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 5;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = y+2;
		getContentPane().add(btnSave, gbc_btnSave);

		this.setVisible(true);
	}

	public ArrayList<JTextField> getTxtP() {
		return txtP;
	}

	public void setTxtP(ArrayList<JTextField> txtP) {
		this.txtP = txtP;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
