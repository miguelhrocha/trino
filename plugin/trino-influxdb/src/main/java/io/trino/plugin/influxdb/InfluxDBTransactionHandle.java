package io.trino.plugin.influxdb;

import io.trino.spi.connector.ConnectorTransactionHandle;

public enum InfluxDBTransactionHandle
        implements ConnectorTransactionHandle
{
    INSTANCE
}
