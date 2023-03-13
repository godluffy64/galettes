public class Gourmet extends Mangeur{

    public Gourmet(String n) {
        super(n, 500);
        setType(Type.GOURMET);
    }

    @Override
    public PartDeGalettes recherchePart(Galette G)
    {
        int pos_min = 0;
        double poids_min = 0;
        for(int i = 0; i <G.getListe_part().size(); i++)
        {
            if(i == 0 || G.getListe_part().get(i).getPoids() < poids_min)
            {
                poids_min = G.getListe_part().get(i).getPoids();
                pos_min = i;
            }
        }
        return G.getListe_part().get(pos_min);
    }
}
