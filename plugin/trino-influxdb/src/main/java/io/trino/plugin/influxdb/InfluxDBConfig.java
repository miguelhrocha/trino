package io.trino.plugin.influxdb;

import io.airlift.configuration.Config;
import io.airlift.configuration.ConfigSecuritySensitive;

import javax.validation.constraints.NotNull;

import java.time.Duration;

public class InfluxDBConfig
{
    private String host;
    private int port = 8086;
    private Duration metadataCacheTtl = Duration.ofMillis(1000);
    private String database;
    private String username;
    private String password;
    private boolean sslEnabled;
    private int connectionTimeout = 10;
    private int writeTimeout = 10;
    private int readTimeout = 10;

    @NotNull
    public String getHost()
    {
        return host;
    }

    @Config("influxdb.host")
    public InfluxDBConfig setHost(String host)
    {
        this.host = host;
        return this;
    }

    public int getPort()
    {
        return port;
    }

    @Config("influxdb.port")
    public InfluxDBConfig setPort(int port)
    {
        this.port = port;
        return this;
    }

    public Duration getMetadataCacheTtl()
    {
        return metadataCacheTtl;
    }

    @Config("influxdb.metadata-cache-ttl")
    public InfluxDBConfig setMetadataCacheTtl(final Duration metadataCacheTtl)
    {
        this.metadataCacheTtl = metadataCacheTtl;
        return this;
    }

    public String getDatabase()
    {
        return database;
    }

    @Config("influxdb.database")
    public InfluxDBConfig setDatabase(String database)
    {
        this.database = database;
        return this;
    }

    public String getUsername()
    {
        return username;
    }

    @Config("influxdb.username")
    public InfluxDBConfig setUsername(String username)
    {
        this.username = username;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    @ConfigSecuritySensitive
    @Config("influxdb.password")
    public InfluxDBConfig setPassword(String password)
    {
        this.password = password;
        return this;
    }

    public boolean isSslEnabled()
    {
        return sslEnabled;
    }

    @Config("influxdb.ssl.enabled")
    public InfluxDBConfig setSslEnabled(boolean sslEnabled)
    {
        this.sslEnabled = sslEnabled;
        return this;
    }

    public int getConnectionTimeout()
    {
        return connectionTimeout;
    }

    @Config("influxdb.connection-timeout")
    public InfluxDBConfig setConnectionTimeout(int connectionTimeout)
    {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public int getWriteTimeout()
    {
        return writeTimeout;
    }

    @Config("influxdb.write-timeout")
    public InfluxDBConfig setWriteTimeout(int writeTimeout)
    {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public int getReadTimeout()
    {
        return readTimeout;
    }

    @Config("influxdb-read-timeout")
    public InfluxDBConfig setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
        return this;
    }
}
