package at.sew.s04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Control
 * 
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 */
public class Control implements ActionListener {

	private View v;

	private Model m;

	/**
	 * @param ip
	 *            des Partners
	 * @param port
	 *            Port des Partners
	 */
	public Control(String ip, int port) {
		v = new View(m, this);
		m = new Model(v, ip, port);
		new GUI(v);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == v.getBConnect()) {
			m.connect();
			v.chatin();
		} else if (e.getSource() == v.getBSend()) {
			m.send(v.getMsg());
		}
	}

	/**
	 * Liefert die View zurueck
	 * 
	 * @return View
	 */
	public View getV() {
		return v;
	}

	/**
	 * Liefert das Model zurück
	 * 
	 * @return Model
	 */
	public Model getM() {
		return m;
	}
}
