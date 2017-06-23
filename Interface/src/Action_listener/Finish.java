package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Error_message;
import Interface.Param;
import Interface.Save;
import Principal.Application;
import Principal.File_maker;
import Principal.Script_generator;

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
			Integer.parseInt(param.getTxtscale().getText());
		}
		catch(NumberFormatException e){
			new Error_message("scale must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtS().getText());
		}
		catch(NumberFormatException e){
			new Error_message("S must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtL().getText());
		}
		catch(NumberFormatException e){
			new Error_message("L must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtR().getText());
		}
		catch(NumberFormatException e){
			new Error_message("R must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtV_min().getText());
		}
		catch(NumberFormatException e){
			new Error_message("V_min must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtGranA().getText());
		}
		catch(NumberFormatException e){
			new Error_message("GranA must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtW().getText());
		}
		catch(NumberFormatException e){
			new Error_message("W must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtNormX().getText());
		}
		catch(NumberFormatException e){
			new Error_message("NormX must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtnb_lane().getText());
		}
		catch(NumberFormatException e){
			new Error_message("nb_lane must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtend_junction().getText());
		}
		catch(NumberFormatException e){
			new Error_message("end_junction must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtbegin_junction().getText());
		}
		catch(NumberFormatException e){
			new Error_message("begin_junction must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtnb_car().getText());
		}
		catch(NumberFormatException e){
			new Error_message("nb_car must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtsafety_length().getText());
		}
		catch(NumberFormatException e){
			new Error_message("safety_length must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtsafety_width().getText());
		}
		catch(NumberFormatException e){
			new Error_message("safety_width must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxttraj_length().getText());
		}
		catch(NumberFormatException e){
			new Error_message("traj_length must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtdelay_step().getText());
		}
		catch(NumberFormatException e){
			new Error_message("delay_step must be a decimal value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getTxtmax_delay().getText());
		}
		catch(NumberFormatException e){
			new Error_message("max_delay must be a decimal value");
			evryThingIsOk=false;
		}




		if(param.getMarking().size()!=(Integer.parseInt(param.getTxtnb_lane().getText())-1)){
			new Error_message("marking is not defined");
			evryThingIsOk=false;
		}
		else if(param.getMarking().get(param.getMarking().size()-1)>Integer.parseInt(param.getTxtR().getText())){
			new Error_message("posY"+(param.getMarking().size())+" (in marking) can not be greater than R");
			evryThingIsOk=false;
		}

		if(param.getCar_list().size()!=(param.getNb_car())){
			new Error_message("Cars are not defined");
			evryThingIsOk=false;
		}
		else {
			for(int i=0;i<param.getCar_list().size();i++){
				if(param.getCar_list().get(i).getVmax()<param.getV_min()){
					new Error_message("v_max can not be smaller than V_min");
					evryThingIsOk=false;
				}
			}
		}

		if(param.getScale()<0){
			new Error_message("scale can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getS()<0){
			new Error_message("S can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getL()<0){
			new Error_message("L can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getR()<0){
			new Error_message("R can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getV_min()<0){
			new Error_message("V_min can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getGranA()<0){
			new Error_message("GranA can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getW()<0){
			new Error_message("W can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getNormX()<0){
			new Error_message("Normx can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getNb_lane()<0){
			new Error_message("nb_lane can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getEnd_junction()<0){
			new Error_message("end_junction can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getBegin_junction()<0){
			new Error_message("begin_junction can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getNb_car()<0){
			new Error_message("nb_car can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getSafety_length()<0){
			new Error_message("safety_length can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getSafety_width()<0){
			new Error_message("safety_width can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getTraj_length()<0){
			new Error_message("traj_length can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getDelay_step()<0){
			new Error_message("delay_step can not be negative value");
			evryThingIsOk=false;

		}
		if(param.getMax_delay()<0){
			new Error_message("max_delay can not be negative value");
			evryThingIsOk=false;

		}

		if((param.getMax_delay()%param.getDelay_step())!=0){
			new Error_message("max_delay must be a multiple of delay_step");
			evryThingIsOk=false;
		}



		if(param.getNormX()<((param.getGranA()*param.getS()/param.getScale())/2)){
			new Error_message("nb_lane can not be smaller than 2");
			evryThingIsOk=false;
		}
		if(param.getNb_lane()<2){
			new Error_message("nb_lane can not be smaller than 2");
			evryThingIsOk=false;
		}

//calculation zone
		if(evryThingIsOk){
			int Vmax=0;
			int Amax=0;
			int Amin=0;

			for(int i=0;i<param.getCar_list().size();i++){
				Vmax+=param.getCar_list().get(i).getVmax();
				Amax+=param.getCar_list().get(i).getAmax();
				Amin+=param.getCar_list().get(i).getAmin();
			}
			Vmax=Vmax/param.getCar_list().size();
			Amax=Amax/param.getCar_list().size();
			Amin=Amin/param.getCar_list().size();

			param.setV_max(Vmax);
			param.setA_max(Amax);
			param.setA_min(Amin);

			param.setNavigation_points_max(param.getCar_list().get(0).getNavigationpoints());
			for(int i=1;i<param.getCar_list().size();i++){
				if(param.getCar_list().get(i).getNavigationpoints()>param.getNavigation_points_max()){
					param.setNavigation_points_max(param.getCar_list().get(i).getNavigationpoints());
				}
			}

			for(int i=0;i<param.getCar_list().size();i++){
				ArrayList<Integer> new_navigation_posX=new ArrayList<Integer>();
				ArrayList<Integer> new_navigation_laneInf=new ArrayList<Integer>();
				ArrayList<Integer> new_navigation_laneSup=new ArrayList<Integer>();

				int size_empty=param.getNavigation_points_max()-param.getCar_list().get(i).getNavigation_posX().size();

				int y=0;
				while(y<size_empty){
					new_navigation_posX.add(y, 0);
					new_navigation_laneInf.add(y, param.getCar_list().get(i).getNavigation_laneInf().get(0));
					new_navigation_laneSup.add(y, param.getCar_list().get(i).getNavigation_laneSup().get(0));
					y++;
				}
				while(y<param.getNavigation_points_max()){
					new_navigation_posX.add(y, param.getCar_list().get(i).getNavigation_posX().get(y-size_empty));
					new_navigation_laneInf.add(y, param.getCar_list().get(i).getNavigation_laneInf().get(y-size_empty));
					new_navigation_laneSup.add(y, param.getCar_list().get(i).getNavigation_laneSup().get(y-size_empty));
					y++;
				}

				param.getCar_list().get(i).setNavigation_posX(new_navigation_posX);
				param.getCar_list().get(i).setNavigation_laneInf(new_navigation_laneInf);
				param.getCar_list().get(i).setNavigation_laneSup(new_navigation_laneSup);
			}

			//end zone
			this.app.setVisible(false);
			new Save(this.app,this.param);
		}

	}

}
