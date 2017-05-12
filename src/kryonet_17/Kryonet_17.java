/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet_17;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;

/**
 *
 * @author rober
 */
public class Kryonet_17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //1. create Server
        Server server = new Server();
        //2. create Listener
        KryonetServerListener listener = new KryonetServerListener(server);
        //3. add Listener to server
        server.addListener(listener);
        //4. register class type
        Kryo kryo = server.getKryo();
        kryo.register(String.class);
        //5. bind server
        server.bind(8070);
        //6. start server
        server.start();
        System.out.println("Server is starting! ");
    }
    
}
