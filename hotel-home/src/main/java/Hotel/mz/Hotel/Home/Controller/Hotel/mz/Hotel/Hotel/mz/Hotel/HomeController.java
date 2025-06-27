package Hotel.mz.Hotel.Home.Controller.Hotel.mz.Hotel.Hotel.mz.Hotel;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {


    @GetMapping("/home")
    public ModelAndView home(HttpServletRequest request) {
         //Verifica se o usuário está autenticado
        //if (request.getSession().getAttribute("authenticatedUser") != null) {
            return new ModelAndView("home");
       // }
        //return new ModelAndView("redirect:http://localhost:8084/login"); // Redireciona para a página de login se não estiver autenticado
    }
}
  

