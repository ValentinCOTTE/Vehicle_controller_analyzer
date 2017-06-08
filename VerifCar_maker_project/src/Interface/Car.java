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
import Action_listener.Define_navigation;
import Action_listener.Save_car;
import Action_listener.Save_marking;
import Principal.Car_set;

public class Car extends JDialog {

	private JPanel contentPane;

	int index;
	Param param;




	private JTextField txtLengthvehicle;
	private JTextField txtWidthvehicle;
	private JTextField txtVmax;
	private JTextField txtAmin;
	private JTextField txtAmax;
	private JLabel lblVmax;
	private JLabel lblAmin;
	private JLabel lblAmax;
	private JLabel lblCtrfreq;
	private JLabel lblMaxcom;
	private JLabel lblMincom;
	private JLabel lblInitposx;
	private JLabel lblIntitposy;
	private JLabel lblInitv;
	private JLabel lblInita;
	private JLabel lblNavigationpoints;
	private JLabel lblNavigationlist;
	private JTextField txtMaxcom;
	private JTextField txtCtrfreq;
	private JTextField txtMincom;
	private JTextField txtInitposx;
	private JTextField txtInitV;
	private JTextField txtInitA;
	private JTextField txtInitposy;
	private JTextField txtNavigationpoints;
	private JButton btnDefine;

	private JTextField txtStepinitv;
	private JTextField txtStepinita;
	private JTextField txtLimitinita;
	private JTextField txtLimitinitv;

	int length_vehicle;
	int width_vehicle;
	int vmax;
	int amin;
	int amax;
	int maxcom;
	int ctrfreq;
	int mincom;
	int initposx;
	int initposy;
	int initV;
	int STEP_initV;
	int LIMIT_initV;
	int initA;
	int STEP_initA;
	int LIMIT_initA;
	int navigationpoints;

	ArrayList<Integer> navigation_posX=new ArrayList<Integer>();
	ArrayList<Integer> navigation_laneInf=new ArrayList<Integer>();
	ArrayList<Integer> navigation_laneSup=new ArrayList<Integer>();
	private JLabel lblStep;
	private JLabel lblLimit;





