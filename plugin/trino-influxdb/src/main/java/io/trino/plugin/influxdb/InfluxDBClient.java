package io.trino.plugin.influxdb;

import io.airlift.log.Logger;
import okhttp3.OkHttpClient;

public class InfluxDBClient
{
    private static final Logger log = Logger.get(InfluxDBClient.class);

    private final OkHttpClient okHttpClient;

    public InfluxDBClient(final InfluxDBConfig config)
    {
        this.okHttpClient = new OkHttpClient.Builder().build();
    }
}
