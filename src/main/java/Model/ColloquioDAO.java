package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColloquioDAO {
    public List<Colloquio> doRetrieveByCodISOLingua(String codISOLingua) {
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM ((Prodotto p JOIN Colloquio c ON p.ID=c.IDProdotto) " +
                    "JOIN Categoria ca ON p.IDCategoria=ca.ID) JOIN Lingua l ON c.codISOLingua=l.codISOLingua " +
                    "WHERE l.codISOLingua=?");
            ps.setString(1, codISOLingua);


            ResultSet rs = ps.executeQuery();

            List<Colloquio> colloqui = new ArrayList<>();

            while(rs.next()) {
                Colloquio c = new Colloquio();

                Categoria cat = new Categoria();
                cat.setID(rs.getInt("IDCategoria"));
                cat.setNome(rs.getString("ca.nome"));

                Lingua l = new Lingua();
                l.setCodISOLingua(rs.getString("codISOLingua"));
                l.setParlanti(rs.getInt("parlanti"));
                l.setNome(rs.getString("l.nome"));
                l.setFotoStatoOrigine(rs.getString("fotoStatoOrigine"));

                Prodotto p = new Prodotto();
                p.setID(rs.getInt("IDProdotto"));
                p.setPrezzoBase(rs.getDouble("prezzoBase"));
                p.setScontoPercentuale(rs.getDouble("scontoPercentuale"));
                p.setPrezzoAttuale(rs.getDouble("prezzoAttuale"));
                p.setCategoria(cat);

                /*c.setProdotto(p);
                c.setDescrizione(rs.getString("descrizione"));
                c.setNumeroUnita(rs.getInt("numeroUnita"));
                c.setLivello(rs.getString("livello"));
                c.setLingua(l);*/

                colloqui.add(c);
            }

            return colloqui;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
