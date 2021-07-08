package io.trino.plugin.influxdb;

import io.airlift.bootstrap.LifeCycleManager;
import io.airlift.bootstrap.LifeCycleStopException;
import io.airlift.log.Logger;
import io.trino.spi.connector.Connector;
import io.trino.spi.connector.ConnectorMetadata;
import io.trino.spi.connector.ConnectorRecordSetProvider;
import io.trino.spi.connector.ConnectorSplitManager;
import io.trino.spi.connector.ConnectorTransactionHandle;
import io.trino.spi.transaction.IsolationLevel;

import javax.inject.Inject;

import static io.trino.plugin.influxdb.InfluxDBTransactionHandle.INSTANCE;
import static java.lang.String.format;

public class InfluxDBConnector
        implements Connector
{
    private static final Logger log = Logger.get(InfluxDBConnector.class);

    private final LifeCycleManager lifeCycleManager;
    private final InfluxDBMetadata influxDBMetadata;
    private final InfluxDBSplitManager influxDBSplitManager;
    private final InfluxDBRecordSetProvider influxDBRecordSetProvider;

    @Inject
    public InfluxDBConnector(
            final LifeCycleManager lifeCycleManager,
            final InfluxDBMetadata influxDBMetadata,
            final InfluxDBSplitManager influxDBSplitManager,
            final InfluxDBRecordSetProvider influxDBRecordSetProvider)
    {
        this.lifeCycleManager = lifeCycleManager;
        this.influxDBMetadata = influxDBMetadata;
        this.influxDBSplitManager = influxDBSplitManager;
        this.influxDBRecordSetProvider = influxDBRecordSetProvider;
    }

    @Override
    public ConnectorTransactionHandle beginTransaction(IsolationLevel isolationLevel, boolean readOnly)
    {
        return INSTANCE;
    }

    @Override
    public ConnectorMetadata getMetadata(ConnectorTransactionHandle transactionHandle)
    {
        return influxDBMetadata;
    }

    @Override
    public ConnectorSplitManager getSplitManager()
    {
        return influxDBSplitManager;
    }

    @Override
    public ConnectorRecordSetProvider getRecordSetProvider()
    {
        return influxDBRecordSetProvider;
    }

    @Override
    public void shutdown()
    {
        try {
            lifeCycleManager.stop();
        }
        catch (final LifeCycleStopException lifeCycleStopException) {
            log.error(format("Error shutting down connector %s", lifeCycleStopException));
        }
    }
}
