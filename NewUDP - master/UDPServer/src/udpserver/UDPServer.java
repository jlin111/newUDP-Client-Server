package udpserver;
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Cagni Lorenzo, Lin Jiale, Valloncini Stefano 
 */

public class UDPServer {

    public static void main(String[] args) throws Exception {
         final String secretKey = "ssshhhhhhhhhhh!!!!";
         final int port = 3333;

		// Step 1 : Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(port); 
        byte[] receive = new byte[65535]; 
  
        DatagramPacket DpReceive = null; 
        
        System.out.println("Server in ascolto sulla port "+port);
        while (true) 
        { 
  
            // Step 2 : create a DatgramPacket to receive the data. 
            DpReceive = new DatagramPacket(receive, receive.length); 
  
            // Step 3 : revieve the data in byte buffer. 
            ds.receive(DpReceive); 
            String D_msg = AES.decrypt(data(receive).toString(), secretKey);
  
            System.out.println("Client: " + D_msg.toUpperCase()); 
  
            // Exit the server if the client sends "bye" 
            if (data(receive).toString().equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            // Clear the buffer after every message. 
            receive = new byte[65535]; 
        } 
    } 
  
    // A utility method to convert the byte array 
    // data into a string representation. 
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
} 
    
