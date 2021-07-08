package io.trino.plugin.influxdb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestInfluxDBConnectorFactory
{
    private InfluxDBConnectorFactory sut;

    @BeforeMethod
    void setUp() {
        sut = new InfluxDBConnectorFactory();
    }


    @Test
    void should_return_influxdb_as_connector_factory_name() {
        final String expectedConnectorFactoryName = "influxdb";

        final String actualConnectorFactoryName = sut.getName();

        assertThat(actualConnectorFactoryName).isEqualTo(expectedConnectorFactoryName);
    }

}
