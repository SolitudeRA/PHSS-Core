package org.protogalaxy.phss.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.resource.assembler.account.AccountResourceAssembler;
import org.protogalaxy.phss.datasource.resource.main.entity.account.AccountResource;
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
        AccountResourceAssembler accountResourceAssembler = new AccountResourceAssembler();
        AccountResource accountResource = accountResourceAssembler.toResource((AccountEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().print(mapper.writeValueAsString(accountResource));
    }
}
