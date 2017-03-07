package packageelecciones.MODELO;

public class Partidos {

    private String nombre;
    private String logo;
    private int votos;

    public Partidos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Partidos{" + "nombre=" + nombre + ", logo=" + logo + ", votos=" + votos + '}';
    }
}
