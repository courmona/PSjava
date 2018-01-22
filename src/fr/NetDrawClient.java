package fr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;


public class NetDrawClient extends JComponent {
    
    public NetDrawClient(String title, int width, int height) {
        
        frame = new JFrame(title);
        msgTextArea.setBackground(Color.white);
        msgTextArea.setEditable(false);
        msgTextArea.setLineWrap(true);
      
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(new JLabel(Emission.log));
        controlPanel.add(inputText);
        controlPanel.setBackground(Color.yellow);
        inputText.setEnabled(true);
      
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(msgTextArea, BorderLayout.CENTER);
        pane.add(controlPanel, BorderLayout.SOUTH);
                
        inputText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
                try{
                    String message = inputText.getText();
                    /*System.out.println("mess: "+message);
                     */
                     socket = new Socket("192.168.1.40", 1515);
                     bwriter = new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));
                    //msgTextArea.append("["+horodatage()+"]"+" < "+Emission.log+" > : "+message+"\n");
                    //out.println("["+horodatage()+"]"+" < "+Emission.log+" > : "+message+"\n");
                    //out.flush();
                    //System.out.println("breader= "+breader.readLine());
                    bwriter.write("["+horodatage()+"]"+" < "+Emission.log+" > : "+message+"\n");
                    bwriter.newLine();
                    bwriter.flush();
                    inputText.setText("");
                   
                }
                catch(Exception ie){
                    System.out.println(ie.getMessage());
                }
                    
            }
        });
        
        
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private final JFrame frame;
    public static final JTextArea msgTextArea = new JTextArea();
    private final JTextField inputText = new JTextField("",50);
    private BufferedReader breader = null;
    private BufferedWriter bwriter = null;
    private PrintWriter out;
    private Socket socket = null;
    private final int port = 8081;
    
    public static String horodatage(){
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());
        return time;
        
    }
    
}
