/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author arthurfernandes
 */
@Controller
@RequestMapping(value="rotas")
public class MenorCaminhoController {
    @RequestMapping(value="menorcaminho")
    public String menorCaminho(ModelMap map,HttpServletRequest request){
        String fileNameTrechos="../../resources/xml/rotas.xml";
        String fileNameAeroportos="../../resources/xml/aeroportos.xml";
        
        Resource resource = null;
        TrechoDAO daoTrecho = null;
        AeroportoDAO daoAeroporto = null;
        
        resource = new ClassPathResource(fileNameTrechos);
        try {
            daoTrecho = new TrechoDAO(resource.getFile());
        } catch (IOException ex) {
            Logger.getLogger(MenorCaminhoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resource = new ClassPathResource(fileNameAeroportos);
        try {
            daoAeroporto = new AeroportoDAO(resource.getFile());
        } catch (IOException ex) {
            Logger.getLogger(MenorCaminhoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Aeroporto> listaDeAeroportos = daoAeroporto.listarAeroportos();
        List<Trecho> listaDeTrechos = daoTrecho.listarTrechos();
        GeradorGrafoDijkstra geradorDeGrafo = new GeradorGrafoDijkstra(daoAeroporto.listarAeroportos(),daoTrecho.listarTrechos());
        
        int origem = -1;
        int destino = -1;
        try{
            origem = Integer.parseInt(request.getParameter("origem"));
            destino = Integer.parseInt(request.getParameter("destino"));
        }
        catch(Exception e){
            return "erro";
        }
        
        if(origem<0 || destino<0)
            return "erro";
        
        List<Aeroporto> listaDeAeroportosDestino = geradorDeGrafo.geraMenorCaminho(origem, destino);
        List<Trecho> listaDeTrechosDestino = new ArrayList<>();
        
        map.addAttribute("aeroportoOrigem",listaDeAeroportos.get(origem-1));
        map.addAttribute("aeroportoDestino",listaDeAeroportos.get(destino-1));
        
        if(listaDeAeroportosDestino.size() ==1){
            map.addAttribute("visibility",0);
            if(listaDeAeroportos.get(origem-1).getId()==listaDeAeroportos.get(destino-1).getId())
                map.addAttribute("visibility",1);
        }
        else{
        
            for(int i = 0;i<listaDeAeroportosDestino.size()-1;i++){
                Aeroporto aeroportoOrigem = listaDeAeroportosDestino.get(i);
                for(int j = 0;j<listaDeTrechos.size();j++){
                   Trecho trecho = listaDeTrechos.get(j);

                   if(trecho.getIdAeroportoOrigem()==aeroportoOrigem.getId()){
                       Aeroporto aeroportoDestino = listaDeAeroportosDestino.get(i+1);
                       trecho.setAeroportoOrigemNome(aeroportoOrigem.getNome());
                       if(trecho.getIdAeroportoDestino()==aeroportoDestino.getId()){
                           trecho.setAeroportoDestinoNome(aeroportoDestino.getNome());
                           listaDeTrechosDestino.add(trecho);
                       }
                   }
                }
            }
            map.addAttribute("visibility",2);
        }
        
        map.addAttribute("listaDeAeroportos",listaDeAeroportos);
        map.addAttribute("listaDeTrechos", listaDeTrechosDestino);
        
        return "menorcaminho";
    }
}
