public class OracleDB {
    private static OracleDB oracleDBInstance;

    private OracleDB() {
    }

    public static OracleDB getInstance() {
        if (oracleDBInstance == null)
            oracleDBInstance = new OracleDB();
        return oracleDBInstance;
    }
}
