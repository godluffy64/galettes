public class PartDeGalettes
{


    private double poids;



    private boolean feve;

    public PartDeGalettes(double p, boolean f)
    {
        poids = p;
        feve = f;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public boolean isFeve() {
        return feve;
    }

    public void setFeve(boolean feve) {
        this.feve = feve;
    }

}
