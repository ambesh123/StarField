/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfield;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Ambesh Tiwari
 */
public class Star {
    int x,y,z,r,pz;
    Color color;
    Star()
    {   
        
        x= (int)((2*Math.random()-1)*StarField.frame.getWidth())*500;
        y= (int)((2*Math.random()-1)*StarField.frame.getHeight())*500;
        z=(int)(Math.random()*500); pz=z;
        color = Color.getHSBColor((float)Math.random(), (float)Math.random(), (float)Math.random());
    }
    void update(){
        pz=z;
        z=z-StarField.speed;
        if(z<10){
             x= (int)((2*Math.random()-1)*StarField.frame.getWidth())*500;
             y= (int)((2*Math.random()-1)*StarField.frame.getHeight())*500;
             z=500;  pz=500;
             color = Color.getHSBColor((float)Math.random(), (float)Math.random(), (float)Math.random());
        }
    }
    
    void show(Graphics g){
        r=1000/z;
        g.fillOval(x/z, y/z, r, r);
        g.drawLine(x/z+r/2, y/z+r/2, x/pz+r/2, y/pz+r/2);
    }
}
