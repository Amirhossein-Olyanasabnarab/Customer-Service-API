package dk.amir.customerservice.controller.swagger;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Controller to proxy and forward custom paths to the Swagger UI.
 * <p>
 * This controller enables access to the Swagger UI via custom endpoints,
 * providing a user-friendly and consistent URL structure for API documentation.
 * </p>
 * Example: Accessing <code>/api-ui/main</code> will forward to the default Swagger UI.
 * Any request starting with <code>/api-ui/</code> will be proxied to <code>/swagger-ui/</code>.
 *
 * This is useful for customizing access paths in environments where the default Swagger path
 * needs to be overridden (e.g., for better integration, reverse proxies, or security rules).
 */
@Controller
public class SwaggerController {

    /**
     * Forwards the custom path '/api-ui/main' to the Swagger UI index page.
     *
     * @return a forward instruction to Swagger UI's index.html.
     */
    @GetMapping("/api-ui/main")
    public String apiUi() {
        return "forward:/swagger-ui/index.html";
    }


    /**
     * Proxies all requests under '/api-ui/**' to corresponding paths under '/swagger-ui/**'.
     * This allows seamless redirection to Swagger UI resources using a custom base path.
     *
     * @param request the incoming HTTP request
     * @return a forward instruction to the corresponding Swagger UI resource path.
     */
    @RequestMapping("/api-ui/**")
    public String proxySwagger(HttpServletRequest request) {
        String path = request.getRequestURI().replaceFirst("/api-ui", "/swagger-ui");
        return "forward:" + path;
    }
}
