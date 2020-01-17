package practice.solarb.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.solarb.authentication.AuthenticationProviderExtend;

@Controller
public class SSOController {
    @RequestMapping("user-change")
    public String sso(String id) {
        UsernamePasswordAuthenticationToken authentication = AuthenticationProviderExtend.createAuthentication(id, id);
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);
        return "redirect:/hi";
    }

}
