/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthurfernandes
 */
package br.eb.ime.labprog3.tam;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping(value="index")
    public String index(ModelMap map) {
        
        String fileName="../../resources/xml/aeroportos.xml";
        Resource resource = null;
        
        resource = new ClassPathResource(fileName);

        AeroportoDAO dao = null;
        try {
            dao = new AeroportoDAO(resource.getFile());
        } catch (IOException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Aeroporto> listaDeAeroportos = null;
        
        if(dao!=null){
            listaDeAeroportos = dao.listarAeroportos();
            map.addAttribute("listaDeAeroportos",listaDeAeroportos);
            
        }
        
        return "index";
    }
    
    @RequestMapping(value="about")
    public String about(){
        return "about";
    }
    

}
