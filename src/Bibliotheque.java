import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
public class Bibliotheque {
    ArrayList<Livre> inventaire = new ArrayList<>(); // liste pour les livres
    ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    ArrayList<Auteur> auteurs = new ArrayList<>();
    ArrayList<Utilisateur> UemprunterLivre = new ArrayList<>();//liste pour les utilisateur qui ont emprunter un livre
    public void AjouterLivre(Livre L){
        inventaire.add(L); //ajoute un livre dans la liste inventaire
    }
    public void AjouterUtilisateur(Utilisateur u){
        utilisateurs.add(u); //ajoute un utilisateur dans la liste utilisateur
    }
    public void VoirLivre(){ //afficher les details des livres dans notre liste
        System.out.println("~~~~~~~~~~~~~~les livres~~~~~~~~~~~~~~");
        for(Livre l : inventaire){
            l.AfficherDetails();
            System.out.println();
        }
    }
    //je cree une fonction Rechercher qui va retourner une liste(liste des resultats que la boucle va trouver)
    public ArrayList<Livre> RechercheLivre(String Critere){
        //je cree un fonction de type Arraylist pour pouvoir retourner une liste
        //je cree un liste pour les resultats de la reccherche pour facilité l'affichage
        ArrayList<Livre> resultat = new ArrayList<>();
        for (Livre l : inventaire) {
            if (l.getTitre().toLowerCase().matches(Critere.toLowerCase()) ||    //cherche en fonction du titre,l'auteur ou la categorie
                    l.getAuteur().getNom().toLowerCase().matches(Critere) ||
                    l.getCategorie().toLowerCase().matches(Critere.toLowerCase())) {
                resultat.add(l); //des qu'il y'a une correspondance on enregistre cette correspondance dans la liste resultat cree au dessus
            }
        }
        return resultat; //on retourne la liste resultat
    }
    public void EmprunterLivre(String NomUtilisateur, String PrenomUtilisateur, String titre) {
        Utilisateur u = null; //je fais ca pour utiliser u plus tard dans la methode
        for (Utilisateur U :utilisateurs) {
            if (U.getNom().equalsIgnoreCase(NomUtilisateur) && U.getPrenom().equalsIgnoreCase(PrenomUtilisateur)) {
                u = U; //si il y'a correspondance entre les nom et les prenom u prend la valeur de l'utilisateur U
                break;
            }
        }
        if (u == null) {
            System.out.println("Utilisateur inexistant ! Créez un utilisateur SVP !");
        } else {
            Livre LEmprunter = null; // je fais ca pour utiliser LEmprunter plus tard dans la methode
            for (Livre l : inventaire) {
                if (l.getTitre().equalsIgnoreCase(titre) && l.getQuantiteDisponible() > 0) {
                    LEmprunter = l; //je fais la même chose que plus haut mais la je compare les titres et je verifie que la quantite de livre n'est pas null
                    break;
                }
            }
            if (LEmprunter != null) { // si LEmprunter n'est pas null j'enregistre l'utilisateur u dans la liste UemprunterLivre
                int QteMaj = LEmprunter.getQuantiteDisponible();
                LEmprunter.setQuantiteDisponible(QteMaj - 1);
                u.EmprunterLivre(LEmprunter);
                LocalTime HeureEmprunt = LocalTime.now();
                LocalTime HeureEcheance = HeureEmprunt.plus(1,ChronoUnit.HOURS);
                LocalDate DateEmprunt = LocalDate.now();
                LocalDate DateEcheance = DateEmprunt.plus(2,ChronoUnit.WEEKS);
                System.out.println(NomUtilisateur+" a emprunté le livre : " + LEmprunter.getTitre()+" le "+DateEmprunt+" a "+HeureEmprunt);
                System.out.println("la date d'echeance est fixé au : "+DateEcheance+" a "+HeureEcheance);
                UemprunterLivre.add(u);
            } else {
                System.out.println(NomUtilisateur+" le livre est en rupture de stock ou introuvable"); //sinon je renvois ce message
            }
        }
    }
    public void RendreLivre(String NomUtilisateur, String PrenomUtilisateur, String titre){
        Utilisateur u = null;
        for (Utilisateur U : UemprunterLivre) { //je parcours Uemprunter parce que c'est la liste des emprunteurs
            if (U.getNom().equalsIgnoreCase(NomUtilisateur) && U.getPrenom().equalsIgnoreCase(PrenomUtilisateur)){ //je compare les noms et prenoms
                u = U; //si il ya correspondance u prend la valeur de U
                break;
            }
        }
        if (u == null) {
            System.out.println("Cet utilisateur est inexistant ! ou il n'a pas encore emprunter un livre");
        } else {
            Livre LRendre = null; //si u est different de null je vais comparer les titres
            for (Livre l : u.getLivresEmprunter()){
                if(l.getTitre().toLowerCase().matches(titre.toLowerCase())){
                    LRendre = l; // si il ya correspondance LRendre prend l
                    break;
                }
            }
            if(LRendre != null){ //si LRendre n'est pas null on peut procedeer a l'operation
                int QteMaj = LRendre.getQuantiteDisponible();
                LRendre.setQuantiteDisponible(QteMaj + 1);
                u.RendreLivre(LRendre);
                LocalDate DateRetour = LocalDate.now();
                LocalTime HeureRetour = LocalTime.now();
                System.out.println("vous avez rendu le livre "+LRendre.getTitre()+" le "+DateRetour+" a "+HeureRetour);
            }
            else {
                System.out.println("vous n'avez pas emprunter ce livre ! Ou livre introuvable");
            }
        }
    }
    public void AfficherEmprunteur(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~LISTE DES EMPRUNTEUR~~~~~~~~~~~~~~~~~~~~\n");
        for(Utilisateur u : utilisateurs){ //je ne parcours pas la liste des emprunteur "UemprunterLivre" parce que je veux montrer la situation de tous les utilisateurs
            System.out.println("Nom de l'utilisateur : "+u.getNom());
            if(u.getLivresEmprunter().isEmpty()){ //si il n'y a pas de livre enregistrer pour l'utilisateur on renvois le message ci-dessous
                System.out.println("cet utilisateur n'a emprunter aucun livre");
            }
            else {
                System.out.println("Livre emprunter par "+u.getNom()+" :");
                for(Livre l : u.getLivresEmprunter()){ //ici j'affiche tous les livres emprunter par l'utilisateur
                    System.out.println("* "+l.getTitre());
                }
            }
            System.out.println();
        }

    }
    public void MajQte(int id, int NQte){ //ici j'ai utiliser la meme technique mais avec l'id des livres pour la recherche du livre a mettre a jour
        Livre lMaj = null;
        int QteActuelle;
        int NouvelleQte;
        for (Livre l : inventaire){
            if(id == l.getId()){
                lMaj = l;
                break;
            }
        }
        if(lMaj != null){
            QteActuelle = lMaj.getQuantiteDisponible();
            NouvelleQte = QteActuelle + NQte;
            if(NouvelleQte < 0){ // si la nouvelle quantite est negative elle prend la valeur 0
                NouvelleQte = 0;
            }
            else{
                lMaj.setQuantiteDisponible(NouvelleQte);
            }
            System.out.println("Les quantites du livre : "+lMaj.getTitre()+" ont ete mis a jour");
        }
        else {
            System.out.println("livre introuvable !");
        }

    }
    public void AjouterAuteur(Auteur a){
        auteurs.add(a);
    }
    public void AfficherAuteur(){
        for(Auteur a : auteurs){
            a.AfficherDetails();
            System.out.println();
        }
    }
    public void SupprimerLivre(int Id){ //je fais une recherche a partir de l'id du livre a supprimer comme dans la methode MajQte
        Livre Lsup = null;
        for (Livre l : inventaire){
            if(Id == l.getId()){
                Lsup = l;
                break;
            }
        }
        if(Lsup != null){
            inventaire.remove(Lsup);
        }else {
            System.out.println("Cet Id ne correspond a aucun livre !");
        }
    }
}
