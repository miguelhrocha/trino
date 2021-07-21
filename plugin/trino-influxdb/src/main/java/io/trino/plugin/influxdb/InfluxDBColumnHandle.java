package io.trino.plugin.influxdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.trino.spi.connector.ColumnHandle;
import io.trino.spi.type.Type;

import java.util.Objects;
import java.util.StringJoiner;

public class InfluxDBColumnHandle
        implements ColumnHandle
{

    private final String name;
    private final Type columnType;
    private final InfluxDBType influxDBType;
    private final String retentionPolicy;
    private final String measurement;
    private final boolean hidden;

    @JsonCreator
    public InfluxDBColumnHandle(
            @JsonProperty("columnName") final String name,
            @JsonProperty("columnType") final Type columnType,
            @JsonProperty("influxDBType") final InfluxDBType influxDBType,
            @JsonProperty("retentionPolicy") final String retentionPolicy,
            @JsonProperty("measurement") final String measurement,
            @JsonProperty("hidden") final boolean hidden)
    {
        this.name = name;
        this.columnType = columnType;
        this.influxDBType = influxDBType;
        this.retentionPolicy = retentionPolicy;
        this.measurement = measurement;
        this.hidden = hidden;
    }

    @JsonProperty
    public String getName()
    {
        return name;
    }

    @JsonProperty
    public Type getColumnType()
    {
        return columnType;
    }

    @JsonProperty
    public InfluxDBType getInfluxDBType()
    {
        return influxDBType;
    }

    @JsonProperty
    public String getRetentionPolicy()
    {
        return retentionPolicy;
    }

    @JsonProperty
    public String getMeasurement()
    {
        return measurement;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InfluxDBColumnHandle that = (InfluxDBColumnHandle) o;
        return Objects.equals(name, that.name) && Objects.equals(columnType, that.columnType) && influxDBType == that.influxDBType && Objects.equals(retentionPolicy, that.retentionPolicy) && Objects.equals(measurement, that.measurement);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, columnType, influxDBType, retentionPolicy, measurement);
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", InfluxDBColumnHandle.class.getSimpleName() + "[", "]")
                .add("columnName='" + name + "'")
                .add("columnType=" + columnType)
                .add("influxDBType=" + influxDBType)
                .add("retentionPolicy='" + retentionPolicy + "'")
                .add("measurement='" + measurement + "'")
                .toString();
    }
}
