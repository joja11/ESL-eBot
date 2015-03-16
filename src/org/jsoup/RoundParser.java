package org.jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.channels.SelectableChannel;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.jsoup.Test.ExtensionFileFilter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RoundParser {

	public static void main (String args[]) throws IOException, FileNotFoundException,
			URISyntaxException {

		/*JFileChooser fileChooser = new JFileChooser(".");
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
		}*/

		/*
		 * int firstmatchid = Integer.parseInt(txtFirstMatchid.getText()); int
		 * lastmatchid = Integer.parseInt(txtLastMatchid.getText());
		 */
		for (int i = 1527; i <= 1555; i++) {

			// if (comboBox.getSelectedIndex() == 0) {
			String url = "http://csgolive.eslproseries.de/matchs/view/" + i
					+ "#stats-match";
			Connection connection1 = Jsoup.connect(url);
			try {
				Document doc = connection1.get();
				for (Element table1 : doc.select("div[class=tab-content]")) {
				for (Element table : table1.select("table[border=0]")) {
					Elements els = table.select("tr");
					/*System.out.println(els.size());
					System.out.println(table);*/
					for (int f = 1; f < els.size()-1; f++) {
						Element row2 = table.select("tr").get(f);
						Elements tds2 = row2.select("td:not([rowspan])");
						System.out.println(tds2);
						//System.out.println(tds2.size());

						/*
						 * if (tds2.get(0).text().toLowerCase()
						 * .contains(teamName.getText()) || tds2.get(0).text()
						 * .contains(teamName.getText())) {
						 

						String MatchID = doc.select("h4").text();
						if (f == 1) {
							System.out.println("\n\n" + "Spiel: " + MatchID
									+ "\n\n");
						}
						int vsTwo = Integer.parseInt(tds2.get(13).text());
						int vsThree = Integer.parseInt(tds2.get(14).text());
						int vsFour = Integer.parseInt(tds2.get(15).text());
						int vsFive = Integer.parseInt(tds2.get(16).text());
						int fourKills = Integer.parseInt(tds2.get(20).text());
						int fiveKills = Integer.parseInt(tds2.get(21).text());
						if (vsTwo > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v2 Clutch: " + tds2.get(13).text());
						}
						if (vsThree > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v3 Clutch: " + tds2.get(14).text());
						}
						if (vsFour > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v4 Clutch: " + tds2.get(15).text());
						}
						if (vsFive > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v5 Clutch: " + tds2.get(16).text());
						}
						if (fourKills > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 4 Kills: " + tds2.get(20).text());
						}
						if (fiveKills > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 5 Kills: " + tds2.get(21).text());
						} else {
						}
					}*/
				}
				}
				}
				}
			

			catch (HttpStatusException e) {
				if (e.getStatusCode() == 404) {
				}

			}

			// if (comboBox.getSelectedIndex() == 1) {
			url = "http://estats.ebot.wedeho.be/matchs/view/" + i
					+ "#stats-players";
			connection1 = Jsoup.connect(url);
			try {
				Document doc = connection1.get();

				for (Element table : doc.select("table[id=tablePlayers]")) {
					for (int f = 1; f < 11; f++) {
						Element row2 = table.select("tr").get(f);
						Elements tds2 = row2.select("td:not([rowspan])");
						/*
						 * if (tds2.get(0).text().toLowerCase()
						 * .contains(teamName.getText()) || tds2.get(0).text()
						 * .contains(teamName.getText()) ) {
						 
						String MatchID = doc.select("h4").text();
						System.out.println("\n\n" + "Spiel: " + MatchID
								+ "\n\n");
						int vsTwo = Integer.parseInt(tds2.get(13).text());
						int vsThree = Integer.parseInt(tds2.get(14).text());
						int vsFour = Integer.parseInt(tds2.get(15).text());
						int vsFive = Integer.parseInt(tds2.get(16).text());
						int fourKills = Integer.parseInt(tds2.get(20).text());
						int fiveKills = Integer.parseInt(tds2.get(21).text());
						if (vsTwo > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v2 Clutch: " + tds2.get(13).text());
						}
						if (vsThree > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v3 Clutch: " + tds2.get(14).text());
						}
						if (vsFour > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v4 Clutch: " + tds2.get(15).text());
						}
						if (vsFive > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 1v5 Clutch: " + tds2.get(16).text());
						}
						if (fourKills > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 4 Kills: " + tds2.get(20).text());
						}
						if (fiveKills > 0) {
							System.out.println("Team: " + tds2.get(0).text()
									+ " Player: " + tds2.get(1).text()
									+ " 5 Kills: " + tds2.get(21).text());
						} else {
						}*/

					}
				}

			} catch (HttpStatusException e) {
				if (e.getStatusCode() == 404) {

				}
			}

		}
	}
}
