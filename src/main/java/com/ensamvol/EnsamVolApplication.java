package com.ensamvol;
import com.ensamvol.entities.Client;
import com.ensamvol.entities.Personne;
import com.ensamvol.entities.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ensamvol.service.AccountService;
import java.util.ArrayList;
import java.util.Date;
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class EnsamVolApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnsamVolApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }}
//    @Bean
    /*CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new Role(null,"ADMIN"));
            accountService.addNewRole(new Role(null,"ADHERANT"));
            accountService.addNewUser(new Personne(null,"El Arif","Amine", new Date(1992,12,20),"1","123",new ArrayList<>(),new Client(null,"884",new Personne())));
            accountService.addNewUser(new Personne(null,"Yassmine","Souhair", new Date(1992,12,20),"2","123",new ArrayList<Role>(),new Client(null,"885",new Personne())));
            accountService.addNewUser(new Personne(null,"Lina","masba7i", new Date(1992,12,20),"3","123",new ArrayList<>(),new Client(null,"886",new Personne())));
            accountService.addNewUser(new Personne(null,"Fahmi","Mustapha", new Date(1992,12,20),"4","123",new ArrayList<>(),new Client(null,"887",new Personne())));
            accountService.addRoleToUser("1","ADMIN");
            accountService.addRoleToUser("1","ADHERANT");
            accountService.addRoleToUser("2","ADHERANT");
            accountService.addRoleToUser("3","ADHERANT");
//            System.out.println(accountService.loadUserByUsername("1").getRoles());
        };}
}*/
