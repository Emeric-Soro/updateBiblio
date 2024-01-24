import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Principal{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int Id; int choix = 0; int choixId = 0; int Quantite = 0;
        String Titre; String Auteur; String Edition; String Categorie; String Domaine; String Niveau; String Genre; String CritereRecherche;
        String Nom; String Prenom; String Adresse; String NumeroTel; String Departement; String Classe;
        boolean validation = false;

        //objet biblio de la class Bibliotheque
        Bibliotheque biblio = new Bibliotheque();

        //je cree des instance de livre pour pouvoir commencer le test directement
        Roman R1 = new Roman("La Peste","Albert Camus","Folio", "Roman",10,"fiction philosophique");
        Roman R2 = new Roman("L'Etranger","Albert Camus","Folio","Roman", 12,"fiction Absurde");
        Roman R3 = new Roman("Les soleils des l'independances","Amadou Kourouma","Presence Africaine","Roman",15,"fiction,engagee");

        BandeDessinee BD1 = new BandeDessinee("Berserk", "Kentaro Miura","Jump","Bande Desinee",0,"Manga");

        LivreScientifique LS1 = new LivreScientifique("Micrographia","Robert Hooke","ScienceF","Livre Scientifique",
                                                      6,"Biologie","Avancé","Mode d'emploie");

        LivreTheatrale LT1 = new LivreTheatrale("Romeo et Juliette","William Shakespeare","Magnard","Livre Theatrale",
                                                3,"Romance");

        Poesie Po1 = new Poesie("Coup de pilon","David Diop","Presence Africaine","Poesie",10,"Poesi engagee");

        //pareille ici je cree des instance d'utilisateur deja pret a etre utiliser
        Professeur P1 = new Professeur("Satoru","Gojo","Abidjan","0123456789","Math-info");
        Etudiant E1 = new Etudiant("Kouame","Brunelle", "Rue de la BIA","0787547896","L2-Droit");
        Etudiant E2 = new Etudiant("Assy","Eliel","Yopougon","0142568975","L2-MIAGE");
        Etudiant E3 = new Etudiant("Soro","Emeric","Cocody","0787154863","L2-MIAGE");

        //j'enregisqtre les utilisateurs
        biblio.AjouterUtilisateur(E1);
        biblio.AjouterUtilisateur(P1);
        biblio.AjouterUtilisateur(E2);
        biblio.AjouterUtilisateur(E3);

        //pareille pour les livre
        biblio.AjouterLivre(R1);
        biblio.AjouterLivre(R2);
        biblio.AjouterLivre(R3);
        biblio.AjouterLivre(BD1);
        biblio.AjouterLivre(LS1);
        biblio.AjouterLivre(LT1);
        biblio.AjouterLivre(Po1);

        //j'ininitialise un premier emprunt
        biblio.EmprunterLivre("Kouame","Brunelle","L'Etranger");
        biblio.EmprunterLivre("Soro","emeric","L'Etranger");
        biblio.EmprunterLivre("Soro","emeric","coup de pilon");
        biblio.EmprunterLivre("Assy","Eliel","berserk");

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~bienvenue dans ma bibliotheque~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("\t\tNB : avant de pouvoir emprunter un livre, vous devez \n\t\tvous creer un compte utilisateur\n");
        do { //Menu : choix de l'action
            System.out.println("\t1. Creer un nouvel utilisateur");
            System.out.println("\t2. Ajouter un nouveau livre");
            System.out.println("\t3. voir la liste des livres");
            System.out.println("\t4. rechercher un livre");
            System.out.println("\t5. Emprunter un livre");
            System.out.println("\t6. Rendre un livre");
            System.out.println("\t7. voir la liste des emprunteurs");
            System.out.println("\t8. Mettre a jour les Quantités");
            System.out.println("\t9. Ajouter un auteur");
            System.out.println("\t10. Afficher les auteurs");
            System.out.println("\t11. Supprimer un livre");
            System.out.println("\t12. Quitter");
            System.out.println("\tchoix : ");
            try{
                choix = Integer.parseInt(scan.nextLine());
                if(choix < 1 || choix > 12){
                    System.out.println("\tChoississez parmis les numeros ci dessous\n");
                }
            } catch (NumberFormatException e){
                System.out.println("\tEntrer un numero parmis ceux ci-dessus s'il vous plaît");
            }
            System.out.println();
            switch (choix){
                case 1 ->{ //choix = 1 pour enregistrer un nouvel utilisateur soit professeur ou etudiant
                    System.out.println("\tEtes-vous \n1.un professeur ou \n2.un Etudiant ? ");
                    System.out.println("choix(1 ou 2) : ");
                    int choixU = scan.nextInt();
                    scan.nextLine(); //consomer le retour a la ligne
                    switch (choixU){
                        case 1 -> {
                            System.out.println("\tEntrer votre nom : ");
                            Nom = scan.nextLine();

                            System.out.println("\tVotre Prenom(s) : ");
                            Prenom = scan.nextLine();

                            System.out.println("\tVotre adresse : ");
                            Adresse = scan.nextLine();

                            System.out.println("\tEntrer votre numero de telephone : ");
                            NumeroTel = scan.nextLine();

                            System.out.println("\tVotre departement : ");
                            Departement = scan.nextLine();

                            Professeur P = new Professeur(Nom,Prenom,Adresse,NumeroTel,Departement);
                            biblio.AjouterUtilisateur(P); //enregistrement du professeur

                            System.out.println("\tProfesseur Ajouter !\n");
                        }
                        case 2 -> {
                            System.out.println("\tEntrer votre nom : ");
                            Nom = scan.nextLine();

                            System.out.println("\tVotre Prenom(s) : ");
                            Prenom = scan.nextLine();

                            System.out.println("\tVotre adresse : ");
                            Adresse = scan.nextLine();

                            System.out.println("\tEntrer votre numero de telephone : ");
                            NumeroTel = scan.nextLine();

                            System.out.println("\tVotre class : ");
                            Classe = scan.nextLine();

                            Etudiant E = new Etudiant(Nom,Prenom,Adresse,NumeroTel,Classe);
                            biblio.AjouterUtilisateur(E);//enregistrement de l'etudiant

                            System.out.println("\tEtudiant ajouter !\n");
                        }
                        default -> System.out.println("\tchoisi 1 ou 2");
                    }
                }
                case 2 ->{ //pour ajouter un livre l'utilisateur va devoir choisir le type du livre a enregistrer
                System.out.println("\tquelle categorie de livre voulez-vous ajouter ?");
                System.out.println("\t1. Livre Scientifique ?");
                System.out.println("\t2. Roman ?");
                System.out.println("\t3. Poesie ?");
                System.out.println("\t4. Livre Theatrale ?");
                System.out.println("\t5. Bande Dessinee ?");
                System.out.println("\tchoix : ");
                int choixL = scan.nextInt();
                scan.nextLine();//consomer le retour a la ligne
                switch (choixL) {
                    case 1 -> {
                        //pour le cas ou c'est un livre scientifique

                        System.out.println("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.println("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.println("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.println("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine();//consomer le retour a la ligne

                        System.out.println("\tGenre : ");
                        Genre = scan.nextLine();

                        System.out.println("\tDomaine Scientifique : ");
                        Domaine = scan.nextLine();

                        System.out.println("\tNiveau d'etude : ");
                        Niveau = scan.nextLine();

                        //je cree une nouvelle instance de Livre scientifique
                        LivreScientifique NLS = new LivreScientifique(Titre, Auteur, Edition, Categorie, Quantite,Genre, Domaine, Niveau);
                        biblio.AjouterLivre(NLS); //NLS pour nouveau livre scientifique. ici grace au polymorphisme

                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    // NLS sera ajouter a l'inventaire comme LivreScientifique derive de Livre l'objet
                    // va être directement specifier
                    case 2 -> {

                        System.out.println("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.println("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.println("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.println("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consomer le retour à la ligne en suspens

                        System.out.println("\tGenre : ");
                        Genre = scan.nextLine();

                        Roman NLR = new Roman(Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLR);

                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    case 3 -> {

                        System.out.println("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.println("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.println("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.println("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.println("\tGenre : ");
                        Genre = scan.nextLine();

                        Poesie NLP = new Poesie(Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLP);

                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    case 4 -> {

                        System.out.println("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.println("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.println("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.println("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine();//consomer le retour a la ligne

                        System.out.println("\tGenre : ");
                        Genre = scan.nextLine();

                        LivreTheatrale NLT = new LivreTheatrale(Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLT);

                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    case 5 -> {

                        System.out.println("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.println("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.println("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.println("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine();//consomer le retour a la ligne

                        System.out.println("\tGenre : ");
                        Genre = scan.nextLine();

                        BandeDessinee NLBD = new BandeDessinee(Titre, Auteur, Edition,Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLBD);

                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                }

            }
                case 3 -> biblio.VoirLivre(); //affiche tous les livres avec les details
                case 4 ->{ //recherche d'un livre
                System.out.println("\tentrer le titre, l'auteur ou la categorie du livre rechercher : ");
                CritereRecherche = scan.nextLine();

                ArrayList<Livre> resultat = biblio.RechercheLivre(CritereRecherche);//liste pour retourner les resultats de la recheche

                if(!resultat.isEmpty()) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~Resultats de la recherche~~~~~~~~~~~~~~~~~~~~~~");
                    for (Livre livre : resultat) {
                        livre.AfficherDetails();
                    }
                }else { //si le livre n'est pas dans la bibliotheque on vous propose de l'ajouter si vous accepter vous aller l'ajouter
                    System.out.println("\tce livre n'est pas dans la bibliotheque !");

                    System.out.println("\tvoulez vous l'ajouter ? \n choix(oui ou non) : ");
                    String choix2 = scan.nextLine();


                    if (choix2.equalsIgnoreCase("oui")){
                        System.out.println("\tquelle categorie de livre voulez-vous ajouter ?");
                        System.out.println("\t1. Livre Scientifique ?");
                        System.out.println("\t2. Roman ?");
                        System.out.println("\t3. Poesie ?");
                        System.out.println("\t4. Livre Theatrale ?");
                        System.out.println("\t5. Bande Dessinee ?");
                        System.out.println("\tchoix : ");
                        int choixL = scan.nextInt();
                        scan.nextLine();//consomer le retour a la ligne
                        switch (choixL) {
                            case 1 -> {
                                //pour le cas ou c'est un livre scientifique

                                System.out.println("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.println("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.println("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.println("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine();//consomer le retour a la ligne

                                System.out.println("\tGenre : ");
                                Genre = scan.nextLine();

                                System.out.println("\tDomaine Scientifique : ");
                                Domaine = scan.nextLine();

                                System.out.println("\tNiveau d'etude : ");
                                Niveau = scan.nextLine();

                                //je cree une nouvelle instance de Livre scientifique
                                LivreScientifique NLS = new LivreScientifique(Titre, Auteur, Edition, Categorie, Quantite,Genre, Domaine, Niveau);
                                biblio.AjouterLivre(NLS); //NLS pour nouveau livre scientifique. ici grace au polymorphisme

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            // NLS sera ajouter a l'inventaire comme LivreScientifique derive de Livre l'objet
                            // va être directement specifier
                            case 2 -> {

                                System.out.println("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.println("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.println("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.println("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine();//consomer le retour a la ligne

                                System.out.println("\tGenre : ");
                                Genre = scan.nextLine();

                                Roman NLR = new Roman(Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLR);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            case 3 -> {

                                System.out.println("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.println("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.println("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.println("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine();//consomer le retour a la ligne

                                System.out.println("\tGenre : ");
                                Genre = scan.nextLine();

                                Poesie NLP = new Poesie(Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLP);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            case 4 -> {

                                System.out.println("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.println("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.println("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.println("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine();//consomer le retour a la ligne

                                System.out.println("\tGenre : ");
                                Genre = scan.nextLine();

                                LivreTheatrale NLT = new LivreTheatrale(Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLT);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            case 5 -> {

                                System.out.println("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.println("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.println("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.println("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine();//consomer le retour a la ligne

                                System.out.println("\tGenre : ");
                                Genre = scan.nextLine();

                                BandeDessinee NLBD = new BandeDessinee(Titre, Auteur, Edition,Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLBD);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                        }

                    }
                    else if(choix2.equalsIgnoreCase("non")){
                        System.out.println("\tpas de sousci");
                    }else{
                        System.out.println("\tpas compris !");
                    }
                }
            }
                case 5 ->{//pour emprunter un livre
                System.out.println("\tEntrer votre nom : ");
                Nom = scan.nextLine();

                System.out.println("\tVotre Prenom(s) : ");
                Prenom = scan.nextLine();

                System.out.println("\tentrer le titre du livre que vous souhaitez emprunter : ");
                Titre = scan.nextLine();

                biblio.EmprunterLivre(Nom,Prenom,Titre);
                }
                case 6 ->{ //pour rendre un livre
                System.out.println("\tEntrer votre nom : ");
                Nom = scan.nextLine();

                System.out.println("\tVotre Prenom(s) : ");
                Prenom = scan.nextLine();

                System.out.println("\tEntrer le titre du livre a rendre : ");
                Titre = scan.nextLine();

                biblio.RendreLivre(Nom,Prenom,Titre);
                }
                case 7 -> biblio.AfficherEmprunteur(); //affiche tous les utilisateurs et les livres qu'ils ont emprunter ou non pour ceux qui n'en n'ont pas emprunter
                case 8 ->{ //mettre a jour les qte
                do {
                    boolean rep = true;
                    boolean rep2 = true;
                    System.out.println("\tentrer l'Id du livre dont vous voulez mettre a jour les quantités : ");
                    try {
                        choixId = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("\tEntrer un nombre S'il vous plaît !");
                        rep = false;
                    }
                    System.out.println("\tEntrer la quantité à ajouter : ");
                    try {
                        Quantite = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("\tun nombre s'il vous plaît !");
                        rep2 = false;
                    }
                    if(rep && rep2){
                        validation = true;
                        biblio.MajQte(choixId,Quantite);
                    }
                }while (!validation);

                }
                case 9 ->{ //ajouter un nouvelle auteur
                System.out.println("\tEntrer le nom de l'auteur : ");
                Nom = scan.nextLine();

                System.out.println("\tla date de naissance de l'auteur : ");
                String DateNaissance = scan.nextLine();

                System.out.println("\tEcrivez la biographie de l'auteur : ");
                String Bio = scan.nextLine();

                Auteur A = new Auteur(Nom,DateNaissance,Bio);
                biblio.AjouterAuteur(A);

                System.out.println(("Auteur ajouter !"));
                }
                case 10 -> biblio.AfficherAuteur();
                case 11 ->{ //supprime un livre
                    System.out.println("Entrer l' id du livre que vous voulez supprimer : ");
                    Id = scan.nextInt();
                    scan.nextLine();//consomer le retour a la ligne

                    biblio.SupprimerLivre(Id);
                    System.out.println("livre supprimer !");
                }
            }
        }while (choix != 12 );
        System.out.println("au revoir");
    }
}