package org.hansol.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.hansol.board.HomeController;
import org.hansol.board.command.BCommand;
import org.hansol.board.command.BContentCommand;
import org.hansol.board.command.BDeleteCommand;
import org.hansol.board.command.BListCommand;
import org.hansol.board.command.BModifyCommand;
import org.hansol.board.command.BModifyFormCommand;
import org.hansol.board.command.BReplyCommand;
import org.hansol.board.command.BReplyViewCommand;
import org.hansol.board.command.BWriteCommand;
import org.hansol.board.command.BWriteViewCommand;
import org.hansol.board.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model model) {
		BCommand command;
		logger.info("welcome list");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value="/write_view", method = RequestMethod.GET)
	public String writeView(Model model) {
		BCommand command;
		
		command = new BWriteViewCommand();
		command.execute(model);
		
		logger.info("welcome writeView");
		
		return "write_view";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		BCommand command;
		logger.info("welcome write");
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list"; 
	}
	
	@RequestMapping(value="/content_view", method=RequestMethod.GET)
	public String cotentView(HttpServletRequest request, Model model) {
		BCommand command;
		logger.info("Welcome content_view");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model){
		BCommand command;
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="replyForm", method=RequestMethod.GET)
	public String replyView(HttpServletRequest request, Model model) {
		BCommand command;
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);

		return "reply_view";
	}
	
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(HttpServletRequest request, Model model) {
		BCommand command;
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);	
		return "redirect:list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		BCommand command;
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);	
		return "redirect:list";
	}
	
	@RequestMapping(value="modifyForm") 
	public String modifyForm(HttpServletRequest request, Model model) {
		BCommand command;
		model.addAttribute("request", request);
		command = new BModifyFormCommand();
		command.execute(model);	
		
		return "modify_form";
	}
}
