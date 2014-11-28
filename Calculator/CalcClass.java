package Calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalcClass extends JFrame {
	JLabel label;         //����� ��ºκ�
	JButton bNum[] = new JButton[10];    //���� ��ư
	JButton plus,minus, multi, div, equal, clear; //���� ��ư
	
	String inputValue;  //���� �Է����� ����
	int result;    //�߰� ��� ���
	char last;   //���� ������ ������
	
public static void main(String[] args) {

	new CalcClass();
 }
 public CalcClass() {
	 super("����");
	  setBounds(200, 200, 300,300);
	  setResizable(false);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  label = new JLabel("0", JLabel.RIGHT);
	  

	  add(label, BorderLayout.NORTH);

	  JPanel p = new JPanel(new GridLayout(4,4,1,1));
	  add(p, BorderLayout.CENTER);

	  plus = new JButton("+");
	  minus = new JButton("-");
	  multi = new JButton("*");
	  div  = new JButton("/");
	  equal = new JButton("=");
	  clear = new JButton("C");

	 
	  for (int i = 0; i < bNum.length; i++) {
	   bNum[i] = new JButton(Integer.toString(i));
	  }

	  p.add(bNum[7]); p.add(bNum[8]); p.add(bNum[9]); p.add(plus);
	  p.add(bNum[4]); p.add(bNum[5]); p.add(bNum[6]); p.add(minus);
	  p.add(bNum[1]); p.add(bNum[2]); p.add(bNum[3]); p.add(multi);
	  p.add(bNum[0]); p.add(equal); p.add(clear); p.add(div);
	  
	  //�̺�Ʈ ������ ����
	  Number iven = new Number();
	  for (int i = 0; i < bNum.length; i++) {
	   bNum[i].addActionListener(iven);
	  }

	  Calc a = new Calc();
	  plus.addActionListener(a);
	  minus.addActionListener(a);
	  multi.addActionListener(a);
	  div.addActionListener(a);
	  equal.addActionListener(a);
	  clear.addActionListener(a);

	  setVisible(true);
	 }

	 //���ڹ�ư�� �̺�Ʈ ó��
	 class Number implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	   String s = e.getActionCommand(); //Ŭ���� ��ư�� ���̺�
	   if (inputValue == null) {
	    if (s.equals("0")) return;  //ù �ڸ��̸鼭 0�̸� ����
	    else inputValue = new String(); //ù �ڸ��̸� String ��ü ����
	   }
	   if (inputValue.length() >= 9) return; //9�ڸ� ������ ����
	   inputValue += s;     //�ι�° �����̸� ���� ���� �����̱�
	   label.setText(inputValue);   //���� ���� ȭ�鿡 ǥ��
	  }
	 }

	 //��Ÿ ��� ��ư�� �̺�Ʈ ó��
	 class Calc implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	   JButton source = (JButton) e.getSource();
	   int value;


	   //��Ÿ ��� +,-,*,/
	   if (inputValue != null) {
	    value = Integer.parseInt(inputValue);
	    switch (last) {
	     case '+' : result += value; break;
	     case '-' : result -= value; break;
	     case '*' : result *= value; break;
	     case '/' : result /= value; break;
	     default  : result = value; break;
	    }
	    label.setText(Integer.toString(result));
	   }
	   inputValue = null;
	   last = source.getText().charAt(0);
	  }
	 }
	}