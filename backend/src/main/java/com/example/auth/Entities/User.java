package com.example.auth.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String mail;
    private String nom;
    private String prenom;
    private String mdp;

    public User(String mail,String mdp){
        this.mail = mail;
        this.mdp = mdp;
    }

    public User(String mail, String nom, String prenom){
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
    }
}
