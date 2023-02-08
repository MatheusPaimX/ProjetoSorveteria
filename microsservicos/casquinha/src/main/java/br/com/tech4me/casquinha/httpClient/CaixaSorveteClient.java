package br.com.tech4me.casquinha.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.casquinha.model.CaixaSorvete;

@FeignClient("caixasorvetes")
public interface CaixaSorveteClient{
    
    @RequestMapping(method= RequestMethod.GET, value="/sorveteria/{id}")
    CaixaSorvete obterCaixaSorvete(@PathVariable String id);

}
