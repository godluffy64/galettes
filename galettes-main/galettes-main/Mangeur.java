import java.util.ArrayList;

public class Mangeur
{


    private Strategy strategy;
    private String name;
    private double poids_max;
    private double poids_mange;
    private boolean feve;

    // Constructeur avec name et poids_max

    public Mangeur(String n, double pmax, Strategy strat)
    {
        name = n;
        poids_max = pmax;
        strategy = strat;
        feve = false;
        poids_mange = 0;
    }

    // Getters et Setters
    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

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
        else return 1;
    }
}
