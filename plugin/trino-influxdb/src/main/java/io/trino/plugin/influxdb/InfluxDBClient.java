package io.trino.plugin.influxdb;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.airlift.log.Logger;
import io.trino.spi.connector.SchemaTableName;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;

import javax.inject.Inject;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class InfluxDBClient
{
    private static final Logger log = Logger.get(InfluxDBClient.class);

    private final OkHttpClient okHttpClient;
    private final LoadingCache<SchemaTableName, InfluxDBTable> tableCache;

    @Inject
    public InfluxDBClient(final InfluxDBConfig config)
    {
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(config.getConnectionTimeout()))
                .writeTimeout(Duration.ofSeconds(config.getWriteTimeout()))
                .readTimeout(Duration.ofSeconds(config.getReadTimeout()))
                .authenticator(((route, response) -> response.request()
                        .newBuilder()
                        .header("Authorization", Credentials.basic(config.getUsername(), config.getPassword()))
                        .build()))
                .build();

        this.tableCache = CacheBuilder.newBuilder()
                .expireAfterWrite(Duration.ofHours(1))
                .refreshAfterWrite(Duration.ofMinutes(1))
                .build(CacheLoader.from(this::loadTableSchema));
    }

    private InfluxDBTable loadTableSchema(final SchemaTableName schemaTableName)
    {
        return null;
    }

    public Set<String> getSchemaNames()
    {
        return Collections.emptySet();
    }

    public Set<String> getTableNames()
    {
        return Collections.emptySet();
    }

}