	public Car(int index,Param param) {
		try{
			load(param.getCar_list().get(index));
		}
		catch(IndexOutOfBoundsException arg){
			loadDefault();
		}
		catch(NullPointerException arg){
			loadDefault();
		}
		this.index=index;
		this.param=param;

		this.setTitle("Car "+(index+1));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100+(index*20), 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblStep = new JLabel("STEP");
		GridBagConstraints gbc_lblStep = new GridBagConstraints();
		gbc_lblStep.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep.gridx = 3;
		gbc_lblStep.gridy = 0;
		contentPane.add(lblStep, gbc_lblStep);

		lblLimit = new JLabel("LIMIT");
		GridBagConstraints gbc_lblLimit = new GridBagConstraints();
		gbc_lblLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimit.gridx = 4;
		gbc_lblLimit.gridy = 0;
		contentPane.add(lblLimit, gbc_lblLimit);


		JLabel lblLengthvehicle = new JLabel("length_vehicle=");
		GridBagConstraints gbc_lblLengthvehicle = new GridBagConstraints();
		gbc_lblLengthvehicle.insets = new Insets(0, 0, 5, 5);
		gbc_lblLengthvehicle.anchor = GridBagConstraints.EAST;
		gbc_lblLengthvehicle.gridx = 1;
		gbc_lblLengthvehicle.gridy = 1;
		contentPane.add(lblLengthvehicle, gbc_lblLengthvehicle);

		txtLengthvehicle = new JTextField();
		txtLengthvehicle.setText(""+length_vehicle);
		GridBagConstraints gbc_txtLength_vehicle = new GridBagConstraints();
		gbc_txtLength_vehicle.insets = new Insets(0, 0, 5, 5);
		gbc_txtLength_vehicle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLength_vehicle.gridx = 2;
		gbc_txtLength_vehicle.gridy = 1;
		contentPane.add(txtLengthvehicle, gbc_txtLength_vehicle);
		txtLengthvehicle.setColumns(10);

		JLabel lblWidthvehicle = new JLabel("width_vehicle=");
		GridBagConstraints gbc_lblWidthvehicle = new GridBagConstraints();
		gbc_lblWidthvehicle.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidthvehicle.anchor = GridBagConstraints.EAST;
		gbc_lblWidthvehicle.gridx = 1;
		gbc_lblWidthvehicle.gridy = 2;
		contentPane.add(lblWidthvehicle, gbc_lblWidthvehicle);

		txtWidthvehicle = new JTextField();
		txtWidthvehicle.setText(""+width_vehicle);
		GridBagConstraints gbc_txtWidthvehicle = new GridBagConstraints();
		gbc_txtWidthvehicle.insets = new Insets(0, 0, 5, 5);
		gbc_txtWidthvehicle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidthvehicle.gridx = 2;
		gbc_txtWidthvehicle.gridy = 2;
		contentPane.add(txtWidthvehicle, gbc_txtWidthvehicle);
		txtWidthvehicle.setColumns(10);

		lblVmax = new JLabel("v_max=");
		GridBagConstraints gbc_lblVmax = new GridBagConstraints();
		gbc_lblVmax.insets = new Insets(0, 0, 5, 5);
		gbc_lblVmax.anchor = GridBagConstraints.EAST;
		gbc_lblVmax.gridx = 1;
		gbc_lblVmax.gridy = 3;
		contentPane.add(lblVmax, gbc_lblVmax);

		txtVmax = new JTextField();
		txtVmax.setText(""+vmax);
		GridBagConstraints gbc_txtVmax = new GridBagConstraints();
		gbc_txtVmax.insets = new Insets(0, 0, 5, 5);
		gbc_txtVmax.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVmax.gridx = 2;
		gbc_txtVmax.gridy = 3;
		contentPane.add(txtVmax, gbc_txtVmax);
		txtVmax.setColumns(10);

		lblAmin = new JLabel("a_min=");
		GridBagConstraints gbc_lblAmin = new GridBagConstraints();
		gbc_lblAmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmin.anchor = GridBagConstraints.EAST;
		gbc_lblAmin.gridx = 1;
		gbc_lblAmin.gridy = 4;
		contentPane.add(lblAmin, gbc_lblAmin);

		txtAmin = new JTextField();
		txtAmin.setText(""+amin);
		GridBagConstraints gbc_txtAmin = new GridBagConstraints();
		gbc_txtAmin.insets = new Insets(0, 0, 5, 5);
		gbc_txtAmin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAmin.gridx = 2;
		gbc_txtAmin.gridy = 4;
		contentPane.add(txtAmin, gbc_txtAmin);
		txtAmin.setColumns(10);

		lblAmax = new JLabel("a_max=");
		GridBagConstraints gbc_lblAmax = new GridBagConstraints();
		gbc_lblAmax.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmax.anchor = GridBagConstraints.EAST;
		gbc_lblAmax.gridx = 1;
		gbc_lblAmax.gridy = 5;
		contentPane.add(lblAmax, gbc_lblAmax);

		txtAmax = new JTextField();
		txtAmax.setText(""+amax);
		GridBagConstraints gbc_txtAmax = new GridBagConstraints();
		gbc_txtAmax.anchor = GridBagConstraints.NORTH;
		gbc_txtAmax.insets = new Insets(0, 0, 5, 5);
		gbc_txtAmax.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAmax.gridx = 2;
		gbc_txtAmax.gridy = 5;
		contentPane.add(txtAmax, gbc_txtAmax);
		txtAmax.setColumns(10);

		lblCtrfreq = new JLabel("ctr_freq=");
		GridBagConstraints gbc_lblCtrfreq = new GridBagConstraints();
		gbc_lblCtrfreq.anchor = GridBagConstraints.EAST;
		gbc_lblCtrfreq.insets = new Insets(0, 0, 5, 5);
		gbc_lblCtrfreq.gridx = 1;
		gbc_lblCtrfreq.gridy = 6;
		contentPane.add(lblCtrfreq, gbc_lblCtrfreq);

		txtCtrfreq = new JTextField();
		txtCtrfreq.setText(""+ctrfreq);
		GridBagConstraints gbc_txtCtrfreq = new GridBagConstraints();
		gbc_txtCtrfreq.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCtrfreq.anchor = GridBagConstraints.NORTH;
		gbc_txtCtrfreq.insets = new Insets(0, 0, 5, 5);
		gbc_txtCtrfreq.gridx = 2;
		gbc_txtCtrfreq.gridy = 6;
		contentPane.add(txtCtrfreq, gbc_txtCtrfreq);
		txtCtrfreq.setColumns(10);

		lblMaxcom = new JLabel("max_com=");
		GridBagConstraints gbc_lblMaxcom = new GridBagConstraints();
		gbc_lblMaxcom.anchor = GridBagConstraints.EAST;
		gbc_lblMaxcom.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxcom.gridx = 1;
		gbc_lblMaxcom.gridy = 7;
		contentPane.add(lblMaxcom, gbc_lblMaxcom);

		txtMaxcom = new JTextField();
		txtMaxcom.setText(""+maxcom);
		GridBagConstraints gbc_txtMaxcom = new GridBagConstraints();
		gbc_txtMaxcom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaxcom.anchor = GridBagConstraints.NORTH;
		gbc_txtMaxcom.insets = new Insets(0, 0, 5, 5);
		gbc_txtMaxcom.gridx = 2;
		gbc_txtMaxcom.gridy = 7;
		contentPane.add(txtMaxcom, gbc_txtMaxcom);
		txtMaxcom.setColumns(10);

		lblMincom = new JLabel("min_com=");
		GridBagConstraints gbc_lblMincom = new GridBagConstraints();
		gbc_lblMincom.anchor = GridBagConstraints.EAST;
		gbc_lblMincom.insets = new Insets(0, 0, 5, 5);
		gbc_lblMincom.gridx = 1;
		gbc_lblMincom.gridy = 8;
		contentPane.add(lblMincom, gbc_lblMincom);

				txtMincom = new JTextField();
				txtMincom.setText(""+mincom);
				GridBagConstraints gbc_txtMincom = new GridBagConstraints();
				gbc_txtMincom.insets = new Insets(0, 0, 5, 5);
				gbc_txtMincom.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMincom.gridx = 2;
				gbc_txtMincom.gridy = 8;
				contentPane.add(txtMincom, gbc_txtMincom);
				txtMincom.setColumns(10);

				lblInitposx = new JLabel("init_posX=");
				GridBagConstraints gbc_lblInitposx = new GridBagConstraints();
				gbc_lblInitposx.anchor = GridBagConstraints.EAST;
				gbc_lblInitposx.insets = new Insets(0, 0, 5, 5);
				gbc_lblInitposx.gridx = 1;
				gbc_lblInitposx.gridy = 9;
				contentPane.add(lblInitposx, gbc_lblInitposx);

				txtInitposx = new JTextField();
				txtInitposx.setText(""+initposx);
				GridBagConstraints gbc_txtInitposx = new GridBagConstraints();
				gbc_txtInitposx.insets = new Insets(0, 0, 5, 5);
				gbc_txtInitposx.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInitposx.gridx = 2;
				gbc_txtInitposx.gridy = 9;
				contentPane.add(txtInitposx, gbc_txtInitposx);
				txtInitposx.setColumns(10);

				lblIntitposy = new JLabel("intit_posY=");
				GridBagConstraints gbc_lblIntitposy = new GridBagConstraints();
				gbc_lblIntitposy.anchor = GridBagConstraints.EAST;
				gbc_lblIntitposy.insets = new Insets(0, 0, 5, 5);
				gbc_lblIntitposy.gridx = 1;
				gbc_lblIntitposy.gridy = 10;
				contentPane.add(lblIntitposy, gbc_lblIntitposy);

				txtInitposy = new JTextField();
				txtInitposy.setText(""+initposy);
				GridBagConstraints gbc_txtInitposy = new GridBagConstraints();
				gbc_txtInitposy.insets = new Insets(0, 0, 5, 5);
				gbc_txtInitposy.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInitposy.gridx = 2;
				gbc_txtInitposy.gridy = 10;
				contentPane.add(txtInitposy, gbc_txtInitposy);
				txtInitposy.setColumns(10);

				lblInitv = new JLabel("init_V=");
				GridBagConstraints gbc_lblInitv = new GridBagConstraints();
				gbc_lblInitv.anchor = GridBagConstraints.EAST;
				gbc_lblInitv.insets = new Insets(0, 0, 5, 5);
				gbc_lblInitv.gridx = 1;
				gbc_lblInitv.gridy = 11;
				contentPane.add(lblInitv, gbc_lblInitv);

				txtInitV = new JTextField();
				txtInitV.setText(""+initV);
				GridBagConstraints gbc_txtInitV = new GridBagConstraints();
				gbc_txtInitV.insets = new Insets(0, 0, 5, 5);
				gbc_txtInitV.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInitV.gridx = 2;
				gbc_txtInitV.gridy = 11;
				contentPane.add(txtInitV, gbc_txtInitV);
				txtInitV.setColumns(10);

				txtStepinitv = new JTextField();
				txtStepinitv.setText(Integer.toString(STEP_initV));
				GridBagConstraints gbc_txtStepinitv = new GridBagConstraints();
				gbc_txtStepinitv.insets = new Insets(0, 0, 5, 5);
				gbc_txtStepinitv.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtStepinitv.gridx = 3;
				gbc_txtStepinitv.gridy = 11;
				contentPane.add(txtStepinitv, gbc_txtStepinitv);
				txtStepinitv.setColumns(10);

				txtLimitinitv = new JTextField();
				txtLimitinitv.setText(Integer.toString(LIMIT_initV));
				GridBagConstraints gbc_txtLimitinitv = new GridBagConstraints();
				gbc_txtLimitinitv.insets = new Insets(0, 0, 5, 5);
				gbc_txtLimitinitv.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLimitinitv.gridx = 4;
				gbc_txtLimitinitv.gridy = 11;
				contentPane.add(txtLimitinitv, gbc_txtLimitinitv);
				txtLimitinitv.setColumns(10);

				lblInita = new JLabel("init_A=");
				GridBagConstraints gbc_lblInita = new GridBagConstraints();
				gbc_lblInita.anchor = GridBagConstraints.EAST;
				gbc_lblInita.insets = new Insets(0, 0, 5, 5);
				gbc_lblInita.gridx = 1;
				gbc_lblInita.gridy = 12;
				contentPane.add(lblInita, gbc_lblInita);

				txtInitA = new JTextField();
				txtInitA.setText(""+initA);
				GridBagConstraints gbc_txtInitA = new GridBagConstraints();
				gbc_txtInitA.insets = new Insets(0, 0, 5, 5);
				gbc_txtInitA.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInitA.gridx = 2;
				gbc_txtInitA.gridy = 12;
				contentPane.add(txtInitA, gbc_txtInitA);
				txtInitA.setColumns(10);

				txtStepinita = new JTextField();
				txtStepinita.setText(Integer.toString(STEP_initA));
				GridBagConstraints gbc_txtStepinita = new GridBagConstraints();
				gbc_txtStepinita.insets = new Insets(0, 0, 5, 5);
				gbc_txtStepinita.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtStepinita.gridx = 3;
				gbc_txtStepinita.gridy = 12;
				contentPane.add(txtStepinita, gbc_txtStepinita);
				txtStepinita.setColumns(10);

				txtLimitinita = new JTextField();
				txtLimitinita.setText(Integer.toString(LIMIT_initA));
				GridBagConstraints gbc_txtLimitinita = new GridBagConstraints();
				gbc_txtLimitinita.insets = new Insets(0, 0, 5, 5);
				gbc_txtLimitinita.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLimitinita.gridx = 4;
				gbc_txtLimitinita.gridy = 12;
				contentPane.add(txtLimitinita, gbc_txtLimitinita);
				txtLimitinita.setColumns(10);

				lblNavigationpoints = new JLabel("navigation_points=");
				GridBagConstraints gbc_lblNavigationpoints = new GridBagConstraints();
				gbc_lblNavigationpoints.anchor = GridBagConstraints.EAST;
				gbc_lblNavigationpoints.insets = new Insets(0, 0, 5, 5);
				gbc_lblNavigationpoints.gridx = 1;
				gbc_lblNavigationpoints.gridy = 13;
				contentPane.add(lblNavigationpoints, gbc_lblNavigationpoints);

				txtNavigationpoints = new JTextField();
				txtNavigationpoints.setText(""+navigationpoints);
				GridBagConstraints gbc_txtNavigationpoints = new GridBagConstraints();
				gbc_txtNavigationpoints.insets = new Insets(0, 0, 5, 5);
				gbc_txtNavigationpoints.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNavigationpoints.gridx = 2;
				gbc_txtNavigationpoints.gridy = 13;
				contentPane.add(txtNavigationpoints, gbc_txtNavigationpoints);
				txtNavigationpoints.setColumns(10);

				lblNavigationlist = new JLabel("navigation_list=");
				GridBagConstraints gbc_lblNavigationlist = new GridBagConstraints();
				gbc_lblNavigationlist.anchor = GridBagConstraints.EAST;
				gbc_lblNavigationlist.insets = new Insets(0, 0, 5, 5);
				gbc_lblNavigationlist.gridx = 1;
				gbc_lblNavigationlist.gridy = 14;
				contentPane.add(lblNavigationlist, gbc_lblNavigationlist);

				btnDefine = new JButton("Define");
				btnDefine.addActionListener(new Define_navigation(param, this));
				GridBagConstraints gbc_btnDefine = new GridBagConstraints();
				gbc_btnDefine.anchor = GridBagConstraints.WEST;
				gbc_btnDefine.insets = new Insets(0, 0, 5, 5);
				gbc_btnDefine.gridx = 2;
				gbc_btnDefine.gridy = 14;
				contentPane.add(btnDefine, gbc_btnDefine);

				JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new Save_car(param,this));
				GridBagConstraints gbc_btnSave = new GridBagConstraints();
				gbc_btnSave.insets = new Insets(0, 0, 0, 5);
				gbc_btnSave.gridwidth = 5;
				gbc_btnSave.gridx = 0;
				gbc_btnSave.gridy = 15;
				contentPane.add(btnSave, gbc_btnSave);

