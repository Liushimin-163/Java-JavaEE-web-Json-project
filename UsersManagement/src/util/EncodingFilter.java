package util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        String url=request.getServletPath();
        if(url.contains(".html")||url.contains(".css")||url.contains(".js")||url.contains(".jpg")||url.contains(".png")||
                url.contains(".jpeg")||url.contains(".gif")){
            chain.doFilter(req, resp);
        }else{
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
