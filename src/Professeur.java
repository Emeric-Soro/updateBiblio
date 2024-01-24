public class Professeur extends Utilisateur{
    String departement;

    public Professeur(String nom, String prenom, String adresse, String numeroTelephone, String departement) {
        super(nom,prenom, adresse, numeroTelephone);
        this.departement = departement;
    }


    @Override
    public void AfficherDetails() {
        System.out.println("NOM : "+getNom());
        System.out.println("PRENOM : "+getPrenom());
        System.out.println("Adresse : "+getAdresse());
        System.out.println("Numero de telephone : "+getNumeroTelephone());
        System.out.println("Departement : "+departement);
    }
}
