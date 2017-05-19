package Action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import Interface.Error_message;

public class Exit implements ActionListener{
	JDialog page;
	public Exit(JDialog page){
		this.page=page;
	}
	public void actionPerformed(ActionEvent e) {
		this.page.dispose();
	}
	
}
