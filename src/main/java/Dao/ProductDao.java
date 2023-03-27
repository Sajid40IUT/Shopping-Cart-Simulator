package Dao;

import bean.cartBean;
import bean.productBean;
import java.sql.*;
import java.util.*;
public class ProductDao {
    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;


    public ProductDao(Connection con) {
        super();
        this.con = con;
    }


    public List<productBean> getAllProducts() {
        List<productBean> products = new ArrayList<productBean>();
        try {

            query = "SELECT * FROM ComputerList";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                productBean row = new productBean();
                row.setProcessor(rs.getString("Processor"));
                row.setName(rs.getString("Name"));
                row.setRam(rs.getInt("RAM"));
                row.setPrice(rs.getDouble("Price"));

                products.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
    }

    public List<cartBean> getCartProducts(ArrayList<cartBean> cartList){
        List<cartBean> products = new ArrayList<cartBean>();

        try {
            if (cartList.size() > 0) {
                for (cartBean item:cartList){

                    query = "SELECT * FROM ComputerList WHERE Name = ?";
                    pst = this.con.prepareStatement(query);
                    String name = item.getNameOfProduct();
                    pst.setString(1, name);

                    rs = pst.executeQuery();

                    while (rs.next()) {
                        cartBean row = new cartBean();
                        row.setNameOfProduct(rs.getString("Name"));
                        row.setPrice(rs.getString("Price"));
                        products.add(row);
                    }

                }
            }
        } catch (Exception e)  {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return products;
    }

    public int getTotalCartPrice(ArrayList<cartBean> cartList) {
        int sum = 0;
        try {
            if (cartList.size() > 0) {
                for (cartBean item : cartList) {
                    query = "SELECT Price FROM ComputerList WHERE Name=?";
                    pst = this.con.prepareStatement(query);
                    pst.setString(1, item.getNameOfProduct());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getInt("Price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
}
