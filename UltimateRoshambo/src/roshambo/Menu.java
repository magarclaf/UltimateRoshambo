package roshambo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
	public Menu() {
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/img/rps-titulo.png")));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("ULTIMATE ROSHAMBO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_2, BorderLayout.SOUTH);
	}
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
