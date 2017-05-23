package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Error_message;
import Interface.Marking;
import Interface.Param;

public class Save_marking implements ActionListener{
	Marking page;
	public Save_marking(Marking page){
		this.page=page;
	}
	
	public void actionPerformed(ActionEvent arg0) {

		ArrayList<String> marking= new ArrayList<String>();
		
		int i;
		boolean evryThingIsOk=true;
		
		for(i=0;i<this.page.getNb_lane()-1;i++){
			
			//error zone
			
			try{
				Integer.parseInt(this.page.getTextPosY().get(i).getText());
			}
			catch(NumberFormatException e){
				new Error_message("posY"+(i+1)+" must be a decimal value");
				evryThingIsOk=false;
			}	
			
			if(Integer.parseInt(this.page.getTextPosY().get(i).getText())<0){
				new Error_message("posY"+(i+1)+" can not be negative value");
				evryThingIsOk=false;
				
			}
			
			if(Integer.parseInt(this.page.getTextPosY().get(i).getText())>Integer.parseInt(page.getParam().getR())){
				new Error_message("posY"+(i+1)+" can not be greater than R");
				evryThingIsOk=false;
			}
			
			
			//end error zone
			marking.add(i, this.page.getTextPosY().get(i).getText());
		}
		
		if(evryThingIsOk){
			page.getParam().setMarking(marking);
			this.page.dispose();
		}
	}
		
}
