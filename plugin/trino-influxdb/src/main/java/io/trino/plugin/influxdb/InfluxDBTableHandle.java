package io.trino.plugin.influxdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.trino.spi.connector.ConnectorTableHandle;

import static java.util.Objects.requireNonNull;

public final class InfluxDBTableHandle
        implements ConnectorTableHandle
{

    private final String retentionPolicy;

    private final String measurement;

    @JsonCreator
    public InfluxDBTableHandle(
            @JsonProperty("retentionPolicy") final String retentionPolicy,
            @JsonProperty("measurement") final String measurement
    ) {
        this.retentionPolicy = retentionPolicy;
        this.measurement = requireNonNull(measurement, "measurement is null");
    }


}
