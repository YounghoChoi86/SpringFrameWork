package org.hansol.board.command;

import java.util.ArrayList;

import org.hansol.board.dao.BDao;
import org.hansol.board.dto.BDto;
import org.springframework.ui.Model;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.list();
		
		System.out.println(dtos.size());
		
		model.addAttribute("list", dtos);
	}

}
