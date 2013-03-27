/**
 * 
 */
package com.demo1.reference;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * -------------------------------
 * 
 * @author: wushaolong Sep 12, 2012
 * @company: gohigh.com.cn
 * @”√Õæ: -------------------------------
 */
public class RoundLabel extends JLabel {

    public RoundLabel(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        g.drawRoundRect(1, 1, this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight());
        super.paintComponent(g);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("RoundLabel Test");
        Container c = f.getContentPane();
        RoundLabel testLabel = new RoundLabel("hello world.");
        
        c.add(testLabel);
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        
        f.setVisible(true);

    }

}
