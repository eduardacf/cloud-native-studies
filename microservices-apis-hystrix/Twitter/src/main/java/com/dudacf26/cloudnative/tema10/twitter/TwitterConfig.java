package com.dudacf26.cloudnative.tema10.twitter;

import org.springframework.beans.factory.annotation.Value;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfig {

    @Value("${CONSUMER_KEY}")
    private String CONSUMER_KEY;
    @Value("${CONSUMER_SECRET}")
    private String CONSUMER_SECRET;
    @Value("${ACCESS_TOKEN}")
    private String ACCESS_TOKEN;
    @Value("${ACCESS_TOKEN_SECRET}")
    private String ACCCESS_TOKEN_SECRET;

    private Twitter conexaoTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}
