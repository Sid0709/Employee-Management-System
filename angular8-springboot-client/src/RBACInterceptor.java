import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RBACInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        // Implement logic to check user roles and permissions
        String role = getUserRole(request); // Example function to retrieve user role
        
        if ("admin".equals(role)) {
            return true; // Allow access for admin
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false; // Deny access for other roles
        }
    }

    private String getUserRole(HttpServletRequest request) {
        // Implement logic to retrieve user role from token or session
        // This is just a placeholder, replace it with your actual implementation
        return "user";
    }
}
