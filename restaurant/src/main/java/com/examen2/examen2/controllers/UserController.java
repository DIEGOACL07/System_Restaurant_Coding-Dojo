package com.examen2.examen2.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.examen2.examen2.models.Mesa;
import com.examen2.examen2.models.User;
import com.examen2.examen2.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

  @Autowired
  private UserService userService;


  @GetMapping("/")
  public String Register(@ModelAttribute("user") User user) {
    return "register.jsp";
  }

  @PostMapping("/")
  public String createUser(
      @Valid @ModelAttribute("user") User user,
      BindingResult result,
      HttpSession session) {
    User unique = userService.findByEmail(user.getEmail());
    if (unique != null) {
      ObjectError error = new ObjectError(
          "email",
          "Email ya se encuentra en uso");
      result.addError(error);
    }

    if (!user.getPassword().contentEquals(user.getPasswordConfirmation())) {
      ObjectError error = new ObjectError(
          "passwordConfirmation",
          "Las contraseñas no coinciden");
      result.addError(error);
    }

    if (result.hasErrors()) {
      return "register.jsp";
    }

    User newUser = userService.registerUser(user);
    session.setAttribute("user_id", newUser.getId());
    return "redirect:/home";
  }

  @GetMapping("/home")
  public String home(Model model, HttpSession session) {
    if (session.getAttribute("user_id") == null) {
      return "redirect:/login";
    }
    User current = userService.findById(
        (Long) session.getAttribute("user_id"));
    List<Mesa> mesasUser = current.getMesas();
    model.addAttribute("Mesa", mesasUser);
    model.addAttribute("user", current);

    return "home.jsp";
  }

  @GetMapping("/login")
  public String login() {
    return "login.jsp";
  }

  @PostMapping("/login")
  public String loginUser(
      @RequestParam("email") String email,
      @RequestParam("password") String password,
      Model model,
      HttpSession session) {
    if (!userService.authenticateUser(email, password)) {
      model.addAttribute("error", "Credenciales inválidas");
      return "login.jsp";
    }

    User authUser = userService.findByEmail(email);
    session.setAttribute("user_id", authUser.getId());
    return "redirect:/home";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("user_id");
    return "redirect:/login";
  }
}
