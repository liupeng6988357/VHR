package com.Javaboy.vhr.config;

import com.Javaboy.vhr.bean.RespBean;
import com.Javaboy.vhr.service.HrService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author 刘鹏
 * @Date 2019-08-24
 */
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;

    @Autowired
    MyDecisionManager myDecisionManager;

    @Autowired
    MyFilter myFilter;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

            .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(myFilter);
                o.setAccessDecisionManager(myDecisionManager);
                return o;
            }
        }).and().formLogin()
                //登录页面，用户未登录时跳转的页面
                .loginPage("/login")
                //登录请求处理接口
                .loginProcessingUrl("/doLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                //登录成功后跳转的页面
            //    .successForwardUrl("")
                //登录成功后的处理器，可以在这个处理器中返回json
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)
                            throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        ObjectMapper om = new ObjectMapper();
                        String s = om.writeValueAsString(RespBean.ok("登录成功",authentication.getPrincipal()));
                        out.write(s);
                        out.flush();
                        out.close();

                    }
                })
                //登录失败处理器
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e)
                            throws IOException, ServletException {
                        RespBean error = RespBean.error("登录失败");
                        if (e instanceof BadCredentialsException){
                            error.setMassage("用户名或密码输入错误");
                        }else if (e instanceof DisabledException){
                            error.setMassage("账户被禁用，请联系管理员");
                        }else if (e instanceof CredentialsExpiredException){
                            error.setMassage("密码过期，请修改密码");
                        }else if (e instanceof AccountExpiredException){
                            error.setMassage("账户过期，请联系管理员");
                        }
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(error));

                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp, AccessDeniedException e) throws
                    IOException, ServletException {
                RespBean error = RespBean.error("权限不足，请联系管理员！");
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write(new ObjectMapper().writeValueAsString(error));

                out.flush();
                out.close();

            }
        });
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }
}
