import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{

	private View v;
	
	public GUI(View v)
	{
		this.v = v;
		Container c = this.getContentPane();
		this.setSize(new Dimension(1000,500));
		c.add(v);
		setTitle("Chat");     	
	    setLocation(200,300); 		
		setVisible(true);	
		
	}
}
