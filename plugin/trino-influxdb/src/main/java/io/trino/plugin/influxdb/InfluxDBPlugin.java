package io.trino.plugin.influxdb;

import com.google.common.collect.ImmutableList;
import io.trino.spi.Plugin;
import io.trino.spi.connector.ConnectorFactory;

public class InfluxDBPlugin
        implements Plugin
{

    @Override
    public Iterable<ConnectorFactory> getConnectorFactories()
    {
        return ImmutableList.of(new InfluxDBConnectorFactory());
    }
}
