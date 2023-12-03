package roshambo;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartidaUnJugador extends JFrame{
	private int multiplicadorGangan;
	private JButton btnGanganConEspacioParaColores;
	
	public PartidaUnJugador() {
		getContentPane().setLayout(null);
		
		btnGanganConEspacioParaColores = new JButton("");
		btnGanganConEspacioParaColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarMultiplicador();
			}

			
		});
		btnGanganConEspacioParaColores.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/gangan-resizeM.png")));
		btnGanganConEspacioParaColores.setBackground(Color.GRAY);
		btnGanganConEspacioParaColores.setOpaque(true);
		btnGanganConEspacioParaColores.setBounds(366, 81, 150, 150);
		getContentPane().add(btnGanganConEspacioParaColores);
		
		
	}
	
	private void cambiarMultiplicador() {
		// TODO Auto-generated method stub
		double random = Math.random();// generamos un numero al azar entre 0 y 1

		if (random < 0.2)// Blanco (1/5%)
		{
			multiplicadorGangan = 2;// golpe x2
			btnGanganConEspacioParaColores.setBackground(Color.WHITE);
		}

		else {
			if (random < 0.4)// Azul (1/5%)
			{
				multiplicadorGangan = 4;// golpe x4
				btnGanganConEspacioParaColores.setBackground(Color.BLUE);
			} else {
				if (random < 0.6)// Verde (1/5%)
				{
					multiplicadorGangan = 6;
					btnGanganConEspacioParaColores.setBackground(Color.GREEN);
				} // golpe x6
				else {
					if (random < 0.8) { //Rojo (1/5%)
						multiplicadorGangan = 8;// golpe x8
						btnGanganConEspacioParaColores.setBackground(Color.RED);
					} else { // Dorado (1/5%)
						multiplicadorGangan = 10;// golpe x10
						btnGanganConEspacioParaColores.setBackground(Color.YELLOW);
					}
				}
			}

		}

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidaUnJugador frame = new PartidaUnJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
