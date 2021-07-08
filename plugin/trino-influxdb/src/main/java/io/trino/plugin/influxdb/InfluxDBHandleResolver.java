package io.trino.plugin.influxdb;

import io.trino.spi.connector.ColumnHandle;
import io.trino.spi.connector.ConnectorHandleResolver;
import io.trino.spi.connector.ConnectorSplit;
import io.trino.spi.connector.ConnectorTableHandle;
import io.trino.spi.connector.ConnectorTransactionHandle;

public class InfluxDBHandleResolver implements ConnectorHandleResolver
{
    @Override
    public Class<? extends ConnectorTableHandle> getTableHandleClass()
    {
        return ConnectorHandleResolver.super.getTableHandleClass();
    }

    @Override
    public Class<? extends ColumnHandle> getColumnHandleClass()
    {
        return ConnectorHandleResolver.super.getColumnHandleClass();
    }

    @Override
    public Class<? extends ConnectorSplit> getSplitClass()
    {
        return ConnectorHandleResolver.super.getSplitClass();
    }

    @Override
    public Class<? extends ConnectorTransactionHandle> getTransactionHandleClass()
    {
        return ConnectorHandleResolver.super.getTransactionHandleClass();
    }

}
