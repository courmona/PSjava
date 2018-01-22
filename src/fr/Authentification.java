package fr;

import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
                while(!authentifier){
                    
			/*System.out.println("Entrez votre login msi:");
			login = sc.nextLine();
                        */
                        System.out.println("connecte");
			//System.out.println(login +" vient de se connecter ");
                        //ut.println(Emission.log);
                        //out.flush();
                        authentifier = true;

                        
                   }

			t2 = new Thread(new Chat_p2p(socket));
			t2.start();
			
		} catch (IOException e) {
			
			System.err.println("Machin ne répond pas !");
		}
        }

}

