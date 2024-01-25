public class Auteur implements MethodeCommune{
    private String Nom;
    private String DateNaissance;
    private String Biographie;

    public Auteur(String nom) {
        this.Nom = nom;
    }
    public Auteur(String nom, String dateNaissance, String biographie){
        this.DateNaissance = dateNaissance;
        this.Biographie = biographie;
    }

    public String getNom() {
        return Nom;
    }
    public String getDateNaissance() {
        return DateNaissance;
    }
    public String getBiographie() {
        return Biographie;
    }

    //afficher les details sur l'auteur
    public void AfficherDetailsComplet(){
        System.out.println("NOM : "+getNom());
        System.out.println("Date de naissance : "+getDateNaissance());
        System.out.println("Bio : "+getBiographie());
    }

    @Override
    public void AfficherDetails(){
        System.out.println("NOM : "+getNom());
    }
}
