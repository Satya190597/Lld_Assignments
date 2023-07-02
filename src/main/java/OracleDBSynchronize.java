public class OracleDBSynchronize {

    private static OracleDBSynchronize oracleDBSynchronize;

    private OracleDBSynchronize() {
    }

    public static synchronized OracleDBSynchronize getInstance() {
        if (oracleDBSynchronize == null) {
            oracleDBSynchronize = new OracleDBSynchronize();
        }
        return oracleDBSynchronize;
    }
}
