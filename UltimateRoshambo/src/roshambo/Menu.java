package roshambo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;

public class Menu extends JFrame{
	
	private String nombre;
	private JPanel inicio;
	private JPanel contentPane;
	private JLayeredPane layeredPanel;
	
	public Menu() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPanel = new JLayeredPane();
		layeredPanel.setBackground(new Color(255, 228, 181));
		layeredPanel.setForeground(Color.WHITE);
		layeredPanel.setBounds(0, 0, 816, 633);
		contentPane.add(layeredPanel);
		layeredPanel.setLayout(null);
		
		JPanel inicioUR = new JPanel();
		inicioUR.setBackground(SystemColor.activeCaption);
		inicioUR.setBounds(0, 0, 816, 623);
		layeredPanel.add(inicioUR);
		inicioUR.setLayout(null);
		
		JLabel lbLIntroduce = new JLabel("Como quieres llamarte?");
		lbLIntroduce.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbLIntroduce.setBounds(70, 443, 353, 109);
		inicioUR.add(lbLIntroduce);
		
		JLabel lblTitulo = new JLabel("ULTIMATE ROSHAMBO");
		lblTitulo.setFont(new Font("Quintessential", Font.PLAIN, 52));
		lblTitulo.setBounds(118, 359, 737, 144);
		inicioUR.add(lblTitulo);
		
		JLabel Icono = new JLabel("New label");
		Icono.setIcon(new ImageIcon(Menu.class.getResource("/img/rps-titulo-resize.png")));
		Icono.setBounds(10, 28, 797, 370);
		inicioUR.add(Icono);
		
		JTextPane textNombreUser = new JTextPane();
		textNombreUser.setBounds(375, 484, 332, 28);
		inicioUR.add(textNombreUser);
		
		JButton btnEntrar = new JButton("Entrar");
		
		
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEntrar.setBounds(297, 541, 146, 47);
		inicioUR.add(btnEntrar);
		
		JPanel menuUR = new JPanel();
		menuUR.setVisible(false);
		menuUR.setBackground(SystemColor.activeCaption);
		menuUR.setBounds(0, 0, 816, 623);
		layeredPanel.add(menuUR);
		menuUR.setLayout(null);
		
		JLabel lblTituloM = new JLabel("ULTIMATE ROSHAMBO");
		lblTituloM.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloM.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTituloM.setBounds(10, -12, 796, 84);
		menuUR.add(lblTituloM);
		
		JLabel lblHeaderM = new JLabel("");
		lblHeaderM.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderM.setFont(new Font("Mongolian Baiti", Font.PLAIN, 40));
		lblHeaderM.setBounds(10, 50, 796, 82);
		menuUR.add(lblHeaderM);
		
		JButton btnNewButton = new JButton("Personaje");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setBounds(84, 194, 257, 73);
		menuUR.add(btnNewButton);
		
		JButton btnMultijugador = new JButton("Multijugador");
		btnMultijugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnMultijugador.setBounds(84, 329, 257, 73);
		menuUR.add(btnMultijugador);
		
		JButton btnNewButton_1_1 = new JButton("Un jugador");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton_1_1.setBounds(84, 472, 257, 73);
		menuUR.add(btnNewButton_1_1);
		
		JButton btnSalir = new JButton("Salir del juego");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(457, 472, 257, 73);
		menuUR.add(btnSalir);
		
		JButton btnNewButton_1_2 = new JButton("Historial");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton_1_2.setBounds(457, 329, 257, 73);
		menuUR.add(btnNewButton_1_2);
		
		JButton btnReglas = new JButton("Reglas");
		btnReglas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switchPanels(reglasUR);
			}
		});
		btnReglas.setBounds(457, 194, 257, 73);
		menuUR.add(btnReglas);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombreUser.getText()!=null) {
					nombre = textNombreUser.getText();
				}
				lblHeaderM.setText("Bienvenido " + nombre);
				switchPanels(menuUR);
			}
		});
		

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
	
	public void switchPanels(JPanel jp) {
		jp.setVisible(true);
		layeredPanel.removeAll();
		layeredPanel.add(jp);
		layeredPanel.repaint();
		layeredPanel.revalidate();
		
	}
}
