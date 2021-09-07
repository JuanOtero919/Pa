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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Velasco
 */
public class servidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciado el servidor, recibo info del cliente");
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            while(true){
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(peticion);

            String mensaje = new String(peticion.getData());
            System.out.println("hola desde el cliente");

            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();

            mensaje = "Hola desde el servidor";
            buffer = mensaje.getBytes();

            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
            System.out.println("Envio informacion");
            socketUDP.send(respuesta);
            }
        } catch (SocketException ex) {
            Logger.getLogger(servidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(servidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
