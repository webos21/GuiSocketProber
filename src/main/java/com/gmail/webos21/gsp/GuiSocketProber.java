package com.gmail.webos21.gsp;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.gmail.webos21.gsp.swing.About;
import com.gmail.webos21.gsp.swing.SocketTestClient;
import com.gmail.webos21.gsp.swing.SocketTestServer;
import com.gmail.webos21.gsp.swing.SocketTestUdp;
import com.gmail.webos21.gsp.swing.SplashScreen;

public class GuiSocketProber extends JFrame {

	private static final long serialVersionUID = 1L;

	private ClassLoader cl = getClass().getClassLoader();
	public ImageIcon logo = new ImageIcon(cl.getResource("icons/logo.gif"));
	public ImageIcon ball = new ImageIcon(cl.getResource("icons/ball.gif"));
	private JTabbedPane tabbedPane;

	/** Creates a new instance of SocketTest */
	public GuiSocketProber() {
		Container cp = getContentPane();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		SocketTestClient client = new SocketTestClient(this);
		SocketTestServer server = new SocketTestServer(this);
		SocketTestUdp udp = new SocketTestUdp(this);
		About about = new About();

		tabbedPane.addTab("Client", ball, (Component) client, "Test any server");
		tabbedPane.addTab("Server", ball, server, "Test any client");
		tabbedPane.addTab("Udp", ball, udp, "Test any UDP Client or Server");
		tabbedPane.addTab("About", ball, about, "About GuiSocketProber");

		tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		cp.add(tabbedPane);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		boolean toSplash = true;
		if (args.length > 0) {
			if ("nosplash".equals(args[0]))
				toSplash = false;
		}

		SplashScreen splash = null;
		if (toSplash)
			splash = new SplashScreen();

		GuiSocketProber st = new GuiSocketProber();
		st.setTitle("GuiSocketProber v1.0.0");
		st.setSize(600, 500);
		Util.centerWindow(st);
		st.setDefaultCloseOperation(EXIT_ON_CLOSE);
		st.setIconImage(st.logo.getImage());
		if (toSplash)
			splash.kill();
		st.setVisible(true);
	}

}
