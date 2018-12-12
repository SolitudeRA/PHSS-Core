package org.protogalaxy.phss.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.exception.account.AccountServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
    //Logging
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * Try to resolve the given exception that got thrown during handler execution,
     * returning a {@link ModelAndView} that represents a specific error page if appropriate.
     * <p>The returned {@code ModelAndView} may be {@linkplain ModelAndView#isEmpty() empty}
     * to indicate that the exception has been resolved successfully but that no view
     * should be rendered, for instance by setting a status code.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  the executed handler, or {@code null} if none chosen at the
     *                 time of the exception (for example, if multipart resolution failed)
     * @param ex       the exception that got thrown during handler execution
     * @return a corresponding {@code ModelAndView} to forward to,
     * or {@code null} for default processing in the resolution chain
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            ObjectMapper mapper = new ObjectMapper();
            if (ex instanceof AccountServiceException) {
                response.getWriter().write(mapper.writeValueAsString(ex));
            } else {
                response.getWriter().write(ex.getMessage());
            }
        } catch (IOException e) {
            logger.error("Client" + e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }
}
