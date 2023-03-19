public class GalettePistacheFactory implements GaletteFactory {
    @Override
    public Galette createGalette(String n, Boolean feve) {
        return new GalettePistache(n, feve);
    }
}
