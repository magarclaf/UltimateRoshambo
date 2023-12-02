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
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Menu extends JFrame{
	
	private String nombre;
	private JPanel inicio;
	private JPanel contentPane;
	private JLayeredPane layeredPanel;
	private JPanel inicioUR;
	private JPanel menuUR;
	private JPanel reglasUR;
	private JPanel personajeUR;
	private JPanel historialUR;
	private int personaje;
	private int seleccion;
	private JLabel lblHeaderM;
	private JLabel lblPiedra;
	private JLabel lblPapel;
	private JLabel lblTijera;
	private JLabel lblPasiva;
	private JLabel lblNombrePersonaje;
	private JLabel lblImgPersonaje;
	private JLabel lblImgM;
	
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
		
		personajeUR = new JPanel();
		personajeUR.setVisible(false);
		
		menuUR = new JPanel();
		menuUR.setVisible(false);
		menuUR.setBackground(SystemColor.activeCaption);
		menuUR.setBounds(0, 0, 816, 623);
		layeredPanel.add(menuUR);
		menuUR.setLayout(null);
		
		JLabel lblTituloM = new JLabel("ULTIMATE ROSHAMBO");
		lblTituloM.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloM.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTituloM.setBounds(0, -12, 816, 84);
		menuUR.add(lblTituloM);
		
		lblHeaderM = new JLabel("");
		lblHeaderM.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeaderM.setFont(new Font("Mongolian Baiti", Font.PLAIN, 40));
		lblHeaderM.setBounds(175, 75, 631, 79);
		menuUR.add(lblHeaderM);
		
		JButton btnPersonaje = new JButton("Personaje");
		btnPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(personajeUR);
				seleccion = 1;
				personajeSeleccionado(1);
				
			}
		});
		btnPersonaje.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnPersonaje.setBounds(84, 194, 257, 73);
		menuUR.add(btnPersonaje);
		
		JButton btnMultijugador = new JButton("Multijugador");
		btnMultijugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnMultijugador.setBounds(84, 329, 257, 73);
		menuUR.add(btnMultijugador);
		
		JButton btnUnJugador = new JButton("Un jugador");
		btnUnJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnUnJugador.setBounds(84, 472, 257, 73);
		menuUR.add(btnUnJugador);
		
		JButton btnSalir = new JButton("Salir del juego");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(457, 472, 257, 73);
		menuUR.add(btnSalir);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnHistorial.setBounds(457, 329, 257, 73);
		menuUR.add(btnHistorial);
		
		JButton btnReglas = new JButton("Reglas");
		btnReglas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(reglasUR);
			}
		});
		btnReglas.setBounds(457, 194, 257, 73);
		menuUR.add(btnReglas);
		
		lblImgM = new JLabel("");
		lblImgM.setBounds(20, 20, 127, 127);
		menuUR.add(lblImgM);
		
		JButton btnCambioUsuario = new JButton("Cambio de usuario");
		btnCambioUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambioUsuario.setBounds(619, 10, 165, 44);
		menuUR.add(btnCambioUsuario);
		btnCambioUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inicioUR);
			}
		});
		
		
		inicioUR = new JPanel();
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
		textNombreUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombreUser.setBounds(375, 484, 332, 28);
		inicioUR.add(textNombreUser);
		
		JButton btnEntrar = new JButton("Entrar");
		
		
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEntrar.setBounds(339, 541, 146, 47);
		inicioUR.add(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNombreUser.getText()!=null) {
					nombre = textNombreUser.getText();
				}
				lblHeaderM.setText("Bienvenido " + nombre);
				switchPanels(menuUR);
			}
		});
		personajeUR.setBackground(SystemColor.activeCaption);
		personajeUR.setBounds(0, 0, 816, 623);
		layeredPanel.add(personajeUR);
		personajeUR.setLayout(null);
		
		JLabel lblSelección = new JLabel("SELECCIÓN DE PERSONAJE");
		lblSelección.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSelección.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelección.setBounds(0, 0, 816, 85);
		personajeUR.add(lblSelección);
		
		JButton btnIzq = new JButton("");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seleccion>1 && seleccion<=5) {
					seleccion--;
				}else {
					seleccion=5;
				}
				personajeSeleccionado(seleccion);
			}
		});
		btnIzq.setIcon(new ImageIcon(Menu.class.getResource("/img/vecteezy_icono-de-flecha-izquierda_15337673-1.png")));
		btnIzq.setBounds(10, 229, 85, 90);
		personajeUR.add(btnIzq);
		
		JButton btnDer = new JButton("");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seleccion>=1 && seleccion<5) {
					seleccion++;
				}else {
					seleccion=1;
				}
				personajeSeleccionado(seleccion);
			}
		});
		btnDer.setIcon(new ImageIcon(Menu.class.getResource("/img/vecteezy_right-arrow-icon_15337678-1.png")));
		btnDer.setBounds(720, 229, 85, 90);
		personajeUR.add(btnDer);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioHeaderMenu();
				switchPanels(menuUR);
			}
		});
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSeleccionar.setBounds(240, 487, 320, 55);
		personajeUR.add(btnSeleccionar);
		
		lblPiedra = new JLabel("PIEDRA");
		lblPiedra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPiedra.setBounds(447, 213, 240, 43);
		personajeUR.add(lblPiedra);
		
		lblPapel = new JLabel("PAPEL");
		lblPapel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPapel.setBounds(447, 266, 240, 43);
		personajeUR.add(lblPapel);
		
		lblTijera = new JLabel("TIJERA");
		lblTijera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTijera.setBounds(447, 319, 240, 43);
		personajeUR.add(lblTijera);
		
		lblPasiva = new JLabel("H. PASIVA:");
		lblPasiva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPasiva.setBounds(447, 372, 326, 43);
		personajeUR.add(lblPasiva);
		
		lblImgPersonaje = new JLabel("");
		lblImgPersonaje.setBounds(144, 145, 268, 268);
		personajeUR.add(lblImgPersonaje);
		
		lblNombrePersonaje = new JLabel("");
		lblNombrePersonaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombrePersonaje.setBounds(447, 145, 240, 43);
		personajeUR.add(lblNombrePersonaje);
		
		
		
		reglasUR = new JPanel();
		reglasUR.setVisible(false);
		reglasUR.setBackground(SystemColor.activeCaption);
		reglasUR.setBounds(0, 0, 816, 623);
		layeredPanel.add(reglasUR);
		reglasUR.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 76, 796, 442);
		reglasUR.add(scrollPane);
		
		JTextPane textReglas = new JTextPane();
		textReglas.setEditable(false);
		textReglas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(textReglas);
		textReglas.setBounds(33, 85, 588, 478);
		textReglas.setText("Cómo jugar: Enfrentamiento piedra-papel-tijeras con mecánicas. \r\n"
				+ "Gana el que deja a su rival a 0 puntos de vida.\r\nPara dejar a 0 de vida a tu rival debes ganar duelos en donde le quitarás unos puntos de vida determinados a tu rival. Estos seguirán produciéndose mientras ninguno de los dos combatientes haya alcanzado 0 puntos de vida.\r\n"
				+ "Las dos formas de ganar duelos: Ganando el piedra-papel-tijera directamente o ganando un duelo por el desempate cuando ambos saqueis el mismo gesto clicando un botón que aparecerá por pantalla.\r\n"
				+ "Además los jugadores deberán elegir personajes para jugar partidas con sus correspondientes habilidades expuestas a continuación.\r\n"
				+ "—------------------------------------------------------------------------------------------------------------------------\r\n"
				+ "Personajes:\r\n"
				+ "**Glosario: P=Piedra;Pa=Papel;T=Tijeras**\r\n"
				+ "The Rock/5P-1Pa-3T/Initiative\r\n"
				+ "Gangan/2P-2Pa-5T/Comeback\r\n"
				+ "Mapa/3P-5Pa-1T/Vitality\r\n"
				+ "Nugget/4P-3Pa-2T/Endurance\r\n"
				+ "Weathley Mamado/3P-3Pa-3T/DrawMaster\r\n"
				+ "—------------------------------------------------------------------------------------------------------------------------\r\n"
				+ "Puntos con cada gesto:\r\n"
				+ "El daño de cada gesto va ligado a los puntos expuestos arriba donde 5 puntos será el máximo daño y 1 el mínimo.\r\n"
				+ "—------------------------------------------------------------------------------------------------------------------------\r\n"
				+ "Habilidades pasivas:\r\n"
				+ "Comeback - Cuando la barra le llega a 0 al jugador, te hace una instakill (9%)\r\n"
				+ "Vitality - Recupera un 20% de vida en cualquier turno (15%)\r\n"
				+ "Endurance - Cuando la barra le llega a 0 al jugador, se pondrá con 33 de vida (50%)\r\n"
				+ "Initiative - Hace un golpe al empezar que quita un 20% (50% de probabilidades)\r\n"
				+ "DrawMaster - En caso de empate, empieza con 5 clicks extra en el duelo por el desempate.\r\n"
				+ "—------------------------------------------------------------------------------------------------------------------------\r\n"
				+ "Colores Multiplicadores:\r\n"
				+ "En cada ronda cada carta adquirirá un color que multiplicará al daño propio del gesto donde:\r\n"
				+ "Dorado > Rojo > Verde > Azul > Blanco\r\n"
				+ "Si ganas una ronda con un gesto dorado tendrás la opción de ocasionar más daño clicando un botón que te aparecerá en la pantalla.\r\n"
				+ "—------------------------------------------------------------------------------------------------------------------------\r\n"
				+ "");
		
		JLabel lblReglasUltimateRoshambo = new JLabel("REGLAS ULTIMATE ROSHAMBO");
		lblReglasUltimateRoshambo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReglasUltimateRoshambo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblReglasUltimateRoshambo.setBounds(0, 0, 816, 84);
		reglasUR.add(lblReglasUltimateRoshambo);
		
		JButton btnVolverReglas = new JButton("Volver al menú principal");
		
		btnVolverReglas.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolverReglas.setBounds(253, 544, 317, 37);
		reglasUR.add(btnVolverReglas);
		
		
		btnVolverReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(menuUR);
			}
		});
		
		historialUR = new JPanel();
		historialUR.setBounds(0, 0, 816, 623);
		layeredPanel.add(historialUR);
		historialUR.setLayout(null);
		

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
	
	private void personajeSeleccionado(int i) {
		switch(i) {
		case 1:
			personajeAtributos("The Rock","5","1","3","Initiative","/img/therock-resize.png");
			break;
		case 2:
			personajeAtributos("Gangan","2","2","5","Comeback","/img/gangan-resize.png");
			break;
		case 3:
			personajeAtributos("El mapa","3","5","1","Vitality","/img/mapa-resize.png");
			break;
		case 4:
			personajeAtributos("Nugget","4","3","2","Endurance","/img/nugget-resize.png");
			break;
		case 5:
			personajeAtributos("Wheatley","3","3","3","DrawMaster","/img/wheatley-resize.png");
			break;
		default:
			personajeAtributos("The Rock","5","1","3","Initiative","/img/therock-resize.png");
			break;
		}
		
	}

	private void personajeAtributos(String nombre, String piedra, String papel, String tijera, String pasiva, String img) {
		lblNombrePersonaje.setText(nombre);
		lblPiedra.setText("Piedra "+piedra+" ESTRELLAS");
		lblPapel.setText("Papel "+papel+" ESTRELLAS");
		lblTijera.setText("Tijera "+tijera+" ESTRELLAS");
		lblPasiva.setText("H. pasiva: "+pasiva);
		lblImgPersonaje.setIcon(new ImageIcon(Menu.class.getResource(img)));
		
	}
	
	private void cambioHeaderMenu() {
		// TODO Auto-generated method stub
		lblHeaderM.setFont(new Font("Mongolian Baiti", Font.PLAIN, 30));	
		lblHeaderM.setText(nombre + " jugando con " + elegirNPersonajeMenu(seleccion) + ".");
		lblImgM.setIcon(new ImageIcon(Menu.class.getResource(elegirImgMenu(seleccion))));
	}

	private String elegirImgMenu(int seleccion) {
		// TODO Auto-generated method stub
		String urlImagenMenu = null;
		switch(seleccion) {
		case 1:
			urlImagenMenu = "/img/therock-resizeM.png";
			break;
		case 2:
			urlImagenMenu = "/img/gangan-resizeM.png";
			break;
		case 3:
			urlImagenMenu = "/img/mapa-resizeM.png";
			break;
		case 4:
			urlImagenMenu = "/img/nugget-resizeM.png";
			break;
		case 5:
			urlImagenMenu = "/img/wheatley-resizeM.png";
			break;
		default:
			urlImagenMenu = "/img/therock-resize.png";
			break;
		}
		return urlImagenMenu;
	}
	
	private String elegirNPersonajeMenu(int seleccion) {
		// TODO Auto-generated method stub
		String nomImagenMenu = null;
		switch(seleccion) {
		case 1:
			nomImagenMenu = "el calvo The Rock";
			break;
		case 2:
			nomImagenMenu = "el mítico Gangan";
			break;
		case 3:
			nomImagenMenu = "el fucking mapa";
			break;
		case 4:
			nomImagenMenu = "el gerente Nugget";
			break;
		case 5:
			nomImagenMenu = "el mamado Wheatley";
			break;
		default:
			nomImagenMenu = "el invencible The Rock";
			break;
		}
		return nomImagenMenu;
	}
}
