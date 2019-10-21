package udpclient;
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

/**
 *
 * @author Cagni Lorenzo, Lin Jiale, Valloncini Stefano 
 */

public class UDPClient {

    public static void main(String[] args) throws IOException{
                final String secretKey = "ssshhhhhhhhhhh!!!!";
                final int port = 3333;

		Scanner sc = new Scanner(System.in); 
  
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
         System.out.println("Messages    ('bye' to terminate the conversation)");
  
        // loop while user not enters "bye" 
        while (true) 
        { 
            System.out.print("Client: ");
            String inp = sc.nextLine(); 
            String E_inp = AES.encrypt(inp, secretKey) ;
            // convert the String input into the byte array. 
            buf = E_inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, port); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
  
            // break the loop if user enters "bye" 
            if (inp.equals("bye")) 
                break; 
        } 
        
    //String originalString = "howtodoinjava.com";
    //String encryptedString = AES.encrypt(originalString, secretKey) ;
    //String decryptedString = AES.decrypt(encryptedString, secretKey) ;
     
    ;
    } 
}
    
     


        
    
    

