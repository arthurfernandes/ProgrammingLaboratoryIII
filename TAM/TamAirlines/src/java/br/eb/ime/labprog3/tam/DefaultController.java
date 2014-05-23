/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author arthurfernandes
 */
@Controller
public class DefaultController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("hello", "Hello Spring from Netbeans!!");
        
        return "index";
    }

}
