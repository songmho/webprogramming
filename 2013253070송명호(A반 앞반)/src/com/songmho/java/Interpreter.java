package com.songmho.java;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Interpreter {
	static String line;
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		Scanner scanner=new Scanner(System.in);		//Scanner 객체 생성
		
		HashMap<String, Double> env=new HashMap<String,Double>();	//HashMap 객체 생성
		
		while(scanner.hasNext()){		//입력 받은 것이 끝나기 전까지 반복
			line=scanner.nextLine();	//1줄 입력
			StringTokenizer stz=new StringTokenizer(line);		//입력 받은 줄 토큰화

			//double result = evalExpr(env, 0, "+", stz);
			//System.out.println("Evalute " + line + " to " + result);		// evalExpr 사용함
			
			evalStmt(env,stz);		//evalStmt 사용
			
		}
	}
	
	private static String stzmakestr(StringTokenizer stz){		//stzmakestr - stringTokenizer를 string으로 전환
		String stz_copy="";		
		while(stz.hasMoreTokens()){			//stz에서 토큰이 없을 때까지 반복
			stz_copy=stz_copy+" "+stz.nextToken();		//공백을 추가하여 만듬
		}
		return stz_copy;
	}

	private static void evalStmt(HashMap<String, Double> env,
			StringTokenizer stz) {
		// TODO 자동 생성된 메소드 스텁
		String operand1;
		operand1=stz.nextToken();
		
		if(operand1.equals("FOR")){		//맨 처음 토큰이 FOR일 때 
			double result = 0;
			String var=stz.nextToken();	//변수 초기화
			stz.nextToken();		// = 
			String num_fir_str=stz.nextToken();	//숫자
			double num_fir=new Double(num_fir_str);
			int num_fir_int=new Integer(num_fir_str);
			env.put(var, num_fir);
			stz.nextToken(); //TO
			String num_end_str=stz.nextToken();	//숫자 끝 값
			double num_end=new Double(num_end_str);
			int num_end_int=new Integer(num_end_str);
			
			stz.nextToken();	//DO

			String stzCpy_str = stzmakestr(stz);		//stringTokenizer를 string으로 변환
			
			for(int i=num_fir_int;i<=num_end_int;i++){		
			//	System.out.println(i);		i 카운트 출력 
				evalStmt(env,new StringTokenizer(stzCpy_str));	//stzCpy_str을 토대로 evalstmt를 실행
			}
		}
		
		else if(operand1.equals("IF")){			//맨 처음 토큰이 IF일 때
			
		}
		
		else if(operand1.equals("WHILE")){		//맨 처음 토큰이 WHILE 일 때 
					
		}
		
		else if(operand1.equals("PRINT")){	//맨 처음 토큰이 PRINT일 때 
			double result;
			if(stz.countTokens()==1){			// 변수만 입력됬을 때 ex) PRINT x
				operand1=stz.nextToken();		// 문자 저장(변수)
				System.out.println(operand1);	// 출력 
				result=env.get(operand1);		// 변수에 맞는 변수 값 가져옴
				System.out.println(result);		// 출력
			}
			else{								// 식이 입력 됬을 때 ex) PRINT 13 * 5
				result=evalExpr(env,0,"+",stz);	// 식 계산
				System.out.println(result);		// 출력
			}
		}
		
		else if(operand1.equals("READ")){		//맨처음 토큰이 READ 일 때 
			String key=stz.nextToken();		//변수 초기화
			Scanner scanner=new Scanner(System.in);	// 변수 값 입력
			double number=scanner.nextDouble();	// double 로 형 변형
			env.put(key, number);		//env에 저장
		}
		
		else if(stz.countTokens()==2){		//할당문  토큰 3개 ex) x = 10
			stz.nextToken();		// = 
			String number_str=stz.nextToken();	// 숫자 저장
			double number_dou=new Double(number_str);	//double로 형 변환
			env.put(operand1, number_dou);	//env에 저장
		}
		
		else{						//할당문 토큰 3개 초과 ex) x = 10 * 20
			stz.nextToken();		// = 
			double result=evalExpr(env,0,"+",stz);	//evalExpr 실행 후 result에 갑 저장 
			env.put(operand1, result);		//env에 저장
		}
		
	}

	private static double evalExpr(HashMap<String, Double> env, double operand1,
			String operator1, StringTokenizer stz) {			//evalExpr - 
		// TODO 자동 생성된 메소드 스텁
		double result=0;
		
		if(stz.countTokens()==0){			//토큰이 0개 일 때 
			System.err.println("Tokens not available");		//에러 출력
		}
		
		else if(stz.countTokens()==1){		//토큰이 1개 일 때  ex) x
			String token=stz.nextToken();		// 값 입력
			double operand2=evalOperand(env, token);		//변수 인지 상수인지 구분
			
			result=evalExpr(operand1,operator1,operand2);
		}
		
		else if(stz.countTokens()>=3){		//토큰이 3개 이상일 때
			String tokenOperand2=stz.nextToken();
			double operand2=evalOperand(env,tokenOperand2);		//변수 인지 상수인지 구분

			String operator2=stz.nextToken();
			
			if(precedence(operator1)>precedence(operator2)){		//왼쪽 연산자가 오른쪽 연산자의 우선순위보다 높을 때
				double d=evalExpr(operand1,operator1,operand2);
				result=evalExpr(env, d,operator2,stz);
			}
			
			else if(precedence(operator1)<precedence(operator2)){	//오른쪽 연산자의 우선순위가 왼쪽 연산자보다 높을 때
				double d=evalExpr(env,operand2,operator2,stz);
				result=evalExpr(operand1,operator1,d);
			}
			
			else{														//같을 때
				if(associativity(operator1)==Associativity.LeftToRight){	// 연산 순서가 왼쪽에서 오른쪽일 때
					double d=evalExpr(operand1,operator1,operand2);
					result=evalExpr(env,d,operator2,stz);
				}
				else{														//연산 순서가 오른쪽에서 왼쪽일 때
					double d=evalExpr(env,operand2,operator2,stz);
					result=evalExpr(operand1,operator1,d);
				}
			}
		}
		
		else{			//토큰이 2개 일 때
			System.err.println("Something wrong:");		//에러 출력 
				while ( stz.hasMoreTokens() ) {
					System.err.print( stz.nextToken() + " ");
		        }
		        System.err.println();
		}
		return result;
	}

	private static double evalOperand(HashMap<String, Double> env, String operand) {		// evalOperand - 피연산자를 받아서 상수인지 변수인지 판별해주는 함수
		// TODO 자동 생성된 메소드 스텁
		double result=0;
		
		if(Character.isLetter(operand.charAt(0))){		// MAji 해석기에서 첫글자가 char이면 변수
			Double d=env.get(operand);
			if(d==null){				// 변수의 값 존재 x
				env.put(operand, d);	// 변수 저장
			}
			else{			// 있으면 출력
				result=d;
			}
		}
		
		else{				// 첫글자가 char가 아니면 상수
			result=new Double(operand);
		}
		return result;
	}

	public static double evalExpr(double operand1, String operator, double operand2){		//evalExpr 연산하는 함수
		double result=0;
		
		switch(operator.charAt(0)){			//연산자를 바탕으로 switch문 
		case '+':							// +일 때
			result=operand1+operand2;		//연산
			break;
		case '-':							// - 일 때
			result=operand1-operand2;		//연산
			break;	
		case '*':							// * 일 때
			result=operand1*operand2;		//연산
			break;
		case '/':							// / 일 때
			result=operand1/operand2;		//연산
			break;
		default:				//이 외에 연산자 입력
			System.err.println("Unsupported operator:"+operator);		//에러메시지 출력 
		}
		
		return result;
	}
	
	public static int precedence(String operator){		//precedence - 연산자 우선순위 관련 함수
		switch(operator.charAt(0)){		
		case '+':
		case '-':
		case '=':
			return 2;		//연산자가 +, -, = 이면 2 반환
		case '*':
		case '/':
			return 4;		//연산자가 *, / 이면 4 반환
		default:			//이외의 경우 오류 출력
			System.err.println("Unsupported operator : "+operator);
			return 0;
		}
	}
	
	enum Associativity{			//enum - 연산 순서 관련 
		LeftToRight, RightToLeft;
	}
	
	public static Associativity associativity(String operator){		//연산 순서 관련 함수
		switch(operator.charAt(0)){
		case '+':
		case '-':
		case '*':
		case '/':
			return Associativity.LeftToRight;		//+, -, *, / 일 때, 왼쪽에서 오른쪽으로 연산
		default:									//나머지 경우 
			System.err.println("Unsupported operator:"+operator);		//오류 출력
			return Associativity.LeftToRight;
		}
	}
	
	
}

