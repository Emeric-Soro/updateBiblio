public class LivreScientifique extends Livre{
    private String Domaine;
    private String Niveau;
    private String Genre;

    public LivreScientifique(String titre, String auteur, String edition,String categorie, int Qte, String domaine, String niveau,String genre) {
        super(titre, auteur, edition,categorie, Qte);
        this.Domaine = domaine;
        this.Niveau = niveau;
        this.Genre = genre;
    }

    public String getDomaine() {
        return Domaine;
    }
    public String getNiveau() {
        return Niveau;
    }
    public String getGenre() {
        return Genre;
    }

    @Override
    public void AfficherDetails(){
        System.out.println("Genre : "+getGenre());
        System.out.println("Domaine : "+getDomaine());
        System.out.println("Niveau : "+getNiveau());
        super.AfficherDetails();
    }
}
