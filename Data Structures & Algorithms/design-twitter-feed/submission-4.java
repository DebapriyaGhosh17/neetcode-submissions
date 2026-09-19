class Twitter {
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    Map<Integer, List<Integer>> followlist = new HashMap<>();

    int time = 0;

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }

        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> allTweets = new ArrayList<>();

        if (tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }

        if (followlist.containsKey(userId)) {
            for (int followeeId : followlist.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    allTweets.addAll(tweets.get(followeeId));
                }
            }
        }

        allTweets.sort((a, b) -> b.time - a.time);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i).tweetId);
        }

        return result;
    }
    public void follow(int followerId, int followeeId) {
        if (!followlist.containsKey(followerId)) {
            followlist.put(followerId, new ArrayList<>());
        }

        if (!followlist.get(followerId).contains(followeeId)) {
            followlist.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followlist.containsKey(followerId)) {
            followlist.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}