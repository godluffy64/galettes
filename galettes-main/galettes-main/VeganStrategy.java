import java.util.ArrayList;

public class VeganStrategy implements Strategy
{

    @Override
    public Object[] strategie(ArrayList<Galette> list_g)
    {
        Galette g = list_g.get(0);
        PartDeGalettes part = list_g.get(0).getListe_part().get(0);
        boolean first_PartDeGalette_vegan = false;
        double poids_min = list_g.get(0).getListe_part().get(0).getPoids();
        for(Galette galette : list_g)
        {
            if (galette.getGaletteType() == GaletteType.VEGAN)
            {
                for (PartDeGalettes partDeGalettes : galette.getListe_part())
                {
                    if (!first_PartDeGalette_vegan || poids_min > partDeGalettes.getPoids())
                    {
                        first_PartDeGalette_vegan = true;
                        g = galette;
                        poids_min = partDeGalettes.getPoids();
                        part = partDeGalettes;
                    }
                }
            }

        }
        Object[] result = {g, part};
        if (!first_PartDeGalette_vegan) return null;
        return result;
    }
}
