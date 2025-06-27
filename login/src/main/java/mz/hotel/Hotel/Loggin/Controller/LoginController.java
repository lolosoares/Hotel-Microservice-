package mz.hotel.Hotel.Loggin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

 
    

    public LoginController(){
       
    }
    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login"); // Retorna a página de login
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        if (username.equals("user") && password.equals("password")) { // Verifica a senha
            request.getSession().setAttribute("authenticatedUser", username); // Armazena o usuário autenticado na sessão
            return new ModelAndView("redirect:http://localhost:8080/home"); // Redireciona para a página inicial
        }
        return new ModelAndView("redirect:/login"); // Redireciona de volta para o login se falhar
    }
    
    @GetMapping("/home")
    public ModelAndView home(HttpServletRequest request) {
        // Verifica se o usuário está autenticado
        if (request.getSession().getAttribute("authenticatedUser") != null) {
            return new ModelAndView("http://localhost:8080/home"); 
        } else {
            return new ModelAndView("redirect:/login"); // Redireciona para o login se não autenticado
        }
    }

    

    
}
