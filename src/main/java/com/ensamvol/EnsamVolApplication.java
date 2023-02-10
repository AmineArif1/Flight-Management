package com.ensamvol;

import com.ensamvol.entities.Personne;
import com.ensamvol.entities.Role;
import com.ensamvol.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class EnsamVolApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnsamVolApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new Role(null,"ADMIN"));
            accountService.addNewRole(new Role(null,"ADHERANT"));
            accountService.addNewUser(new Personne(null,"El Arif","Amine", new Date(1992,12,20),"1","123",new ArrayList<>(),null,null));
            accountService.addNewUser(new Personne(null,"Yassmine","Souhair", new Date(1992,12,20),"2","123",new ArrayList<Role>(),null,null));
            accountService.addNewUser(new Personne(null,"Lina","masba7i", new Date(1992,12,20),"3","123",new ArrayList<>(),null,null));
            accountService.addNewUser(new Personne(null,"Fahmi","Mustapha", new Date(1992,12,20),"4","123",new ArrayList<>(),null,null));
            accountService.addRoleToUser("1","ADMIN");
            accountService.addRoleToUser("1","ADHERANT");
            accountService.addRoleToUser("2","ADHERANT");
            accountService.addRoleToUser("3","ADHERANT");
//            System.out.println(accountService.loadUserByUsername("1").getRoles());
        };}
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("elarifamine1@gmail.com");
        mailSender.setPassword("rbcraidjygdzelzn");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }





}
