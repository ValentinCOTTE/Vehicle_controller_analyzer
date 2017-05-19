package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Navigation;

public class Save_navigation implements ActionListener{
	Navigation page;
	public Save_navigation(Navigation page){
		this.page=page;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<String> navigation_posX= new ArrayList<String>();
		ArrayList<String> navigation_laneInf=new ArrayList<String>();
		ArrayList<String> navigation_laneSup=new ArrayList<String>();
		
		int i;
		for(i=0;i<Integer.parseInt(page.getCar().getTxtNavigationpoints().getText());i++){
			navigation_posX.add(i, this.page.getTxtP().get(i).getText());
			navigation_laneInf.add(i, this.page.getComboBox().get(i).getSelectedItem().toString());
			navigation_laneSup.add(i, this.page.getComboBox_2().get(i).getSelectedItem().toString());
		}
		page.getCar().setNavigation_posX(navigation_posX);
		page.getCar().setNavigation_laneInf(navigation_laneInf);
		page.getCar().setNavigation_LaneSup(navigation_laneSup);

		this.page.dispose();
	}
}
