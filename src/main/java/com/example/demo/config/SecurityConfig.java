package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * thực hiện tham chiếu tới bean "userDetailsService" trong Spring Container.
     */
    @Qualifier("customUserDetalisService") // xác định bean mà muốn inject
    @Autowired private UserDetailsService userDetailsService;

    /**
     * đây là nơi thực hiện cấu hình bảo mật cho website.
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests() // thực hiện xác thực request ngưười dùng gửi lên.

                // không thực hiện xác thực đối với các ur/ này.
                .antMatchers("/api/**").permitAll()

                // thực hiện xác thực với các url kiểu ..../admin/....
                //.antMatchers("/admin/**").authenticated()
                .antMatchers("/admin/api/**").hasAnyAuthority("ADMIN")
                .and() // kết hợp với điều kiện.

                // khi click vào button logout thì không cần login.
                // khi click vào button này thì dữ liệu user trên session sẽ bị xoá.
                .logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true) // xoá hết dữ liệu trên seesion
                .deleteCookies("JSESSIONID") // xoá hết dữ liệu trên cokies.
                .permitAll()

                .and() // kết hợp với điều kiện.

                .formLogin() // thực hiện xác thực qua form(username và password)
                .loginPage("/login") // trang login do mình thiết kế.
                .loginProcessingUrl("/demo-perform_login") // link action for form post.
                .defaultSuccessUrl("/home", true) // when user success authenticated then go to this url.
                .failureUrl("/login?login_error=true") // nhập username, password sai thì redirect về trang nào.
                .permitAll();
    }

//     sử dụng để băm mật khẩu dạng mã hóa BCcrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
//		return new NormalPasswordEncoder();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    /**
     * hàm này thực hiện kết nối giữa 2 Beans(AuthenticationManager và UserDetailsService).
     * Lí do phải kết nối 2 Beans này vì cần cho AuthenticationManager biết nơi để
     * xác thực và lấy quyền của người dùng.
     * @param auth thực ra khi dùng @Autowired thì auth là bean được spring quản lí và add tham chiếu tới.
     * @throws Exception
     */

    @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // thực hiện gắn kết AuthenticationManager với UserDetailsService.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * định nghĩa lớp quản lí "Xác Thực" người dùng.
     * @return
     * @throws Exception
     */

//    spring boot JON Web Token
    /**
     * - là tiêu chuẩn mở - định nghĩa một con đường nhỏ gọn - khép kín để truyền thông tin an toàn giữa các bên dưới dạng JSON
     * - sử dụng chữ ký điện tử để xác nhận
     * -
     * */
    @Bean public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

}
