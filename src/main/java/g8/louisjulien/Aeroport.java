package g8.louisjulien;

public class Aeroport {
    private final String Nom;
    private final String Ville;
    private String Description;

    public Aeroport(String nom, String ville) {
        this.Nom = nom;
        this.Ville = ville;
    }

    public void affecterOrigine(Vol vol) {
        if (!vol.getOrigine()[0].equals(this.Ville)) {
            System.out.println("AFFECTATION IMPOSSIBLE: Veuillez choisir un aéroport de la ville d'origine (" + vol.getOrigine()[0] + ")");
        }
        vol.getOrigine()[1] = this.Nom;
    }
    public void affecterDestination(Vol vol) {
        if (!vol.getDestination()[0].equals(this.Ville)) {
            System.out.println("AFFECTATION IMPOSSIBLE: Veuillez choisir un aéroport de la ville de destination (" + vol.getOrigine()[0] + ")");
        }
        vol.getDestination()[1] = this.Nom;
    }
}
