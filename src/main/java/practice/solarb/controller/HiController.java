package practice.solarb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class HiController {
    @RequestMapping("hi")
    public String hi(HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();
        return "hi. " + userPrincipal.getName();
    }
}