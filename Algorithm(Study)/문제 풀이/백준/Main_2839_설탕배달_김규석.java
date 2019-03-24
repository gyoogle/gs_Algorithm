import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_�������_��Լ� {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int min = Integer.MAX_VALUE;
		int cnt = 0;

		if (N % 5 == 0) { // 5ų�� ���������� ��� �����ϸ�
			cnt = N / 5;
			if (min > cnt)
				min = cnt;
		}
		if (N % 3 == 0) { // 3ų�� ���������� ��� �����ϸ�
			cnt = N / 3;
			if (min > cnt)
				min = cnt;
		}

		cnt = 0;
		while (N > 5) { // 5�� ���ָ鼭 3�� ���������� Ȯ��
			cnt++; //5���� �� �߰�
			N -= 5;

			if (N % 3 == 0) { // 3�� �����ָ� ���� üũ
				int res = cnt + N / 3;
				if (min > res)
					min = res;
			}
		}

		if (min == Integer.MAX_VALUE) // min�� ��ȭ ������ -1
			min = -1;

		System.out.println(min);
	}

}
