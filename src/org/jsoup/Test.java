package org.jsoup;

import java.awt.EventQueue;

import org.jsoup.helper.HttpConnection;
import org.jsoup.HttpStatusException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JPanel;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jdesktop.*;
import org.jdesktop.xswingx.PromptSupport;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

public class Test implements ActionListener {

	private JButton btnNewButton;
	private JButton button;
	public JTextField txtFirstMatchid;
	public JTextField txtLastMatchid;
	private JLabel ESLlogo;
	private JFrame frame_1;
	private JLabel ebotLogo;
	public JFileChooser path;
	private JTextField teamName;
	private JComboBox comboBox;
	URI uri;

	public Test() throws URISyntaxException {
		frame_1 = new JFrame("eBot Analysis for ESL by jojA");
		frame_1.setBounds(125, 100, 400, 400);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);

		String comboBoxListe[] = { "ESL Meisterschaft", "ESL One Cologne", };
		comboBox = new JComboBox(comboBoxListe);
		comboBox.setBounds(100, 77, 172, 20);
		frame_1.getContentPane().add(comboBox);
		if (comboBox.getSelectedIndex() == 0) {
			uri = new URI("http://live.csgo-emsone.com/matchs/archived/1");
		}
		if (comboBox.getSelectedIndex() == 1) {
			uri = new URI("http://estats.ebot.wedeho.be/matchs/archived/1");
		}

		btnNewButton = new JButton();
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setSize(162, 25);
		btnNewButton.setLocation(104, 108);
		btnNewButton
				.setText("<HTML><FONT color=\"#000099\"><U>MatchID's can be found here</U></FONT></HTML>");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setToolTipText(uri.toString());

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (comboBox.getSelectedIndex() == 0) {
					try {
						uri = new URI(
								"http://live.csgo-emsone.com/matchs/archived/1");
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (comboBox.getSelectedIndex() == 1) {
					try {
						uri = new URI(
								"http://estats.ebot.wedeho.be/matchs/archived/1");
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				openWebpage(uri);

			}
		});
		frame_1.getContentPane().add(btnNewButton);

		ebotLogo = new JLabel("");
		ebotLogo.setIcon(new ImageIcon(Test.class
				.getResource("/org/jsoup/ebot_logo_edit.png")));
		ebotLogo.setBounds(198, 11, 178, 55);
		frame_1.getContentPane().add(ebotLogo);

		txtFirstMatchid = new JTextField();
		txtFirstMatchid.setText("");
		txtFirstMatchid.setToolTipText("First MatchID");
		txtFirstMatchid.setBounds(70, 144, 86, 20);
		txtFirstMatchid.setColumns(10);
		txtFirstMatchid.setCaret(new HighlightCaret());

		PromptSupport.setPrompt("First MatchID", txtFirstMatchid);
		frame_1.getContentPane().add(txtFirstMatchid);

		txtLastMatchid = new JTextField();
		txtLastMatchid.setText("");
		txtLastMatchid.setToolTipText("Last MatchID");
		txtLastMatchid.setColumns(10);
		txtLastMatchid.setBounds(216, 144, 86, 20);
		txtLastMatchid.setCaret(new HighlightCaret());
		PromptSupport.setPrompt("Last MatchID", txtLastMatchid);
		frame_1.getContentPane().add(txtLastMatchid);

		teamName = new JTextField();
		teamName.setText("");
		teamName.setToolTipText("");
		teamName.setColumns(10);
		teamName.setBounds(154, 175, 148, 20);
		teamName.setCaret(new HighlightCaret());
		PromptSupport.setPrompt("Either upper or lower case", teamName);
		frame_1.getContentPane().add(teamName);

		// Button anlegen
		this.button = new JButton("Parse");
		button.setBounds(136, 224, 89, 23);

		// Eventhandler für Button zuweisen
		this.button.addActionListener(this);

		// Button der Frame hinzufügen
		frame_1.getContentPane().add(this.button);

		// Fenster zentrieren
		/*
		 * frame.setSize(350,150); frame.setLocationRelativeTo(null);
		 */

		// Fenster sichbar machen
		frame_1.setVisible(true);
		frame_1.getContentPane().add(button);

		// Array für unsere JComboBox

		ESLlogo = new JLabel("");
		ESLlogo.setIcon(new ImageIcon(Test.class
				.getResource("/org/jsoup/esl logo_edit.png")));
		ESLlogo.setHorizontalAlignment(SwingConstants.CENTER);
		ESLlogo.setBounds(10, 11, 178, 55);
		frame_1.getContentPane().add(ESLlogo);

		JLabel lblTeamFilter = new JLabel("Team Filter:");
		lblTeamFilter.setBounds(70, 180, 69, 14);
		frame_1.getContentPane().add(lblTeamFilter);
		
		JLabel lblEslLog = new JLabel("ESL Logo: Copyright Copyright Turtle Entertainment GmbH 2011");
		lblEslLog.setBounds(10, 270, 360, 20);
		frame_1.getContentPane().add(lblEslLog);
		
		JLabel lblEbotLogo = new JLabel("eBot Logo and Data: Copyright to deStrO, esports-tools.net");
		lblEbotLogo.setBounds(10, 301, 360, 20);
		frame_1.getContentPane().add(lblEbotLogo);

		frame_1.setVisible(true);

	}

