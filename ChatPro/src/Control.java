import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Control implements ActionListener{
	
	View v;
	GUI g;
	Model m;
	
	public Control()
	{
		v = new View(m,this);
		g = new GUI(v);
		m = new Model(v);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == v.getBhost())
		{
			m.verbinden(v.getHost());
		}else
			if(e.getSource() == v.getSend())
			{
				m.send(v.getMsg());
				
			}
		
		
	}
}
