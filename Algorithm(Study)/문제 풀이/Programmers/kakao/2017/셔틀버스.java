package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class ��Ʋ���� {
	
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
		
		//Ż �� �ִ� �ð� �߿� �ִ��� ���� �ð� ���ϱ�
		
		for (int b = 1; b <= n; b++) { // n��
			
			// ���� ������ Ż �� �ִ� �ο�
			fast = 0;
			for (int i = 0; i < list.size(); i++) {
				if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
					fast++;
				}
			}
			
			//System.out.println("fast : " + fast);
			
			// �� �ο��� ���� ž�·����� ���� ��
			if(fast < m) {
				if(b == n) { // ���� Ÿ�߉�
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
				else { // �� �ο��� ���� �¿� ������
					//System.out.println("�¿���");
					for (int i = 0; i < list.size(); i++) {
						if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
							list.remove(i);
							i--;
						}
					}
				}
			}
			
			//�� �ο��� ���� ž�·��� ���ų� ���� ��
			else if(fast >= m) {
				if(b == n) { // ���� Ÿ�߉�
					int cnt = 0;
					for (int i = 0; i < list.size(); i++) {
						if((list.get(i).h < hour) || ((list.get(i).h == hour) && list.get(i).m <= minute)) {
							fh = list.get(i).h;
							fm = list.get(i).m;
							cnt++;
							if(cnt == m) { // �ð� üũ �ٽ� Ȯ��
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
			
			// �ð� ����
			if(minute + t < 60) {
				minute += t;
			}
			else {
				hour += 1;
				minute = (minute+t) - 60;
			}
			
			//System.out.println("���� ���� ž�� �ο� : " + fast);
			//System.out.println("Ÿ�� ���� ��� : " + list.size());
			//System.out.println("���� ���� �ð� : " + hour + ":" + minute);
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
