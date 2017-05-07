package org.hansol.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hansol.board.dao.BDao;
import org.springframework.ui.Model;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		System.out.println("delete" + bId);
		BDao dao = new BDao();
		
		dao.delete(bId);
	}

}
