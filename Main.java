public class Main
{
    public static void main(String[] args) {
        Galette g = new Galette("g1");
        g.montrerGalette();

        Gourmand gourmand1 = new Gourmand("Marc");
        System.out.println(gourmand1.recherchePart(g).getPoids());
        Gourmet gourmet1 = new Gourmet("Aslan");
        System.out.println(gourmet1.recherchePart(g).getPoids());
        gourmet1.mangerPart(g,gourmet1.recherchePart(g));
        g.montrerGalette();
        gourmet1.mangerPart(g,gourmet1.recherchePart(g));
        System.out.println(gourmet1.getPoids_mange());
        while (true)
        {
            g.montrerGalette();
            if(gourmet1.mangerPart(g, gourmet1.recherchePart(g)) == 1)
            {
                break;
            }
            System.out.println(gourmet1.getPoids_mange());
        }
    }
}
