package packageelecciones.MODELO;

public class Votantes {

    private int cod;
    private String nif;
    private String pass;
    private String voto;

    public Votantes(String nif, String pass) {
        this.nif = nif;
        this.pass = pass;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "Votantes{" + "cod=" + cod + ", nif=" + nif + ", pass=" + pass + '}';
    }
}
