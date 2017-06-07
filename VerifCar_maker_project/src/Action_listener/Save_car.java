package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Car;
import Interface.Error_message;
import Interface.Navigation;
import Interface.Param;
import Principal.Car_set;

public class Save_car implements ActionListener{
	Car car;
	Param param;
	public Save_car(Param param, Car car){
		this.car=car;
		this.param=param;
	}

	public void actionPerformed(ActionEvent arg0) {

	//error zone
		boolean evryThingIsOk=true;
		try{
			Integer.parseInt(this.car.getTxtLengthvehicle().getText());
		}
		catch(NumberFormatException e){
			new Error_message("length_vehicle must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtLengthvehicle().getText())<0){
			new Error_message("length_vehicle can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtWidthvehicle().getText());
		}
		catch(NumberFormatException e){
			new Error_message("width_vehicle must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtWidthvehicle().getText())<0){
			new Error_message("width_vehicle can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtVmax().getText());
		}
		catch(NumberFormatException e){
			new Error_message("v_max must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtVmax().getText())<0){
			new Error_message("v_max can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtAmin().getText());
		}
		catch(NumberFormatException e){
			new Error_message("a_min must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtAmin().getText())>Integer.parseInt(this.car.getTxtAmax().getText())){
			new Error_message("a_min can not be greater than a_max");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtAmax().getText());
		}
		catch(NumberFormatException e){
			new Error_message("a_max must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtAmax().getText())<0){
			new Error_message(" a_max can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtCtrfreq().getText());
		}
		catch(NumberFormatException e){
			new Error_message("ctr_freq must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtCtrfreq().getText())<0){
			new Error_message("ctr_freq can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtMaxcom().getText());
		}
		catch(NumberFormatException e){
			new Error_message("max_com must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtMaxcom().getText())<0){
			new Error_message("max_com can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtMincom().getText());
		}
		catch(NumberFormatException e){
			new Error_message("min_com must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtMincom().getText())<0){
			new Error_message("min_com can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtInitposx().getText());
		}
		catch(NumberFormatException e){
			new Error_message("init_posX must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitposx().getText())<0){
			new Error_message("init_posX can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtInitposy().getText());
		}
		catch(NumberFormatException e){
			new Error_message("init_posY must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitposy().getText())<0){
			new Error_message("init_posY can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtInitV().getText());
		}
		catch(NumberFormatException e){
			new Error_message("init_V must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitV().getText())<0){
			new Error_message("init_V can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtInitA().getText());
		}
		catch(NumberFormatException e){
			new Error_message("init_A must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitA().getText())<0){
			new Error_message("init_A can not be negative value");
			evryThingIsOk=false;
		}

		try{
			Integer.parseInt(this.car.getTxtNavigationpoints().getText());
		}
		catch(NumberFormatException e){
			new Error_message("navigation_points must be a decimal value");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtNavigationpoints().getText())<0){
			new Error_message("navigation_points can not be negative value");
			evryThingIsOk=false;
		}

		if(this.car.getNavigation_posX().size()!=(Integer.parseInt(this.car.getTxtNavigationpoints().getText()))){
			new Error_message("navigation_list is not defined");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtVmax().getText())<Integer.parseInt(param.getTxtV_min().getText())){
			new Error_message("v_max can not be smaller than V_min");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtCtrfreq().getText())<Integer.parseInt(param.getTxtS().getText())){
			new Error_message("ctr_freq can not be smaller than S");
			evryThingIsOk=false;
		}
		if(Integer.parseInt(this.car.getTxtMaxcom().getText())>Integer.parseInt(this.car.getTxtCtrfreq().getText())){
			new Error_message("ctr_freq can not be smaller than max_com");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtMaxcom().getText())<Integer.parseInt(this.car.getTxtMincom().getText())){
			new Error_message("max_com can not be smaller than min_com");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitposx().getText())>Integer.parseInt(param.getTxtL().getText())){
			new Error_message("init_posX can not be greater than L");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitposy().getText())>Integer.parseInt(param.getTxtR().getText())){
			new Error_message("init_posY can not be smaller than R");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitV().getText())<Integer.parseInt(param.getTxtV_min().getText())){
			new Error_message("init_V can not be smaller than V_min");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitV().getText())>Integer.parseInt(this.car.getTxtVmax().getText())){
			new Error_message("init_V can not be greater than v_max");
			evryThingIsOk=false;
		}
		if(Integer.parseInt(this.car.getTxtInitA().getText())<Integer.parseInt(this.car.getTxtAmin().getText())){
			new Error_message("init_A can not be smaller than a_min");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtInitA().getText())>Integer.parseInt(this.car.getTxtAmax().getText())){
			new Error_message("init_A can not be greater than a_max");
			evryThingIsOk=false;
		}

		if(Integer.parseInt(this.car.getTxtNavigationpoints().getText())<1){
			new Error_message("init_A can not be greater than a_max");
			evryThingIsOk=false;
		}
	//end error zone


		if(evryThingIsOk){

			try{
				param.getCar_list().set(car.getIndex(), new Car_set(car.getLength_vehicle(), car.getWidth_vehicle(), car.getVmax(), car.getAmin(), car.getAmax(), car.getCtrfreq(), car.getMaxcom(), car.getMincom(), car.getInitposx(), car.getInitposy(), car.getInitV(), car.getSTEP_initV(), car.getLIMIT_initV(), car.getInitA(), car.getSTEP_initA(), car.getLIMIT_initA(), car.getNavigationpoints(), car.getNavigation_posX(), car.getNavigation_laneInf(), car.getNavigation_LaneSup()));
			}
			catch(IndexOutOfBoundsException e){
				while(param.getCar_list().size()-1<car.getIndex()){
					param.getCar_list().add(null);
				}
				param.getCar_list().set(car.getIndex(), new Car_set(car.getLength_vehicle(), car.getWidth_vehicle(), car.getVmax(), car.getAmin(), car.getAmax(), car.getCtrfreq(), car.getMaxcom(), car.getMincom(), car.getInitposx(), car.getInitposy(), car.getInitV(), car.getSTEP_initV(), car.getLIMIT_initV(), car.getInitA(), car.getSTEP_initA(), car.getLIMIT_initA(), car.getNavigationpoints(), car.getNavigation_posX(), car.getNavigation_laneInf(), car.getNavigation_LaneSup()));
			}

		this.car.dispose();
		}
	}
}
