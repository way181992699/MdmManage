package com.seven.sbinit.utils;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements javax.servlet.Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse respnse,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		respnse.setCharacterEncoding("UTF-8");
		chain.doFilter(request, respnse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}


}
