package org.example.webiste.controller;

import org.example.webiste.DTO.UserDto;
import org.example.webiste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/create")
    public String register (
            @ModelAttribute UserDto dto, Model model
    ) {
        userService.create(dto);
        return "redirect:list";
    }

    /**
     * User list endpoint. Shows user list page using search data
     * @param dto dto for search data
     * @return users list page
     */
    @GetMapping("list")
    public String showUserList(
            @ModelAttribute UserDto dto,
            Model model
    ) {
        model.addAttribute("user", dto);
        model.addAttribute("users", userService.search(dto));

        return "userlist";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute UserDto dto, Model model) {
        model.addAttribute("user", dto);
        model.addAttribute("users", userService.search(dto));
        return "userlist";
    }

    @GetMapping("edit/{id}")
    public String showEditPage(
            @PathVariable("id") Long id,
            Model model
    ) {
        UserDto dto = userService.findById(id);
        System.out.println("edit user " + dto.toString());
        model.addAttribute("user", dto);
        return "edit";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto dto, RedirectAttributes redirectAttributes) {
        if (userService.login(dto)) {
            return "redirect:/user/list";
        }
        redirectAttributes.addFlashAttribute("error", "User not found");
        return "redirect:/user/login";
    }

    @PostMapping("update/{id}")
    public ModelAndView update(
            @PathVariable("id") Long id,
            @ModelAttribute UserDto dto,
            Model model
    ) {
        userService.update(dto);
        return new ModelAndView ("redirect:/user/list");
    }

    @PostMapping("delete/{id}")
    public ModelAndView deleteUser(
            @PathVariable("id") Long id,
            Model model
    ) {
        userService.deleteById(id);
        return new ModelAndView ("redirect:/user/list");
    }


}
