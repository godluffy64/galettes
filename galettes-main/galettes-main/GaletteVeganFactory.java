public class GaletteVeganFactory implements GaletteFactory{
    @Override
    public Galette createGalette(String n, Boolean feve) {
        return new GaletteVegan(n, feve);
    }
}
