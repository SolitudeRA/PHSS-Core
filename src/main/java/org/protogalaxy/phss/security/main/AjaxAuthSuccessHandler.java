package org.protogalaxy.phss.security.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.user.UserResource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userDetails = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().print(mapper.writeValueAsString(new UserResource(userDetails)));
    }
}
