package fr;
import java.io.*;
import java.net.*;

public class Main {
 public static ServerSocket ss = null;
 public static Thread t,t1;
 public static Socket socket = null;
 private static String adresse = "192.168.1.55";

 
	public static void main(String[] args) {
            NetDrawClient client = new NetDrawClient("Discussion", 640, 480);
		
		try {
			ss = new ServerSocket(5555);
			System.out.println("On contacte "+adresse+":"+ss.getLocalPort());
			
			t = new Thread(new Accepter_connexion(ss));
			t.start();
			
		} catch (IOException e) {
			System.err.println("Le port "+ss.getLocalPort()+" est déjà utilisé !");
		}
                try {

                        System.out.println("Demande de connexion");
                        socket = new Socket(adresse,5555);
                        System.out.println("Connexion établie avec "+adresse+", authentification :"); // Si le message s'affiche c'est que je suis connecté

                        t1 = new Thread(new Authentification(socket));
                        t1.start();
                } 
                
                 catch (IOException e) {
                  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
                }
                /*catch (UnknownHostException e) {
                  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
                }*/
	
	}

	
	}
