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
    private TextData textData = new TextData();
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public String blogs(Blog blog,Model model) {
        model.addAttribute("blogs",blogRepository.findAll());
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("userName", "UserName");
        model.addAttribute("back",textData.getBack_PL());
        model.addAttribute("content",textData.getBlogContent());
        model.addAttribute("nameT",textData.getBlogName());
        model.addAttribute("topicT",textData.getBlogTopic());
        model.addAttribute("messageT",textData.getBlogMessage());
        return "DataBaseTest";
    }
    @PostMapping("/blogs")
    public String addUser(@Valid Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        blogRepository.save(blog);
        return "redirect:/blogs";
    }
}

