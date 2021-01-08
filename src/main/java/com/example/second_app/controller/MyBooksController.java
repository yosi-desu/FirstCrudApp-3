package com.example.second_app.controller;

import com.example.second_app.domain.MyBooksModel;
import com.example.second_app.service.MyBooksService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyBooksController {
  @Autowired private MyBooksService myBooksService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("mybooks", myBooksService.selectAll());
    return "index";
  }

  @GetMapping("{id}")
  public String show(@PathVariable Integer id, Model model) {
    model.addAttribute("mybook", myBooksService.selectOne(id));
    return "show";
  }

  @GetMapping("new")
  public String getBooksNew(@ModelAttribute("mybook") MyBooksModel myBooksModel) {
    return "new";
  }

  @GetMapping("{id}/edit")
  public String edit(@PathVariable Integer id,@ModelAttribute("mybook")MyBooksModel myBooksModel,Model model){
    model.addAttribute("mybook",myBooksService.selectOne(id));
    return "edit";
  }

  @PostMapping
  public String postBookCreate(
      @ModelAttribute("mybook") @Validated MyBooksModel myBooksModel, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "new";
    }
    myBooksService.insert(myBooksModel);
    return "redirect:";
  }

  @PutMapping("{id}")
  public String updateBooks(
      @PathVariable Integer id,
      @ModelAttribute("mybook") @Validated MyBooksModel myBooksModel,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("mybook", myBooksModel);
      return "edit";
    }
    {
      myBooksModel.setId(id);
      myBooksService.update(myBooksModel);
      return "redirect:";
    }
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable Integer id) {
    myBooksService.delete(id);
    return "redirect:";
  }
}
