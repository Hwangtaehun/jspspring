package com.board.service;

import java.util.ArrayList;
import com.board.db.*;

public class BoardService {
	private static final int listSize = 5;
	private static final int paginationSize = 3;
	
	public ArrayList<Pagination> getPagination(int pageNo) {
		ArrayList<Pagination> pgnList = new ArrayList<Pagination>();
		
		int numRecords = new BoardDao().getNumRecords();
		int numPages = (int)Math.ceil((double)numRecords/listSize);
		
		int firstLink = ((pageNo - 1) / paginationSize) * paginationSize + 1;
		int lastLink = firstLink + paginationSize - 1;
		
		if(lastLink > numPages) {
			lastLink = numPages;
		}
		
		if(firstLink > 1) {
			pgnList.add(new Pagination("이전", pageNo - paginationSize, false));
		}
		
		for (int i = firstLink; i <= lastLink; i++) {
			pgnList.add(new Pagination("" + i, i, i == pageNo));
		}
		
		if(lastLink < numPages) {
			int tmpPageNo = pageNo + paginationSize;
			if(tmpPageNo > numPages) {
				tmpPageNo = numPages;
			}
			pgnList.add(new Pagination("다음", tmpPageNo, false));
		}
		
		return pgnList;
	}
	
	public ArrayList<BoardDto> getMsgList(int pageNo) {
		return new BoardDao().selectList((pageNo - 1) * listSize, listSize);
	}
	
	public BoardDto getMsg(int num) {
		BoardDto dto = new BoardDao().selectOne(num, true);
		
		// 글 제목과 내용이 웹 페이지에 몰바르게 출력되도록
		// 공백과 줄 바꿈 처리
		dto.setTitle(dto.getTitle().replace(" ", "&nbsp;"));
		dto.setContent(dto.getContent().replace(" ", "&nbsp;").replace("\n", "<br>"));
		
		return dto;
	}
	
	public BoardDto getMsgForWrite(int num) {
		return new BoardDao().selectOne(num, false);
	}
	
	public void writeMsg(String writer, String title, String content) throws Exception {
		// 빈 칸이 하나라도 있으며 오류 출력하고 종료
		if (writer  == null || writer.length()  == 0 || 
			title   == null || title.length()   == 0 ||
			content == null || content.length() == 0) {
			throw new Exception("모든 항목이 빈칸이 없이 입력되어야 합니다.");
		}
		
		// 글 데이터를 DTO에 저장
		BoardDto dto = new BoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		// 입력된 내용응로 새 글 레코드 추가
		new BoardDao().insertOne(dto);
	}
	
	public void updateMsg(String writer, String title, String content, int num) throws Exception {
		if (writer  == null || writer.length()  == 0 || 
			title   == null || title.length()   == 0 ||
			content == null || content.length() == 0) {
			throw new Exception("모든 항목이 빈칸이 없이 입력되어야 합니다.");
		}
		BoardDto dto = new BoardDto();
		dto.setNum(num);
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		// 입력된 내용으로 글 내용 업데이트
		new BoardDao().updateOne(dto);
	}
	
	public void deleteMsg(int num) {
		new BoardDao().deleteOne(num);
	}
}
