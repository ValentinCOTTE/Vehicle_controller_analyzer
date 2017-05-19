package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import Interface.Param;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Application extends JFrame {

	 Param fenetre;


	 
	public Application() {
		this.setResizable(false);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		fenetre = new Param(this);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 630);
		setContentPane(fenetre);
	}

	
	
}
