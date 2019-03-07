import java.util.Arrays;

/**
 *
 * Ư�� ���ڿ��� ��� �κ� ���ڿ��� ���ĵ� ���·� �˰� ���� ��
 * Ư�� ���ڿ��� ��� ���̻縦 ���� -> ���� -> �� ���̻��� ��� ���λ縦 ����
 * 
 * Ʈ����(Trie) : ���ڿ��� ������ ǥ���ϴ� Ʈ��
 * ���̻��� Ʈ���� : ���ڿ��� ���̻��� Ʈ������ ����� ǥ��
 *
 * ���̾� Ʈ��(Suffix Tree) : Compressed Trie�� ����, ���ڿ� ���� $�� �ٿ��� ǥ��
 *     ���� �ð����⵵ O[n^2] => O[n log n] => O[n]
 * ���̾� �迭(Suffix Array) : ���̾���� ���������� ������ �迭, �ӵ��� ����, �޸� ���� 1/4, �ҽ��� ����
 *      ���� �ð����⵵ O[n log n]
 * LCP �迭 : (Longest Common Prefix) ���� ���� ���ξ�, ���̾� �迭�� ���� ���������� �ʿ���
 *     �� ���ڿ� ������ ���� ���ξ��� ����
 * 
 */

public class Z40_SuffixArray {

	public static void main(String[] args) {
		
		// banana�� ��� �κ� ���ڿ��� ���ĵ� ���·� ���
		String s = "banana";
		
		// s ���ڿ��� ��� ���̻� ����
		int[] sa = new int[s.length()]; // Suffix Array : index��°���� �����ϴ� ���ڿ�s�� ���̻�
		for (int i = 0; i < sa.length; i++) {
			sa[i] = i;
		}
		
		// s ���ڿ��� ��� ���̻� ���� => ��ü �˰��򿡼� ���� ���� �ɸ��� �κ�
		for (int i = 0; i < sa.length; i++) { // ���� ����
			int minIndex = i;
			for (int j = i; j < sa.length; j++) {
				// s.substring(sa[minIndex])�� s.substring(sa[j])�� ��
				if(s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
					minIndex = j;
				}
			}
			
			int temp = sa[minIndex];
			sa[minIndex] = sa[i];
			sa[i] = temp;
		}
		
		// LCP ���� ���� ���ξ� ������ �迭�� �غ�
		int[] LCP = new int[s.length()];
		// LCP[4] = s.substring(sa[3])�� substring(sa[4])�� ����������ξ��� ����
		for (int i = 1; i < LCP.length; i++) { // 1������ �����Ѵ�
			String s1 = s.substring(sa[i-1]);
			String s2 = s.substring(sa[i]);
			while( s1.length() > LCP[i] // ���ڰ� ���� ��� index ���� �߻��� �� ���� 
					&& s2.length() > LCP[i] 
					&& s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
				LCP[i]++;
			}
		}
		
		System.out.println(Arrays.toString(LCP) + " : LCP");
		
		
		/*
		// ���
		System.out.println(Arrays.toString(sa) + " : Suffix Array");
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]); // ���̻�
			System.out.println("<"+str+">");
			
			// �� ���̻��� ��� ���λ縦 ����
			for (int j = 1; j <= str.length(); j++) {
				System.out.println(str.substring(0, j)); // ���λ� = i~j�� �κй��ڿ�
			}
			
			System.out.println(str.length() + " : ���λ��� ����"); // = �ش� ���̻��� ����
			System.out.println(LCP[i] + " : ������� ���λ��� ����"); // �ߺ��� ���ڿ��� ������ �ľ��ϱ� ���ؼ� ���
			System.out.println(str.length() - LCP[i] + " : ��ȿ�� �κ� ���ڿ��� ����"); 
		}
		*/
		
		System.out.println("\n\n����Ǯ��");
		System.out.println("s���ڿ����� ���� �� �ִ� ��� �κ� ���ڿ��� ������ ���Ļ��¿��� k��° ���ڿ�");
		
		int k = 13;
		int index = k;
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]);
			if (index - (str.length() - LCP[i]) > 0) {
				index = index - (str.length() - LCP[i]); // ��ȿ�� ���ڿ��� ������ ����
			} else { // �� ���̻��� ���λ�鿡�� k��° ���ڿ��� ���ԵǾ� �ִ�
				System.out.println(str.substring(0, LCP[i] + index)); // k��° ���̻�
				break;
			}
		}
		
	} // end of main
} // end of class
