package com.bit2015.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.mysite.service.BoardService;
import com.bit2015.mysite.vo.BoardVo;
@Controller
@RequestMapping("/board")
public class BoardController {

	
	@Autowired
	BoardService boardService;  
	
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("list", boardService.list());
		//System.out.println(boardService.list().size());
		return "/board/list";
	}
	@RequestMapping("/write")
	public String insesrt(@ModelAttribute BoardVo boardVo) {
		boardService.write(boardVo);
		return "redirect:/board/list";

	}
}
