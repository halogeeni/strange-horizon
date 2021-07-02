package com.arasio.webdev.strangehorizon;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import org.junit.jupiter.api.BeforeAll;

public abstract class DatabaseIntegrationTest {

    @BeforeAll
    static void initDatabase() throws ManagedProcessException {
        DBConfigurationBuilder config = DBConfigurationBuilder.newBuilder();
        config.setPort(0);
        config.setSecurityDisabled(false);
        DB db = DB.newEmbeddedDB(config.build());
        db.start();
        db.source("db_init.sql", "root", null, null);
        db.source("insert_test_data.sql", "root", null, null);

        System.setProperty("spring.datasource.url",
            "jdbc:mariadb://localhost:" + db.getConfiguration().getPort() + "/strange_horizon");
    }

}
