export class User{
    mail: string="";
    password: string="";
    prenom: string="";
    nom: string="";
    
    constructor(mail:string,password:string,prenom:string,nom:string){
        this.mail = mail;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
    }
}