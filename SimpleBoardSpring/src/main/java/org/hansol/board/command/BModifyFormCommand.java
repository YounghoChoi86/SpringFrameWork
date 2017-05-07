package org.hansol.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class BModifyFormCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bName = request.getParameter("bName");
		String bContent = request.getParameter("bContent");
		
		System.out.println(bId);
		System.out.println(bTitle);
		System.out.println(bName);
		System.out.println(bContent);
		
		model.addAttribute("bId", bId);
		model.addAttribute("bTitle", bTitle);
		model.addAttribute("bName", bName);
		model.addAttribute("bContent", bContent);
	}

}
