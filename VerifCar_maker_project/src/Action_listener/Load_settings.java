package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Interface.Load;
import Interface.Param;
import Principal.Param_set;

public class Load_settings implements ActionListener{	
	Param param;
	public Load_settings(Param param) {
		super();
		this.param = param;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		new Load(param);
	}

}
