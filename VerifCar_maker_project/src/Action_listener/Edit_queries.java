package Action_listener;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Edit_queries implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		if(Desktop.isDesktopSupported())
		{
			if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN))
			{
				File file=new File("resources/queries.q");
				try
				{
					java.awt.Desktop.getDesktop().open(file);
				}
				catch (IOException exc)
				{
			    	System.out.println("Exception: " + exc.toString());
				}
			}
			else
			{
				System.out.println("The fonction OPEN isn't supported on your Operating System");				
			}
		}
		else
		{
			System.out.println("The fonction Desktop isn't supported on your Operating System");
		}
	}

}
