package tools;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Config {

   // public static final Integer NUMBER_OF_CUSTOMERS = 100;
    public static final String PERSISTENCE_UNIT_NAME = PERSISTENCE_UNITS.OGM_MONGODB.name();

    public enum PERSISTENCE_UNITS {
        MYSQL, OGM_MONGODB, OGM_NEO4J, OGM_CASSANDRA, OGM_REDIS,


    }


}

