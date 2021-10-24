package murach.data;

import murach.business.Product;
import murach.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ProductDAO(){

    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from Product";
        try {
            conn = new ConnectionUtils().getMyConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Product getProduct(String txt) {
        String query = "select * from product where ProductCode = ?";
        List<Product> list = new ArrayList<>();
        try {
            conn = new ConnectionUtils().getMyConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public ArrayList<Product> getMinMaxProduct(float min,float max) {
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from Product where Product.Price >? AND Product.Price<?";
        try {
            conn = new ConnectionUtils().getMyConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setFloat(1, min);
            ps.setFloat(2, max);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
