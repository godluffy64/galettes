import java.util.ArrayList;

public class GourmandStrategy implements Strategy
{

    @Override
    public Object[] strategie(ArrayList<Galette> list_g) {

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
        return result;
    }
}
