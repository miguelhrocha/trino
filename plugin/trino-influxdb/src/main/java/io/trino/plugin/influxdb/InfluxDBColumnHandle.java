package io.trino.plugin.influxdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.trino.spi.connector.ColumnHandle;
import io.trino.spi.type.Type;

public class InfluxDBColumnHandle
        implements ColumnHandle
{

    private final String columnName;
    private final Type columnType;
    private final InfluxDBType influxDBType;
    private final String retentionPolicy;
    private final String measurement;

    @JsonCreator
    public InfluxDBColumnHandle(
            @JsonProperty("columnName") final String columnName,
            @JsonProperty("columnType") final Type columnType,
            @JsonProperty("influxDBType") final InfluxDBType influxDBType,
            @JsonProperty("retentionPolicy") final String retentionPolicy,
            @JsonProperty("measurement") final String measurement)
    {
        this.columnName = columnName;
        this.columnType = columnType;
        this.influxDBType = influxDBType;
        this.retentionPolicy = retentionPolicy;
        this.measurement = measurement;
    }
}
