package Calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalcClass extends JFrame {
	JLabel label;         //계산결과 출력부분
	JButton bNum[] = new JButton[10];    //숫자 버튼
	JButton plus,minus, multi, div, equal, clear; //연산 버튼
	
	String inputValue;  //현재 입력중인 숫자
	int result;    //중간 계산 결과
	char last;   //이전 선택한 연산자
	
public static void main(String[] args) {

	new CalcClass();
 }
 public CalcClass() {
	 super("계산기");
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
	  
	  //이벤트 리스너 연결
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

	 //숫자버튼의 이벤트 처리
	 class Number implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	   String s = e.getActionCommand(); //클릭한 버튼의 레이블
	   if (inputValue == null) {
	    if (s.equals("0")) return;  //첫 자리이면서 0이면 무시
	    else inputValue = new String(); //첫 자리이면 String 객체 생성
	   }
	   if (inputValue.length() >= 9) return; //9자리 넘으면 무시
	   inputValue += s;     //두번째 이후이면 누른 숫자 덧붙이기
	   label.setText(inputValue);   //현재 숫자 화면에 표시
	  }
	 }

	 //기타 계산 버튼의 이벤트 처리
	 class Calc implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	   JButton source = (JButton) e.getSource();
	   int value;


	   //기타 계산 +,-,*,/
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