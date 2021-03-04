package view;

import java.io.IOException;
import java.util.Scanner;

import controller.Controlles;

public class Mainz {
	
		public static void main(String[] args) throws IOException {
			Controlles Controller = new Controlles();
			String os = Controller.os();
			Scanner resp = new Scanner (System.in);
			int res = resp.nextInt();	
			int command = 35;
			String nome ="";
			do {		
				if (res == 0) {
				Controller.mostra(os);
				System.out.println("1 - matar por ID \n"
						+ "2 - matar por nome \n"
						+ "3 - sair");
				res = resp.nextInt();
				}
				if (res == 1) {
					System.out.println("digite o numero do ID");
					command = resp.nextInt();
				Controller.matapid(os,command);
				System.out.println("1 - matar por ID \n"
						+ "2 - matar por nome \n"
						+ "3 - sair");
				res = resp.nextInt();
				}
				else if (res == 2) {
				System.out.println("digite o nome do processo");
				nome = resp.next();
				Controller.matanome(os,nome);

				}
				res = resp.nextInt();
			}
			while (res != 3);
		}
	}
