package org.hansol.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hansol.board.dto.BDto;
import org.hansol.board.util.Constant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;


public class BDao {
	static JdbcTemplate template;
	
	public BDao() {
		if (template == null) {
			template = Constant.template;
		}
	}

	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = null;
		
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from board order by bGroup desc, bStep asc";
		
		dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

		return dtos;
	}

	public void write(final String bName, final String bTitle, final String bContent) {
		
		template.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String insertQuery = "INSERT INTO BOARD(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " 
						+ "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, BOARD_SEQ.CURRVAL, 0, 0)";
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
			
		});
	}

	public BDto contentView(String strbId) {
		upHit(strbId);
		String query = "select * from board where bId=" + strbId;
		
		return (BDto)template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	public void upHit(final String strbId) {
		String query = "update board set bHit=bHit+1 where bId=?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strbId));
				
			}
		});
	}

	public void modify(final String strBId, final String bName, final String bTitle, final String bContent) {
		String query = "update board set bName=?, bTitle=?, bContent	=? where bId=?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(strBId));
			}
			
		});
	}

	public void delete(final String strBid) {
		String query = "delete from board where bId=?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strBid));
			}
		});		
	}

	public BDto replyView(String strBid) {
		String query = "select * from board where bId = " + strBid;
		
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	public void reply(final String bId, final String bName, final String bTitle, 
			final String bContent, final String bGroup, final String bStep, final String bIndent) {
		
		String insertQuery = "INSERT INTO BOARD(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)" 
				+ "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		template.update(insertQuery, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}			
		});	
	}
	private void replyShape(final String strGroup, final String strStep) {
		String query = "update board set bStep = bStep + 1 where bGroup = ? and bStep = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strGroup);
				ps.setString(2, strStep);
			}
		});
		return;
	}
}
