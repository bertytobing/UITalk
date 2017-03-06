package com.student.configs;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FlywayConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayConfiguration.class);

    @Bean
    @Profile(value = { "development", "test" })
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        FlywayMigrationStrategy strategy = new FlywayMigrationStrategy() {
            @Override
            public void migrate(Flyway flyway) {
                LOGGER.debug("Flyway Profile : Development / Test");
                flyway.clean();
                setPlaceholder(flyway);
                flyway.migrate();
            }
        };
        return strategy;
    }

    @Bean
    @Profile(value = { "repair" })
    public FlywayMigrationStrategy repairStrategy() {
        FlywayMigrationStrategy strategy = new FlywayMigrationStrategy() {
            @Override
            public void migrate(Flyway flyway) {
                LOGGER.debug("Flyway Profile : Repair");
                flyway.repair();
                setPlaceholder(flyway);
                flyway.migrate();
            }
        };
        return strategy;
    }

    private void setPlaceholder(Flyway flyway) {
        flyway.setPlaceholderPrefix("$&#");
        flyway.setPlaceholderSuffix("#&");
    }
}
