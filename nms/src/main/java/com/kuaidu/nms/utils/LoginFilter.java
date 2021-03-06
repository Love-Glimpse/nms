package com.kuaidu.nms.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

/*
 * 登录过滤器,防止跳过登录直接进入
 */
public class LoginFilter extends OncePerRequestFilter {

	// 获得在下面代码中要用的request,response,session对象
	private static String[] notFilter = new String[] {"/nms/static","/nms/temp","/nms/externalUrl","/nms/index.jsp","/nms/userlogin","/nms/partner/userlogin","/nms/partner/index.jsp" };

	@Override
	public void destroy() {

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		boolean doFilter = true;
		for (String s : notFilter) {
			if (path.startsWith(s)) {
				// 如果url中包含不过滤的url，则不进行过滤
				doFilter = false;
				break;
			}
		}
		// 执行过滤
		if (doFilter) {
			String login_flag = (String) session.getAttribute("login_flag");
			Object user = session.getAttribute("user");
			Object partner_user = session.getAttribute("partner_user");
			// 从session中获取登录者实体
			if (login_flag==null||(!login_flag.equalsIgnoreCase("system")&&!login_flag.equalsIgnoreCase("partner"))){
				if (path.startsWith("/nms/partner")) {
					response.sendRedirect("/nms/partner/index.jsp");
					return;
				}else {
					response.sendRedirect("/nms/index.jsp");
					return;
				}
			}else if (login_flag.equalsIgnoreCase("partner")&&partner_user==null) {
				response.sendRedirect("/nms/partner/index.jsp");
				return;
			}else if (login_flag.equalsIgnoreCase("system")&&user==null) {
				response.sendRedirect("/nms/index.jsp");
				return;
			}else {
				// 如果session中存在登录者实体，则继续
				chain.doFilter(request, response);
			}
		} else {
			// 如果不执行过滤，则继续
			chain.doFilter(request, response);
		}
	}

}
