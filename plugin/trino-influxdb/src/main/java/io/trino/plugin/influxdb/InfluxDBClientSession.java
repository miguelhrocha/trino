package io.trino.plugin.influxdb;

import io.airlift.log.Logger;

public class InfluxDBClientSession
{
    private static final Logger log = Logger.get(InfluxDBClientSession.class);

    private final InfluxClient influxClient;

    public InfluxDBClientSession(final InfluxClient influxClient, final InfluxDBConfig config)
    {
        this.influxClient = influxClient;
    }
}
