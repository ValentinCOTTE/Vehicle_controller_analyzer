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

public class Continue_without_saving implements ActionListener{

	Application app;
	Param param;
	Save page;
	
	public Continue_without_saving(Application app,Param param,Save page){
		this.app=app;
		this.param=param;
		this.page=page;
	}
	public void actionPerformed(ActionEvent arg0) {
			this.page.dispose();
			this.app.dispose();
			Script_generator script=new Script_generator(param);
	}

}