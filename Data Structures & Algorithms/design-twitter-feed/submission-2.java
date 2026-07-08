class Twitter {
    private static class Tweet{
        int tweetId;
        long time;
        Tweet next;

        Tweet(int tweetId, long time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    private final Map<Integer, Tweet> userTweets;
    private final Map<Integer, Set<Integer>> follows;
    private long timestamp;

    public Twitter() {
        this.timestamp = 0;
        this.follows = new HashMap<>();
        this.userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, this.timestamp++);
        newTweet.next = userTweets.get(userId);
        userTweets.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet>pq = new PriorityQueue<>((a,b) -> Long.compare(b.time, a.time));
        if(userTweets.containsKey(userId)){ 
            pq.offer(userTweets.get(userId));
        }
        Set<Integer> followees = this.follows.get(userId);

        if(followees != null){
            for(int followeeId : followees){
                Tweet latestTweet = userTweets.get(followeeId);
                if(latestTweet != null){
                    pq.offer(latestTweet);
                }
            }
        }
        while(!pq.isEmpty() && result.size()<10){
            Tweet cur = pq.poll();
            result.add(cur.tweetId);

            if(cur.next!=null){
                pq.offer(cur.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followees = follows.get(followerId);
        if(followees != null){
            followees.remove(followeeId);
        }
    }
}
