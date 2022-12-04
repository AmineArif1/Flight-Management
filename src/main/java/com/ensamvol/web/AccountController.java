package com.ensamvol.web;
import com.ensamvol.entities.AppUser;
import com.ensamvol.service.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;


@Controller
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/users")
    @PostAuthorize("hasAuthority('ADMIN')")
    public String appUsers(Model model){
        model.addAttribute("listUsers",accountService.listUsers());
        return "users";
    }
    @GetMapping("/profile")
    public AppUser profile(Principal principal){
        return accountService.loadUserByUsername(principal.getName());
    }
}
