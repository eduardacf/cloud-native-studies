package com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao.Config;

import com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao.Domain.AgregacaoDomain;
import com.dudacf26.cloudnative.tema7.integracao_tt_git.integracao.Service.AgregacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration

public class AgregacaoController {

    @Autowired
    private AgregacaoService agregacaoService;

    @RequestMapping("/twitter/{usuarioTwitter}/github/{usuarioGitHub}")
    public ResponseEntity<AgregacaoDomain> retornoTwettsRepo(@PathVariable("usuarioTwitter") String usuarioTwitter,
                                                                 @PathVariable("usuarioGitHub") String usuarioGitHub) {
        try {
            AgregacaoDomain agregacaoDomain = agregacaoService.getTweetsRepo(usuarioTwitter, usuarioGitHub);
            return new ResponseEntity<>(agregacaoDomain, HttpStatus.OK);
        } catch (Exception erro) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

    }
}
