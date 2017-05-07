package org.hansol.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hansol.board.dao.BDao;
import org.springframework.ui.Model;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bName = request.getParameter("bName");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");

		
		System.out.println("BReplyCommand" + bId);
		System.out.println("BReplyCommand" + bTitle);
		System.out.println("BReplyCommand" + bName);
		System.out.println("BReplyCommand" + bContent);
		System.out.println("BReplyCommand" + bGroup);
		System.out.println("BReplyCommand" + bStep);
		System.out.println("BReplyCommand" + bIndent);
		
		BDao dao = new BDao();
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
	}

}
