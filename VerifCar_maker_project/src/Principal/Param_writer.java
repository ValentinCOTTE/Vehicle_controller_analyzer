package Principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Interface.Param;

public class Param_writer {
	Param_writer(Param param,String name){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("parameters")));
			
			String save="Slot:"+name+"\n"
					+ "scale="+param.getScale()+"\n"
					+"S="+param.getS()+"\n"
					+"L="+param.getL()+"\n"
					+"R="+param.getR()+"\n"
					+"V_min="+param.getV_min()+"\n"
					+"GranA="+param.getGranA()+"\n"
					+"W="+param.getW()+"\n"
					+"NormX="+param.getNormX()+"\n"
					+"nb_lane="+param.getNb_lane()+"\n"
					+"end_junction="+param.getEnd_junction()+"\n"
					+"begin_junction="+param.getBegin_junction()+"\n";
			for(int i=0;i<param.getMarking().size();i++){
				save+="marking["+i+"]="+param.getMarking().get(i)+"\n";
			}
			
			save+="nb_car="+param.getNb_car()+"\n"
				+"safety_length="+param.getSafety_length()+"\n"
				+"safety_width="+param.getWidth()+"\n"
				+"traj_length="+param.getTraj_length()+"\n"
					+"delay_step="+param.getDelay_step()+"\n"
				+"max_delay="+param.getMax_delay()+"\n"
				+"\n"
				+"\n"
				+"List of vehicle param (one by vehicle) :\n"
				+"\n";
				for(int i=0;i<param.getCar_list().size();i++){
					save+="length_vehicle"+param.getCar_list().get(i).getLength_vehicle()+"\n"
					+"width_vehicle\n"
					+"v_max ( >= V_min )\n"
					+"a_min ( can be negative )\n"
					+"a_max ( >= a_min )\n"
					+"ctr_freq ( > S )\n"
					+"max_com ( < ctr_freq )\n"
					+"min_com ( < max_com )\n"
					+"init_posX ( <= L )\n"
					+"init_posY ( <= R )\n"
					+"init_V ( >= V_min && <= v_max )\n"
					+"init_A ( >= a_min && <= a_max )\n"
					+"navigation_points ( >= 1 )\n"
					+"navigation_list[navigation_points][3] to build as a list of list {{0,lane(inf),lane(sup)},{(posX*scale)/(NormX*S),lane(inf),lane(sup)}, ... , {(L*scale)/(NormX*S),lane(inf),lane(sup)}}\n" 
					+"\n";
				}
				
			save+="Constants to calculate :"
				+""
				+"V_max ( max v_max from vehicle param )"
				+"A_min ( min a_min from vehicle param )"
				+"A_max ( max a_max from vehicle param )";
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
