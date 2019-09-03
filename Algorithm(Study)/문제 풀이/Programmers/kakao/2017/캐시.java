package algorithm;

import java.util.LinkedList;

public class Ä³½Ã {
	
	public static LinkedList<String> list;
	public static int index = 0;
	
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		list = new LinkedList<>();
		
		if(cacheSize == 0) {
			answer += cities.length*5;
		}
		else {
			for (int i = 0; i < cities.length; i++) {
				
				String city = cities[i].toLowerCase();
				
				if(list.size() < cacheSize) {
					if(checking(city)) {
						list.remove(index);
						list.add(city);
						answer+=1;
					}
					else {
						list.add(city);
						answer+=5;
					}
				}
				else if(list.size() == cacheSize) {
					if(checking(city)) {
						list.remove(index);
						list.add(city);
						answer+=1;
					}
					else {
						list.remove(0);
						list.add(city);
						answer+=5;
					}
				}
				
			}
		}
		
		return answer;
	}
	
	public static boolean checking(String city) {
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(city)) {
				index = i;
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println(solution(3, cities));
		
	}

}
