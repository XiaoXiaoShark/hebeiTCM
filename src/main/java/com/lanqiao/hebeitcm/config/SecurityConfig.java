package com.lanqiao.hebeitcm.config;

import com.lanqiao.hebeitcm.model.User;
import com.lanqiao.hebeitcm.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author : 小小shark
 * @ClassName SecurityConfig
 * @date : 2021-07-21 11:53
 * @Description TODO
 *  prePostEnabled :决定Spring Security的前注解是否可用 [@PreAuthorize,@PostAuthorize,..]
 *  secureEnabled : 决定是否Spring Security的保障注解 [@Secured] 是否可用
 *  jsr250Enabled ：决定 JSR-250 annotations 注解[@RolesAllowed..] 是否可用.
 **/
@Configurable
@EnableWebSecurity
//开启 Spring Security 方法级安全注解 @EnableGlobalMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用于对认证进行处理(核心)
     * <p>
     * AuthenticationManager: 用于认证的核心接口.
     * AuthenticationManagerBuilder: 用于构建AuthenticationManager接口对象的工具.
     * ProviderManager: AuthenticationManager接口的默认实现类.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        内置(默认)的认证规则：
//        auth.userDetailsService(userService)
//                 对密码进行编码,Pbkdf2PasswordEncoder 加密时候附带的盐值
//                .passwordEncoder(new Pbkdf2PasswordEncoder("securtyu"));
        /**
         * 自定义认证规则：
         * AuthenticationProvider: ProviderManager持有一组 AuthenticationProvider,
         * 每个 AuthenticationProvider 负责一种认证.
         *
         * 这种设计模式称为委托模式: ProviderManager 将认证委托给 AuthenticationProvider.
         */
        auth.authenticationProvider(new AuthenticationProvider() {
            /**
             * Authentication: 用于封装认证信息的接口,不同的实现类代表不同类型的认证信息.
             *
             * @param authentication
             * @return
             * @throws AuthenticationException
             */
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                // 获取用户名
                String username = authentication.getName();
                // 获取密码
                String password = (String) authentication.getCredentials();

                User user = userService.findUserByName(username);
                if (user == null) {
                    throw new UsernameNotFoundException("账号不存在!");
                }
                // 对密码加密后再到数据库查询
                if (!user.getPassword().equals(password)) {
                    throw new BadCredentialsException("密码不正确!");
                }

                String typeName = userService.getTypeName(user.getType());
                // 填充权限
                Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
                authorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        log.info(typeName);
                        return typeName;
                    }
                });
                user.setAuthorities(authorities);


                // principal: 认证的主要信息(比如user对象);
                // credentials: 证书(账号密码模式下，证书使用密码password表示);
                // authorities: 权限;
                return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            }

            /**
             * 当前的 AuthenticationProvider支持的是哪种类型的认证.
             *
             * @param authentication
             * @return
             */
            @Override
            public boolean supports(Class<?> authentication) {
                // 支持账号密码认证模式：
                // UsernamePasswordAuthenticationToken: Authentication接口的常用的实现类.
                return UsernamePasswordAuthenticationToken.class.equals(authentication);
            }
        });
    }

    /**
     * 用于对授权进行处理(核心)
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//         父类授权逻辑,想深入了解,点入super查看其源码
//         super.configure(http);

        // 登录页面相关配置
        http.formLogin()
                // 指定登录页面
                .loginPage("/loginpage")
                // 处理登录请求的路径
                .loginProcessingUrl("/login")
//                 登录成功时候跳转的路径
//                .successForwardUrl("/xxx")
//                 登录失败时跳转的路径
//                .failureForwardUrl("/xxx")
                // 登录成功后,做出相应处理的 handler
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Authentication authentication)
                            throws IOException, ServletException {
                        // 重定向到首页
                        response.sendRedirect(request.getContextPath() + "/index");
                    }
                })
                // 登录失败后,做出相应处理的 handler
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        AuthenticationException exception)
                            throws IOException, ServletException {
                        // 储存错误信息
                        request.setAttribute("error", exception.getMessage());
                        // 转发到登录页面
                        request.getRequestDispatcher("/loginpage").forward(request, response);
                    }
                });

        // 退出相关配置
        http.logout()
                // 处理登出的请求
                .logoutUrl("/logout")
                // 登出后,做出相应处理的 handler
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request,
                                                HttpServletResponse response,
                                                Authentication authentication)
                            throws IOException, ServletException {
                        // 重定向到首页
                        response.sendRedirect(request.getContextPath() + "/index");
                    }
                });

        // 授权配置
        http.authorizeRequests()
                //规定只有哪些权限（“ADMIN”）的用户才能访问哪些方法（"/admin"）
                //科员权限
                .antMatchers("/admin").hasAnyAuthority("CLERK")
                //处长权限
                .antMatchers("/letter").hasAnyAuthority("DIVISION_CHIEF")
                //综合处处长权限
                .antMatchers("/letter").hasAnyAuthority("DIRECTOR_OF_GENERAL_OFFICE")
                // 如果没有权限,则访问 denied 提示页面
                .and().exceptionHandling().accessDeniedPage("/denied");

        // 增加一个Filter,用于处理验证码
        http.addFilterBefore(new Filter() {
            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                HttpServletResponse response = (HttpServletResponse) servletResponse;

                if (request.getServletPath().equals("/login")) {
                    String verifyCode = request.getParameter("verifyCode").toUpperCase();
                    // 这里把验证码校验写死,实际业务中是需要动态的验证码:
                    // 需要加一个验证码生成的方法,把验证码存入 cookie 或者 redis 中
                    // 这里仅仅是为了展示效果而已:
                    String code = request.getParameter("code").toUpperCase();
                    log.info(verifyCode+code);
                    if (verifyCode == null || !verifyCode.equalsIgnoreCase(code)) {
                        request.setAttribute("error", "验证码错误!");
                        request.getRequestDispatcher("/loginpage").forward(request, response);
                        return;
                    }
                }
                // 让请求继续向下执行.
                filterChain.doFilter(request, response);
            }
            // 新增的这个过滤器new Filter()会在 UsernamePasswordAuthenticationFilter 过滤器之前执行
        }, UsernamePasswordAuthenticationFilter.class);

        // 记住我
        http.rememberMe()
                // 存储用户数据的方案: new InMemoryTokenRepositoryImpl() 把用户数据存入内存
                // 如果是存cookie 或者 redis 存储token 需要自己写相关实现方法,并在这里new 出方法实例
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                // 过期时间 24h
                .tokenValiditySeconds(3600 * 24)
                // 指定 userService
                .userDetailsService(userService);
    }

    /**
     * 用于配置一些拦截的资源
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略resources 下的所有静态资源
        web.ignoring().antMatchers("/resources/**");
    }
}
