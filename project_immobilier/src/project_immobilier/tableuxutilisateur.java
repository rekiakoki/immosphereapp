package project_immobilier;

class Property {
    private String adresse;
    private String prix;
    private String surface;
    private String type;
    private String disponibilite;

    public Property(String adresse, String prix, String surface, String type, String disponibilite) {
        this.adresse = adresse;
        this.prix = prix;
        this.surface = surface;
        this.type = type;
        this.disponibilite = disponibilite;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPrix() {
        return prix;
    }

    public String getSurface() {
        return surface;
    }

    public String getType() {
        return type;
    }

    public String getDisponibilite() {
        return disponibilite;
    }
}
