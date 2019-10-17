package udpclient;
import java.io.*;
import java.net.*;
/**
 *
 * @author Cagni Lorenzo, Lin Jiale, Valloncini Stefano 
 */
public class UDPClient {

    public static void main(String[] args) throws Exception{
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
      
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      boolean check = false;
      
      
      while(!check){
      System.out.print("inserisci una frase: ");
      String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
      
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8800);
      clientSocket.send(sendPacket);
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("Dal Server:" + modifiedSentence);
      
          System.out.println("Vuoi continuare?");
          String risposta = inFromUser.readLine();
          if(risposta.equalsIgnoreCase("no")) check=true;
      }
      clientSocket.close();
        
    }
    
}
