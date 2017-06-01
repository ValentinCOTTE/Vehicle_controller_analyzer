package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Interface.Error_message;
import Interface.Param;
import Interface.Save;
import Principal.Application;
import Principal.Param_set;
import Principal.Script_generator;

public class Save_set implements ActionListener{
	
	
	Application app;
	Param param;
	Save page;
	
	Param_set set;
	
	

	public Save_set(Application app, Param param, Save page, Param_set set) {
		super();
		this.app = app;
		this.param = param;
		this.page = page;
		this.set = set;
	}



	public void actionPerformed(ActionEvent e) {
			File fichier= new File("resources/saves/"+page.getTxtName().getText()+".ser");
			if (fichier.exists()){
				new Error_message("This name is already taken");
			}
			else{
					// ouverture d'un flux sur un fichier
				ObjectOutputStream oos;
				try {
					System.out.println(set.getCar_list().get(0).getInitA());
					oos = new ObjectOutputStream(new FileOutputStream(fichier));// création d'un objet à sérializer
	
					
					try {
						oos.writeObject(set); // sérialization de l'objet
						
						this.page.dispose();
						this.app.dispose();
						Script_generator script=new Script_generator(param.extract());
						
					} catch (IOException e1) {
						System.out.println("ERROR: Serialization failed");
					}
				} catch (FileNotFoundException e1) {
					System.out.println("ERROR: "+page.getTxtName().getText()+".ser not found");
				} catch (IOException e1) {
					System.out.println("ERROR: open "+page.getTxtName().getText()+".ser failed");
				}
			}
	}
}
