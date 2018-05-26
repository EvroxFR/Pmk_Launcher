package io.github.efkabe.launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.theshark34.openlauncherlib.util.Saver;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;

public class LauncherPanel extends JPanel implements SwingerEventListener {

	private Image background = Swinger.getResource("launcher_bg.png");

	private Saver saver = new Saver(new File(Launcher.PMK_DIR, "launcher.properties"));

	private JTextField usernameField = new JTextField("");
	private JPasswordField passwordField = new JPasswordField("");
	private STexturedButton quitButton = new STexturedButton(Swinger.getResource("launcher_quit.png"));
	private STexturedButton hideButton = new STexturedButton(Swinger.getResource("launcher_minimize.png"));

	public LauncherPanel() {
		this.setLayout(null);

		usernameField.setForeground(Color.WHITE);
		usernameField.setOpaque(false);
		usernameField.setFont(usernameField.getFont().deriveFont(30F));
		usernameField.setCaretColor(Color.WHITE);
		usernameField.setBorder(null);
		usernameField.setBounds(833, 134, 377, 83);
		this.add(usernameField);

		passwordField.setForeground(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setFont(usernameField.getFont());
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setBounds(833, 297, 377, 83);
		this.add(passwordField);

		quitButton.setBounds(0, 0);
		quitButton.addEventListener(this);
		this.add(quitButton);

		hideButton.setBounds(64, 0);
		hideButton.addEventListener(this);
		this.add(hideButton);

	}

	@Override
	public void onEvent(SwingerEvent e) {
		if(e.getSource() == quitButton) {
			System.exit(0);
		}
		else if(e.getSource() == hideButton) {
			LauncherFrame.getInstance().setState(JFrame.ICONIFIED);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
