/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Velasco
 */
public class clienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PUERTO_server =5000;
        byte[] buffer = new byte[1024];
        try {
            // TODO code application logic
            InetAddress direccion = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();
            //DatagramSocket socketUDP =new DatagramSocket();
            String mensaje ="Hola mundo desde el cliente";
            buffer = mensaje.getBytes();
            
            System.out.println("ENVIO EL DATAGRAMA");
            DatagramPacket pregunta = new DatagramPacket(buffer,buffer.length,direccion,PUERTO_server);
            socketUDP.send(pregunta);
            
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            
            System.out.println("Recibo peticion");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);
            
            socketUDP.close();
        } catch (SocketException ex) {
            Logger.getLogger(clienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(clienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
