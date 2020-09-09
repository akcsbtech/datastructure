package leetcodeproblem.may2020;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
class LogSystem {
    TreeMap<String, List<Integer>> timeToIdMap;
    String minTimeStamp;
    String maxTimeStamp;
    Map<String, Integer> graMap;
 
    public LogSystem() {
        timeToIdMap = new TreeMap<>();
        minTimeStamp = "2000:01:01:00:00:00";
        maxTimeStamp = "2017:12:31:23:59:59";
        graMap = new HashMap<>();
        graMap.put("Year", 4);
        graMap.put("Month", 7);
        graMap.put("Day", 10);
        graMap.put("Hour", 13);
        graMap.put("Minute", 16);
        graMap.put("Second", 19);
    }
     
    public void put(int id, String timestamp) {
        List<Integer> idList = timeToIdMap.getOrDefault(timestamp, new ArrayList<>());
        idList.add(id);
        timeToIdMap.put(timestamp, idList);
    }
     
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ans = new ArrayList<>();
        int graIdx = graMap.get(gra);
        String startTime = s.substring(0, graIdx) + minTimeStamp.substring(graIdx);
        String endTime = e.substring(0, graIdx) + maxTimeStamp.substring(graIdx);
 
        NavigableMap<String, List<Integer>> subMap = timeToIdMap.subMap(
            startTime, true, endTime, true);
 
        for (String timeStamp : subMap.keySet()) {
            ans.addAll(subMap.get(timeStamp));
        }
 
        return ans;
    }
}
 
/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */