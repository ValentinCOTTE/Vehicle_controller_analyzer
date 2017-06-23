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

public class Load_set implements ActionListener{

	String file;
	Param param;
	Load page;

	public Load_set(String file, Param param,Load page){
		this.file=file;
		this.param=param;
		this.page=page;
	}

	public void actionPerformed(ActionEvent arg0) {
		ObjectInputStream ois = null;


		try {
			final FileInputStream fichier = new FileInputStream(file);
			ois = new ObjectInputStream(fichier);
			final Param_set set = (Param_set) ois.readObject();
			this.param=new Param(param.getApp(), set);
			this.param.getApp().setContentPane(this.param);
			this.param.getApp().repaint();
			this.param.getApp().revalidate();
		} catch (final IOException e) {
			System.out.println("ERROR: IOException");
		} catch (final ClassNotFoundException e) {
			System.out.println("ERROR: ClassNotFoundException");
		} finally {
			try {
				if (ois != null) {
				ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
		this.page.dispose();
	}

}
