package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.BoardDao;
import com.board.db.BoardDto;
import com.board.service.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = null;
		
		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		// 주어진 URL에 따라 지정된 동작 수행
		if(com.equals("/list") || com.equals("/")) {
			String tmp = request.getParameter("page");
			int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;
			
			// 게시글이 담긴 DTO객체들의 리스트를 request의 속성 "msgList"로 등록
			request.setAttribute("msgList", new BoardService().getMsgList(pageNo));
			view = "list.jsp";
		} else if(com.equals("/view")) {
			// 지정된 글 번호의 글을 DB에서 읽음
			int num = Integer.parseInt(request.getParameter("num"));
				
			// DTO 객체를 request의 속성 "msg"로 등록
			request.setAttribute("msg", new BoardService().getMsg(num));
			view = "view.jsp";
		} else if(com.equals("/write")) {
			// 글 번호 값 얻기, 주어지지 않았으면 0으로 설정
			String tmp = request.getParameter("num");
			int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;

			// 새 글쓰기 모드를 가정하고 변수 초기값 설정
			BoardDto dto = new BoardDto();
			String action = "insert";
			
			// 글 번호가 주어졌으면, 글 수정 모드
			if(num > 0) {
				dto = new BoardService().getMsgForWrite(num);
				action = "update?num=" + num;
			}
			
			// DTO 객체와 form의 action을 request에 등록
			request.setAttribute("msg", dto);
			request.setAttribute("action", action);
			view = "write.jsp";
			
		} else if(com.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			
			// 양식에 입력되었던 값 읽기
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			try {
				new BoardService().writeMsg(writer, title, content);
				// 목록보기 화면으로 돌아감
				view = "redirect:list";
			} catch(Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}
		} else if (com.equals("/update")) {
			request.setCharacterEncoding("utf-8");
			
			// 전달받은 값 읽기
			int    num     = Integer.parseInt(request.getParameter("num"));
			String writer  = request.getParameter("writer");
			String title   = request.getParameter("title");
			String content = request.getParameter("content");
			
			try {
				new BoardService().updateMsg(writer, title, content, num);
				// 목록보기 화면으로 돌아감
				view = "redirect:list";
			} catch(Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}
		} else if (com.equals("/delete")) {
			//지정된 글 번호의 레코드를 DB에서 삭제
			int num = Integer.parseInt(request.getParameter("num"));
			new BoardService().deleteMsg(num);
			
			// 목록보기 화면으로 돌아감
			view = "redirect:list";
		}
		
		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
