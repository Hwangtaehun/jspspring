package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcomeMethod() {
		String outHtml = 
			"<html>\r\n"
			+ "<head>\r\n"
			+ "	<meta charset=\"UTF-8\">\r\n"
			+ "	<title>Welcome</title>\r\n"
			+ "	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\">\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "	<div class=\"container py-4\">\r\n"
			+ "		<header class=\"pb-3 mb-4 border-bottom\">  \r\n"
			+ "			<a href=\"/welcome.html\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">	\r\n"
			+ "				<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" fill=\"currentColor\" class=\"bi bi-book-half me-2\" viewBox=\"0 0 16 16\">\r\n"
			+ "					<path d=\"M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783\"/>\r\n"
			+ "				</svg>\r\n"
			+ "				<span class=\"fs-4\">BookMarket</span>\r\n"
			+ "			</a>\r\n"
			+ "		</header>\r\n"
			+ "		<div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\r\n"
			+ "	 		<div class=\"container-fluid py-5\">\r\n"
			+ "				<h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신 것을 환영합니다</h1>\r\n"
			+ "				<p class=\"col-md-8 fs-4\">BookMarket</p>       \r\n"
			+ "			</div>\r\n"
			+ "		</div>\r\n"
			+ "\r\n"
			+ "	\r\n"
			+ "		<div class=\"row align-items-md-stretch text-center\">\r\n"
			+ "				<div class=\"col-md-12\">\r\n"
			+ "					<div class=\"h-100 p-5\">\r\n"
			+ "						<h2>Welcome to Web Market!</h2>\r\n"
			+ "		         	</div>\r\n"
			+ "				</div>\r\n"
			+ "		</div>\r\n"
			+ "  \r\n"
			+ "	\r\n"
			+ "		<footer class=\"pt-3 mt-4 text-body-secondary border-top\">\r\n"
			+ " 			<span class=\"text-body-secondary\"> &copy; BookMarket</span>\r\n"
			+ "		</footer>\r\n"
			+ "	</div>\r\n"
			+ "</body>\r\n"
			+ "</html>";
		return outHtml;
	}
}
