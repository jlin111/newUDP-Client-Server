/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import static udpserver.UDPServerGUI.data;

/**
 *
 * @author Stefano
 */
public class threadAscoltoMessaggi extends Thread
{   
    public void run()
    {
        while (true) 
        {
            try
            {
                UDPServerGUI.DpReceive = new DatagramPacket(UDPServerGUI.receive, UDPServerGUI.receive.length); 

                UDPServerGUI.ds.receive(UDPServerGUI.DpReceive); 
                String stringhetta = data(UDPServerGUI.receive).toString(); 
                System.out.println("Messaggio Criptato Ricevuto: " + stringhetta);
                
                String D_msg = AES.decrypt(data(UDPServerGUI.receive).toString(), UDPServerGUI.secretKey);
                UDPServerGUI.jTextArea1.append("Client: " + D_msg + "\n");
                
                // Clear the buffer after every message. 
                UDPServerGUI.receive = new byte[65535]; 
            }
            catch(Exception e)
            {
                
            }
        } 
    }
}
