package com.examen2.examen2.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.examen2.examen2.models.Mesa;
import com.examen2.examen2.models.User;
import com.examen2.examen2.service.MesaService;
import com.examen2.examen2.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @Autowired
    private UserService userService;

    @GetMapping("/home/tables/new")
    public String newTable(@ModelAttribute("Mesa") Mesa mesa) {
        return "/newMesa.jsp";
    }

    @PostMapping("/tables/new")
    public String createTable(@Valid @ModelAttribute("Mesa") Mesa mesa, BindingResult result) {
        if (result.hasErrors()) {
            return "/newMesa.jsp";
        } else {
            mesaService.save(mesa);
            return "redirect:/home";
        }
    }

    @GetMapping("/tables/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/login";
        }
        Mesa editmesa = mesaService.findById(id);
        model.addAttribute("mesa", editmesa);
        return "/edit.jsp";
    }

    @PutMapping("/tables/{id}/edit")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("mesa") Mesa mesa,
            BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            mesaService.updateMesa(id, mesa);
            return "redirect:/home";
        }
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/login";
        }
        mesaService.deleteById(id);
        return "redirect:/home";
    }

    @PostMapping("/{id}/give")
    public String giveUpTable(@PathVariable("id") Long mesaId, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            Mesa mesa = mesaService.findById(mesaId);

            if (mesa != null && mesa.getUser() != null && mesa.getUser().getId().equals(userId)) {
                mesa.setUser(null);
                mesaService.update(mesa);
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/tables")
    public String allTables(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/login";
        }
        List<Mesa> openTables = mesaService.findOpenTables();
        model.addAttribute("mesas", openTables);
        return "tables.jsp";
    }

    @PostMapping("/tables")
    public String assignTable(@RequestParam("mesaId") Long mesaId, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            Mesa mesa = mesaService.findById(mesaId);
            User user = userService.findById(userId);

            if (mesa != null && user != null) {
                mesa.setUser(user);
                mesaService.update(mesa);
            }
        }
        return "redirect:/tables";
    }

}
