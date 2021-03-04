package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controlles {

	public Controlles() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void mostra(String os) {
		if (os.equals("Windows 10")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					linha = buffer.readLine();
					System.out.println(linha);
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.equals("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					linha = buffer.readLine();
					System.out.println(linha);
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void matapid(String os, int jorge) throws IOException {
		if (os.equals("Windows 10")) {
			String cmdPid = "TASKKILL /PID";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try {
				pid = jorge;
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);

				Runtime.getRuntime().exec(buffer.toString());
			} catch (NumberFormatException e) {

			}
			mostra(buffer.toString());
		} else if (os.equals("Linux")) {
			String cmdPid = "kill -9";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try {
				pid = jorge;
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);

				Runtime.getRuntime().exec(buffer.toString());
			} catch (NumberFormatException e) {

			}
		}
	}

	public void matanome(String os, String nome) {
		if (os.equals("Windows 10")) {
			String cmdNome = "TASKKILL /IM";
			StringBuffer buffer = new StringBuffer();
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(nome);
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (Exception e) {

			}
		} else if (os.equals("Linux")) {
				String cmdNome = "pkill -f";
				StringBuffer buffer = new StringBuffer();
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(nome);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e) {

				}
			}
		}

	}
