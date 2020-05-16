package com.dudacf26.cloudnative.tema7.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterService {

    @Autowired
    private TwitterConfig twitterConfig;

    public TwitterDomain listarTweets(String usuario) {
        TwitterDomain twitterDomain = new TwitterDomain();
        Twitter twitter = twitterConfig.conexaoTwitter();
        try {
            int quantidadeDeTwetts = twitter.showUser(usuario).getStatusesCount();
            twitterDomain.setUsuario(usuario);
            twitterDomain.setQuantidadeDeTwetts(quantidadeDeTwetts);
        } catch (TwitterException erro) {
            erro.getMessage();
        }
        return twitterDomain;
    }
}


