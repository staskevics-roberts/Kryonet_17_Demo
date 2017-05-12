/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kryonet_17;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

/**
 *
 * @author rober
 */
public class KryonetClientListener extends Listener {
    
    public KryonetClientListener()
    {
        
    }
    
    @Override
    public void connected(Connection con)
    {
        System.out.println("You Are Connected!");
    }
    
    public void disconected(Connection con)
    {
        System.out.println("You Are Disconnected!");
    }
    
    @Override
    public void received(Connection con, Object obj)
    {
        if(obj instanceof String)
            System.out.println("Client: " + con.getID() + " <<<< " + (String)obj);
    }
    
}
