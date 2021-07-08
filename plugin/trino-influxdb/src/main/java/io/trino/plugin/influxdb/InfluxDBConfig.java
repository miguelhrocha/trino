package io.trino.plugin.influxdb;

import io.airlift.configuration.Config;

import javax.validation.constraints.NotNull;

public class InfluxDBConfig
{
    private String host;
    private int port = 8086;
    private String database;
    private String username;
    private String password;
    private boolean httpsEnabled;
    private int connectionTimeout = 10;
    private int writeTimeout = 10;
    private int readTimeout = 10;


    @NotNull
    public String getHost()
    {
        return host;
    }

    @Config("influxdb.host")
    public void setHost(String host)
    {
        this.host = host;
    }

    public int getPort()
    {
        return port;
    }

    @Config("influxdb.port")
    public void setPort(int port)
    {
        this.port = port;
    }

    public String getDatabase()
    {
        return database;
    }

    @Config("influxdb.database")
    public void setDatabase(String database)
    {
        this.database = database;
    }

    public String getUsername()
    {
        return username;
    }

    @Config("influxdb.username")
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    @Config("influxdb.password")
    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isHttpsEnabled()
    {
        return httpsEnabled;
    }

    @Config("influxdb.https.enabled")
    public void setHttpsEnabled(boolean httpsEnabled)
    {
        this.httpsEnabled = httpsEnabled;
    }

    public int getConnectionTimeout()
    {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout)
    {
        this.connectionTimeout = connectionTimeout;
    }

    public int getWriteTimeout()
    {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout)
    {
        this.writeTimeout = writeTimeout;
    }

    public int getReadTimeout()
    {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
    }
}
