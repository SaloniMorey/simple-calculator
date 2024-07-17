// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberbuttons=new JButton[10];
    JButton[] functionbuttons=new JButton[9];
    JButton addbutton,subbutton,mulbutton,divbutton;
    JButton equbutton,decbutton,delbutton,clrbutton,negbutton;
    JPanel panel;
    Font myFont =new Font("itaaly",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,550);
        frame.setLayout(null);

        textfield=new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addbutton=new JButton("+");
        subbutton=new JButton("-");
        mulbutton=new JButton("*");
        divbutton=new JButton("/");
        equbutton=new JButton("=");
        decbutton=new JButton(".");
        delbutton=new JButton("Delete");
        clrbutton=new JButton("Clear");
        negbutton=new JButton("(-)");


        functionbuttons[0]=addbutton;
        functionbuttons[1]=subbutton;
        functionbuttons[2]=mulbutton;
        functionbuttons[3]=divbutton;
        functionbuttons[4]=equbutton;
        functionbuttons[5]=decbutton;
        functionbuttons[6]=delbutton;
        functionbuttons[7]=clrbutton;
        functionbuttons[8]=negbutton;

        for(int i=0;i<9;i++){
            functionbuttons[i].addActionListener(this);
            functionbuttons[i].setFont(myFont);
            functionbuttons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberbuttons[i]=new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(myFont);
            numberbuttons[i].setFocusable(false);
        }
        negbutton.setBounds(50,430,70,50);
        delbutton.setBounds(120,430,130,50);
        clrbutton.setBounds(250,430,120,50);


        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);

        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(addbutton);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(subbutton);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(mulbutton);
        panel.add(decbutton);
        panel.add(numberbuttons[0]);
        panel.add(equbutton);
        panel.add(divbutton);

        frame.add(panel);
        frame.add(negbutton);
        frame.add(delbutton);
        frame.add(clrbutton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
      Calculator calc =new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberbuttons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decbutton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addbutton){
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subbutton){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mulbutton){
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource()==divbutton){
            num1=Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        if(e.getSource()==equbutton){
            num2=Double.parseDouble(textfield.getText());

            switch(operator){
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrbutton){
            textfield.setText("");
        }

        if(e.getSource()==negbutton){
           double temp=Double.parseDouble(textfield.getText());
           temp*=-1;
           textfield.setText(String.valueOf(temp) );
        }
       if(e.getSource()==delbutton){
           String string=textfield.getText();
           textfield.setText("");
           for(int i=0;i<string.length()-1;i++){
               textfield.setText(textfield.getText()+string.charAt(i));
           }
       }
    }
}