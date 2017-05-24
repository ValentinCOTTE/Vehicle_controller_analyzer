package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Interface.Param;

public class File_maker {
	Param param;
	public File_maker(Param param){
		this.param=param;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("resources/VerifCar.xml")));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("new_VerifCar.xml")));
			
			String parameters_zone="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
					+ "<!DOCTYPE nta PUBLIC \'-//Uppaal Team//DTD Flat System 1.1//EN\' \'http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd\'>\n"
					+ "<nta>\n"
					+ "<declaration>// Scale\n"
					+ "const int scale = "+param.getScale()+";\n"
					+"\n"
					+ "// System parameters (define size of the data structure)\n"
					+ "const int S := "+param.getS()+";	// sample period, in 1/scale seconds\n"
					+ "const int L := "+param.getL()+";	// length of the road segment, in 1/scale meters\n"
					+ "const int R := "+param.getR()+";	// width of the road segment, in 1/scale meters\n"
					+ "const int V_min := "+param.getV_min()+";	// min value of longitudinal speed, in 1/scale meters per second\n"
					+ "const int V_max := "+param.getV_max()+";	// max value of longitudinal speed, in 1/scale meters per second\n"
					+ "const int A_min := "+param.getA_min()+";	// min value of longitudinal acceleration, in 1/scale meters per second squared\n"
					+ "const int A_max := "+param.getA_max()+";	// max value of longitudinal acceleration, in 1/scale meters per second squared\n"
					+ "const int GranA := "+param.getGranA()+";	// granularity of the acceleration expressed in 1/scale meters per second squared\n"
					+ "const int W := "+param.getW()+";	// maximal absolute value of the lateral speed expressed in 1/scale meters per second\n"
					+ "const int NormX := "+param.getNormX()+";	// maximal loss of precision during a second in 1/scale meters (&gt;= (GranA*S/scale)/2)\n"
					+"\n"
					+ "// Environment constraints\n"
					+ "const int length_vehicle := "+param.getCar_list().get(0).getLength_vehicle()+";    // length of a vehicle in 1/scale meters\n" //BESOIN MISE A JOUR
					+ "const int width_vehicle := "+param.getCar_list().get(0).getWidth_vehicle()+";    // width of a vehicle in 1/scale meters\n"	//IDEM
					+ "const int begin_junction := "+param.getBegin_junction()+";	// begining of junction lane in 1/scale meters\n"
					+ "const int end_junction := "+param.getEnd_junction()+";	// end of junction lane in 1/scale meters\n"
					+ "const int nb_lane := "+param.getNb_lane()+";	// number of lanes, including junction (&gt;= 2)\n"
					+"const int marking[nb_lane+1] := {0,";
					for(int i=0;i<param.getMarking().size();i++){
						parameters_zone+="("+param.getMarking().get(i)+"*scale)/(W*S),";
					}
					parameters_zone+="(R*scale)/(W*S)};	// lateral position of markings separating lanes (junction is lane 0)\n"
					+"\n"
					+ "const int nb_car := "+param.getNb_car()+";	// number of vehicles (&gt;= 2)\n"
					+ "const int ctr_freq[nb_car] := {"+param.getCar_list().get(0).getCtrfreq();   
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getCtrfreq();
					}
					parameters_zone+="};	// activation sample of the controler for each vehicle in 1/scale second, must be greater than S\n"
					+ "const int min_com_delay[nb_car] := {"+param.getCar_list().get(0).getMincom();
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getMincom();
					}
					parameters_zone+="}; // min communication delay for each vehicle in 1/scale second, must be smaller than the vehicle's controller sample\n"
					+ "const int max_com_delay[nb_car] := {"+param.getCar_list().get(0).getMaxcom();
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getMaxcom();
					}
					parameters_zone+="};	// max communication delay for each vehicle in 1/scale second, must be smaller than the vehicle's controller sample\n"
					+ "const int init_posX[nb_car] := {"+param.getCar_list().get(0).getInitposx();
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getInitposx();
					}
					parameters_zone+="};	// initial longitudinal position for each vehicle in 1/scale meters\n"
					+ "const int init_posY[nb_car] := {"+param.getCar_list().get(0).getInitposy();
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getInitposy();
					}
					parameters_zone+="};	// initial lateral position for each vehicle in 1/scale meters\n"
					+ "const int init_V[nb_car] := {"+param.getCar_list().get(0).getInitV();
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getInitV();
					}
					parameters_zone+="};	// initial longitudinal speed for each vehicle in 1/scale meters per second\n"
					+ "const int init_A[nb_car] := {"+param.getCar_list().get(0).getInitA();
					for(int i=1;i<param.getCar_list().size();i++){
						parameters_zone+=","+param.getCar_list().get(i).getInitA();
					}
					parameters_zone+="};	// initial longitudinal acceleration for each vehicle in 1/scale meters per second squared\n"
					+ "\n"
					+ "// Control related information\n"
					+ "const int navigation_points := "+param.getNavigation_points_max()+";	// number of coordinate on a navigation list\n"	//MISE A JOUR ????
					+ "const int navigation_list[nb_car][navigation_points][3] := {\n"
					+"{{("+param.getCar_list().get(0).getNavigation_posX().get(0)+"*scale)/(NormX*S),"+param.getCar_list().get(0).getNavigation_laneInf().get(0)+","+param.getCar_list().get(0).getNavigation_laneSup().get(0)+"}";
					
					for(int i=1;i<param.getCar_list().get(0).getNavigation_posX().size();i++){
						parameters_zone+=",{("+param.getCar_list().get(0).getNavigation_posX().get(i)+"*scale)/(NormX*S),"+param.getCar_list().get(0).getNavigation_laneInf().get(i)+","+param.getCar_list().get(0).getNavigation_laneSup().get(i)+"}";
					}
					parameters_zone+="}\n";
					for(int car=1;car<param.getCar_list().size();car++){
						parameters_zone+=",{{("+param.getCar_list().get(car).getNavigation_posX().get(0)+"*scale)/(NormX*S),"+param.getCar_list().get(car).getNavigation_laneInf().get(0)+","+param.getCar_list().get(car).getNavigation_laneSup().get(0)+"}";
						for(int i=1;i<param.getCar_list().get(0).getNavigation_posX().size();i++){
							parameters_zone+=",{("+param.getCar_list().get(car).getNavigation_posX().get(i)+"*scale)/(NormX*S),"+param.getCar_list().get(car).getNavigation_laneInf().get(i)+","+param.getCar_list().get(car).getNavigation_laneSup().get(i)+"}";
						}
						parameters_zone+= "}\n";
					}
					parameters_zone+= "};	// GPS trajectory for each vehicle in list of {posX,lane(min),lane(max)}, each car MUST have a complete trajectory that goes up to horizon value\n"
					+ "const int safety_length := "+param.getSafety_length()+";	// longitudinal safety distance of a vehicle in 1/scale meters\n"
					+ "const int safety_width := "+param.getSafety_width()+";	// lateral safety distance of a vehicle in 1/scale meters\n"
					+ "const int traj_length := "+param.getTraj_length()+";	// length of the predicted trajectory in 1/scale seconds\n"
					+ "const int delay_step := "+param.getDelay_step()+";	// delay step in 1/scale seconds\n"
					+ "const int max_delay := "+param.getMax_delay()+";	// maximum delay in 1/scale seconds\n"
					+"\n"
					+ "//////////////////////////////////////////////////////////////////////Parameters end zone\n";
			
			writer.write(parameters_zone);
			
			//end_code
			String line;
			while(!reader.readLine().equals("//The code below this line can be modified (this line can not be modified)")){
				//keep reading
			}
			
			line=reader.readLine();
			while(!line.equals("//The code above this line can be modified (this line can not be modified)")){
				writer.write(line+"\n");
				line=reader.readLine();
			}
			
			String system_zone="Ctr0 = Controller(0);\n"
					+ "Ctr1 = Controller(1);// List one or more processes to be composed into a system.\n";
			for(int i=2;i<param.getCar_list().size();i++){
				system_zone+="Ctr"+i+" = Controller("+i+");\n";
			}
			system_zone+="system Env, Ctr0, Ctr1";
			
			for(int i=2;i<param.getCar_list().size();i++){
				system_zone+=", Ctr"+i;
			}
			system_zone+=";\n";
			
			writer.write(system_zone);
			
			while(!reader.readLine().equals("//The code below this line can be modified (this line can not be modified)")){
				//keep reading
			}

			while((line=reader.readLine())!=null){
				writer.write(line+"\n");
			}
			
			 
			writer.close();
			reader.close();
			
			System.out.println("new_VerifCar.xml crée");
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
