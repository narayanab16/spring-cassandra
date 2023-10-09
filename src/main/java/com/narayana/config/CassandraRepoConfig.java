package com.narayana.config;


import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories(basePackages = "com.narayana.repo")
public class CassandraRepoConfig {
}
