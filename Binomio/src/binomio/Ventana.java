/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package binomio;
//LIBRERIAS
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Esta clase crea una ventana para desplegar los parametros de un Binomio para despúes desplegar un TCP
 * @author Monroy Gonzalez Juan  Ignacio y Juan Carlos Nevarez Tovar
 * @version 25/08/2017 1.1
 */
public class Ventana extends JFrame implements ActionListener{

    //Campos de la clase
    JLabel titulo;
    JLabel com1;
    JLabel com2;
    JLabel literal;
    JButton calcu;
    JTextField signo;
    JTextField coeficiente1;
    JTextField coeficiente2;
    JTextField obtenido;
    
    public Ventana(){
        configurar();
        elementos();
    }
    
    public void configurar(){
        setTitle("Binomio");
        setSize(600,500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void elementos(){
      titulo = new JLabel("Binomio al cuadrado");
      titulo.setBounds(175,87, 250, 30);
      titulo.setFont(new Font("Arial", Font.BOLD,25));
      add(titulo);
      
      //Inicio del binomio
      com1 = new JLabel("(");
      com1.setBounds(100, 140, 30, 100);
      com1.setFont(new Font("Arial", Font.ITALIC, 35));
      add(com1);
      
      //Final del binomio
      com2= new JLabel(")^2");
      com2.setBounds(400, 140,60, 100);
      com2.setFont(new Font("Arial", Font.ITALIC, 35));
      add(com2);
      
      //Incognita 'x'
      literal = new JLabel("X");
      literal.setBounds(200,140,30,100);
      literal.setFont(new Font("Arial", Font.ITALIC, 35));
      add(literal);
      
      calcu = new JButton("Calcular");
      calcu.setBounds(150,250,300,50);
      calcu.addActionListener(this);
      add(calcu);
      calcu.setVisible(true);
      add(calcu);
      
      //Textfield para ingresar SIGNO
      /*
        Se debe validar que solo se ingrese un signo, esto debe tener consecuencias en el desplegado del resultado
      */
      signo = new JTextField();
      signo.setBounds(275,170,30,30);
      signo.setAlignmentX(CENTER_ALIGNMENT);
      signo.setFont(new Font("Arial", Font.ITALIC, 20));
      signo.setHorizontalAlignment(signo.CENTER);
      signo.addKeyListener(new KeyAdapter() {
          /**
           * METODO QUE VALIDA QUE SOLO SE INGRESEN SIGNOS '+' Y '-'
           * @param e Se valida por medio de entrada del evento e
           */
          @Override
          public void keyTyped(KeyEvent e) {
            char entrada = e.getKeyChar();
            //43 = '+'  45 = '-' 8 = BORRADO
            //Si es un digito sale error
            if(Character.isDigit(entrada) 
               ||  ((int)entrada!=43 && (int)entrada!=45 && (int)entrada!=8) 
            ){
                getToolkit().beep();
                e.consume();
                JOptionPane.showMessageDialog(null,"Solo ingrese signos", "Error", JOptionPane.ERROR_MESSAGE);
                signo.setCursor(null);
            } 
            
            //Validar que solo ingresen un signo
            String dobles = signo.getText();
            if(dobles.length() > 0){
                getToolkit().beep();
                e.consume();
                JOptionPane.showMessageDialog(null,"Solo se puede ingresar un signo", "Error", JOptionPane.ERROR_MESSAGE);
                signo.setCursor(null);
            }
         }//Cierre del método
      });
      add(signo);
      
      coeficiente1 =  new JTextField();
      coeficiente1.setBounds(150,160,30,50);
      coeficiente1.setFont(new Font("Arial", Font.ITALIC, 30));
      coeficiente1.setHorizontalAlignment(coeficiente1.CENTER);
      coeficiente1.addKeyListener(new KeyAdapter() {
          /**
           * Metodo que valida que solo se ingresen numeros del 1 al 9
           * @param e Entra la tecla que presiona el usuario
           */ 
          @Override
          public void keyTyped(KeyEvent e) {
            char letra = e.getKeyChar();
 
            if(letra<'0' || letra>'9' ){
                e.consume();
            }
         }//Cierre del método
      });
      add(coeficiente1);
      
      coeficiente2 = new JTextField();
      coeficiente2.setBounds(350,160,30,50);
      coeficiente2.setFont(new Font("Arial", Font.ITALIC, 30));
      coeficiente2.setHorizontalAlignment(coeficiente2.CENTER);
      coeficiente2.addKeyListener(new KeyAdapter() {
        /**
         * Metodo que valida que solo se ingresen numeros del 1 al 9
         * @param e Entra la tecla que presiona el usuario
         */ 
        @Override
          public void keyTyped(KeyEvent e) {
              char caracter = e.getKeyChar();
              
              if(caracter<'0' || caracter>'9' ){
                  e.consume();
              }
         }//Cierre del método   
      });
      add(coeficiente2);
      
      obtenido = new JTextField();
      obtenido.setBounds(150, 350, 300, 50);
      obtenido.setFont(new Font("Arial",Font.BOLD ,25));
      obtenido.setHorizontalAlignment(obtenido.CENTER);
      obtenido.setEditable(false);
      add(obtenido);
    }
    
    
    /**
     * Metodo para desplegar el desarrollo del binomio
     * @param e El parametro e trae el evento del boton calcu
     * @see calcu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int num1 = Integer.parseInt(coeficiente1.getText());
        int num2 = Integer.parseInt(coeficiente2.getText());
        char tipo = signo.getText().charAt(0);
        //axx = ax*2
        int axx = 0;
        int bx = 0;
        int c = 0;
        
        axx = num1 * num1;
        if(tipo == '+'){
            bx = 2 * num1 * num2;
            c= num2 * num2;
            obtenido.setText(axx+"X^2 "+tipo+" "+bx+"X + "+c);
        }
        else if(tipo == '-'){
            bx = 2 * num1 * num2;
            c= num2 * num2;
            obtenido.setText(axx+"X^2 "+tipo+" "+bx+"X + "+c);
        }
        else{
            obtenido.setText("No se pase compa >:v");
        }
        
        
    }//Cierre del metodo
    
}//Cierre de la clse