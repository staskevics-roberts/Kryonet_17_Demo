/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet_17;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;


/**
 *
 * @author rober
 */
public class KryonetServerListener extends Listener{
    
    Server server;
    
    public KryonetServerListener(Server server)
    {
        super();
        this.server = server;
    }
    
    @Override
    public void connected(Connection con)
    {
        System.out.println("Client Nr. " + con.getID() + " is connected!");
    }
    
    public void disconected(Connection con)
    {
        System.out.println("Client Nr. " + con.getID() + " is disconnected!");
    }
    
    @Override
    public void received(Connection con, Object obj)
    {
        if(obj instanceof String)
        {
            System.out.println("Client: " + con.getID() + " >>>>> " + (String)obj);
            sendMSGToAll((String)obj);
        }
    }
    public void sendMSGToAll(String msg)
    {
        Connection[] allClients = server.getConnections();
        for(Connection con: allClients)
            con.sendTCP(msg);
    }
}
