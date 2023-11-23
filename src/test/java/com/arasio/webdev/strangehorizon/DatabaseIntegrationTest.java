package com.arasio.webdev.strangehorizon;

import org.flywaydb.core.Flyway;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public abstract class DatabaseIntegrationTest {

    static final PostgreSQLContainer DB_CONTAINER =
            new PostgreSQLContainer<>("postgres:14")
                    .withDatabaseName("test-db")
                    .withUsername("test")
                    .withPassword("test");

    static {
        DB_CONTAINER.start();
        final Flyway flyway = Flyway.configure()
                .dataSource(
                        DB_CONTAINER.getJdbcUrl(),
                        DB_CONTAINER.getUsername(),
                        DB_CONTAINER.getPassword())
                .schemas("public")
                .load();
        flyway.clean();
        flyway.migrate();
    }

    @DynamicPropertySource
    static void registerDynamicProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", DB_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", DB_CONTAINER::getUsername);
        registry.add("spring.datasource.password", DB_CONTAINER::getPassword);
    }
}
