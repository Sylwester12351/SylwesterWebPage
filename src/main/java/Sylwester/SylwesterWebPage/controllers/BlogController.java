package Sylwester.SylwesterWebPage.controllers;

import Sylwester.SylwesterWebPage.entity.Blog;
import Sylwester.SylwesterWebPage.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogs",blogRepository.findAll());
        model.addAttribute("date", LocalDate.now());
        return "DataBaseTest";
    }
    @PostMapping("/blogs")
    public String addUser(@Valid Blog blog, BindingResult result, Model model,Authentication authentication) {
        if (result.hasErrors()) {
            return "error";
        }
        blog.setName(authentication.getName());
        blogRepository.save(blog);
        return "redirect:/blogs";
    }
}

