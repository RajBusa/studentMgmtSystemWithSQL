package in.ac.charusat.studentmgmtsystem.utility;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtility {
    private String jwtSecret;
    private int jwtExpirationMS;
    public String generateJwtToken(Authentication authentication){
        wauthentication.getPrincipal();
    }
}
