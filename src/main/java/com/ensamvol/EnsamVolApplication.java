package com.ensamvol;

import com.ensamvol.entities.AppRole;
import com.ensamvol.entities.AppUser;
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
    }
//    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
//            ConnectionString connectionString = new ConnectionString("mongodb+srv://killua:<password>@cluster0.t2wohrr.mongodb.net/?retryWrites=true&w=majority");
//            MongoClientSettings settings = MongoClientSettings.builder()
//                    .applyConnectionString(connectionString)
//                    .serverApi(ServerApi.builder()
//                            .version(ServerApiVersion.V1)
//                            .build())
//                    .build();
//            MongoClient mongoClient = MongoClients.create(settings);
//            MongoDatabase database = mongoClient.getDatabase("test");

            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"ADHERANT"));


            accountService.addNewUser(new AppUser(null,"El Arif","Amine", new Date(1992,12,20),"5eme",true,"Hassan2",false,"brih","killua","123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"Achak","Ayoub", new Date(1992,12,20),"5eme",true,"Hassan2",false,"brih","Kurapica","123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"Fahmi","Mustapha", new Date(1992,12,20),"5eme",true,"Hassan2",false,"brih","Leoro","123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"Fahmi","Mustapha", new Date(1992,12,20),"5eme",true,"Hassan2",false,"brih","Leoro2","123",new ArrayList<>()));


            accountService.addRoleToUser("killua","ADMIN");
            accountService.addRoleToUser("killua","ADHERANT");
            accountService.addRoleToUser("Leoro","ADHERANT");
            accountService.addRoleToUser("Kurapica","ADHERANT");
        };}
}
