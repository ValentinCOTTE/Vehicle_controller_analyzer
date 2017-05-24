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
					save+="Car"+(i+1)+":\n"
							+"length_vehicle="+param.getCar_list().get(i).getLength_vehicle()+"\n"
							+"width_vehicle="+param.getCar_list().get(i).getWidth_vehicle()+"\n"
							+"v_max="+param.getCar_list().get(i).getVmax()+"\n"
							+"a_min="+param.getCar_list().get(i).getAmin()+"\n"
							+"a_max="+param.getCar_list().get(i).getAmax()+"\n"
							+"ctr_freq"+param.getCar_list().get(i).getCtrfreq()+"\n"
							+"max_com="+param.getCar_list().get(i).getMaxcom()+"\n"
							+"min_com="+param.getCar_list().get(i).getMincom()+"\n"
							+"init_posX="+param.getCar_list().get(i).getInitposx()+"\n"
							+"init_posY="+param.getCar_list().get(i).getInitposy()+"\n"
							+"init_V"+param.getCar_list().get(i).getInitV()+"\n"
							+"init_A"+param.getCar_list().get(i).getInitA()+"\n"
							+"navigation_points"+param.getCar_list().get(i).getNavigationpoints()+"\n"
							+"navigation_list:\n";
							for(int y=0;y<param.getCar_list().get(i).getNavigation_posX().size();y++){
								save+="posX="+param.getCar_list().get(i).getNavigation_posX()+"\n"
										+"lane_inf="+param.getCar_list().get(i).getNavigation_laneInf()+"\n"
										+"lane_sup="+param.getCar_list().get(i).getNavigation_laneSup()+"\n";
							}
							 
					save+="\n";
				}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
