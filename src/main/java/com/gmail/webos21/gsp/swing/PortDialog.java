package com.gmail.webos21.gsp.swing;

import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.gmail.webos21.gsp.PortModel;
import com.gmail.webos21.gsp.Util;

public class PortDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public static final int UDP = 1;
	public static final int TCP = 2;
	private PortModel model;

	/** Creates a new instance of PortDialog */
	public PortDialog(JFrame parent, int type) {
		super(parent);
		if (type == TCP) {
			setTitle("Standard TCP Port");
			model = new PortModel("tcpports.txt");
		} else {
			setTitle("Select UDP port");
			model = new PortModel("udpports.txt");
		}
		Container cp = getContentPane();

		JTable table = new JTable(model);
		cp.add(new JScrollPane(table));
		setSize(300, 200);
		Util.centerWindow(this);
	}

	public String getPort() {
		return model.getPort();
	}

}
