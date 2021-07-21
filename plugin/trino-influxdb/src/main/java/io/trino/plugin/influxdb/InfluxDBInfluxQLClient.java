package io.trino.plugin.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;

public class InfluxDBInfluxQLClient
        implements InfluxClient
{
    private final InfluxDB client;

    public InfluxDBInfluxQLClient(final InfluxDB client) {
        this.client = client;
    }
}
