package tools;

public class Config {

   // public static final Integer NUMBER_OF_CUSTOMERS = 100;
    public static final String PERSISTENCE_UNIT_NAME = PERSISTENCE_UNITS.OGM_MYSQL.name();
 //   public static final String LOG_STORAGE_LOCATION = "/home/jens/Downloads/" + PERSISTENCE_UNIT_NAME + "_crud_performance.txt";
    public static final Integer TRANSACTION_TIMEOUT = 900000;
    public static final String PERSIST_STORAGE_LOCATION = "/home/lucas/Downloads/customers.txt";
    public static final String PERSIST_STORAGE_OUTPUT_LOCATION = "/home/lucas/Downloads/customers_out.txt";

    public enum PERSISTENCE_UNITS {
        OGM_MYSQL, OGM_MONGODB, OGM_NEO4J, OGM_CASSANDRA, OGM_REDIS,


    }

}
