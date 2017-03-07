package packageelecciones.DAO;

import packageelecciones.MODELO.*;
import org.apache.commons.codec.digest.*;
import java.sql.*;
import java.util.*;

public class Operaciones {

    public int darAlta(Connection conex, Votantes vota) throws SQLException {
        String nif = vota.getNif();
        String pass = vota.getPass();

        PreparedStatement state = conex.prepareStatement("INSERT INTO votantes (nif, pass) VALUES (?, ?);");

        String passenc = DigestUtils.md5Hex(pass);

        state.setString(1, nif);
        state.setString(2, passenc);
        return state.executeUpdate();
    }

    public int darBaja(Connection conex, Votantes vota) throws SQLException {
        String nif = vota.getNif();
        String pass = vota.getPass();
        int res;

        String passenc = DigestUtils.md5Hex(pass);

        PreparedStatement cons = conex.prepareStatement("SELECT * FROM votantes WHERE nif=? AND pass=?;");

        cons.setString(1, nif);
        cons.setString(2, passenc);
        ResultSet nom = cons.executeQuery();
        nom.next();
        String voto = nom.getString("voto");
        int id = nom.getInt("id_votantes");
        if (voto.equals("Si")) {
            res = 0;
        } else {
            PreparedStatement state = conex.prepareStatement("DELETE FROM votantes WHERE id_votantes=?;");
            state.setInt(1, id);
            res = state.executeUpdate();
            state.close();
        }
        cons.close();
        return res;
    }

    public ArrayList listaPartidos(Connection conex) throws SQLException {
        ArrayList partidos;
        PreparedStatement state = conex.prepareStatement("SELECT * FROM partidos ORDER BY votos DESC");
        ResultSet nom = state.executeQuery();
        partidos = new ArrayList();
        while (nom.next()) {
            partidos.add(nom.getString("nombre"));
            partidos.add(nom.getString("logo"));
            partidos.add(nom.getInt("votos"));
        }

        state.close();
        return partidos;
    }

    public int comprobar(Connection conex, Votantes vota) throws SQLException {
        String nif = vota.getNif();
        String pass = vota.getPass();
        int res;

        String passenc = DigestUtils.md5Hex(pass);

        PreparedStatement cons = conex.prepareStatement("SELECT * FROM votantes WHERE nif=? AND pass=?;");
        cons.setString(1, nif);
        cons.setString(2, passenc);
        ResultSet nom = cons.executeQuery();
        nom.next();
        String voto = nom.getString("voto");

        if (voto.equals("Si")) {
            res = 2;
        } else {
            res = 1;
        }

        cons.close();
        return res;
    }

    public int votar(Connection conex, Votantes vota, Partidos parti) throws SQLException {
        String nif = vota.getNif();
        String pass = vota.getPass();
        String nom = parti.getNombre();
        int res = 1;
        int resupd;
        int rescons;
        conex.setAutoCommit(false);

        String passenc = DigestUtils.md5Hex(pass);

        PreparedStatement cons = conex.prepareStatement("UPDATE votantes SET voto='Si' WHERE nif=? AND pass=?;");
        PreparedStatement upd = conex.prepareStatement("UPDATE partidos SET votos=votos+1 WHERE nombre=?;");

        cons.setString(1, nif);
        cons.setString(2, passenc);
        rescons = cons.executeUpdate();

        upd.setString(1, nom);
        resupd = upd.executeUpdate();

        if (rescons == 0 || resupd == 0) {
            conex.rollback();
            res = 2;
        } else {
            conex.commit();
            cons.close();
            upd.close();
        }

        return res;
    }

    public ArrayList listaCenso(Connection conex) throws SQLException {
        ArrayList censo;
        PreparedStatement state = conex.prepareStatement("SELECT * FROM votantes");
        ResultSet nom = state.executeQuery();
        censo = new ArrayList();
        while (nom.next()) {
            censo.add(nom.getString("nif"));
            censo.add(nom.getString("voto"));
        }
        state.close();
        return censo;
    }
}
