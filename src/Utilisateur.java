import java.util.ArrayList;

public abstract class Utilisateur implements MethodeCommune{
    private ArrayList<Livre> LivresEmprunter;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String NumeroTelephone;
    public Utilisateur(String nom,String prenom, String adresse, String numeroTelephone){
        this.Nom = nom;
        this.Prenom = prenom;
        this.Adresse = adresse;
        this.NumeroTelephone = numeroTelephone;
        this.LivresEmprunter = new ArrayList<>();
    }
    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getNumeroTelephone() {
        return NumeroTelephone;
    }

    public void EmprunterLivre(Livre l){ //lier a la methode EmprunterLivre de la class Bibliotheque
        LivresEmprunter.add(l);
    }
    public void RendreLivre(Livre l){ // lier a la methode RendreLivre de Bibliotheque
        LivresEmprunter.remove(l);
    }

    public ArrayList<Livre> getLivresEmprunter() {

        return LivresEmprunter;
    }

    @Override
    public abstract void AfficherDetails(); //Methode abstraite qui va permettre a la class Professeur d'afficher les details et aussi a la class Etudiant
}
