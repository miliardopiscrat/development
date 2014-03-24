/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.barcodereader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mmigdal
 */
public class BarcodeReader {
    

    
    public static void main (String [] args){
        
        System.out.println("Invoking BarcodeReader main Class .......................");
        
        
        
        
        MyFrame frame = new MyFrame("Example Tilte");


        System.out.println("Invokation of BarcodeReader main Class done ...............");
    }
}
