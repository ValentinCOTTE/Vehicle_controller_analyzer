package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Interface.Param;

public class Script_generator {
	Param_set param;
	public Script_generator(Param_set param){
		this.param=param;
		try {
			File file =new File("tmp_script.sh");
			file.setExecutable(true);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			String SCRIPT=this.writeCycle();

			writer.write(SCRIPT);


			writer.close();
			Runtime.getRuntime().exec("chmod 777 tmp_script.sh");


			System.out.println("tmp_script crée");
		}
		catch (IOException e){
			System.out.println("error: can't create tmp_script.sh");
			e.printStackTrace();
		}

		String[] cmd = { "/bin/sh", "tmp_script.sh" };
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.getOutputStream().close();
            p.getInputStream().close();
	      } catch (IOException e) {
	          System.out.println("error: can't execute tmp_script.sh");
	    	  e.printStackTrace();
	        }

	}

	public String writeCycle(){
		String line="#!/bin/sh\n"
				+ "java -jar Generator.jar "+param.getScale()
				+" "+param.getS()
				+" "+param.getL()
				+" "+param.getR()
				+" "+param.getV_min()
				+" "+param.getV_max()
				+" "+param.getA_min()
				+" "+param.getA_max()
				+" "+param.getGranA()
				+" "+param.getW()
				+" "+param.getNormX()
				+" "+param.getCar_list().get(0).getLength_vehicle()
				+" "+param.getCar_list().get(0).getWidth_vehicle()
				+" "+param.getBegin_junction()
				+" "+param.getEnd_junction()
				+" "+param.getNb_lane();

				for(int i=0;i<param.getMarking().size();i++){
					line+=" "+param.getMarking().get(i);
				}

				line+=" "+param.getNb_car()
						+" "+param.getCar_list().get(0).getCtrfreq();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getCtrfreq();
				}
				line+=" "+param.getCar_list().get(0).getMincom();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getMincom();
				}
				line+=" "+param.getCar_list().get(0).getMaxcom();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getMaxcom();
				}
				line+=" "+param.getCar_list().get(0).getInitposx();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getInitposx();
				}
				line+=" "+param.getCar_list().get(0).getInitposy();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getInitposy();
				}
				line+=" "+param.getCar_list().get(0).getInitV();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getInitV();
				}
				line+=" "+param.getCar_list().get(0).getInitA();

				for(int i=1;i<param.getCar_list().size();i++){
					line+=" "+param.getCar_list().get(i).getInitA();
				}
				line+=" "+param.getNavigation_points_max()
				+" "+param.getCar_list().get(0).getNavigation_posX().get(0)
				+" "+param.getCar_list().get(0).getNavigation_laneInf().get(0)
				+" "+param.getCar_list().get(0).getNavigation_laneSup().get(0);

				for(int i=1;i<param.getCar_list().get(0).getNavigation_posX().size();i++){
					line+=" "+param.getCar_list().get(0).getNavigation_posX().get(i)
							+" "+param.getCar_list().get(0).getNavigation_laneInf().get(i)
							+" "+param.getCar_list().get(0).getNavigation_laneSup().get(i);
				}
						;
				for(int car=1;car<param.getCar_list().size();car++){
					line+=" "+param.getCar_list().get(car).getNavigation_posX().get(0)
							+" "+param.getCar_list().get(car).getNavigation_laneInf().get(0)
							+" "+param.getCar_list().get(car).getNavigation_laneSup().get(0);
					for(int i=1;i<param.getCar_list().get(0).getNavigation_posX().size();i++){
						line+=" "+param.getCar_list().get(car).getNavigation_posX().get(i)
								+" "+param.getCar_list().get(car).getNavigation_laneInf().get(i)
								+" "+param.getCar_list().get(car).getNavigation_laneSup().get(i);
					}
				}
				line+=" "+param.getSafety_length()
				+" "+param.getSafety_width()
				+" "+param.getTraj_length()
				+" "+param.getDelay_step()
				+" "+param.getMax_delay()
				+"\n";
				line+="echo Formal verification with queries.q ...\n"
				+"./verifyta -q -s new_VerifCar.xml resources/queries.q > Tests.txt\n"
				+"echo File Tests.txt done\n"
				+"exit 0\n";
				return line;
	}
}
