package Utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import jade.gui.GuiEvent;
import test_gui.ImagePanel;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import DAO.Information;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UtilisateurGUI extends JFrame
{
	private ImagePanel contentPane;
	private UtilisateurAgent utilisateurAgent;

	private JTextArea textArea;
	private JScrollPane scrollPane;

	private final ButtonGroup carType = new ButtonGroup();
	private JPanel panel;
	private JTextField marque;
	private JTable table;
	
	public UtilisateurAgent getUtilisateurAgent() {
		return utilisateurAgent;
	}

	public void setUtilisateurAgent(UtilisateurAgent utilisateurAgent) {
		this.utilisateurAgent = utilisateurAgent;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UtilisateurGUI frame = new UtilisateurGUI();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	public UtilisateurGUI() {
		setTitle("Chercher des PCs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new ImagePanel();//new JPanel();
		contentPane.setBackground(new Color(250,243,221));
		contentPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 
	       
		/*panel = new JPanel();
		panel.setForeground(SystemColor.desktop);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Computers", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250,243,221));
		panel.setBounds(37, 25, 535, 82);
		contentPane.add(panel);

		JLabel lbltype = new JLabel("Type :");
		lbltype.setBounds(28, 52, 51, 20);
		lbltype.setHorizontalAlignment(SwingConstants.LEFT);
		lbltype.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel = new JLabel("PC Brand:");
		lblNewLabel.setBounds(28, 21, 151, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		marque = new JTextField();
		marque.setBounds(189, 18, 212, 26);
		marque.setFont(new Font("Tahoma", Font.BOLD, 16));
		marque.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Manual");
		rdbtnNewRadioButton.setBounds(189, 51, 99, 23);
		rdbtnNewRadioButton.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton.setSelected(true);
		type.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));

		JRadioButton rdbtnS = new JRadioButton("Automatique");
		rdbtnS.setBounds(284, 51, 144, 23);
		rdbtnS.setBackground(SystemColor.inactiveCaption);
		type.add(rdbtnS);
		rdbtnS.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.setLayout(null);
		panel.add(lbltype);
		panel.add(lblNewLabel);
		panel.add(marque);
		panel.add(rdbtnNewRadioButton);
		panel.add(rdbtnS);
		 */
		JButton btnEnvoyer = new JButton("Rechercher");
		btnEnvoyer.setForeground(SystemColor.menu);
		btnEnvoyer.setBackground(new Color(74,124,89));		
		btnEnvoyer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String marquee = marque.getText();
				String typee = getSelectedButtonText(carType);
				GuiEvent ev = new GuiEvent(this,1);
				ev.addParameter(marquee);
				ev.addParameter(typee);
				System.out.println("ev : "+ev);
				utilisateurAgent.onGuiEvent(ev);
			}
		});
		btnEnvoyer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnvoyer.setBounds(148, 482, 158, 32);
		contentPane.add(btnEnvoyer);
		
		/*scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 605, 150);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setTabSize(2);
		textArea.setBackground(new Color(250,243,221));
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));*/
		
		JButton btnViderLaListe = new JButton("Effacer");
		btnViderLaListe.setContentAreaFilled(true);
		btnViderLaListe.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DefaultTableModel newmodel = new DefaultTableModel(new Object[] {"Marque", "Model", "Type"},0);
				table.setModel(newmodel);
			}
		});
		btnViderLaListe.setForeground(SystemColor.menu);
		btnViderLaListe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViderLaListe.setBounds(386, 482, 158, 32);
		btnViderLaListe.setBackground(new Color(74,124,89));
		contentPane.add(btnViderLaListe);
		
		JPanel UserChoicePanel = new JPanel();
		UserChoicePanel.setBounds(94, 33, 500, 100);
		UserChoicePanel.setBackground(new Color(218,185,167));
		UserChoicePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Voitures", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(UserChoicePanel);
		UserChoicePanel.setLayout(null);
		
		JRadioButton rdbtnAuto = new JRadioButton("Automatic");
		rdbtnAuto.setFont(new Font("Georgia", Font.PLAIN, 10));
		rdbtnAuto.setBackground(new Color(218,185,167));
		rdbtnAuto.setBounds(351, 30, 103, 21);
		UserChoicePanel.add(rdbtnAuto);
		
		JRadioButton rdbtnManuelle = new JRadioButton("Manual");
		rdbtnManuelle.setFont(new Font("Georgia", Font.PLAIN, 10));
		rdbtnManuelle.setBackground(new Color(218,185,167));
		rdbtnManuelle.setBounds(351, 53, 103, 21);
		UserChoicePanel.add(rdbtnManuelle);
		
		carType.add(rdbtnAuto);
		carType.add(rdbtnManuelle);
		
		marque = new JTextField();
		marque.setBounds(40, 44, 276, 30);
		UserChoicePanel.add(marque);
		marque.setColumns(10);
		
		JLabel InputLabel = new JLabel("Marque de voiture :");
		InputLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
		InputLabel.setBounds(40, 19, 280, 21);
		UserChoicePanel.add(InputLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(94, 179, 500, 100);
		scrollPane_1.setOpaque(false);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setOpaque(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Marque", "Model", "Type"
			}
		));
		scrollPane_1.getViewport().add(table);
		
		this.setVisible(true);

	}

	public void showMessage(Information info)
	{
		
		// TODO: Ferdaous/Aymane, change this to show it in a table
		//textArea.append(info.getBrand() + " " + info.getModel() + "\n");
		
		System.out.println("show message : "+ info.getModel());
		
		DefaultTableModel oldmodel =( DefaultTableModel )table.getModel();
		
		oldmodel.addRow(new Object[] {info.getBrand() , info.getModel(), info.getType()});
		
		table.setModel(oldmodel);

	}
	public void showMessage(String message)
	{
		List<Information> infos = Information.StringToList(message);
		
		// TODO: Ferdaous/Aymane, change this to show it in a table
		//textArea.append(info.getBrand() + " " + info.getModel() + "\n");
		
		System.out.println("show message : "+ infos);
		
		DefaultTableModel oldmodel =( DefaultTableModel )table.getModel();
		
		for (Information s : infos) {
			  Object[] o = new Object[3];
			  o[0] = s.getBrand();
			  o[1] = s.getModel();
			  o[2] = s.getType();

			  oldmodel.addRow(o);
			}
		
		table.setModel(oldmodel);

	}

	String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	public void showNotFound() {
		JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Aucun resultat n'est trouve", "Information", JOptionPane.INFORMATION_MESSAGE);
         
	}
}
