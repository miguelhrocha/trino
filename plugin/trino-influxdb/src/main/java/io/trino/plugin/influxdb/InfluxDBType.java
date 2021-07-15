package io.trino.plugin.influxdb;

import io.trino.spi.type.BigintType;
import io.trino.spi.type.BooleanType;
import io.trino.spi.type.DoubleType;
import io.trino.spi.type.TimestampWithTimeZoneType;
import io.trino.spi.type.Type;
import io.trino.spi.type.VarcharType;

import static java.util.Objects.requireNonNull;

public enum InfluxDBType
{
    STRING(VarcharType.VARCHAR),
    BOOLEAN(BooleanType.BOOLEAN),
    INTEGER(BigintType.BIGINT),
    FLOAT(DoubleType.DOUBLE),
    TIME(TimestampWithTimeZoneType.TIMESTAMP_TZ_MILLIS),
    ;

    private final Type trinoType;

    InfluxDBType(final Type trinoType) {
        this.trinoType = requireNonNull(trinoType, "trinoType is null");
    }

    public Type getTrinoType()
    {
        return trinoType;
    }


}
