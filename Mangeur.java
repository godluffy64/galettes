public abstract class Mangeur
{

    private Type type;
    private String name;
    private double poids_max;
    private double poids_mange;
    private boolean feve;

    // Constructeur avec name et poids_max

    public Mangeur(String n, double pmax)
    {
        name = n;
        poids_max = pmax;
        feve = false;
        poids_mange = 0;
    }

    // Getters et Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoids_max() {
        return poids_max;
    }

    public void setPoids_max(double poids_max) {
        this.poids_max = poids_max;
    }

    public double getPoids_mange() {
        return poids_mange;
    }

    public void setPoids_mange(double poids_mange) {
        this.poids_mange = poids_mange;
    }

    public boolean isFeve() {
        return feve;
    }

    public void setFeve(boolean feve) {
        this.feve = feve;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // Méthodes

    public int mangerPart(Galette g, PartDeGalettes p)
    {
        if(!(p.getPoids() > (getPoids_max() - getPoids_mange())))
        {
            setPoids_mange(getPoids_mange() + p.getPoids());
            setFeve(p.isFeve());
            g.retirerPart(p);
            return 0;

        }
        else
        {
            System.out.println("Je ne peut pas ta mere");
            return 1;
        }
    }

    abstract public PartDeGalettes recherchePart(Galette G);

}
