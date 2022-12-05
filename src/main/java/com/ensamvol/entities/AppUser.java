package com.ensamvol.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;
import java.util.List;
@Document
@NoArgsConstructor @AllArgsConstructor @Data
public class AppUser {
    @Id
    private String CIN;
    @Field
    private String Nom;
    @Field
    private String Prenom;
    @Field
    private Date Date_Naissance;
    @Indexed(unique = true)
    private String username;
    @Field
    private String Password;
    @DBRef
    private List<AppRole> appRoles ;

}
