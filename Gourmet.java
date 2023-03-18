import java.util.ArrayList;

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

    @Override
    public Object[] recherchePart(ArrayList<Galette> list_g)
    {
        Galette g = list_g.get(0);
        PartDeGalettes part = list_g.get(0).getListe_part().get(0);
        double poids_min = list_g.get(0).getListe_part().get(0).getPoids();
        for(Galette galette : list_g)
        {
            for (PartDeGalettes partDeGalettes : galette.getListe_part())
            {
                if (poids_min > partDeGalettes.getPoids())
                {
                    g = galette;
                    poids_min = partDeGalettes.getPoids();
                    part = partDeGalettes;
                }
            }
        }
        Object[] result = {g, part};
        if (part.getPoids() > (getPoids_max() - getPoids_mange())) return null;
        return result;
    }
}
