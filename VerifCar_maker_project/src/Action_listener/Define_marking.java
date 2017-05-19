package Action_listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interface.Error_message;
import Interface.Marking;
import Interface.Param;

public class Define_marking implements ActionListener {
	
	Param param;
	public Define_marking(Param param)
	{
		this.param=param;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		boolean evryThingIsOk=true;
		//error zone
		try{
			Integer.parseInt(param.getTxtnb_lane().getText());
		}
		catch(NumberFormatException e1){
			new Error_message("nb_lane must be a decimal value");
			evryThingIsOk=false;
		}	
		if(Integer.parseInt(param.getTxtnb_lane().getText())<0){
			new Error_message("nb_lane can not be negative value");
			evryThingIsOk=false;
		//end error zone
		}
		if(evryThingIsOk){
			int nb=Integer.parseInt(param.getTxtnb_lane().getText());
			Marking page =new Marking(nb,param);	
		}
	}
}
