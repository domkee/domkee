package com.fer.librosViejos.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		String userId = getTokenCookie(request);
		System.out.println("Filter: "+userId);
		
		String requestString = request.getRequestURL().toString();
		System.out.println(requestString);
		if (userId==null && !requestString.contains("fbConnect") && !requestString.contains("fbRedirect"))
		{
			
			response.sendRedirect("/fbConnect?uid=1");
		}
		else
		{
			filter.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	public String getTokenCookie(HttpServletRequest req)
	{
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("TOKEN"))
			{
				return cookie.getValue();
			}
		}
		return null;
	}

}
