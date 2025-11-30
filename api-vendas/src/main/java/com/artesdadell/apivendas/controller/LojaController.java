package com.artesdadell.apivendas.controller;

import com.artesdadell.apivendas.model.Produto;
import com.artesdadell.apivendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LojaController {

    @Autowired private ProdutoRepository produtoRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("produtos", produtoRepo.findAll());
        return "index";
    }

    @GetMapping("/produto/{id}")
    public String detalheProduto(@PathVariable Long id, Model model) {
        Produto prod = produtoRepo.findById(id).orElse(null);
        if (prod != null) {
            model.addAttribute("p", prod);
            return "detalhe-produto";
        }
        return "redirect:/";
    }

    @GetMapping("/checkout/{id}")
    public String checkout(@PathVariable Long id, Model model) {
        Produto prod = produtoRepo.findById(id).orElse(null);
        if (prod != null) {
            model.addAttribute("p", prod);
            return "checkout";
        }
        return "redirect:/";
    }
}
