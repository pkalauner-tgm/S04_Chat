package at.sew.s04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {

	View v;
	GUI g;
	Model m;

	public Control(String ip, int port) {
		v = new View(m, this);
		g = new GUI(v);
		m = new Model(v, ip, port);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == v.getSend()) {
			m.send(v.getMsg());
		}
	}
}
