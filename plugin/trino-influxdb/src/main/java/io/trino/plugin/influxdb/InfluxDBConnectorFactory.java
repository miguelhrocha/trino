package io.trino.plugin.influxdb;

import com.google.inject.Injector;
import io.airlift.bootstrap.Bootstrap;
import io.airlift.json.JsonModule;
import io.trino.plugin.base.TypeDeserializerModule;
import io.trino.spi.connector.Connector;
import io.trino.spi.connector.ConnectorContext;
import io.trino.spi.connector.ConnectorFactory;
import io.trino.spi.connector.ConnectorHandleResolver;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public class InfluxDBConnectorFactory
        implements ConnectorFactory
{
    @Override
    public String getName()
    {
        return "influxdb";
    }

    @Override
    public ConnectorHandleResolver getHandleResolver()
    {
        return new InfluxDBHandleResolver();
    }

    @Override
    public Connector create(String catalogName, Map<String, String> config, ConnectorContext context)
    {
        requireNonNull(config, "config is null");
        Bootstrap app = new Bootstrap(new JsonModule(), new TypeDeserializerModule(context.getTypeManager()), new InfluxDBModule());

        Injector injector = app.strictConfig()
                .doNotInitializeLogging()
                .setRequiredConfigurationProperties(config)
                .initialize();

        return injector.getInstance(InfluxDBConnector.class);
    }
}
