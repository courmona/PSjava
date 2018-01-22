package fr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
    public static String log = "MSI";
	
	public Emission(PrintWriter out) {
		this.out = out;
	}

	
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				out.println("["+NetDrawClient.horodatage()+"]"+" < "+log+" > : "+message+"\n");
                NetDrawClient.msgTextArea.append("["+NetDrawClient.horodatage()+"]"+" < "+log+" > : "+message+"\n");
			    out.flush();
			  }
	}
}

