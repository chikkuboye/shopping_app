import java.sql.*;
import java.util.Scanner;

public class Shoping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Enter the option below");
            System.out.println("1 :Insert");
            System.out.println("2 :View");
            System.out.println("3 :Search");
            System.out.println("4 :Update");
            System.out.println("5 :Delete");
            System.out.println("6 :exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert");
                    System.out.println("Enter the nme ");
                    String name = sc.next();
                    System.out.println("Enter the description ");
                    String desname = sc.next();
                    System.out.println("Enter the manufacture date");
                    String date = sc.next();
                    System.out.println("Enter the brand name");
                    String brandName = sc.next();
                    System.out.println("Enter the price");
                    int price = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping_db","root","");
                        String sql = "INSERT INTO `product`(`Pname`, `Description`, `Manuf_date`, `Brand_name`, `Price`) VALUES(?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,desname);
                        stmt.setString(3,date);
                        stmt.setString(4,brandName);
                        stmt.setInt(5,price);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping_db","root","");
                        String sql = "SELECT `Pname`, `Description`, `Manuf_date`, `Brand_name`, `Price` FROM `product`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            name = rs.getString("Pname");
                            String Desc = rs.getString("Description");
                            String Manu_date = rs.getString("Manuf_date");
                            String BrandName = rs.getString("Brand_Name");
                            price = rs.getInt("Price");
                            System.out.println("Purchase name ="+name);
                            System.out.println("Description ="+Desc);
                            System.out.println("Date ="+Manu_date);
                            System.out.println("Brand out ="+BrandName);
                            System.out.println("Price ="+price+'\n');
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Search");
                    System.out.println("Enter the product name");
                    int id = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping_db","root","");
                        String sql = "SELECT `Id`, `Pname`, `Description`, `Manuf_date`, `Brand_name`, `Price` FROM `product` WHERE `Id`="+id;
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            name = rs.getString("Pname");
                            String Desc = rs.getString("Description");
                            String Manu_date = rs.getString("Manuf_date");
                            String BrandName = rs.getString("Brand_Name");
                            price = rs.getInt("Price");
                            System.out.println("Purchase name ="+name);
                            System.out.println("Description ="+Desc);
                            System.out.println("Date ="+Manu_date);
                            System.out.println("Brand out ="+BrandName);
                            System.out.println("Price ="+price+'\n');
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update");
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    System.out.println("Enter the nme ");
                    name = sc.next();
                    System.out.println("Enter the description ");
                    desname = sc.next();
                    System.out.println("Enter the manufacture date");
                    date = sc.next();
                    System.out.println("Enter the brand name");
                    brandName = sc.next();
                    System.out.println("Enter the price");
                    price = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping_db","root","");
                        String sql = "UPDATE `product` SET `Pname`='"+name+"',`Description`='"+desname+"',`Manuf_date`='"+date+"',`Brand_name`='"+brandName+"',`Price`='"+price+"' WHERE `Id`="+id;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("Delete");
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
