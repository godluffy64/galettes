import java.util.ArrayList;

public class Galette
{
    // Attributs

    private String name;
    private ArrayList<PartDeGalettes> liste_part;

    // Setters et Getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PartDeGalettes> getListe_part() {
        return liste_part;
    }

    public void setListe_part(ArrayList<PartDeGalettes> liste_part) {
        this.liste_part = liste_part;
    }

    // Constructeur

    public Galette(String n)
    {
        name = n;
        int pos_feve = (int) (Math.random() * 8) + 1 ;
        liste_part = new ArrayList<>();
        PartDeGalettes p;
        for (int i = 0; i < 8; i++)
        {
            double poids_part = (Math.random() * 50) + 100;
            if (pos_feve == i)
            {
                p = new PartDeGalettes(poids_part, true);
            }
            else
            {
                p = new PartDeGalettes(poids_part, false);
            }
            getListe_part().add(p);

        }

    }

    // Méthode

    public void retirerPart(PartDeGalettes p)
    {
        if (getListe_part().contains(p)) getListe_part().remove(p);
        else System.out.println("Part de galette non trouvée");
    }

    public void montrerGalette()
    {
        System.out.println("Galette : " + getName());
        for(PartDeGalettes part : getListe_part())
        {
            System.out.println("- " + String.format("%.2f", part.getPoids()) + " grammes, fève : " + part.isFeve());
        }
    }

}
