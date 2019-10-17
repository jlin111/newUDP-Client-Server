package udpserver;
import java.io.*;
import java.net.*;
/**
 *
 * @author Cagni Lorenzo, Lin Jiale, Valloncini Stefano 
 */
public class UDPServer {

    public static void main(String[] args) throws Exception {
        
            DatagramSocket serverSocket = new DatagramSocket(8800);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
            while(true)
               {
                  System.out.println("Server in ascolto sulla porta "+ serverSocket.getLocalPort());
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  System.out.println("Messagio Ricevuto: " + sentence);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  String capitalizedSentence = sentence.toUpperCase();
                  sendData = capitalizedSentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
                  
                  
    }
    
    }
}
