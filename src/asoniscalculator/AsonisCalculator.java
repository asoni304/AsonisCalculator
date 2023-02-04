/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asoniscalculator;
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
import java.awt.FlowLayout;
class AsonisCalculator extends JFrame implements ActionListener { 
    // create a frame 
    static JFrame f; 
  
    // create a textfield 
    static JTextField l; 
  
    // store oprerator and operands 
    String s0, s1, s2; 
  
    // default constrcutor 
    AsonisCalculator() 
    { 
        s0 = s1 = s2 = ""; 
    } 
  
    // main function 
    public static void main(String args[]) 
    { 
        // create a frame 
        f = new JFrame("Asonis Calculator"); 
  
        
        // create a object of class 
        AsonisCalculator c = new AsonisCalculator(); 
  
        // create a textfield 
        l = new JTextField(14); 
        l.setBackground(Color.cyan);
  
        // set the textfield to non editable 
        l.setEditable(false); 
  
        // create number buttons and some operators 
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, baddition, bsubtraction, bdivision, bmultiplication, bequals, bclear,bdecimal; 
  
        // create number buttons 
        b0 = new JButton("0"); 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8"); 
        b9 = new JButton("9"); 
  
        // equals button 
        bdecimal = new JButton("."); 
        bdecimal.setBackground(Color.red);
  
        // create operator buttons 
        baddition = new JButton("+"); 
        baddition.setBackground(Color.red);
        
        bsubtraction = new JButton("-"); 
        bsubtraction.setBackground(Color.red);
        
        bdivision = new JButton("/"); 
        bdivision.setBackground(Color.red);
        
        bmultiplication = new JButton("*"); 
        bmultiplication.setBackground(Color.red);
        
        bclear = new JButton("C"); 
        bclear.setBackground(Color.yellow);
  
        // create . button 
        bequals = new JButton("="); 
        bequals.setBackground(Color.red);
  
        // create a panel 
        JPanel p = new JPanel(); 
         LayoutManager layout = new FlowLayout();  
         p.setLayout(layout);
  
        // add action listeners 
        bmultiplication.addActionListener(c); 
        bdivision.addActionListener(c); 
        bsubtraction.addActionListener(c);
        baddition.addActionListener(c); 
        b9.addActionListener(c); 
        b8.addActionListener(c); 
        b7.addActionListener(c); 
        b6.addActionListener(c); 
        b5.addActionListener(c); 
        b4.addActionListener(c); 
        b3.addActionListener(c); 
        b2.addActionListener(c); 
        b1.addActionListener(c); 
        b0.addActionListener(c); 
        bequals.addActionListener(c); 
        bclear.addActionListener(c); 
        bdecimal.addActionListener(c); 
  
        // add elements to panel 
        p.add(l); 
        p.add(baddition); 
        p.add(bsubtraction); 
        p.add(bmultiplication);
        p.add(bdivision); 
        p.add(b1); 
        p.add(b2); 
        p.add(b3);
        p.add(b4); 
        p.add(b5); 
        p.add(b6); 
        p.add(b7); 
        p.add(b8); 
        p.add(b9); 
        p.add(b0); 
        p.add(bequals); 
        p.add(bdecimal); 
        p.add(bclear); 
        
  
        // set Background of panel 
        p.setBackground(Color.black);
  
     
        f.add(p);
        f.setSize(200, 220); 
        f.show(); 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
  
        // if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
            // if operand is present then add to second no 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
  
            // set the value of text 
            l.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == 'C') { 
            // clear the one letter 
            s0 = s1 = s2 = ""; 
  
            // set the value of text 
            l.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == '=') { 
  
            double te; 
  
            // store the value in 1st 
            if (s1.equals("+")) 
                te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
            // set the value of text 
            l.setText(s0 + s1 + s2 + "=" + te); 
  
            // convert it to string 
            s0 = Double.toString(te); 
  
            s1 = s2 = ""; 
        } 
        else { 
            // if there was no operand 
            if (s1.equals("") || s2.equals("")) 
                s1 = s; 
            // else evaluate 
            else { 
                double te; 
  
                // store the value in 1st 
                if (s1.equals("+")) 
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
                // convert it to string 
                s0 = Double.toString(te); 
  
                // place the operator 
                s1 = s; 
  
                // make the operand blank 
                s2 = ""; 
            } 
  
            // set the value of text 
            l.setText(s0 + s1 + s2); 
        } 
    } 
}


