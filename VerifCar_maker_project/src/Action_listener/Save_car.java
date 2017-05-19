package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Interface.Car;
import Interface.Error_message;
import Interface.Navigation;
import Interface.Param;

public class Save_car implements ActionListener{
	Car car;
	Param param;
	public Save_car(Param param, Car car){
		this.car=car;
		this.param=param;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		param.getCar_list().set(car.getIndex(), car);
		this.car.dispose();
	}
}
