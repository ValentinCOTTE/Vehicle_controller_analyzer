package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import Interface.Car;
import Interface.Param;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Application extends JFrame {

	 Param fenetre;


	 
	public Application() {
		this.setResizable(false);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//default settings
		String scale="100";
		String S="10";
		String L="50000";
		String R="1050";
		String V_min="1000";
		String GranA="100";
		String W="100";
		String NormX="100"; //( >= (GranA*S/scale)/2 )
		String nb_lane="3"; //( >= 2 )
		String end_junction="40000"; //( <= L )
		String begin_junction="20000"; //( <= end_junction )
		ArrayList<String> marking=new ArrayList<String>(); //[nb_lane + 1] ( marking[i] <= marking[i-1] ) to build as a list {posY, ... , posY}
		marking.add("350");
		marking.add("750");
		String nb_car="2"; //( >= 2 )
		String safety_length="200";
		String safety_width="50";
		String traj_length="1000";
		String delay_step="100";
		String max_delay="500"; //(integer multiple of delay_step)
		ArrayList<Car_set> Car_list=new ArrayList<Car_set>();
			ArrayList<String> posx1=new ArrayList<String>();
			posx1.add("0");
			posx1.add("50000");
			ArrayList<String> inf1=new ArrayList<String>();
			inf1.add("1");
			inf1.add("1");
			ArrayList<String> sup1=new ArrayList<String>();
			sup1.add("1");
			sup1.add("1");
		Car_list.add(new Car_set("500", "200", "4000", "-500", "300", "11", "4", "3", "5000", "525", "2000", "0", "2", posx1, inf1, sup1));
			ArrayList<String> posx2=new ArrayList<String>();
			posx2.add("0");
			posx2.add("50000");
			ArrayList<String> inf2=new ArrayList<String>();
			inf2.add("1");
			inf2.add("1");
			ArrayList<String> sup2=new ArrayList<String>();
			sup2.add("1");
			sup2.add("1");
		Car_list.add(new Car_set("500", "200", "4000", "-500", "300", "11", "4", "3", "0", "525", "3000", "0", "2", posx2, inf2, sup2));		
		
		String navigation_points_max="2";
		String V_max="4000";
		String A_min="-500";
//end default settings
		
		Param_set defaultSet=new Param_set(scale, S, L, R, V_min, GranA, W, NormX, nb_lane, end_junction, begin_junction, marking, nb_car, safety_length, safety_width, traj_length, delay_step, max_delay, Car_list, navigation_points_max, V_max, A_min);
		
		fenetre = new Param(this,defaultSet);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 630);
		setContentPane(fenetre);
	}

	
	
}
