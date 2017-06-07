package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Error_message;
import Interface.Navigation;

public class Save_navigation implements ActionListener{
	Navigation page;
	public Save_navigation(Navigation page){
		this.page=page;
	}

	public void actionPerformed(ActionEvent arg0) {
		//error zone
		boolean evryThingIsOk=true;



		ArrayList<Integer> navigation_posX= new ArrayList<Integer>();
		ArrayList<Integer> navigation_laneInf=new ArrayList<Integer>();
		ArrayList<Integer> navigation_laneSup=new ArrayList<Integer>();

		int i;
		for(i=0;i<Integer.parseInt(page.getCar().getTxtNavigationpoints().getText());i++){

			try{
				Integer.parseInt(this.page.getTxtP().get(i).getText());
			}
			catch(NumberFormatException e){
				new Error_message("posX of P"+i+" must be a decimal value");
				evryThingIsOk=false;
			}

			if(Integer.parseInt(this.page.getTxtP().get(i).getText())<0){
				new Error_message("posX of P"+i+" can not be negative value");
				evryThingIsOk=false;
			}

			if(Integer.parseInt(this.page.getComboBox().get(i).getSelectedItem().toString())>Integer.parseInt(this.page.getComboBox_2().get(i).getSelectedItem().toString())){
				new Error_message("lane_inf can not be greater than lane_sup");
				evryThingIsOk=false;
			}
			//end error zone

			navigation_posX.add(i, Integer.parseInt(this.page.getTxtP().get(i).getText()));
			navigation_laneInf.add(i, Integer.parseInt(this.page.getComboBox().get(i).getSelectedItem().toString()));
			navigation_laneSup.add(i, Integer.parseInt(this.page.getComboBox_2().get(i).getSelectedItem().toString()));
		}

		if(evryThingIsOk){
			page.getCar().setNavigation_posX(navigation_posX);
			page.getCar().setNavigation_laneInf(navigation_laneInf);
			page.getCar().setNavigation_LaneSup(navigation_laneSup);

			this.page.dispose();
		}



	}
}
