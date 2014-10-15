package com.songmho.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;

public class Converttemperature {

	private JFrame frame;			//frame 객체 생성
	private JTextField textField;	//textField 객체 생성

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {			//main 메쏘드
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Converttemperature window = new Converttemperature();	//Converttemperature 객체 생성
					window.frame.setVisible(true);							//window 객체의 frame visible을 true로 설정
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Converttemperature() {		//생성자
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();						//frame 객체 초기화
		frame.setBounds(100, 100, 350, 230);		//frame 크기 설정
		frame.setTitle("Temperature Converter");	//frame의 제목 지정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();			//panel 객체 생성
		frame.getContentPane().add(panel, BorderLayout.NORTH);	//panel의 위치를 frame의 상단에 배치
		
		final JRadioButton rdbtnCF = new JRadioButton("C -> F");	//라디오 버튼 객체 생성
		
		rdbtnCF.setSelected(true);									//default값으로 rdbtnCF를 선택하도록 함
		panel.add(rdbtnCF);										//panel에 라디오 버튼 추가
		
		final JRadioButton rdbtnFC = new JRadioButton("F -> C");	//라디오 버튼 객체 생성
		panel.add(rdbtnFC);										//panel에 라디오 버튼 추가
		
		final ButtonGroup bg=new ButtonGroup();					//ButtonGroup 객체 생성
		bg.add(rdbtnCF);										//ButtonGroup에 rdbtnCF추가 
		bg.add(rdbtnFC);										//ButtonGroup에 rdbtnFC추가 
		
		JPanel panel_2 = new JPanel();							//panel 객체 생성
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);	//panel의 위치를 frame의 중앙에 배치 
		
		JLabel lblInsertTemperature = new JLabel("Insert temperature : ");	//라벨 객체 생성
		
		textField = new JTextField();			//TextField 객체 생성
		textField.setColumns(10);
		
		final JButton btnConvert = new JButton("convert");		//버튼 객체 생성
		
		final JLabel lblformula = new JLabel("공식 : ºF = (ºC*1.8)+32 \n ºC = (ºF-32)/1.8");		//공식 출력하는 label 객체 생성
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);			//GroupLayout 객체
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInsertTemperature)
							.addGap(5)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(btnConvert))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(43)
							.addComponent(lblformula)))
					.addContainerGap(9, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(4)
							.addComponent(lblInsertTemperature))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnConvert))
					.addGap(37)
					.addComponent(lblformula)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		

		
		btnConvert.addActionListener(new ActionListener(){			//btnconvert에 액션 추가

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁

				
				if(rdbtnCF.isSelected()){				//rdbtnCF 가 선택되어 있을 때
					final String c_str=textField.getText();		//textField에 입력된 글자 c_str에 초기화
					double c=new Double(c_str);			//c_str에 입력된 값 double형으로 바꿔 c에 초기화
					double f=(c*1.8)+32;				//화씨 온도로 바꾸는 공식 사용한 후 f에 저장
					JOptionPane.showMessageDialog(null,f+"ºF 입니다.");		//다이얼로그창 띄어 출력
					
				}
				
				else if(rdbtnFC.isSelected()){			//rdbtnFC가 선택되어 있을 때
					final String f_str=textField.getText();		//textField에 입력된 글자 f_str에 초기화
					double f=new Double(f_str);			//f_str에 입력된 값 double형으로 바꿔 f에 초기화
					double c=(f-32)/1.8;				//섭씨 온도로 바꾸는 공식을 사용한 후 c에 저장
					JOptionPane.showMessageDialog(null,c+"ºC 입니다.");		//다이얼로그창 띄어 출력
				}
			}
			
		});
	}
}
