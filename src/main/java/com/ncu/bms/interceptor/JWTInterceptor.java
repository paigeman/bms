package com.ncu.bms.interceptor;

import com.ncu.bms.bean.Admin;
import com.ncu.bms.bean.Reader;
import com.ncu.bms.service.IAdminService;
import com.ncu.bms.service.IReaderService;
import com.ncu.bms.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private IAdminService iAdminService;

    @Autowired
    private IReaderService iReaderService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println(request.getRequestURI()+"00");
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if(token==null||token.equals("")){
            return false;
        }
        else{
            Map<String,Object> map = JWTUtil.parseToken(token);
            if(map.containsKey("admin_id")){
                Admin admin = iAdminService.isExist((String)map.get("admin_id"));
                String admin_pwd = admin.getAdmin_pwd();
                String tmp_admin_pwd = (String)map.get("admin_pwd");
                if(!admin_pwd.equals(tmp_admin_pwd)||JWTUtil.verifyToken(token)!=0){
                    return false;
                }
                else{
                    return true;
                }
            }
            else if(map.containsKey("reader_id")){
                Reader reader = iReaderService.isExist((String)map.get("reader_id"));
                String reader_pwd = reader.getReader_pwd();
                String tmp_reader_id = (String)map.get("reader_pwd");
                if(!reader_pwd.equals(tmp_reader_id)||JWTUtil.verifyToken(token)!=0){
                    //System.out.println(request.getRequestURI()+"00");
                    return false;
                }
                else{
                    //System.out.println(request.getRequestURI()+"true");
                    return true;
                }
            }
            else{
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
