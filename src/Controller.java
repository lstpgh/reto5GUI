import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {
    protected ArrayList<Req1> req1s;
    protected ArrayList<Req2> req2s;
    protected ArrayList<Req3> req3s;
    private Conector conectorDB;
 
    public Controller(String url) {
        super();
        this.req1s = new ArrayList<>();
        this.req2s = new ArrayList<>();
        this.req3s = new ArrayList<>();
        conectorDB = new Conector(url);
    }
 
    public void req1() {
        ResultSet rs1 = conectorDB.getReq1DB();
        try {
            while (rs1.next()) {
                Req1 requerimiento1 = new Req1(rs1.getInt("total"), rs1.getInt("ID_Proyecto"), rs1.getString("pagado"), rs1.getString("Proveedor"));
                req1s.add(requerimiento1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void req2() {
        ResultSet rs2 = conectorDB.getReq2DB();
        try {
            while (rs2.next()) {
                Req2 requerimiento2 = new Req2(rs2.getInt("estrato"), rs2.getString("Fecha_Inicio"), rs2.getInt("Financiable"), rs2.getDouble("porcetaje"));

                req2s.add(requerimiento2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 
    public void req3() {
        ResultSet rs3 = conectorDB.getReq3DB();
        try{
            while (rs3.next()) {
                Req3 requerimiento3 = new Req3(rs3.getString("clasificacion"), rs3.getInt("ID_Proyecto"), rs3.getString("pagado"));

                req3s.add(requerimiento3);
                
            }
        }catch (SQLException e){
             
            e.printStackTrace();
        }
    }
 
    public void printReq1() {
        for (Req1 req1 : req1s) {
            System.out.println(req1);
        }
    }

    public void printReq2() {
        for (Req2 req2 : req2s) {
            System.out.println(req2);
        }
    }

    public void printReq3() {
        for (Req3 req3 : req3s) {
            System.out.println(req3);
        }
    }

}
