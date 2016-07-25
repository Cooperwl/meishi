package com.melody.meishi.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登录检查
 */
public class LoginCheckFilter implements Filter {
	
	private FilterConfig config;

	public void init(FilterConfig filterConfig) {
		this.config = filterConfig;
	}
	
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Object user = request.getSession().getAttribute("USERINFO");
		if (user==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			chain.doFilter(req, res);
		}
	}

	public void destroy() {
		this.config = null;
	}
}