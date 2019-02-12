package ct01_����_5_��Լ�;

public class ct01_mabangjin {

	static int[][] map; // �������� ���� 2���� �迭 ����

	static void makeMabangjin(int size) { // ������ ���� �޼ҵ�
		
		map = new int[size][size]; // �Ķ���ͷ� ���� �����ŭ map�迭 ������ ����

		int fill = 0; // ������ �迭�� ���� ���� ����

		int stop = size * size; // ������ ũ�� ��ŭ ���ڰ� �����Ǹ� �����ų ���� ����

		// ó�� 1�� �� �Ʒ� �߾� �迭���� ������
		// map[y][x]
		
		int y = size - 1; 
		int x = size / 2;

		while (true) {
			
			map[y][x] = ++fill;
			if (fill == stop) // fill�̶� stop�̶� ������ ������ ����
				break;

			//���� ���ڸ� �ֱ� ���� ������ �Ʒ��� �˻� (y�� x 1�� ������Ű�� ��)
			int ny = y + 1;
			int nx = x + 1;

			if (ny > size - 1 && nx > size - 1) { // �Ѵ� �迭 ������ ������ ����� �߰��� �� �����Ƿ� �ڱ��ڸ� ���� �߰�
				y = y - 1;
			} else if (ny > size - 1) { // ny�� ����� �� �ʿ� ���� �߰��� �� �ֳ� Ȯ��
				if (map[0][nx] == 0) { // 0�̸� �߰� ����
					y = 0;
					x = nx;
				} else { // �̹� ��ϵǾ������� �ڱ��ڸ� ���� �߰�
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
				if (map[ny][nx] == 0) { // ���� ������ �Ʒ��� ����ְ� �迭 ���̶�� �߰� ����
					y = ny;
					x = nx;
				} else { // �ƴϸ� �ڱ��ڸ� ���� �߰�
					y = y - 1;
				}
			}

		}
	}
	
	static boolean check(int[][] map){ // �ش� �迭�� ���������� �ƴ��� Ȯ���ϴ� �޼ҵ�
		
		int row = 0; 
		boolean chk = true;
		int temp = 0;
		
		for (int i = 0; i < map.length; i++) { // Ư�� ���� �� �� ����
			row += map[0][i];
		}
		
		
		// �� �� ���� �����ϸ鼭 row�� ��
		for (int i = 0; i < map.length; i++) {
			
			temp = 0;
			
			for (int j = 0; j < map.length; j++) {
				temp += map[i][j];
			}
			
			if(row != temp){ // ���� �� ���� �ٸ��� �������� �� �� ����
				chk = false;
				break;
			}
			else 
				chk = true;
		}
		
		temp = 0;
		
		// �밢�� ���� �����ϸ鼭 row�� ��
		for (int i = 0, j = 0; i < map.length; i++, j++) {
			temp += map[i][j];
		}
		
		if(row != temp) // ���� �� ���� �ٸ��� �������� �� �� ����
			chk = false;
		
		temp = 0;
		
		for (int i = 0, j = map.length-1; i < map.length; i++, j--) {
			temp += map[i][j];
		}
		
		if(row != temp) // ���� �� ���� �ٸ��� �������� �� �� ����
			chk = false;
		
		
		if(!chk) {
			System.out.println("�������� �ƴմϴ�!");
			return false;
		}
		// false�� �ƴϸ� ������
		
		System.out.println("�������� �½��ϴ�!");
		System.out.println("�� ���� �� �� : " + row);
		System.out.println("��ü ���� �� : " + (row * (map.length)));
		
		return true;
	}

	public static void main(String[] args) {

		int num = 5; // 5x5 ������

		makeMabangjin(num);

		System.out.println("[" + num + "x" + num + " ������]");
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//������ �ƴ��� Ȯ���ϱ� ���� �� �����غ���
		//map[0][0] = 1;
		
		check(map);
		
	}

}
