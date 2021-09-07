/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_yo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Velasco
 */
public class servidorr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        ServerSocket servidor = null; //Crear el servidor
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final int PUERTO = 5000;
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            
            while(true){
                sc = servidor.accept(); //Se queda a la espera en esta linea hasta conexion, este es el socket del servidorr
                System.out.println("cliente conectado");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF(); //Espera hasta que el servidorr mande algo
                System.out.println(mensaje);
                
                out.writeUTF("Desde el servidor");
                
                sc.close();
                System.out.println("cliente desconectado"); 
                
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(servidorr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
