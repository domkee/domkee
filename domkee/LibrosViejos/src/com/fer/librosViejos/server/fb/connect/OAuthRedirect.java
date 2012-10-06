package com.fer.librosViejos.server.fb.connect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fer.t1.server.fbConnect.FB;
import com.fer.t1.server.fbConnect.OAuthRedirectServlet;

public class OAuthRedirect extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2446090799577156927L;

	static
	{
		FB.init("327891523972361", "9cff3f1fbb55cbcad47a75672ac0a163", "http://librosviejos1.appspot.com/fbRedirect", "http://librosviejos1.appspot.com");
		
	}

	private OAuthRedirectServlet oauth = new OAuthRedirectServlet() {
		
		@Override
		public void doDebugLogin(HttpServletRequest req, HttpServletResponse resp,
				String uid) {
			System.out.println("DEBUG LOGIN: "+uid);
			try {
				String token = "AAAEqNzHPrQkBAFmguoDw6OnMHbMglPyippgQYnZBr6Y1oFbVfTUHiXZC1UvtFcDhJRFFCxYRN2uvcNsgNZAzOYfXc65c2uvw1Cp7BPFMnEXEAfbCd1O";
				RedirectUri.registerUser(token);
				resp.sendRedirect("http://127.0.0.1:8888/LibrosViejos.html?gwt.codesvr=127.0.0.1:9997#home/token="+token);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		oauth.doGet(req, resp, OAuthRedirectServlet.PERM_EMAIL+","+OAuthRedirectServlet.PERM_BIRTH);
	}

}
