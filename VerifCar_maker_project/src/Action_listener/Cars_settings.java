package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Marking;
import Interface.Param;
import Interface.Car;
import Interface.Error_message;

public class Cars_settings implements ActionListener{

	Param param;
	public Cars_settings(Param param)
	{
		this.param=param;
	}
	public void actionPerformed(ActionEvent arg0) {
		//error zone
		boolean evryThingIsOk=true;
		try{
			Integer.parseInt(param.getTxtnb_car().getText());
		}
		catch(NumberFormatException e){
			new Error_message("nb_car must be a decimal value");
			evryThingIsOk=false;
		}	
		
		if(Integer.parseInt(param.getTxtnb_car().getText())<0){
			new Error_message("nb_car can not be negative value");
			evryThingIsOk=false;
		}
		//end error zone
		
		if(evryThingIsOk){
		int nb=Integer.parseInt(param.getTxtnb_car().getText());
			
			ArrayList<Car> carsList=new ArrayList<Car>();
			for(int i=0;i<nb;i++){
				carsList.add(i, new Car(i,param));
			}
			param.setCar_list(carsList);
		}
		
	}
	
}
