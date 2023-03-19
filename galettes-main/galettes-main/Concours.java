import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Random;

public class Concours {
    // Attributs
    public static final int NB_COMPETITEUR = 5;
    public static final int NB_GALETTES = 10;
    private ArrayList<Mangeur> competiteurs;
    private ArrayList<Galette> liste_galettes;

    // Getters and Setters

    public ArrayList<Mangeur> getCompetiteurs() {
        return competiteurs;
    }

    public void setCompetiteurs(ArrayList<Mangeur> competiteurs) {
        this.competiteurs = competiteurs;
    }

    public ArrayList<Galette> getListe_galettes() {
        return liste_galettes;
    }

    public void setListe_galettes(ArrayList<Galette> liste_galettes) {
        this.liste_galettes = liste_galettes;
    }

    // Constructeurs

    public Concours()
    {
        competiteurs = new ArrayList<>();
        liste_galettes = new ArrayList<>();

        for (int i = 1; i < NB_COMPETITEUR + 1; i++)
        {
            Mangeur mangeur;
            Strategy strategy;
            String type;
            int p_max;
            int r = (int) (Math.random() * 3);
            switch (r)
            {
                case (0) :
                {
                    strategy = new GourmetStrategy();
                    type = "Gourmet";
                    p_max = 500;
                    break;
                }
                case (1) :
                {
                    strategy = new GourmandStrategy();
                    type = "Gourmand";
                    p_max = 2000;
                    break;
                }
                default :
                {
                    strategy = new VeganStrategy();
                    type = "Vegan";
                    p_max = 1500;
                    break;
                }
            }
            mangeur = new Mangeur("Compétiteur " + i + " " + type, p_max, strategy);
            competiteurs.add(mangeur);
        }
        GaletteFactory PistacheFactory = new GalettePistacheFactory();
        GaletteFactory AllegeFactory = new GaletteAllegeFactory();
        GaletteFactory FrangipaneFactory = new GaletteFrangipaneFactory();
        GaletteFactory VeganFactory = new GaletteVeganFactory();

        int randomNumber;
        int pos_feve_galette = (int)(Math.random() * NB_GALETTES) + 1; // position de la galette qui aura la fève
        for (int i = 1; i < NB_GALETTES + 1; i++)
        {
            Random random = new Random();
            randomNumber = random.nextInt(4);
            if (randomNumber == 0)
            {
                if (pos_feve_galette == i) liste_galettes.add(new GalettePistache("Galette " + i, true));
                else liste_galettes.add(new GalettePistache("Galette " + i, false));
            }

            else if(randomNumber == 1)
            {
                {
                    if (pos_feve_galette == i) liste_galettes.add(new GaletteFrangipane("Galette " + i, true));
                    else liste_galettes.add(new GaletteFrangipane("Galette " + i, false));
                }
            }
            else if (randomNumber == 2)
            {
                if (pos_feve_galette == i) liste_galettes.add(new GaletteAllege("Galette " + i, true));
                else liste_galettes.add(new GaletteAllege("Galette " + i, false));
            }
            else if (randomNumber == 3)
            {
                if (pos_feve_galette == i) liste_galettes.add(new GaletteVegan("Galette " + i, true));
                else liste_galettes.add(new GaletteVegan("Galette " + i, false));
            }

        }

    }

    // Méthodes

    public void montrerConcours()
    {
        System.out.println("Compétiteurs :");
        for(Mangeur mangeur : competiteurs)
        {
            System.out.println("- " + mangeur.getName() + " "+ " " + mangeur.getPoids_mange() + " fève : " + mangeur.isFeve());
        }
        for(Galette galette : liste_galettes)
        {
            galette.montrerGalette();
        }
    }

    public void nettoyerTable()
    {
        for(int i = 0; i < liste_galettes.size(); i++)
        {
            if (liste_galettes.get(i).getListe_part().isEmpty()) liste_galettes.remove(liste_galettes.get(i));
        }
    }

    public void enleverLesPerdants()
    {
        for(int i = 0; i < competiteurs.size(); i++)
        {
            PartDeGalettes part = null;
            Object[] list = competiteurs.get(i).getStrategy().strategie(liste_galettes);

            if (list != null)
            {
                part = (PartDeGalettes) list[1];
            }
            if(list == null || competiteurs.get(i).getPoids_max() <  competiteurs.get(i).getPoids_mange() + part.getPoids())
            {
                System.out.println("Compétiteur : " + competiteurs.get(i).getName() + " ne peut plus manger");
                competiteurs.remove(competiteurs.get(i));
            }
        }
    }

    public Mangeur verifierFeve()
    {
        for (Mangeur mangeur : competiteurs)
        {
            if (mangeur.isFeve()) return mangeur;
        }
        return null;
    }

    public int getNombreParts()
    {
        int nb_part = 0;
        for(Galette galette : liste_galettes)
        {
            nb_part += galette.getListe_part().size();
        }
        return nb_part;
    }

    public Mangeur concourir()
    {
        montrerConcours();
        int tour = 1;
        while(true)
        {
            if (competiteurs.isEmpty())
            {
                System.out.println("Il ne reste plus de compétiteur");
                break;
            }
            if (liste_galettes.isEmpty())
            {
                System.out.println("Il ne reste plus de galette");
                break;
            }

            if (getNombreParts() < NB_COMPETITEUR)
            {
                System.out.println("Il ne reste plus assez de parts.");
                break;
            }

            if(verifierFeve() != null)
            {
                System.out.println(verifierFeve().getName() + " à gagné !");
                return verifierFeve();
            }
            System.out.println("--------------- Tour " + tour+ " ---------------");
            for(int i = 0; i < competiteurs.size(); i++)
            {
                Object[] list;
                list = competiteurs.get(i).getStrategy().strategie(getListe_galettes());
                if (list != null)
                {
                    competiteurs.get(i).mangerPart((Galette) list[0], (PartDeGalettes) list[1]);
                }

                nettoyerTable();
                enleverLesPerdants();
            }
            montrerConcours();
            tour++;
        }
        return null;
    }
}