	public static void main(String[] args) throws URISyntaxException {
		new Test();
	}

	private void parseAndOutput() throws IOException, FileNotFoundException,
			URISyntaxException {

		JFileChooser fileChooser = new JFileChooser(".");
		FileFilter filter1 = new ExtensionFileFilter(".doc",
				new String[] { "doc" });
		fileChooser.setFileFilter(filter1);
		int status = fileChooser.showSaveDialog(null);
		File selectedFile = fileChooser.getSelectedFile();
		selectedFile.setReadable(true);
		if (status == JFileChooser.APPROVE_OPTION) {
			System.out.println(selectedFile.getParent());
			System.out.println(selectedFile.getName());
		} else if (status == JFileChooser.CANCEL_OPTION) {
			System.out.println(JFileChooser.CANCEL_OPTION);
		}
		try {
			PrintStream output = new PrintStream(new File(
					fileChooser.getCurrentDirectory() + "/"
							+ selectedFile.getName() + ".doc"));
			System.setOut(output);

		} catch (FileNotFoundException fx) {
			System.out.println(fx);
		}

		int firstmatchid = Integer.parseInt(txtFirstMatchid.getText());
		int lastmatchid = Integer.parseInt(txtLastMatchid.getText());
		for (int i = firstmatchid; i <= lastmatchid; i++) {

			if (comboBox.getSelectedIndex() == 0) {
				String url = "http://csgolive.eslproseries.de/matchs/view/" + i
						+ "#stats-players";
				Connection connection1 = Jsoup.connect(url);
				try {
					Document doc = connection1.get();

					for (Element table : doc.select("table[id=tablePlayers]")) {
						for (int f = 1; f < 11; f++) {
							Element row2 = table.select("tr").get(f);
							Elements tds2 = row2.select("td:not([rowspan])");
							if (tds2.get(0).text().toLowerCase()
									.contains(teamName.getText())
									|| tds2.get(0).text()
											.contains(teamName.getText()) || teamName.getText() == "") {

								String MatchID = doc.select("h4").text();
								if (f == 1) {
									System.out.println("\n\n" + "Spiel: "
											+ MatchID + "\n\n");
								}
								int vsTwo = Integer.parseInt(tds2.get(13)
										.text());
								int vsThree = Integer.parseInt(tds2.get(14)
										.text());
								int vsFour = Integer.parseInt(tds2.get(15)
										.text());
								int vsFive = Integer.parseInt(tds2.get(16)
										.text());
								int fourKills = Integer.parseInt(tds2.get(20)
										.text());
								int fiveKills = Integer.parseInt(tds2.get(21)
										.text());
								if (vsTwo > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v2 Clutch: "
											+ tds2.get(13).text());
								}
								if (vsThree > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v3 Clutch: "
											+ tds2.get(14).text());
								}
								if (vsFour > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v4 Clutch: "
											+ tds2.get(15).text());
								}
								if (vsFive > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v5 Clutch: "
											+ tds2.get(16).text());
								}
								if (fourKills > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text() + " 4 Kills: "
											+ tds2.get(20).text());
								}
								if (fiveKills > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text() + " 5 Kills: "
											+ tds2.get(21).text());
								} else {
								}
							}

						}
					}

				} catch (HttpStatusException e) {
					if (e.getStatusCode() == 404) {
					}
				}

			}
			if (comboBox.getSelectedIndex() == 1) {
				String url = "http://estats.ebot.wedeho.be/matchs/view/" + i
						+ "#stats-players";
				Connection connection1 = Jsoup.connect(url);
				try {
					Document doc = connection1.get();

					for (Element table : doc.select("table[id=tablePlayers]")) {
						for (int f = 1; f < 11; f++) {
							Element row2 = table.select("tr").get(f);
							Elements tds2 = row2.select("td:not([rowspan])");
							if (tds2.get(0).text().toLowerCase()
									.contains(teamName.getText())
									|| tds2.get(0).text()
											.contains(teamName.getText())) {
								String MatchID = doc.select("h4").text();
								if (f == 1) {
									System.out.println("\n\n" + "Spiel: "
											+ MatchID + "\n\n");
								}
								int vsTwo = Integer.parseInt(tds2.get(13)
										.text());
								int vsThree = Integer.parseInt(tds2.get(14)
										.text());
								int vsFour = Integer.parseInt(tds2.get(15)
										.text());
								int vsFive = Integer.parseInt(tds2.get(16)
										.text());
								int fourKills = Integer.parseInt(tds2.get(20)
										.text());
								int fiveKills = Integer.parseInt(tds2.get(21)
										.text());
								if (vsTwo > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v2 Clutch: "
											+ tds2.get(13).text());
								}
								if (vsThree > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v3 Clutch: "
											+ tds2.get(14).text());
								}
								if (vsFour > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v4 Clutch: "
											+ tds2.get(15).text());
								}
								if (vsFive > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text()
											+ " 1v5 Clutch: "
											+ tds2.get(16).text());
								}
								if (fourKills > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text() + " 4 Kills: "
											+ tds2.get(20).text());
								}
								if (fiveKills > 0) {
									System.out.println("Team: "
											+ tds2.get(0).text() + " Player: "
											+ tds2.get(1).text() + " 5 Kills: "
											+ tds2.get(21).text());
								} else {
								}
							}

						}
					}

				} catch (HttpStatusException e) {
					if (e.getStatusCode() == 404) {

					}
				}

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (button == e.getSource()) {
			try {
				parseAndOutput();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop()
				: null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void openWebpage(URL url) {
		try {
			openWebpage(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	class ExtensionFileFilter extends FileFilter {
		String description;

		String extensions[];

		public ExtensionFileFilter(String description, String extension) {
			this(description, new String[] { extension });
		}

		public ExtensionFileFilter(String description, String extensions[]) {
			if (description == null) {
				this.description = extensions[0];
			} else {
				this.description = description;
			}
			this.extensions = (String[]) extensions.clone();
			toLower(this.extensions);
		}

		private void toLower(String array[]) {
			for (int i = 0, n = array.length; i < n; i++) {
				array[i] = array[i].toLowerCase();
			}
		}

		public String getDescription() {
			return description;
		}

		public boolean accept(File file) {
			if (file.isDirectory()) {
				return true;
			} else {
				String path = file.getAbsolutePath().toLowerCase();
				for (int i = 0, n = extensions.length; i < n; i++) {
					String extension = extensions[i];
					if ((path.endsWith(extension) && (path.charAt(path.length()
							- extension.length() - 1)) == '.')) {
						return true;
					}
				}
			}
			return false;
		}
	}
}