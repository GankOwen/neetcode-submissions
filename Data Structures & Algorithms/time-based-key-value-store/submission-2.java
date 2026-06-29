class TimeMap {

    static class Record{
        int time;
        String value;

        Record(int time, String value){
            this.time = time;
            this.value = value;
        }
    }

    private Map<String, List<Record>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Record(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Record> list = map.get(key);
        if(list == null){
            return "";
        }

        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = left + (right - left) / 2;

            if(list.get(mid).time <= timestamp){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left == 0 ? "" : list.get(left - 1).value;
    }
}
