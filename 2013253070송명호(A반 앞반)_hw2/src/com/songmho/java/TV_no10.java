package com.songmho.java;

//5단원의 10번 문제
/*
 * 구현 메쏘드 : Tv 전원 관련 , 채널 변경(숫자입력, 1개 증감), 볼륨 변경(1개 증감)
 */

public class TV_no10 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		TV tv1,tv2;		//클래스 선언

		tv1=new TV(true,5,7);	//클래스 초기화
		
		tv1.change_cha(14);
		tv1.inc_chanel();
		tv1.inc_chanel();
		tv1.dec_chanel();
		tv1.inc_volume();
		tv1.inc_volume();
		tv1.dec_volume();
		System.out.println(tv1);
		tv1.turn_on_off(false);
		tv1.inc_chanel();
		System.out.println(tv1);
	}

}

class TV{
	boolean onoff;		//tv 전원 on/off
	int chanel;			//채널
	int volume;			//볼륨
	
	public TV(boolean onoff, int chanel,int volume){		//생성자
		this.onoff=onoff;
		this.chanel=chanel;
		this.volume=volume;
	}
	
	public void turn_on_off(boolean onoff){		//Tv 전원 받는 메쏘드
		this.onoff=onoff;
		if(this.onoff==true){					//Tv가 켜져있을 때
			System.out.println("Tv가 켜졌습니다.");
		}
		
		else{									//꺼져있을 때
			System.out.println("Tv가 꺼졌습니다.");
		}
	}
	
	public int change_cha(int chanel){			//채널을 입력해서 변경하는 메쏘드
		if(this.onoff==true){					//Tv가 켜져있을 때
			this.chanel=chanel;
			System.out.println("현재 채널은 "+this.chanel+"번 입니다.");
		}
		else{									//꺼져있을 때
			System.out.println("Tv가 꺼져있습니다.");
		}
		return this.chanel;
	}
	
	public int inc_chanel(){					//채널을 1개 증가하는 메쏘드
		if(this.onoff==true){					//Tv가 켜져있을 때
			this.chanel++;
			System.out.println("현재 채널은 "+this.chanel+"번 입니다.");
			return this.chanel;
		}
		else{									//꺼져있을 때
			System.out.println("Tv가 꺼져있습니다.");
		}
		return this.chanel;
	}
	
	public int dec_chanel(){					//채널을 1개 감소하는 메쏘드
		if(this.onoff==true){					//Tv가 켜져있을 때
			this.chanel--;
			System.out.println("현재 채널은 "+this.chanel+"번 입니다.");
		}
		else{									//꺼져있을 때
			System.out.println("Tv가 꺼져있습니다.");
		}
		return this.chanel;
	}
	
	public int inc_volume(){					//볼륨 증가 메쏘드
		if(this.onoff==true){					//Tv가 켜져있을 때
		this.volume++;
		System.out.println("현재 볼륨은 "+this.volume+"번 입니다.");
		}
		else									//꺼져있을 때
			System.out.println("Tv가 꺼져있습니다.");

		return this.volume;
	}
	
	public int dec_volume(){				//볼륨 감소 메쏘드
		if(this.onoff==true){					//Tv가 켜져있을 때
			this.volume--;
			System.out.println("현재 볼륨은 "+this.volume+"번 입니다.");
		}
		else									//꺼져있을 때
			System.out.println("Tv가 꺼져있습니다.");

		return this.volume;
	}
	
	public String toString(){				//현재 상태 출력하는 메쏘드(toString)
		return("현재 채널은 "+this.chanel+", 현재 볼륨은"+this.volume+"입니다.");
	}
	
}
