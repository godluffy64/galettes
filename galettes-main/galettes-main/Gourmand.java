import java.util.ArrayList;

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

    @Override
    public Object[] recherchePart(ArrayList<Galette> list_g)
    {

        Galette g = list_g.get(0);
        PartDeGalettes part = list_g.get(0).getListe_part().get(0);
        double poids_max = list_g.get(0).getListe_part().get(0).getPoids();
        for(Galette galette : list_g)
        {
            for (PartDeGalettes partDeGalettes : galette.getListe_part())
            {
                if (poids_max < partDeGalettes.getPoids())
                {
                    g = galette;
                    poids_max = partDeGalettes.getPoids();
                    part = partDeGalettes;
                }
            }
        }
        Object[] result = {g, part};
        if (part.getPoids() > (getPoids_max() - getPoids_mange())) return null;
        return result;
    }
}
