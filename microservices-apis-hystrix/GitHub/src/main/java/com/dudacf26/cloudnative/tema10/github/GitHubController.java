package com.dudacf26.cloudnative.tema10.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GitHubController {

    @Autowired
    private GitHubService gitHubService;

    @RequestMapping(value = "/github/{usuario}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<GitHubDomain> getUsuarioGitHub(@PathVariable("usuario") String usuario) {
        try {
            GitHubDomain gitHubDomain = gitHubService.listarRepositorios(usuario);
            return new ResponseEntity<>(gitHubDomain, HttpStatus.OK);
        } catch (Exception erro) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}

