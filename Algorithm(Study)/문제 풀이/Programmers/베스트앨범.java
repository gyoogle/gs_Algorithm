class 베스트앨범 {
    static final int hash_size = 1000;
	static final int hash_len = 40;
	static final int hash_val = 257;
	
	static int[][] hash_table = new int[hash_size][hash_len];
	static int[] cnt = new int[hash_size];
	static int[] plays_m;
	static String[] genres_m;
	
	static class Music {
		
		int playtime;
		int idx;
		
		Music(int playtime, int idx) {
			this.playtime = playtime;
			this.idx = idx;
		}

		public int getPlaytime() {
			return playtime;
		}

		public void setPlaytime(int playtime) {
			this.playtime = playtime;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}
		
	}
	
	public static int getHashKey(String str) {
		
		int key = 0;
		
		for (int i = 0; i < str.length(); i++) {
			key = (key*hash_val) + str.charAt(i);
		}
		
		if(key < 0) key = -key;
		
		return key % hash_size;
	}
	
	public static boolean isEquals(String origin, String compare) {
		
		if(origin.length() != compare.length()) return false;
		for (int i = 0; i < origin.length(); i++) {
			if(origin.charAt(i) != compare.charAt(i)) return false;
		}
		
		return true;
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        genres_m = new String[genres.length];
        plays_m = new int[plays.length];
        
        int[] result = new int[genres.length];
        int result_idx = 0;
        //테이블에 index를 저장
        for (int i = 0; i < genres.length; i++) {
			
        	String genre = genres[i];
        	int play = plays[i];
        	int index = i;
        	
        	int key = getHashKey(genre);
        	if(cnt[key] == 0) { // 처음 들어온 장르
        		hash_table[key][cnt[key]++] = index;
        		plays_m[index] = play;
        		genres_m[index] = genre;
        	}
        	else { // 들어온 적이 있거나, 충돌된 경우
        		boolean chk = false;
        		for (int j = 0; j < cnt[key]; j++) {
					int idx = hash_table[key][j];
					if(isEquals(genres_m[idx], genre)) { // 들어온적 있는 경우
						hash_table[key][cnt[key]++] = index;
						plays_m[index] = play;
						genres_m[index] = genre;
						break;
					}
					else { // 들어온 적 없는 경우
						chk = true;
						break;
					}
				}
        		if(chk) {
        			int temp = key+1;
        			while(true) {
        				if(cnt[temp] == 0) {
        					break;
        				}
        				else temp++;
        			}
        			hash_table[temp][cnt[temp]++] = index;
        			plays_m[index] = play;
        			genres_m[index] = genre;
        		}
        	}
		}
        
        // genre 별로 정렬해야함
        // 1. 속한 노래가 많은 재생한 장르를 찾아야 함
        
        int genreCnt = 0;
        int tempIdx = 0;
        int[] cntIdx = new int[cnt.length];
        for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] != 0) {
				genreCnt++;
				cntIdx[tempIdx++] = i;
			}
		}
        // cntIdx에는 cnt에 key가 저장된 해당 인덱스를 저장해둠
        
        Music[] music1 = new Music[genreCnt];
        String[] genresIdx = new String[genreCnt];
        
        for (int i = 0; i < music1.length; i++) {
			int key = cntIdx[i];
			int sumTime = 0;
			for (int j = 0; j < cnt[key]; j++) {
				sumTime += plays_m[hash_table[key][j]];
			}
			String tempStr = genres_m[hash_table[key][0]];
			music1[i] = new Music(sumTime, i);
			genresIdx[i] = tempStr;
		}
        
        quickSort2(music1, 0, music1.length-1);
        
        //int[] sort_cnt = new int[cnt.length];
        //for (int i = 0; i < cnt.length; i++) {
        //	sort_cnt[i] = cnt[i];
		//}
        
        //quickSort(sort_cnt, 0, sort_cnt.length-1);
        
        // 많이 저장된 장르부터 정렬된 배열이 완성됨 (sort_cnt)
        for (int i = 0; i < music1.length; i++) {
			String prio_genre = genresIdx[music1[i].idx];
			
			// 우선 순위 장르의 string을 얻었음. 이 중에 재생 수가 가장 많고, 고유번호가 낮은 2개 뽑기
			// 2개가 없으면 1개만 뽑기
			int[] genre_idx_list = new int[genres_m.length];
			int gidx = 0;
        	for (int j = 0; j < genres_m.length; j++) {
				if(isEquals(prio_genre, genres_m[j])) { // 장르가 일치하는 index
					genre_idx_list[gidx++] = j;
				}
			}
        	if(gidx == 0) break;
        	
        	Music[] music = new Music[gidx];
        	for (int j = 0; j < music.length; j++) {
        		music[j] = new Music(plays_m[genre_idx_list[j]], genre_idx_list[j]);
			}
        	if(music.length == 1) { // 장르가 한곡이면 걍 뽑으면 됨
        		result[result_idx++] = music[0].idx;
        	}
        	else {
	        	//재생수가 높은 순으로 정렬됨 (2개만 뽑기)
	        	quickSort2(music, 0, music.length-1);
	        	for (int j = 0; j < 2; j++) {
					Music tempMusic = music[j];
					result[result_idx++] = tempMusic.idx;
				}
        	}
		}
        
        answer = new int[result_idx];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = result[i];
		}
        
        return answer;
    }
	
	public static void quickSort(int[] arr, int start, int end) {
		
		if(start >= end) return;
		
		if(start < end) {
			
			int i = start-1;
			int j = end+1;
			int pivot = arr[(start+end)/2];
			
			while(true) {
				
				while(arr[++i] > pivot) {}
				while(arr[--j] < pivot) {}
				
				if(i >= j) break;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			quickSort(arr, start, i-1);
			quickSort(arr, j+1, end);
		}
	}
	
	public static void quickSort2(Music[] arr, int start, int end) {
			
		if(start >= end) return;
		
		if(start < end) {
			
			int i = start-1;
			int j = end+1;
			Music pivot = arr[(start+end)/2];
			
			while(true) {
				
				while(arr[++i].playtime > pivot.playtime ||
					 ((arr[i].playtime == pivot.playtime) && 
					  (arr[i].idx < pivot.idx))
					 ) {}
				while(arr[--j].playtime < pivot.playtime ||
					 ((arr[j].playtime == pivot.playtime) && 
					  (arr[j].idx > pivot.idx))
					 ) {}
				
				if(i >= j) break;
				
				Music temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			quickSort2(arr, start, i-1);
			quickSort2(arr, j+1, end);
		}
	}
}
