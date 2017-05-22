package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Error_message;
import Interface.Param;
import Principal.Application;
import Principal.File_maker;

public class Finish implements ActionListener{

	Application app;
	Param param;
	
	public Finish(Application app,Param param){
		this.app=app;
		this.param=param;
	}
	public void actionPerformed(ActionEvent arg0) {
		boolean evryThingIsOk=true;
		
//error zone
		try{
			Integer.parseInt(param.getScale());
		}
		catch(NumberFormatException e){
			new Error_message("scale must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getS());
		}
		catch(NumberFormatException e){
			new Error_message("S must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getL());
		}
		catch(NumberFormatException e){
			new Error_message("L must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getR());
		}
		catch(NumberFormatException e){
			new Error_message("R must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getV_min());
		}
		catch(NumberFormatException e){
			new Error_message("V_min must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getGranA());
		}
		catch(NumberFormatException e){
			new Error_message("GranA must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getW());
		}
		catch(NumberFormatException e){
			new Error_message("W must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getNormX());
		}
		catch(NumberFormatException e){
			new Error_message("NormX must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getNb_lane());
		}
		catch(NumberFormatException e){
			new Error_message("nb_lane must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getEnd_junction());
		}
		catch(NumberFormatException e){
			new Error_message("end_junction must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getBegin_junction());
		}
		catch(NumberFormatException e){
			new Error_message("begin_junction must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getNb_car());
		}
		catch(NumberFormatException e){
			new Error_message("nb_car must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getSafety_length());
		}
		catch(NumberFormatException e){
			new Error_message("safety_length must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getSafety_width());
		}
		catch(NumberFormatException e){
			new Error_message("safety_width must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTraj_length());
		}
		catch(NumberFormatException e){
			new Error_message("traj_length must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getDelay_step());
		}
		catch(NumberFormatException e){
			new Error_message("delay_step must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getMax_delay());
		}
		catch(NumberFormatException e){
			new Error_message("max_delay must be a decimal value");
			evryThingIsOk=false;
		}
		
		
		
		
		if(param.getMarking().size()!=(Integer.parseInt(param.getNb_lane())-1)){
			new Error_message("marking is not defined");
			evryThingIsOk=false;
		}
		else if(Integer.parseInt(param.getMarking().get(param.getMarking().size()-1))>Integer.parseInt(param.getR())){
			new Error_message("posY"+(param.getMarking().size())+" (in marking) can not be greater than R");
			evryThingIsOk=false;
		}
			
		if(param.getCar_list().size()!=(Integer.parseInt(param.getNb_car()))){
			new Error_message("Cars are not defined");
			evryThingIsOk=false;
		}
		else {
			for(int i=0;i<param.getCar_list().size();i++){
				if(Integer.parseInt(param.getCar_list().get(i).getVmax())<Integer.parseInt(param.getV_min())){
					new Error_message("v_max can not be smaller than V_min");
					evryThingIsOk=false;
				}
			}
		}
		
		if(Integer.parseInt(param.getScale())<0){
			new Error_message("scale can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getS())<0){
			new Error_message("S can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getL())<0){
			new Error_message("L can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getR())<0){
			new Error_message("R can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getV_min())<0){
			new Error_message("V_min can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getGranA())<0){
			new Error_message("GranA can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getW())<0){
			new Error_message("W can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getNormX())<0){
			new Error_message("Normx can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getNb_lane())<0){
			new Error_message("nb_lane can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getEnd_junction())<0){
			new Error_message("end_junction can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getBegin_junction())<0){
			new Error_message("begin_junction can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getNb_car())<0){
			new Error_message("nb_car can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getSafety_length())<0){
			new Error_message("safety_length can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getSafety_width())<0){
			new Error_message("safety_width can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getTraj_length())<0){
			new Error_message("traj_length can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getDelay_step())<0){
			new Error_message("delay_step can not be negative value");
			evryThingIsOk=false;
			
		}
		if(Integer.parseInt(param.getMax_delay())<0){
			new Error_message("max_delay can not be negative value");
			evryThingIsOk=false;
			
		}
		
		if((Integer.parseInt(param.getMax_delay())%Integer.parseInt(param.getDelay_step()))!=0){
			new Error_message("max_delay must be a multiple of delay_step");
			evryThingIsOk=false;	
		}
		
		
		
		if(Integer.parseInt(param.getNormX())<((Integer.parseInt(param.getGranA())*Integer.parseInt(param.getS())/Integer.parseInt(param.getScale()))/2)){
			new Error_message("nb_lane can not be smaller than 2");
			evryThingIsOk=false;
		}
		if(Integer.parseInt(param.getNb_lane())<2){
			new Error_message("nb_lane can not be smaller than 2");
			evryThingIsOk=false;
		}
		
//calculation zone
		if(evryThingIsOk){
			int Vmax=0;
			int Amax=0;
			int Amin=0;
			
			for(int i=0;i<param.getCar_list().size();i++){
				Vmax+=Integer.parseInt(param.getCar_list().get(i).getVmax());
				Amax+=Integer.parseInt(param.getCar_list().get(i).getAmax());
				Amin+=Integer.parseInt(param.getCar_list().get(i).getAmin());
			}
			Vmax=Vmax/param.getCar_list().size();
			Amax=Amax/param.getCar_list().size();
			Amin=Amin/param.getCar_list().size();
			
			param.setV_max(Integer.toString(Vmax));
			param.setA_max(Integer.toString(Amax));
			param.setA_min(Integer.toString(Amin));
			
			param.setNavigation_points_max(param.getCar_list().get(0).getNavigationpoints());
			for(int i=1;i<param.getCar_list().size();i++){
				if(Integer.parseInt(param.getCar_list().get(i).getNavigationpoints())>Integer.parseInt(param.getNavigation_points_max())){
					param.setNavigation_points_max(param.getCar_list().get(i).getNavigationpoints());
				}
			}
			
			for(int i=0;i<param.getCar_list().size();i++){
				ArrayList<String> new_navigation_posX=new ArrayList<String>();
				ArrayList<String> new_navigation_laneInf=new ArrayList<String>();
				ArrayList<String> new_navigation_laneSup=new ArrayList<String>();
				
				int size_empty=Integer.parseInt(param.getNavigation_points_max())-param.getCar_list().get(i).getNavigation_posX().size();
				
				int y=0;
				while(y<size_empty){
					new_navigation_posX.add(y, "0");
					new_navigation_laneInf.add(y, param.getCar_list().get(i).getNavigation_laneInf().get(0));
					new_navigation_laneSup.add(y, param.getCar_list().get(i).getNavigation_LaneSup().get(0));
					y++;
				}
				while(y<Integer.parseInt(param.getNavigation_points_max())){
					new_navigation_posX.add(y, param.getCar_list().get(i).getNavigation_posX().get(y-size_empty));
					new_navigation_laneInf.add(y, param.getCar_list().get(i).getNavigation_laneInf().get(y-size_empty));
					new_navigation_laneSup.add(y, param.getCar_list().get(i).getNavigation_LaneSup().get(y-size_empty));
					y++;
				}
				
				param.getCar_list().get(i).setNavigation_posX(new_navigation_posX);
				param.getCar_list().get(i).setNavigation_laneInf(new_navigation_laneInf);
				param.getCar_list().get(i).setNavigation_LaneSup(new_navigation_laneSup);
			}
			
			//end zone
			this.app.dispose();
			File_maker file=new File_maker(param);
		}
		
	}

}
