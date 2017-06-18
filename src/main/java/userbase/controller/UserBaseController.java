package userbase.controller;

/**
 *Controller for users information {@link userbase.models.User}
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import userbase.models.User;
import userbase.service.UserBaseService;

@Controller
public class UserBaseController {
    private UserBaseService userBaseService;

    @Autowired(required = true)
    @Qualifier(value = "userBaseService")
    public void setUserBaseService(UserBaseService userBaseService) {
        this.userBaseService = userBaseService;
    }

    /*
     *--------------user_mode--------------
     */

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userBaseService.listUsers());

        return "users";
    }

    /*
     * ------------Edit profile------------
     */

    @RequestMapping(value = "/welcome/changedata", method = RequestMethod.POST)
    public String changeProfileData(@ModelAttribute("user") User user){
        this.userBaseService.editUser(user);
        return "redirect:/welcome";
    }

    @RequestMapping("/editprofile/{id}")
    public String editProfile(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userBaseService.getUserById(id));
        model.addAttribute("listUsers", this.userBaseService.listUsers());

        return "welcome";
    }

    /*
     *--------------admin_mode--------------
     */

    @RequestMapping(value = "usersadmin", method = RequestMethod.GET)
    public String adminListUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("adminListUsers", this.userBaseService.listUsers());

        return "usersadmin";
    }

    @RequestMapping(value = "/usersadmin/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        this.userBaseService.editUser(user);

        return "redirect:/usersadmin";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userBaseService.removeUser(id);

        return "redirect:/usersadmin";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userBaseService.getUserById(id));
        model.addAttribute("adminListUsers", this.userBaseService.listUsers());

        return "usersadmin";
    }

    @RequestMapping("usersdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userBaseService.getUserById(id));

        return "usersdata";
    }

}
