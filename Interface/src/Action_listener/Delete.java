package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import Interface.Load;
import Interface.Param;

public class Delete implements ActionListener{
	String path;
	Load page;

	public Delete(String path, Load page) {
		super();
		this.path = path;
		this.page=page;
	}

	public void actionPerformed(ActionEvent arg0) {
		File fichier = new File(path);
		fichier.delete();
		page.getContentPane().removeAll();
		page.repaint();
	}

}
