public class OracleDBDoubleCheckLocking {
    private static OracleDBDoubleCheckLocking oracleDBDoubleCheckLocking;

    private OracleDBDoubleCheckLocking() {
    }

    public static OracleDBDoubleCheckLocking getInstance() {
        if (oracleDBDoubleCheckLocking == null) {
            synchronized (OracleDBDoubleCheckLocking.class) {
                if (oracleDBDoubleCheckLocking == null) {
                    oracleDBDoubleCheckLocking = new OracleDBDoubleCheckLocking();
                }
            }
        }
        return oracleDBDoubleCheckLocking;
    }
}
