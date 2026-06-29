class TimeMap {
    Map<String, List<Integer>> timeMap;
    Map<String, List<String>> valueMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        valueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        List<Integer> times = timeMap.get(key);
        List<String> values = valueMap.get(key);
        
        // Binary search for the largest timestamp <= given timestamp
        int l = 0, r = times.size(), res = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (times.get(mid) <= timestamp) {
                res = mid + 1;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res < 0 ? "" : values.get(res -1);
    }
}
