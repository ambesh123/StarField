/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfield;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
/**
 *
 * @author Ambesh Tiwari
 */
public class StarField extends JPanel{

    static StarField starField = new StarField();
    static Star[] stars= new Star[1000];
    static JFrame frame = new JFrame();
    static int speed;
    
    Thread thread = new Thread(){
            public void run(){
                while(true){
                    for(int i=0;i<stars.length;i++){
                            stars[i].update();
                        }
                    
                    repaint();
                    
                    try{Thread.sleep(20);}catch(Exception e){}
                     
                }
            }
        };
    
    public static void main(String[] args) {
        speed=20;
        Dimension d =frame.getMaximumSize();
        frame.setSize(d);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=0;i<stars.length;i++)stars[i]= new Star();
        frame.add(starField);
        frame.setVisible(true);
        frame.addMouseMotionListener(new Listener());
    }
    
    public void paint(Graphics g)
    {   super.paint(g);
        if(!thread.isAlive())thread.start();
        setBackground(Color.black);
        g.setColor(Color.white);
        g.translate(frame.getWidth()/2,frame.getHeight()/2);
        for(int i=0;i<stars.length;i++)
            stars[i].show(g);
        
        
    }




   static class Listener implements MouseMotionListener

    {   @Override
        public void mouseDragged(MouseEvent me) {
            speed = me.getX()/50;
        }

        @Override
        public void mouseMoved(MouseEvent me) {
        }
    }
    
}