				this.setVisible(true);

	}

	public void load(Car_set set){
		this.length_vehicle=set.getLength_vehicle();

		this.width_vehicle=set.getWidth_vehicle();

		this.vmax=set.getVmax();

		this.amin=set.getAmin();

		this.amax=set.getAmax();

		this.maxcom=set.getMaxcom();

		this.ctrfreq=set.getCtrfreq();

		this.mincom=set.getMincom();

		this.initposx=set.getInitposx();

		this.initV=set.getInitV();
		this.STEP_initV=set.getSTEP_initV();
		this.LIMIT_initV=set.getLIMIT_initV();

		this.initA=set.getInitA();
		this.STEP_initA=set.getSTEP_initA();
		this.LIMIT_initA=set.getLIMIT_initA();

		this.initposy=set.getInitposy();

		this.navigationpoints=set.getNavigationpoints();

		this.navigation_posX=set.getNavigation_posX();

		this.navigation_laneInf=set.getNavigation_laneInf();

		this.navigation_laneSup=set.getNavigation_laneSup();
	}

	public void loadDefault(){
		this.length_vehicle=500;

		this.width_vehicle=200;

		this.vmax=4000;

		this.amin=-500;

		this.amax=300;

		this.maxcom=11;

		this.ctrfreq=4;

		this.mincom=3;

		this.initposx=0;

		this.initV=0;
		this.STEP_initV=1;
		this.LIMIT_initV=0;

		this.initA=0;
		this.STEP_initA=1;
		this.LIMIT_initA=0;

		this.initposy=0;

		this.navigationpoints=1;

		this.navigation_posX=new ArrayList<Integer>();

		this.navigation_laneInf=new ArrayList<Integer>();

		this.navigation_laneSup=new ArrayList<Integer>();
	}

	public ArrayList<Integer> getNavigation_posX() {
		return navigation_posX;
	}

	public void setNavigation_posX(ArrayList<Integer> navigation_posX) {
		this.navigation_posX = navigation_posX;
	}

	public ArrayList<Integer> getNavigation_laneInf() {
		return navigation_laneInf;
	}

	public void setNavigation_laneInf(ArrayList<Integer> navigation_laneInf) {
		this.navigation_laneInf = navigation_laneInf;
	}

	public ArrayList<Integer> getNavigation_LaneSup() {
		return navigation_laneSup;
	}

	public void setNavigation_LaneSup(ArrayList<Integer> navigation_laneSup) {
		this.navigation_laneSup = navigation_laneSup;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public int getIndex() {
		return index;
	}

	public int getLength_vehicle() {
		this.length_vehicle=Integer.parseInt(this.txtLengthvehicle.getText());
		return length_vehicle;
	}

	public int getWidth_vehicle() {
		this.width_vehicle=Integer.parseInt(this.txtWidthvehicle.getText());
		return width_vehicle;
	}

	public int getVmax() {
		this.vmax=Integer.parseInt(this.txtVmax.getText());
		return vmax;
	}

	public int getAmin() {
		this.amin=Integer.parseInt(this.txtAmin.getText());
		return amin;
	}

	public int getAmax() {
		this.amax=Integer.parseInt(this.txtAmax.getText());
		return amax;
	}

	public int getMaxcom() {
		this.maxcom=Integer.parseInt(this.txtMaxcom.getText());
		return maxcom;
	}

	public int getCtrfreq() {
		this.ctrfreq=Integer.parseInt(this.txtCtrfreq.getText());
		return ctrfreq;
	}

	public int getMincom() {
		this.mincom=Integer.parseInt(this.txtMincom.getText());
		return mincom;
	}

	public int getInitposx() {
		this.initposx=Integer.parseInt(this.txtInitposx.getText());
		return initposx;
	}

	public int getInitposy() {
		this.initposy=Integer.parseInt(this.getTxtInitposy().getText());
		return initposy;
	}

	public int getInitV() {
		this.initV=Integer.parseInt(this.getTxtInitV().getText());
		return initV;
	}

	public int getSTEP_initV() {
		this.STEP_initV=Integer.parseInt(this.txtStepinitv.getText());
		if(STEP_initV<1){
			if(Integer.parseInt(this.txtLimitinitv.getText())<0){
				return 1;
			}
			return Math.abs(Integer.parseInt(this.getTxtInitV().getText()))+Math.abs(Integer.parseInt(this.txtLimitinitv.getText()));
		}
		return STEP_initV;
	}

	public int getLIMIT_initV() {
		this.LIMIT_initV=Integer.parseInt(this.txtLimitinitv.getText());
		if(LIMIT_initV<Integer.parseInt(this.getTxtInitV().getText())){
			return Integer.parseInt(this.getTxtInitV().getText());
		}
		return LIMIT_initV;
	}

	public int getInitA() {
		this.initA=Integer.parseInt(this.getTxtInitA().getText());
		return initA;
	}

	public int getSTEP_initA() {
		this.STEP_initA=Integer.parseInt(this.txtStepinita.getText());
		if(STEP_initA<1){
			if(Integer.parseInt(this.txtLimitinita.getText())<0){
				return 1;
			}
			return Math.abs(Integer.parseInt(this.txtLimitinita.getText())+Math.abs(Integer.parseInt(this.getTxtInitA().getText())));
		}
		return STEP_initA;
	}

	public int getLIMIT_initA() {
		this.LIMIT_initA=Integer.parseInt(this.txtLimitinita.getText());
		if(LIMIT_initA<1){
			return initA;
		}
		return LIMIT_initA;
	}

	public int getNavigationpoints() {
		this.navigationpoints=Integer.parseInt(this.getTxtNavigationpoints().getText());
		return navigationpoints;
	}

	public Param getParam() {
		return param;
	}

	public JTextField getTxtLengthvehicle() {
		return txtLengthvehicle;
	}

	public void setTxtLengthvehicle(JTextField txtLengthvehicle) {
		this.txtLengthvehicle = txtLengthvehicle;
	}

	public JTextField getTxtWidthvehicle() {
		return txtWidthvehicle;
	}

	public void setTxtWidthvehicle(JTextField txtWidthvehicle) {
		this.txtWidthvehicle = txtWidthvehicle;
	}

	public JTextField getTxtVmax() {
		return txtVmax;
	}

	public void setTxtVmax(JTextField txtVmax) {
		this.txtVmax = txtVmax;
	}

	public JTextField getTxtAmin() {
		return txtAmin;
	}

	public void setTxtAmin(JTextField txtAmin) {
		this.txtAmin = txtAmin;
	}

	public JTextField getTxtAmax() {
		return txtAmax;
	}

	public void setTxtAmax(JTextField txtAmax) {
		this.txtAmax = txtAmax;
	}

	public JTextField getTxtMaxcom() {
		return txtMaxcom;
	}

	public void setTxtMaxcom(JTextField txtMaxcom) {
		this.txtMaxcom = txtMaxcom;
	}

	public JTextField getTxtCtrfreq() {
		return txtCtrfreq;
	}

	public void setTxtCtrfreq(JTextField txtCtrfreq) {
		this.txtCtrfreq = txtCtrfreq;
	}

	public JTextField getTxtMincom() {
		return txtMincom;
	}

	public void setTxtMincom(JTextField txtMincom) {
		this.txtMincom = txtMincom;
	}

	public JTextField getTxtInitposx() {
		return txtInitposx;
	}

	public void setTxtInitposx(JTextField txtInitposx) {
		this.txtInitposx = txtInitposx;
	}

	public JTextField getTxtInitV() {
		return txtInitV;
	}

	public void setTxtInitV(JTextField txtInitV) {
		this.txtInitV = txtInitV;
	}

	public JTextField getTxtInitA() {
		return txtInitA;
	}

	public void setTxtInitA(JTextField txtInitA) {
		this.txtInitA = txtInitA;
	}

	public JTextField getTxtInitposy() {
		return txtInitposy;
	}

	public void setTxtInitposy(JTextField txtInitposy) {
		this.txtInitposy = txtInitposy;
	}

	public JTextField getTxtNavigationpoints() {
		return txtNavigationpoints;
	}

	public void setTxtNavigationpoints(JTextField txtNavigationpoints) {
		this.txtNavigationpoints = txtNavigationpoints;
	}

	public JTextField getTxtStepinitv() {
		return txtStepinitv;
	}

	public void setTxtStepinitv(JTextField txtStepinitv) {
		this.txtStepinitv = txtStepinitv;
	}

	public JTextField getTxtStepinita() {
		return txtStepinita;
	}

	public void setTxtStepinita(JTextField txtStepinita) {
		this.txtStepinita = txtStepinita;
	}

	public JTextField getTxtLimitinita() {
		return txtLimitinita;
	}

	public void setTxtLimitinita(JTextField txtLimitinita) {
		this.txtLimitinita = txtLimitinita;
	}

	public JTextField getTxtLimitinitv() {
		return txtLimitinitv;
	}

	public void setTxtLimitinitv(JTextField txtLimitinitv) {
		this.txtLimitinitv = txtLimitinitv;
	}
}
