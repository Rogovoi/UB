package userbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import userbase.models.SecurityUser;
import userbase.service.SecurityLoginServise;
import userbase.service.SecurityUserService;
import userbase.validator.SecurityUserValidator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
public class SecurityUserController {

    @Autowired
    private SecurityUserService securityUserService;

    @Autowired
    private SecurityLoginServise securityLoginServise;

    @Autowired
    private SecurityUserValidator securityUserValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("loginForm", new SecurityUser());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("loginForm") SecurityUser loginForm, BindingResult bindingResult, Model model) {
        securityUserValidator.validate(loginForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        securityUserService.save(loginForm);

        securityLoginServise.autoLogin(loginForm.getLogin(), loginForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }


}
