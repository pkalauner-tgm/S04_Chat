package at.sew.s04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {

	private View v;

	private Model m;

	public Control(String ip, int port) {
		v = new View(m, this);
		m = new Model(v, ip, port);
		new GUI(v);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == v.getBhost()) {
			m.connect();
			v.chatin();
		} else if (e.getSource() == v.getSend()) {
			m.send(v.getMsg());
		}
	}

	public View getV() {
		return v;
	}

	public Model getM() {
		return m;
	}
}
