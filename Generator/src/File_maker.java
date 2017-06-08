import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class File_maker {
	public static void main(String[] args){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("resources/VerifCar.xml")));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("new_VerifCar.xml")));

			String parameters_zone="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
					+ "<!DOCTYPE nta PUBLIC \'-//Uppaal Team//DTD Flat System 1.1//EN\' \'http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd\'>\n"
					+ "<nta>\n"
					+ "<declaration>// Scale\n"
					+ "const int scale = "+args[0]+";\n"
					+"\n"
					+ "// System parameters (define size of the data structure)\n"
					+ "const int S := "+args[1]+";	// sample period, in 1/scale seconds\n"
					+ "const int L := "+args[2]+";	// length of the road segment, in 1/scale meters\n"
					+ "const int R := "+args[3]+";	// width of the road segment, in 1/scale meters\n"
					+ "const int V_min := "+args[4]+";	// min value of longitudinal speed, in 1/scale meters per second\n"
					+ "const int V_max := "+args[5]+";	// max value of longitudinal speed, in 1/scale meters per second\n"
					+ "const int A_min := "+args[6]+";	// min value of longitudinal acceleration, in 1/scale meters per second squared\n"
					+ "const int A_max := "+args[7]+";	// max value of longitudinal acceleration, in 1/scale meters per second squared\n"
					+ "const int GranA := "+args[8]+";	// granularity of the acceleration expressed in 1/scale meters per second squared\n"
					+ "const int W := "+args[9]+";	// maximal absolute value of the lateral speed expressed in 1/scale meters per second\n"
					+ "const int NormX := "+args[10]+";	// maximal loss of precision during a second in 1/scale meters (&gt;= (GranA*S/scale)/2)\n"
					+"\n"
					+ "// Environment constraints\n"
					+ "const int length_vehicle := "+args[11]+";    // length of a vehicle in 1/scale meters\n" //BESOIN MISE A JOUR
					+ "const int width_vehicle := "+args[12]+";    // width of a vehicle in 1/scale meters\n"	//IDEM
					+ "const int begin_junction := "+args[13]+";	// begining of junction lane in 1/scale meters\n"
					+ "const int end_junction := "+args[14]+";	// end of junction lane in 1/scale meters\n"
					+ "const int nb_lane := "+args[15]+";	// number of lanes, including junction (&gt;= 2)\n"
					+"const int marking[nb_lane+1] := {0,";
			int nb_lane=Integer.parseInt(args[15]);
			int argNum=16;
					for(int i=0;i<nb_lane-1;i++){
						parameters_zone+="("+args[argNum]+"*scale)/(W*S),";
						argNum++;
					}
					parameters_zone+="(R*scale)/(W*S)};	// lateral position of markings separating lanes (junction is lane 0)\n"
					+"\n"
					+ "const int nb_car := "+args[argNum]+";	// number of vehicles (&gt;= 2)\n";
			int nb_car=Integer.parseInt(args[argNum]);
					argNum++;

					parameters_zone+="const int ctr_freq[nb_car] := {"+args[argNum];
					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="};	// activation sample of the controler for each vehicle in 1/scale second, must be greater than S\n"
					+ "const int min_com_delay[nb_car] := {"+args[argNum];
					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="}; // min communication delay for each vehicle in 1/scale second, must be smaller than the vehicle's controller sample\n"
					+ "const int max_com_delay[nb_car] := {"+args[argNum];
					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="};	// max communication delay for each vehicle in 1/scale second, must be smaller than the vehicle's controller sample\n"
					+ "const int init_posX[nb_car] := {"+args[argNum];
					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="};	// initial longitudinal position for each vehicle in 1/scale meters\n"
					+ "const int init_posY[nb_car] := {"+args[argNum];

					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="};	// initial lateral position for each vehicle in 1/scale meters\n"
					+ "const int init_V[nb_car] := {"+args[argNum];
					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="};	// initial longitudinal speed for each vehicle in 1/scale meters per second\n"
					+ "const int init_A[nb_car] := {"+args[argNum];
					argNum++;
					for(int i=1;i<nb_car;i++){
						parameters_zone+=","+args[argNum];
						argNum++;
					}
					parameters_zone+="};	// initial longitudinal acceleration for each vehicle in 1/scale meters per second squared\n"
					+ "\n"
					+ "// Control related information\n"
					+ "const int navigation_points := "+args[argNum]+";	// number of coordinate on a navigation list\n";	//MISE A JOUR ????
			int nb_nav=Integer.parseInt(args[argNum]);
					argNum++;
					parameters_zone+= "const int navigation_list[nb_car][navigation_points][3] := {\n"
					+"{{("+args[argNum]+"*scale)/(NormX*S),"+args[argNum+1]+","+args[argNum+2]+"}";
					argNum+=3;

					for(int i=1;i<nb_nav;i++){
						parameters_zone+=",{("+args[argNum]+"*scale)/(NormX*S),"+args[argNum+1]+","+args[argNum+2]+"}";
						argNum+=3;
					}
					parameters_zone+="}\n";
					for(int car=1;car<nb_car;car++){
						parameters_zone+=",{{("+args[argNum]+"*scale)/(NormX*S),"+args[argNum+1]+","+args[argNum+2]+"}";
						argNum+=3;
						for(int i=1;i<nb_nav;i++){
							parameters_zone+=",{("+args[argNum]+"*scale)/(NormX*S),"+args[argNum+1]+","+args[argNum+2]+"}";
							argNum+=3;
						}
						parameters_zone+= "}\n";
					}
					parameters_zone+= "};	// GPS trajectory for each vehicle in list of {posX,lane(min),lane(max)}, each car MUST have a complete trajectory that goes up to horizon value\n"
					+ "const int safety_length := "+args[argNum]+";	// longitudinal safety distance of a vehicle in 1/scale meters\n"
					+ "const int safety_width := "+args[argNum+1]+";	// lateral safety distance of a vehicle in 1/scale meters\n"
					+ "const int traj_length := "+args[argNum+2]+";	// length of the predicted trajectory in 1/scale seconds\n"
					+ "const int delay_step := "+args[argNum+3]+";	// delay step in 1/scale seconds\n"
					+ "const int max_delay := "+args[argNum+4]+";	// maximum delay in 1/scale seconds\n"
					+"\n"
					+ "//////////////////////////////////////////////////////////////////////Parameters end zone\n";
			argNum+=5;
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
			for(int i=2;i<nb_car;i++){
				system_zone+="Ctr"+i+" = Controller("+i+");\n";
			}
			system_zone+="system Env, Ctr0, Ctr1";

			for(int i=2;i<nb_car;i++){
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

			System.out.println("new_VerifCar.xml uploaded");
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
