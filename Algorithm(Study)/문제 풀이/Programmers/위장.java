import java.util.HashMap;
import java.util.Map;
class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth :
                clothes) {
            if (!map.containsKey(cloth[1])) {
                map.put(cloth[1], 1);
                continue;
            }
            map.put(cloth[1], map.get(cloth[1]) + 1);
        }

        int numberOfCases = 1;
        for (Integer cases :
                map.values()) {
            numberOfCases *= (cases + 1);
        }

        return numberOfCases - 1;
    }
}
