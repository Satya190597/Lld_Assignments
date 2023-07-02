public class OracleDBEagerInstantiation {
    private static OracleDBEagerInstantiation oracleDBInstance = new OracleDBEagerInstantiation();
    private OracleDBEagerInstantiation() {}

    public static OracleDBEagerInstantiation getInstance() {
        return oracleDBInstance;
    }
}
