package io.trino.plugin.influxdb;

import io.trino.spi.connector.ColumnMetadata;
import io.trino.spi.type.Type;

public class InfluxDBColumn extends ColumnMetadata
{
    public InfluxDBColumn(String name, Type type)
    {
        super(name, type);
    }
}
