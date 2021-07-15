package io.trino.plugin.influxdb;

import com.google.common.collect.ImmutableList;
import io.trino.spi.connector.ConnectorMetadata;
import io.trino.spi.connector.ConnectorSession;

import java.util.List;

public class InfluxDBMetadata implements ConnectorMetadata
{

    private final InfluxDBClient influxDBClient;

    public InfluxDBMetadata(final InfluxDBClient influxDBClient) {
        this.influxDBClient = influxDBClient;
    }

    @Override
    public List<String> listSchemaNames(ConnectorSession session)
    {
        return ImmutableList.copyOf(influxDBClient.getSchemaNames());
    }
}
