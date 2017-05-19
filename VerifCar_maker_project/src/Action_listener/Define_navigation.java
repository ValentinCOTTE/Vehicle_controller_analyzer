package Action_listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface.Navigation;
import Interface.Param;
import Interface.Car;
import Interface.Error_message;

public class Define_navigation implements ActionListener {
	
	Param param;
	Car car;
	public Define_navigation(Param param,Car car)
	{
		this.param=param;
		this.car=car;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		//error zone
		boolean evryThingIsOk=true;
		try{
			Integer.parseInt(car.getNavigationpoints());
		}
		catch(NumberFormatException e){
			new Error_message("navigation_points must be a decimal value");
			evryThingIsOk=false;
		}	
		
		if(Integer.parseInt(car.getNavigationpoints())<0){
			new Error_message("navigation_points can not be negative value");
			evryThingIsOk=false;
		}
		try{
			Integer.parseInt(param.getL());
		}
		catch(NumberFormatException e){
			new Error_message("L must be a decimal value");
			evryThingIsOk=false;
		}	
		
		if(Integer.parseInt(param.getL())<0){
			new Error_message("L can not be negative value");
			evryThingIsOk=false;
		}
		//end error zone
		if(evryThingIsOk){
			Navigation page =new Navigation(param,car);
		}
	}
}