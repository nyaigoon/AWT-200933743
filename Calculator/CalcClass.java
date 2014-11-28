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
	
	public CalcClass() {
		
	}
 public static void main(String[] args) {

 }
}
