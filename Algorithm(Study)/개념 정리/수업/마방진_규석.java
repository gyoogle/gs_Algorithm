package ct01_서울_5_김규석;

public class ct01_mabangjin {

	static int[][] map; // 마방진을 만들 2차원 배열 생성

	static void makeMabangjin(int size) { // 마방진 생성 메소드
		
		map = new int[size][size]; // 파라메터로 받은 사이즈만큼 map배열 사이즈 선언

		int fill = 0; // 마방진 배열에 넣을 숫자 선언

		int stop = size * size; // 사이즈 크기 만큼 숫자가 생성되면 종료시킬 변수 선언

		// 처음 1은 맨 아래 중앙 배열부터 시작함
		// map[y][x]
		
		int y = size - 1; 
		int x = size / 2;

		while (true) {
			
			map[y][x] = ++fill;
			if (fill == stop) // fill이랑 stop이랑 같으면 밖으로 나감
				break;

			//다음 숫자를 넣기 위해 오른쪽 아래를 검색 (y와 x 1씩 증가시키면 됨)
			int ny = y + 1;
			int nx = x + 1;

			if (ny > size - 1 && nx > size - 1) { // 둘다 배열 사이즈 밖으로 벗어나면 추가할 곳 없으므로 자기자리 위에 추가
				y = y - 1;
			} else if (ny > size - 1) { // ny만 벗어나면 끝 쪽에 숫자 추가할 곳 있나 확인
				if (map[0][nx] == 0) { // 0이면 추가 가능
					y = 0;
					x = nx;
				} else { // 이미 등록되어있으면 자기자리 위에 추가
					y = y - 1;
				}
			} else if (nx > size - 1) {
				if (map[ny][0] == 0) {
					y = ny;
					x = 0;
				} else {
					y = y - 1;
				}
			} else {
				if (map[ny][nx] == 0) { // 만약 오른쪽 아래에 비어있고 배열 안이라면 추가 가능
					y = ny;
					x = nx;
				} else { // 아니면 자기자리 위에 추가
					y = y - 1;
				}
			}

		}
	}
	
	static boolean check(int[][] map){ // 해당 배열이 마방진인지 아닌지 확인하는 메소드
		
		int row = 0; 
		boolean chk = true;
		int temp = 0;
		
		for (int i = 0; i < map.length; i++) { // 특정 행의 합 값 저장
			row += map[0][i];
		}
		
		
		// 각 행 값을 저장하면서 row와 비교
		for (int i = 0; i < map.length; i++) {
			
			temp = 0;
			
			for (int j = 0; j < map.length; j++) {
				temp += map[i][j];
			}
			
			if(row != temp){ // 만약 두 값이 다르면 마방진이 될 수 없음
				chk = false;
				break;
			}
			else 
				chk = true;
		}
		
		temp = 0;
		
		// 대각선 값을 저장하면서 row와 비교
		for (int i = 0, j = 0; i < map.length; i++, j++) {
			temp += map[i][j];
		}
		
		if(row != temp) // 만약 두 값이 다르면 마방진이 될 수 없음
			chk = false;
		
		temp = 0;
		
		for (int i = 0, j = map.length-1; i < map.length; i++, j--) {
			temp += map[i][j];
		}
		
		if(row != temp) // 만약 두 값이 다르면 마방진이 될 수 없음
			chk = false;
		
		
		if(!chk) {
			System.out.println("마방진이 아닙니다!");
			return false;
		}
		// false가 아니면 마방진
		
		System.out.println("마방진이 맞습니다!");
		System.out.println("한 행의 합 값 : " + row);
		System.out.println("전체 총합 값 : " + (row * (map.length)));
		
		return true;
	}

	public static void main(String[] args) {

		int num = 5; // 5x5 마방진

		makeMabangjin(num);

		System.out.println("[" + num + "x" + num + " 마방진]");
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//마방진 아닌지 확인하기 위해 값 변경해보기
		//map[0][0] = 1;
		
		check(map);
		
	}

}
