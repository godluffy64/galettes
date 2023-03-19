public class GaletteFrangipaneFactory implements GaletteFactory{
    @Override
    public Galette createGalette(String n, Boolean feve) {
        return new GaletteFrangipane(n, feve);
    }
}
