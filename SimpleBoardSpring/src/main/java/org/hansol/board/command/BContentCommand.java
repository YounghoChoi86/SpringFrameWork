package org.hansol.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hansol.board.dao.BDao;
import org.hansol.board.dto.BDto;
import org.springframework.ui.Model;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bid = request.getParameter("bId");
		System.out.println("BContentCommand" + ":" + bid);
		BDao dao = new BDao();
		
		BDto dto = dao.contentView(bid);
		
		model.addAttribute("content_view", dto);
	}

}
