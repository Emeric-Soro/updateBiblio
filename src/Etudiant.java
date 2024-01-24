public class Etudiant extends Utilisateur {
    String classe; //attribut de client

    //constructeur de client
    public Etudiant(String nom,String prenom, String adresse, String numeroTelephone, String classe) {
        super(nom,prenom, adresse, numeroTelephone);
        this.classe = classe;
    }

    @Override
    public void AfficherDetails() { //afficher les details des utilisateurs (Etudiant)
        System.out.println("NOM : "+getNom());
        System.out.println("PRENOM : "+getPrenom());
        System.out.println("Adresse : "+getAdresse());
        System.out.println("Numero de telephone : "+getNumeroTelephone());
        System.out.println("Classe : "+classe);

    }
}
