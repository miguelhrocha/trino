package io.trino.plugin.influxdb;

import com.influxdb.client.InfluxDBClient;

public class InfluxDBFluxClient
{
    private final InfluxDBClient fluxClient;

    public InfluxDBFluxClient(InfluxDBClient fluxClient) {this.fluxClient = fluxClient;}
}
