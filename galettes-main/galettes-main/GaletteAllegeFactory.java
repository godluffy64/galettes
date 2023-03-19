public class GaletteAllegeFactory implements GaletteFactory
{
    @Override
    public Galette createGalette(String n, Boolean feve) {
        return new GaletteAllege(n, feve);
    }
}
