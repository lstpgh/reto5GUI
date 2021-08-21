import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conector {
    private Connection connect;

    public Conector(String url) {
        super();
        connectDB(url);
    }

    public ResultSet getReq1DB() {

        String sql = "SELECT compra.ID_Proyecto, compra.Pagado, compra.Proveedor, SUM(compra.Cantidad) 'total' FROM compra WHERE compra.Pagado = 'No' GROUP BY compra.ID_Proyecto HAVING total > 50";

        return executeQuery(sql);
    }
 
    public ResultSet getReq2DB() {
        
        String sql = "SELECT tipo.Estrato, proyecto.Fecha_Inicio, tipo.Financiable, proyecto.Porcentaje_Cuota_Inicial * 100 'porcetaje' FROM tipo, proyecto WHERE proyecto.ID_Tipo = tipo.ID_Tipo AND tipo.Estrato >= 5 AND tipo.Financiable = 0 AND proyecto.Porcentaje_Cuota_Inicial = 0.3 ORDER BY proyecto.Fecha_Inicio, proyecto.ID_Proyecto";

        return executeQuery(sql);
    }

    public ResultSet getReq3DB() {
        
        String sql = "SELECT proyecto.Clasificacion, proyecto.ID_Proyecto, compra.Pagado  FROM proyecto, compra, materialconstruccion WHERE proyecto.ID_Proyecto = compra.ID_Proyecto AND  compra.ID_MaterialConstruccion = materialconstruccion.ID_MaterialConstruccion AND proyecto.Clasificacion IN ('Apartaestudio', 'Apartamento') AND compra.Pagado IN ('No', 'Parcialmente') AND materialconstruccion.Importado = 'Si' AND proyecto.Acabados = 'No' GROUP BY proyecto.ID_Proyecto";

        return executeQuery(sql);
    }

    public Connection connectDB(String url) {
        try {
        connect = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }
 
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}

