package com.dudacf26.cloudnative.tema7.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(value = "/twitter/{usuario}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<TwitterDomain> getUsuarioTwitter(@PathVariable("usuario") String usuario) {
        try {
            TwitterDomain twitterDomain = twitterService.listarTweets(usuario);
            return new ResponseEntity<>(twitterDomain, HttpStatus.OK);
        } catch (Exception erro) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
