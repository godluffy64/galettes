import java.util.ArrayList;

public abstract class Galette
{
    // Attributs
    public static final int NB_PARTS = 8;


    private GaletteType galetteType;


    private int poids;
    private String name;
    private ArrayList<PartDeGalettes> liste_part;

    // Setters et Getters
    public GaletteType getGaletteType() {
        return galetteType;
    }

    public void setGaletteType(GaletteType galetteType) {
        this.galetteType = galetteType;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
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

    public Galette(String n, int poids, boolean feve, GaletteType type)
    {
        name = n;
        galetteType = type;
        int pos_feve = -1;
        if (feve)   pos_feve = (int) (Math.random() * NB_PARTS) ;
        liste_part = new ArrayList<>();
        PartDeGalettes p;
        for (int i = 0; i < NB_PARTS; i++)
        {
            double poids_part = (Math.random() *((int) (poids / NB_PARTS) * 0.2)) + ((poids * 0.9) / NB_PARTS) ;
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
        System.out.println("Galette : " + getName() + " " + getGaletteType());
        for(PartDeGalettes part : getListe_part())
        {
            System.out.println("- " + String.format("%.2f", part.getPoids()) + " grammes, fève : " + part.isFeve());
        }
    }

}
