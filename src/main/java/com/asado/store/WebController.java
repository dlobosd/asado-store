package com.asado.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    // Rutas de Navegación (Enlaces a tus HTML)
    
    @GetMapping("/")
    public String inicio() {
        // CORRECCIÓN CLAVE: Devolvemos directamente el nombre de la plantilla
        // para asegurar que Spring Boot encuentre la página de inicio.
        return "historia8diego"; 
    }

    @GetMapping("/catalogo")
    public String catalogo() {
        return "historia8diego"; 
    }

    @GetMapping("/carrito")
    public String carrito() {
        return "historia4diego"; 
    }

    @GetMapping("/pedidos")
    public String pedidos() {
        return "historia5diego"; 
    }

    @GetMapping("/pagar")
    public String pagar() {
        return "historia6diego"; 
    }

    @GetMapping("/comprobante")
    public String comprobante() {
        return "historia11diego"; 
    }

    @GetMapping("/perfil")
    public String perfil() {
        return "historia13dieego"; 
    }

    @GetMapping("/login")
    public String login() {
        return "historia2diego"; 
    }

    @GetMapping("/registro")
    public String registro() {
        return "historia1diego"; 
    }
    
    @GetMapping("/notificaciones")
    public String notificaciones() {
        return "historia7diego"; 
    }
    
    @GetMapping("/promociones")
    public String promociones() {
        return "historia12dieego"; 
    }

    // Rutas de Acción (Simulan la API)

    @PostMapping("/api/register")
    public String handleRegister(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensaje", "✅ Registro Exitoso. Ahora puedes iniciar sesión.");
        return "redirect:/login"; 
    }

    @PostMapping("/api/process-payment")
    public String handlePayment(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensaje", "✅ Pago procesado correctamente. ¡Pedido Confirmado!");
        return "redirect:/comprobante";
    }

    @PostMapping("/api/update-profile")
    public String handleProfileUpdate(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensaje", "✅ Perfil actualizado con éxito.");
        return "redirect:/perfil"; 
    }
    
    @PostMapping("/api/save-notifications")
    public String handleSaveNotifications(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensaje", "✅ Preferencias de notificación guardadas.");
        return "redirect:/notificaciones"; 
    }
}