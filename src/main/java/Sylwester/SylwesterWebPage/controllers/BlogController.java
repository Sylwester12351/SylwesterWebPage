package Sylwester.SylwesterWebPage.controllers;

import Sylwester.SylwesterWebPage.entity.Blog;
import Sylwester.SylwesterWebPage.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String blogs(Blog blog,Model model) {
        model.addAttribute("blogs",blogRepository.findAll());
        model.addAttribute("date", LocalDate.now());
        return "DataBaseTest";
    }
    @GetMapping("/SylwesterWebPage/blogs/DataBaseAddText")
    public String addNewText (Blog blog,Model model) {
        model.addAttribute("date", LocalDate.now());
        return "DataBaseAdd";
    }

    @PostMapping("/SylwesterWebPage/blogs/DataBaseAddText")
    public String addUser(@Valid Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        blogRepository.save(blog);
        return "redirect:/blogs";
    }
}

