class Twitter {
    private int timestamp = 0; // 全局时间戳
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap;

    private class Tweet{
        int id, time;
        Tweet next;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        if(tweetMap.containsKey(userId)){
            newTweet.next = tweetMap.get(userId);
        }
        tweetMap.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));
        if(tweetMap.containsKey(userId)){
            pq.offer(tweetMap.get(userId));
        }
        if(followMap.containsKey(userId)){
            for(int followee : followMap.get(userId)){
                if(tweetMap.containsKey(followee)){
                    pq.offer(tweetMap.get(followee));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size() < 10){
            Tweet cur = pq.poll();
            res.add(cur.id);
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
