package org.hansol.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hansol.board.dao.BDao;
import org.hansol.board.dto.BDto;
import org.springframework.ui.Model;

public class BReplyViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.replyView(bId);
		
		model.addAttribute("reply_view", dto);
	}

}
