package com.dudacf26.cloudnative.tema10.github;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GitHubService {

    @Autowired
    private GitHubDomain gitHubDomain;

    public GitHubDomain listarRepositorios(String usuario) throws IOException {
        GitHub github = new GitHubBuilder().build();
        GitHubDomain gitHubDomain = new GitHubDomain();
        gitHubDomain.setUsuario(usuario);
        gitHubDomain.setNumeroRepositorios(github.getUser(usuario).getRepositories().size());
        return gitHubDomain;
    }
}
