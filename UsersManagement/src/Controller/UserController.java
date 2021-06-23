package Controller;


import com.google.gson.Gson;
import dao.UserDao;
import dao.UserDaoImp;
import pojo.User;
import service.UsersService;
import service.UsersServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController",urlPatterns = "/controller")

public class UserController extends HttpServlet {

    UsersService usersService=new UsersServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
       if("userreg".equalsIgnoreCase((action))) {
           User user=new User();
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           user.setUsername(username);
           user.setPassword(password);
       boolean userreg=usersService.userreg(user);
       if(userreg){
           response.getWriter().write("success");
       }else{
           response.getWriter().write("reg fail!");
       }
    }else if("userlogin".equalsIgnoreCase(action)){
           User user=new User();
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           user.setUsername(username);
           user.setPassword(password);
           boolean userlogin=usersService.userlogin(user);
           if(userlogin){
               response.getWriter().write("success");
           }else{
               response.getWriter().write("Login fail!");
           }
       }else if("userlist".equalsIgnoreCase(action)){
           List <User> userlist=usersService.userlist();
           if(userlist!=null){
               Gson gson=new Gson();
               response.getWriter().write(gson.toJson(userlist));
           }
       }else if ("userDetail".equalsIgnoreCase(action)) {

           String uid = request.getParameter("uid");
           User user = new User();
           if (!"".equals(uid)) {
               user = usersService.queById(Integer.valueOf(uid));
           }

           if (user != null) {

               Gson gson = new Gson();
               String str = gson.toJson(user);
               response.getWriter().write(str);
           }
       }
    }
}
