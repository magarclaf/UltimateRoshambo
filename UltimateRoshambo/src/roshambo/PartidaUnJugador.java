package roshambo;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PartidaUnJugador extends JFrame{
	private JLayeredPane layeredPanel;
	private JPanel empezarUR;
	private JPanel elegirCartaUR;
	private JPanel resultadosUR;
	private JPanel terminarUR;
	private JButton[] listaCartas;
	private int[] listavaloresCartas;
	private int[] listaMultiplicadores;
	private static int seleccion1;
	private int seleccion2;
	private static String nombre;
	private String nombre2;
	private int vida1;
	private int vida2;
	private boolean habilidadUsada1;
	private boolean habilidadUsada2;
	private int valorJugada1;
	private boolean ganador;
	private JButton btnPiedra1;
	private JButton btnPapel1;
	private JButton btnTijeras1;
	private JButton btnPiedra2;
	private JButton btnPapel2;
	private JButton btnTijeras2;
	private JLabel lblInformacion;
	private JLabel lblIconoJugador_1;
	private JLabel lblIconoCpu_1;
	private JLabel lblJugadorJugando_1;
	private JLabel lblCpuJugando_1;
	private JLabel lblLadoJugador1;
	private JLabel lblLadoJugador2;
	private JLabel lblEstrellas1;
	private JLabel lblEstrellas2;
	private JLabel lblEstrellas3;
	private JLabel lblEstrellas4;
	private JLabel lblEstrellas5;
	private JLabel lblEstrellas6;
	private JLabel lblvida1_1;
	private JLabel lblvida12_1;
	private JLabel lblvida1_1_1;
	private JLabel lblvida2; 
	private JLabel lblGanadorR;
	private JLabel lblCarta1;
	private JLabel lblCarta2;
	private JLabel lblIconoJugador_1_1;
	private JLabel lblIconoCpu_1_1;
	private JLabel lblJugadorJugando_1_1;
	private JLabel lblCpuJugando_1_1;
	
	
	public PartidaUnJugador(String nombre, int seleccion1) {
		listaCartas = new JButton[6];
		listavaloresCartas = new int[6];
		listaMultiplicadores = new int[6];
		vida1=100;
		vida2=100;
		habilidadUsada1=false;
		habilidadUsada2=false;
		ganador=false;
		PartidaUnJugador.nombre=nombre;
		nombre2="CPU";
		PartidaUnJugador.seleccion1=seleccion1;
		getContentPane().setLayout(null);
		setResizable(false);
		
		layeredPanel = new JLayeredPane();
		layeredPanel.setBackground(new Color(255, 228, 181));
		layeredPanel.setForeground(Color.WHITE);
		layeredPanel.setBounds(0, 0, 816, 633);
		getContentPane().add(layeredPanel);
		layeredPanel.setLayout(null);
		
		resultadosUR = new JPanel();
		resultadosUR.setVisible(false);
		
		terminarUR = new JPanel();
		terminarUR.setVisible(false);
		
		elegirCartaUR = new JPanel();
		elegirCartaUR.setVisible(false);
		

		elegirCartaUR.setLayout(null);
		elegirCartaUR.setBackground(SystemColor.activeCaption);
		elegirCartaUR.setBounds(0, 0, 758, 565);
		layeredPanel.add(elegirCartaUR);
		
		lblIconoJugador_1 = new JLabel("");
		lblIconoJugador_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/therock-resizeM.png")));
		lblIconoJugador_1.setBounds(10, 10, 127, 127);
		elegirCartaUR.add(lblIconoJugador_1);
		
		lblIconoCpu_1 = new JLabel("");
		lblIconoCpu_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/gangan-resizeM.png")));
		lblIconoCpu_1.setBounds(618, 423, 127, 127);
		elegirCartaUR.add(lblIconoCpu_1);
		
		lblJugadorJugando_1 = new JLabel("Jugador jugando con The Rock");
		lblJugadorJugando_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorJugando_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblJugadorJugando_1.setBounds(144, 29, 601, 33);
		elegirCartaUR.add(lblJugadorJugando_1);
		
		lblCpuJugando_1 = new JLabel("CPU jugando con Gangan");
		lblCpuJugando_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuJugando_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpuJugando_1.setBounds(10, 444, 601, 33);
		elegirCartaUR.add(lblCpuJugando_1);
		
		lblvida1_1 = new JLabel("Vida: 100");
		lblvida1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblvida1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblvida1_1.setBounds(147, 72, 598, 41);
		elegirCartaUR.add(lblvida1_1);
		
		lblvida12_1 = new JLabel("Vida: 100");
		lblvida12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblvida12_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblvida12_1.setBounds(10, 487, 598, 41);
		elegirCartaUR.add(lblvida12_1);
		
		lblInformacion = new JLabel("Elige una carta:");
		lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInformacion.setBounds(10, 136, 735, 41);
		elegirCartaUR.add(lblInformacion);
		
		btnPiedra1 = new JButton("");
		btnPiedra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cartaCPU=eleccionRandomCartaCPU();
				lblCarta1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlC(0))));
				lblCarta2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlC(cartaCPU))));
				if (cartaCPU == 3) {
					//empate
					lblGanadorR.setText("Empate. La partida sigue.");
				} else {
					
					if (cartaCPU == 4) {
						ganador=false;
						valorJugada1=listavaloresCartas[4]*listaMultiplicadores[4];
						vida1-=valorJugada1;
						lblvida1_1.setText("Vida: "+vida1);
						lblvida1_1_1.setText("Vida: "+vida1);
						lblGanadorR.setText("Ganador: CPU");
					} else {
						ganador=true;
						valorJugada1=listavaloresCartas[0]*listaMultiplicadores[0];
						vida2-=valorJugada1;
						lblvida12_1.setText("Vida: "+vida2);
						lblvida2.setText("Vida: "+vida2);
						lblGanadorR.setText("Ganador: "+nombre);
					}
					
				}
				switchPanels(resultadosUR);
			}

		});
		btnPiedra1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/piedra.png")));
		btnPiedra1.setBounds(10, 200, 106, 148);
		elegirCartaUR.add(btnPiedra1);
		
		btnPapel1 = new JButton("");
		btnPapel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cartaCPU=eleccionRandomCartaCPU();
				lblCarta1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlC(1))));
				lblCarta2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlC(cartaCPU))));
				if (cartaCPU == 3) {
					
					ganador=true;
					valorJugada1=listavaloresCartas[1]*listaMultiplicadores[1];
					vida2-=valorJugada1;
					lblvida12_1.setText("Vida: "+vida2);
					lblvida2.setText("Vida: "+vida2);
					lblGanadorR.setText("Ganador: "+nombre);
				} else {
					if (cartaCPU == 4) {
						//empate
						lblGanadorR.setText("Empate. La partida sigue.");
						
					} else {
						ganador=false;
						valorJugada1=listavaloresCartas[4]*listaMultiplicadores[4];
						vida1-=valorJugada1;
						lblvida1_1.setText("Vida: "+vida1);
						lblvida1_1_1.setText("Vida: "+vida1);
						lblGanadorR.setText("Ganador: CPU");
					}
					
				}
				switchPanels(resultadosUR);
			}
		});
		btnPapel1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/papel.png")));
		btnPapel1.setBounds(120, 200, 106, 148);
		elegirCartaUR.add(btnPapel1);
		
		btnTijeras1 = new JButton("");
		btnTijeras1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/tijeras.png")));
		btnTijeras1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cartaCPU=eleccionRandomCartaCPU();
				lblCarta1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlC(2))));
				lblCarta2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlC(cartaCPU))));
				if (cartaCPU == 3) {
					ganador=false;
					valorJugada1=listavaloresCartas[4]*listaMultiplicadores[4];
					vida1-=valorJugada1;
					lblvida1_1.setText("Vida: "+vida1);
					lblvida1_1_1.setText("Vida: "+vida1);
					lblGanadorR.setText("Ganador: CPU");
					
				} else {
					if (cartaCPU == 4) {
						ganador=true;
						valorJugada1=listavaloresCartas[2]*listaMultiplicadores[2];
						vida2-=valorJugada1;
						lblvida12_1.setText("Vida: "+vida2);
						lblvida2.setText("Vida: "+vida2);
						lblGanadorR.setText("Ganador: "+nombre);
						
						
					} else {
						
						//empate
						lblGanadorR.setText("Empate. La partida sigue.");
					}
					
				}	
				switchPanels(resultadosUR);
			}
		});
		btnTijeras1.setBounds(230, 200, 106, 148);
		elegirCartaUR.add(btnTijeras1);
		
		btnPiedra2 = new JButton("");
		btnPiedra2.setFocusable(false);
		btnPiedra2.setEnabled(false);
		btnPiedra2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/piedra.png")));
		btnPiedra2.setBounds(419, 200, 106, 148);
		elegirCartaUR.add(btnPiedra2);
		
		btnPapel2 = new JButton("");
		btnPapel2.setFocusable(false);
		btnPapel2.setEnabled(false);
		btnPapel2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/papel.png")));
		btnPapel2.setBounds(529, 200, 106, 148);
		elegirCartaUR.add(btnPapel2);
		
		btnTijeras2 = new JButton("");
		btnTijeras2.setFocusable(false);
		btnTijeras2.setEnabled(false);
		btnTijeras2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/tijeras.png")));
		btnTijeras2.setBounds(639, 200, 106, 148);
		elegirCartaUR.add(btnTijeras2);
		
		JLabel lblVS = new JLabel("VS.");
		lblVS.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblVS.setHorizontalAlignment(SwingConstants.CENTER);
		lblVS.setBounds(336, 200, 83, 148);
		elegirCartaUR.add(lblVS);
		
		JLabel lblEstrellas = new JLabel("ESTRELLAS");
		lblEstrellas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas.setBounds(10, 358, 735, 41);
		elegirCartaUR.add(lblEstrellas);
		
		lblEstrellas1 = new JLabel("1");
		lblEstrellas1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas1.setBounds(36, 358, 56, 41);
		elegirCartaUR.add(lblEstrellas1);
		
		lblEstrellas2 = new JLabel("1");
		lblEstrellas2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas2.setBounds(147, 358, 56, 41);
		elegirCartaUR.add(lblEstrellas2);
		
		lblEstrellas3 = new JLabel("1");
		lblEstrellas3.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas3.setBounds(257, 358, 56, 41);
		elegirCartaUR.add(lblEstrellas3);
		
		lblEstrellas4 = new JLabel("1");
		lblEstrellas4.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas4.setBounds(443, 358, 56, 41);
		elegirCartaUR.add(lblEstrellas4);
		
		lblEstrellas5 = new JLabel("1");
		lblEstrellas5.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas5.setBounds(554, 358, 56, 41);
		elegirCartaUR.add(lblEstrellas5);
		
		lblEstrellas6 = new JLabel("1");
		lblEstrellas6.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstrellas6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstrellas6.setBounds(664, 358, 56, 41);
		elegirCartaUR.add(lblEstrellas6);
		
		lblLadoJugador1 = new JLabel(nombre);
		lblLadoJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLadoJugador1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLadoJugador1.setBounds(10, 171, 326, 19);
		elegirCartaUR.add(lblLadoJugador1);
		
		lblLadoJugador2 = new JLabel(nombre2);
		lblLadoJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLadoJugador2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLadoJugador2.setBounds(419, 173, 326, 17);
		elegirCartaUR.add(lblLadoJugador2);
		terminarUR.setLayout(null);
		terminarUR.setBackground(SystemColor.activeCaption);
		terminarUR.setBounds(0, 0, 758, 565);
		layeredPanel.add(terminarUR);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreHP = "";
				if(vida1<=0 && (seleccion1==2 || seleccion1==4)) {
					ejecutarPasivas(nombre,seleccion1,habilidadUsada1,1);
					nombreHP=nombre;
				}
				if(vida2<=0 && (seleccion2==2 || seleccion2==4)) {
					ejecutarPasivas(nombre2,seleccion2,habilidadUsada2,2);
					nombreHP=nombre2;
				}
				File f=new File("src/img/historialUR.txt");
				try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f,true))){
					String result;				
					if (vida2<=0) {
						result = "Resultado: " + vida1 + "-" + 0 + " - " + nombre + " has ganado contra " + nombre2;
						JOptionPane.showMessageDialog(null, result);
						
					} else if (vida1<=0){
						result = "Resultado: " + 0 + "-" + vida2 + " - " + nombre + " has perdido contra " + nombre2;
						JOptionPane.showMessageDialog(null, result);
					} else {
						result = "Resultado: " + 0 + "-" + 0 + " - " + nombre + " has empatado contra " + nombre2 + " porque "+ nombreHP + " ha usado Comeback.";
						JOptionPane.showMessageDialog(null, result);
					}
					dos.writeBytes(result+"\r\n");
					vida1=100;vida2=100;
					dispose();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTerminar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTerminar.setBounds(217, 228, 296, 90);
		terminarUR.add(btnTerminar);
		resultadosUR.setLayout(null);
		resultadosUR.setBackground(SystemColor.activeCaption);
		resultadosUR.setBounds(0, 0, 758, 565);
		layeredPanel.add(resultadosUR);
		
		lblIconoJugador_1_1 = new JLabel("");
		lblIconoJugador_1_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/therock-resizeM.png")));
		lblIconoJugador_1_1.setBounds(10, 10, 127, 127);
		resultadosUR.add(lblIconoJugador_1_1);
		
		lblIconoCpu_1_1 = new JLabel("");
		lblIconoCpu_1_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/gangan-resizeM.png")));
		lblIconoCpu_1_1.setBounds(618, 423, 127, 127);
		resultadosUR.add(lblIconoCpu_1_1);
		
		lblJugadorJugando_1_1 = new JLabel(nombre+ " jugando con The Rock");
		lblJugadorJugando_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorJugando_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblJugadorJugando_1_1.setBounds(144, 29, 601, 33);
		resultadosUR.add(lblJugadorJugando_1_1);
		
		lblCpuJugando_1_1 = new JLabel(nombre2+" jugando con Gangan");
		lblCpuJugando_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuJugando_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpuJugando_1_1.setBounds(10, 444, 601, 33);
		resultadosUR.add(lblCpuJugando_1_1);
		
		lblvida1_1_1 = new JLabel("Vida: 100");
		lblvida1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblvida1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblvida1_1_1.setBounds(147, 72, 598, 41);
		resultadosUR.add(lblvida1_1_1);
		
		lblvida2 = new JLabel("Vida: 100");
		lblvida2.setHorizontalAlignment(SwingConstants.CENTER);
		lblvida2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblvida2.setBounds(10, 487, 598, 41);
		resultadosUR.add(lblvida2);
		
		lblCarta1 = new JLabel("");
		lblCarta1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/papel.png")));
		lblCarta1.setBounds(86, 213, 86, 128);
		resultadosUR.add(lblCarta1);
		
		lblCarta2 = new JLabel("");
		lblCarta2.setIcon(new ImageIcon(PartidaUnJugador.class.getResource("/img/tijeras.png")));
		lblCarta2.setBounds(273, 213, 86, 128);
		resultadosUR.add(lblCarta2);
		
		JLabel lblNewLabel = new JLabel("vs.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 213, 104, 128);
		resultadosUR.add(lblNewLabel);
		
		JLabel lbljugadorR1 = new JLabel(nombre);
		lbljugadorR1.setHorizontalAlignment(SwingConstants.CENTER);
		lbljugadorR1.setBounds(44, 190, 169, 13);
		resultadosUR.add(lbljugadorR1);
		
		JLabel lbljugadorR2 = new JLabel(nombre2);
		lbljugadorR2.setHorizontalAlignment(SwingConstants.CENTER);
		lbljugadorR2.setBounds(232, 190, 169, 13);
		resultadosUR.add(lbljugadorR2);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vida1<=0 || vida2<=0) {
					switchPanels(terminarUR);
				}else {
					cambiarMultiplicador();
					switchPanels(elegirCartaUR);
				}
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnContinuar.setBounds(460, 300, 193, 41);
		resultadosUR.add(btnContinuar);
		
		lblGanadorR = new JLabel("Ganador: ");
		lblGanadorR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGanadorR.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanadorR.setBounds(369, 231, 376, 33);
		resultadosUR.add(lblGanadorR);
		
		empezarUR = new JPanel();
		empezarUR.setBackground(SystemColor.activeCaption);
		empezarUR.setBounds(0, 0, 758, 565);
		layeredPanel.add(empezarUR);
		empezarUR.setLayout(null);
		
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meterCartasEnLista();
				seleccion2=eleccionRandomJugadorCPU();
				if(seleccion1==1 || seleccion1==3 || seleccion1==5) {
					ejecutarPasivas(nombre,seleccion1,habilidadUsada1,1);
				}
				if(seleccion2==1 || seleccion2==3 || seleccion2==5) {
					ejecutarPasivas(nombre2,seleccion2,habilidadUsada2,2);
				}
				switchPanels(elegirCartaUR);
				valoresCartas(seleccion1,seleccion2);
				cambiarMultiplicador();
				diseñoElegirCarta();
				diseñoResultado();
			}


		});
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEmpezar.setBounds(217, 228, 296, 90);
		empezarUR.add(btnEmpezar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 600);
		
		
		
		
	}
	
	private void valoresCartas(int seleccion, int seleccion2) {
		// TODO Auto-generated method stub
		listavaloresCartas = new int[6];
		int piedra1, piedra2, papel1, papel2, tijeras1, tijeras2;
		switch(seleccion1) {
		case 1:
			piedra1=5;
			papel1=1;
			tijeras1=3;
			break;
		case 2:
			piedra1=2;
			papel1=2;
			tijeras1=5;
			break;
		case 3:
			piedra1=3;
			papel1=5;
			tijeras1=1;
			break;
		case 4:
			piedra1=4;
			papel1=3;
			tijeras1=2;
			break;
		case 5:
			piedra1=3;
			papel1=3;
			tijeras1=3;
			break;
		default:
			piedra1=1;
			papel1=1;
			tijeras1=1;
			break;
		}
		switch(seleccion2) {
		case 1:
			piedra2=5;
			papel2=1;
			tijeras2=3;
			break;
		case 2:
			piedra2=2;
			papel2=2;
			tijeras2=5;
			break;
		case 3:
			piedra2=3;
			papel2=5;
			tijeras2=1;
			break;
		case 4:
			piedra2=4;
			papel2=3;
			tijeras2=2;
			break;
		case 5:
			piedra2=3;
			papel2=3;
			tijeras2=3;
			break;
		default:
			piedra2=1;
			papel2=1;
			tijeras2=1;
			break;
		}
		listavaloresCartas[0]=piedra1;
		listavaloresCartas[1]=papel1;
		listavaloresCartas[2]=tijeras1;
		listavaloresCartas[3]=piedra2;
		listavaloresCartas[4]=papel2;
		listavaloresCartas[5]=tijeras2;
		
	}
	
	private void cambiarMultiplicador() {
		// TODO Auto-generated method stub
		double random;
		for (int i = 0; i < 6; i++) {
			random = Math.random();// generamos un numero al azar entre 0 y 1
			if (random < 0.2)// Blanco (1/5%)
			{
				listaMultiplicadores[i] = 2;// golpe x2
				listaCartas[i].setBackground(Color.WHITE);
			}

			else {
				if (random < 0.4)// Azul (1/5%)
				{
					listaMultiplicadores[i] = 4;// golpe x4
					listaCartas[i].setBackground(Color.BLUE);
				} else {
					if (random < 0.6)// Verde (1/5%)
					{
						listaMultiplicadores[i] = 6;//golpe x6
						listaCartas[i].setBackground(Color.GREEN);
					} // golpe x6
					else {
						if (random < 0.8) { // Rojo (1/5%)
							listaMultiplicadores[i] = 8;// golpe x8
							listaCartas[i].setBackground(Color.RED);
						} else { // Dorado (1/5%)
							listaMultiplicadores[i] = 10;// golpe x10
							listaCartas[i].setBackground(Color.YELLOW);
						}
					}
				}

			}
		}

	}
	
	private int eleccionRandomJugadorCPU() {
		double random = Math.random();// generamos un numero al azar entre 0 y 1
		if (random < 0.2)
		{
			seleccion2=1;
		}

		else {
			if (random < 0.4)
			{
				seleccion2=2;
			} else {
				if (random < 0.6)
				{
					seleccion2=3;
				} 
				else {
					if (random < 0.8) { 
						seleccion2=4;
					} else { 
						seleccion2=5;
					}
				}
			}

		}
		
		return seleccion2;
	}
	
	private int eleccionRandomCartaCPU() {
		double random = Math.random();// generamos un numero al azar entre 0 y 1
		if (random < 0.33)
		{
			seleccion2=3;
		}

		else {
			if (random < 0.66)
			{
				seleccion2=4;
			} else {
					seleccion2=5;
				

		}
			}
		
		return seleccion2;
	}
	
	private void meterCartasEnLista() {
		// TODO Auto-generated method stub
		listaCartas[0]=btnPiedra1;
		listaCartas[1]=btnPapel1;
		listaCartas[2]=btnTijeras1;
		listaCartas[3]=btnPiedra2;
		listaCartas[4]=btnPapel2;
		listaCartas[5]=btnTijeras2;
	}
	
	private void ejecutarPasivas(String nombre,int seleccion1, boolean habilidad, int i) {
		// TODO Auto-generated method stub
		double random = Math.random();// generamos un numero al azar entre 0 y 1
		
		switch(seleccion1) {
		//Initiative
		case 1:
		case 3:
		case 5:
			if(random<0.8 && !habilidad) {
				if(i==1) {
					vida2-=20;
					lblvida12_1.setText("Vida: "+vida2);
					lblvida2.setText("Vida: "+vida2);
					habilidadUsada1=true;
				}else {
					vida1-=20;
					lblvida1_1.setText("Vida: "+vida1);
					lblvida1_1_1.setText("Vida: "+vida1);
					habilidadUsada2=true;
				}
				lblInformacion.setText(nombre+" ha usado Initiative. Elige una carta:");
				
			}
			break;
		//Comeback
		case 2:
		case 4:
			if(random<0.5 && !habilidad) {
				if(i==1) {
					vida1=1;
					vida2=1;
					habilidadUsada1=true;
				}else {
					vida2=1;
					vida1=1;
					habilidadUsada2=true;
				}
				
			}
			break;
		default:
			break;
		}

	}
	
	private void diseñoElegirCarta() {
		// TODO Auto-generated method stub
		String urlJ1=urlJ(seleccion1);
		String urlJ2=urlJ(this.seleccion2);
		String nombreJ1=nombre;
		String nombreJ2=this.nombre2;
		lblIconoJugador_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlJ1)));
		lblIconoCpu_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlJ2)));
		lblJugadorJugando_1.setText(nombreJ1+" jugando con "+nombreLuchador(seleccion1));
		lblCpuJugando_1.setText(nombreJ2+" jugando con "+nombreLuchador(this.seleccion2));
		lblLadoJugador1.setText(nombreJ1);
		lblLadoJugador2.setText(nombreJ2);
		lblEstrellas1.setText(""+listavaloresCartas[0]);
		lblEstrellas2.setText(""+listavaloresCartas[1]);
		lblEstrellas3.setText(""+listavaloresCartas[2]);
		lblEstrellas4.setText(""+listavaloresCartas[3]);
		lblEstrellas5.setText(""+listavaloresCartas[4]);
		lblEstrellas6.setText(""+listavaloresCartas[5]);
		
	}
	

	private void diseñoResultado() {
		// TODO Auto-generated method stub
		String urlJ1=urlJ(seleccion1);
		String urlJ2=urlJ(this.seleccion2);
		lblIconoJugador_1_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlJ1)));
		lblIconoCpu_1_1.setIcon(new ImageIcon(PartidaUnJugador.class.getResource(urlJ2)));
		lblJugadorJugando_1_1.setText(nombre+" jugando con "+nombreLuchador(seleccion1));
		lblCpuJugando_1_1.setText(nombre2+" jugando con "+nombreLuchador(seleccion2));
	}
	
	private String urlC(int seleccion) {
		// TODO Auto-generated method stub
		String url;
		switch(seleccion) {
		case 0:
			url="/img/piedra.png";
			break;
		case 1:
			url="/img/papel.png";
			break;
		case 2:
			url="/img/tijeras.png";
			break;
		case 3:
			url="/img/piedra.png";
			break;
		case 4:
			url="/img/papel.png";
			break;
		case 5:
			url="/img/tijeras.png";
			break;
		default:
			url="/img/piedra.png";
			break;
		}
		return url;
	}
	
	private String urlJ(int seleccion) {
		// TODO Auto-generated method stub
		String url;
		switch(seleccion) {
		case 1:
			url="/img/therock-resizeM.png";
			break;
		case 2:
			url="/img/gangan-resizeM.png";
			break;
		case 3:
			url="/img/mapa-resizeM.png";
			break;
		case 4:
			url="/img/nugget-resizeM.png";
			break;
		case 5:
			url="/img/wheatley-resizeM.png";
			break;
		default:
			url="/img/therock-resizeM.png";
			break;
		}
		return url;
	}

	private String nombreLuchador(int seleccion) {
		// TODO Auto-generated method stub
		String nom;
		switch(seleccion) {
		case 1:
			nom="The Rock";
			break;
		case 2:
			nom="Gangan";
			break;
		case 3:
			nom="El mapa";
			break;
		case 4:
			nom="Nugget";
			break;
		case 5:
			nom="Wheatley";
			break;
		default:
			nom="The Rock";
			break;
		}
		return nom;
	}
	

	public void switchPanels(JPanel jp) {

		jp.setVisible(true);
		layeredPanel.removeAll();
		layeredPanel.add(jp);
		layeredPanel.repaint();
		layeredPanel.revalidate();

	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidaUnJugador frame = new PartidaUnJugador(nombre,seleccion1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
