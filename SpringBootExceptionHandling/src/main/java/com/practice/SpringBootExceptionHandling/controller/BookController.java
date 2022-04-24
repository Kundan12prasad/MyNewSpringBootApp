package com.practice.SpringBootExceptionHandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.SpringBootExceptionHandling.service.BookService;

@Controller
public class BookController
{
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/findPriceById")
	public String getPriceById(@RequestParam ("bookId") String bookId, Model model)
	{		
		Double bookPrice=bookService.findPriceById(bookId);
		model.addAttribute("bookPrice","Book Price::" +bookPrice );
		return "display";
	}

}
