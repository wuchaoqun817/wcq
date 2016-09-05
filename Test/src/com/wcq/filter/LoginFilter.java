package com.wcq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	private static final String[] DO_FILTER={"newPage"};
	private static final String START_JSP="/index.jsp";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse res=(HttpServletResponse)arg1;
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		StringBuffer uri=req.getRequestURL();
		for(String s:DO_FILTER){
			if(uri.toString().contains(s)){
//				excute
			}else{
				res.sendRedirect(req.getContextPath()+START_JSP);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
