package com.narayana.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.io.IOException;
import java.net.InetSocketAddress;

@Configuration
@EntityScan(basePackages = "com.narayana.model")
public class CassandraAppConfig {
    private static final String CAS_DB_LOCALHOST = "localhost";
    private static final Integer CAS_DB_PORT = 9042;
    private static final String CAS_KEYSPACE = "my_ks";
    private static final String CAS_DC_Name= "datacenter1";


    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder()
                .withApplicationName("narayana-cas-application")
                .addContactPoint(new InetSocketAddress(CAS_DB_LOCALHOST, CAS_DB_PORT))
                .withLocalDatacenter(CAS_DC_Name)
                .withKeyspace(CAS_KEYSPACE)
                .build();
        //return CqlSession.builder().build();
    }
    @Bean
    public CassandraOperations cassandraTemplate() throws IOException {
        CassandraOperations cassandraTemplate = new CassandraTemplate(cqlSession());
        return cassandraTemplate;
    }
}
