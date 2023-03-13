public class Gourmand extends Mangeur{

    public Gourmand(String n) {
        super(n, 2000);
        setType(Type.GOURMAND);
    }

    @Override
    public PartDeGalettes recherchePart(Galette G)
    {
        int pos_max = 0;
        double poids_max = 0;
        for(int i = 0; i <G.getListe_part().size(); i++)
        {
            if(i == 0 || G.getListe_part().get(i).getPoids() > poids_max)
            {
                poids_max = G.getListe_part().get(i).getPoids();
                pos_max = i;
            }
        }
        return G.getListe_part().get(pos_max);
    }
}
