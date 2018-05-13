package com.homework.controller;
import com.homework.model.Buyer;
import com.homework.model.Seller;
import com.homework.service.IBuyerService;
import com.homework.service.ISellerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Scope("prototype")
@Controller
public class LoginController {
    @Resource
    private IBuyerService buyerService;
    @Resource
    private ISellerService iSellerService;

    @RequestMapping("/login.action")
    public void login(HttpServletRequest request , HttpServletResponse response){
        try {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/loginValidation.action")
    public @ResponseBody Buyer loginValidation(String nickname, String password){
        Buyer buyer =buyerService.selectBuyer(nickname);
        if(buyer!=null && buyer.getPassword().equals(password)){
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attr.getRequest();
            HttpSession session=request.getSession();
            session.setAttribute("buyer",buyer);
            return buyer;
        }
        return null;
    }

    @RequestMapping("/registerPage.action")
    public  ModelAndView registerPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping("/exit.action")
    public ModelAndView exit(HttpSession session){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        session.invalidate();
        return modelAndView;
    }

    @RequestMapping("/register.action")
    public @ResponseBody HashMap<String,String> register(String nickname, String password){
        HashMap<String,String> register_message=new HashMap<String,String>();
        Buyer buyer =buyerService.selectBuyer(nickname);
        if(buyer==null){
            //不存在该用户，可以注册
            Buyer register_buyer=new Buyer();
            register_buyer.setNickname(nickname);
            register_buyer.setPassword(password);
            try{
                buyerService.registerBuyer(register_buyer);
            }catch(Exception e){
                //插入数据库异常，跳转至失败页面
                register_message.put("register_prompt_info","抱歉，注册信息保存失败，请再次尝试！");
                return register_message;
            }
            //数据保存成功
            register_message.put("register_prompt_info","嘻嘻，注册成功！");
            return register_message;
        }else{
            //该用户名被占用,调到失败
            register_message.put("register_prompt_info","用户名被占用，请更换！");
            return register_message;
        }


    }
/////////////////////////////////////////
    @RequestMapping("/sellerLogin.action")
    public void sellerLogin(HttpServletRequest request , HttpServletResponse response){
        try {
            request.getRequestDispatcher("/WEB-INF/views/sellerLogin.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/sellerExit.action")
    public void sellerExit(HttpServletRequest request , HttpServletResponse response){
        try {
            request.getSession().invalidate();
            request.getRequestDispatcher("/WEB-INF/views/sellerLogin.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/sellerLoginValidation.action")
    public @ResponseBody Seller sellerLoginValidation(String nickname, String password){
        Seller seller=iSellerService.selectSeller(nickname);
        if(seller!=null && seller.getPassword().equals(password)){
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attr.getRequest();
            HttpSession session=request.getSession();
            session.setAttribute("seller",seller);
            return seller;
        }
        return null;
    }
    @RequestMapping("/sellerRegister.action")
    public @ResponseBody HashMap<String,String> sellerRegister(String nickname, String password){
        HashMap<String,String> register_message=new HashMap<String,String>();
        Seller seller =iSellerService.selectSeller(nickname);
        if(seller==null){
            //不存在该用户，可以注册
            Seller register_seller=new Seller();
            register_seller.setNickname(nickname);
            register_seller.setPassword(password);
            try{
                iSellerService.registerSeller(register_seller);
            }catch(Exception e){
                //插入数据库异常，跳转至失败页面
                register_message.put("register_prompt_info","抱歉，注册信息保存失败，请再次尝试！");
                return register_message;
            }
            //数据保存成功
            register_message.put("register_prompt_info","注册成功，等待管理员审核（其实没人审核你，登录吧）");
            return register_message;
        }else{
            //该用户名被占用,调到失败
            register_message.put("register_prompt_info","用户名被占用，请更换！");
            return register_message;
        }


    }

    @RequestMapping("/sellerRegisterPage.action")
    public  ModelAndView sellerRegisterPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("sellerRegister");
        return modelAndView;
    }
}
