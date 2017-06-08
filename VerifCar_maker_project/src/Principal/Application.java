package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Interface.Car;
import Interface.Param;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Application extends JFrame {

	 Param fenetre;



	public Application() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//default settings
		int scale=100;
		int S=10;
		int L=50000;
		int R=1050;
		int V_min=1000;
		int GranA=100;
		int W=100;
		int NormX=100; //( >= (GranA*S/scale)/2 )
		int nb_lane=3; //( >= 2 )
		int end_junction=40000; //( <= L )
		int begin_junction=20000; //( <= end_junction )
		ArrayList<Integer> marking=new ArrayList<Integer>(); //[nb_lane + 1] ( marking[i] <= marking[i-1] ) to build as a list {posY, ... , posY}
		marking.add(350);
		marking.add(750);
		int nb_car=2; //( >= 2 )
		int safety_length=200;
		int safety_width=50;
		int traj_length=1000;
		int delay_step=100;
		int max_delay=500; //(integer multiple of delay_step)
		ArrayList<Car_set> Car_list=new ArrayList<Car_set>();
			ArrayList<Integer> posx1=new ArrayList<Integer>();
			posx1.add(0);
			posx1.add(50000);
			ArrayList<Integer> inf1=new ArrayList<Integer>();
			inf1.add(1);
			inf1.add(1);
			ArrayList<Integer> sup1=new ArrayList<Integer>();
			sup1.add(1);
			sup1.add(1);
		Car_list.add(new Car_set(500, 200, 4000, -500, 300, 11, 4, 3, 5000, 525, 2000, 1, 2000, 0, 1, 0, 2, posx1, inf1, sup1));
			ArrayList<Integer> posx2=new ArrayList<Integer>();
			posx2.add(0);
			posx2.add(50000);
			ArrayList<Integer> inf2=new ArrayList<Integer>();
			inf2.add(1);
			inf2.add(1);
			ArrayList<Integer> sup2=new ArrayList<Integer>();
			sup2.add(1);
			sup2.add(1);
		Car_list.add(new Car_set(500, 200, 4000, -500, 300, 11, 4, 3, 0, 525, 3000, 1, 3000, 0, 1, 0, 2, posx2, inf2, sup2));

		int navigation_points_max=2;
		int V_max=4000;
		int A_min=-500;
		int A_max=300;
//end default settings
		Param_set moreRecent=findSet();

		Param_set defaultSet=new Param_set(scale, S, L, R, V_min, GranA, W, NormX, nb_lane, end_junction, begin_junction, marking, nb_car, safety_length, safety_width, traj_length, delay_step, max_delay, Car_list, navigation_points_max, V_max, A_min, A_max);
		if (moreRecent==null){
			fenetre = new Param(this,defaultSet);

		}
		else{
			fenetre = new Param(this,moreRecent);
		}
		setBounds(100, 100, 450, 630);
		setContentPane(fenetre);
	}

	public Param_set findSet() {
		String directoryPath="resources/saves/";
		File directory = new File(directoryPath);
		File moreRecentFile = null;
		if (!directory.exists()) {
			System.out.println("The file/directory '" + directoryPath + "' dosn't exist");
		} else if (!directory.isDirectory()) {
			System.out.println("The path '" + directoryPath + "' is actually a file");
		} else if(directory.listFiles().length>0){
			File[] subfiles = directory.listFiles();
			String message = "The directory '" + directoryPath + "' contains " + subfiles.length + " file"
					+ (subfiles.length > 1 ? "s" : "");
			System.out.println(message);
			moreRecentFile =subfiles[0];
			for (int i = 0; i < subfiles.length; i++) {
				File subfile = subfiles[i];
				System.out.println(subfile.getName());
				if (moreRecentFile != null && subfile.lastModified()>moreRecentFile.lastModified()) {
					moreRecentFile = subfile;
				}
			}
			System.out.println("The file the most recent is "+moreRecentFile.getName());

			ObjectInputStream ois = null;


			try {
				final FileInputStream fichier = new FileInputStream(moreRecentFile);
				ois = new ObjectInputStream(fichier);
				final Param_set set = (Param_set) ois.readObject();
				return set;

			} catch (final IOException e) {
				System.out.println("ERROR: IOException when open the file");
			} catch (final ClassNotFoundException e) {
				System.out.println("ERROR: ClassNotFoundException");
			} finally {
				try {
					if (ois != null) {
					ois.close();
					}
				} catch (final IOException ex) {
					System.out.println("ERROR: IOException when close the file");
				}
			}
		}
		System.out.println("No saves available (default parameters)");
		return null;
	}

}
