class 소수만들기 {
    static int[] set;
	static int r = 3;
	static int result;
	
	public static int solution(int[] nums) {
		result = 0;
        set = new int[r];
        
        comb(0, 0, nums);

        return result;
    }
	
	public static void comb(int len, int k, int[] nums) {
		
		if(len == r) {
			int sum = 0;
			for (int i = 0; i < set.length; i++) {
				sum += set[i];
			}
			
			if(checkPrime(sum)) result++;
			
			return;
		}
		if(k == nums.length) return;
		
		set[len] = nums[k];
		comb(len+1, k+1, nums);
		comb(len, k+1, nums);
	}
	
	public static boolean checkPrime(int sum) {
		
		for (int i = 2; i <= Math.sqrt(sum); i++) {
			if(sum % i == 0) return false;
		}
		
		return true;
	}
}
