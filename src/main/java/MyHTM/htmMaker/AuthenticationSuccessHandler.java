//package MyHTM.htmMaker;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//import java.io.IOException;
//
//public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, ServletException, IOException {
//        String destination = null;
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        if(userDetails.getUsername().equals("admin")) {
//            response.setHeader( "Location", "AdminDashboard");
//            destination = "AdminDashboard";
//            setDefaultTargetUrl("/api/user/dashboard?type=admin");
//        } else {
//            response.setHeader( "Location", "UserDashboard");
//            destination = "UserDashboard";
////            response.setStatus(200);
//            setDefaultTargetUrl("/api/user/dashboard?type=user");
//        }
//
////        setDefaultTargetUrl("/api/user/test");
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}


