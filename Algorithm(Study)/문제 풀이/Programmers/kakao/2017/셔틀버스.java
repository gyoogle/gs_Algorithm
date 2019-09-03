package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class 셔틀버스 {
	
	static class Time {
		int h;
		int m;
		
		Time(int h, int m) {
			this.h = h;
			this.m = m;
		}
	}
	
	static LinkedList<Time> list;
	static int fh, fm;
	
	public static String solution(int n, int t, int m, String[] timetable) {
		
		String answer = "";
		
		Arrays.sort(timetable);
		
		list = new LinkedList<>();
		
		int test = (n-1)*t;
		
		int th = test/60 + 9;
		int tm = test%60;
		
		for (int i = 0; i < timetable.length; i++) {
			String[] time = timetable[i].split(":");
			int hh = Integer.parseInt(time[0]);
			int mm = Integer.parseInt(time[1]);
			
			if(hh < th || ((hh == th) && (mm <= tm)))
				list.add(new Time(hh, mm));
		}
		
		int hour = 9;
		int minute = 0;
		
		int fast = 0;
		int fh = 0;
		int fm = 0;
		
		//탈 수 있는 시간 중에 최대한 늦은 시간 구하기
		
		for (int b = 1; b <= n; b++) { // n대
			
			// 현재 버스를 탈 수 있는 인원
			fast = 0;
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
					fast++;
				}
			}
			
			//System.out.println("fast : " + fast);
			
			// 그 인원이 버스 탑승량보다 적을 때
			if(fast < m) {
				if(b == n) { // 여기 타야됌
					for (int i = 0; i < list.size(); i++) {
						if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
							fh = list.get(i).h;
							fm = list.get(i).m;
							
							if(fh < hour || ((fh==hour)&& fm > minute)) {
								fh = hour;
								fm = minute;
							}
						}
					}
				}
				else { // 그 인원들 버스 태워 보내기
					//System.out.println("태우자");
					for (int i = 0; i < list.size(); i++) {
						if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
							list.remove(i);
							i--;
						}
					}
				}
			}
			
			//그 인원이 버스 탑승량과 같거나 많을 때
			else if(fast >= m) {
				if(b == n) { // 여기 타야됌
					int cnt = 0;
					for (int i = 0; i < list.size(); i++) {
						if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
							fh = list.get(i).h;
							fm = list.get(i).m;
							cnt++;
							if(cnt == m) { // 시간 체크 다시 확인
								if(fh < hour || ((fh == hour) && fm <= minute)) {
									if(fm >=1 ) {
										fm -=1;
									}
									else {
										fm = 59;
										fh -= 1;
									}
								}
								break;
							}
						}
					}
				}
				else {
					int cnt = 0;
					for (int i = 0; i < list.size(); i++) {
						if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
							list.remove(i);
							i--;
							cnt++;
							if(cnt == m) {
								fh = hour;
								fm = minute;
								break;
							}
						}
					}
				}
			}
			
			if(list.size() == 0) {
				fh = hour;
				fm = minute;
			}
			
			// 시간 증가
			if(minute + t < 60) {
				minute += t;
			}
			else {
				hour += 1;
				minute = (minute+t) - 60;
			}
			
			//System.out.println("현재 가능 탑승 인원 : " + fast);
			//System.out.println("타고 남은 사람 : " + list.size());
			//System.out.println("다음 버스 시각 : " + hour + ":" + minute);
		}
		
		String s_hour = Integer.toString(fh);
		String s_minute = Integer.toString(fm);
		
		StringBuilder sb = new StringBuilder();
		
		if(s_hour.length() == 1) {
			sb.append("0").append(s_hour);
		}
		else {
			sb.append(s_hour);
		}
		sb.append(":");
		
		if(s_minute.length() == 1) {
			sb.append("0").append(s_minute);
		}
		else {
			sb.append(s_minute);
		}
		
		answer = sb.toString();
		
		return answer;
	}

	public static void main(String[] args) {
		
		int n = 1;
		int t = 1;
		int m = 1;
		
		String[] timetable = {"23:59"};
		
		System.out.println(solution(n, t, m, timetable));
		
	}

}
