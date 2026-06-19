package com.urbanGuard.safebus.iotmonitoring.application.queryservices;
import com.urbanGuard.safebus.iotmonitoring.domain.model.aggregates.Sensor;
import com.urbanGuard.safebus.iotmonitoring.domain.model.queries.GetAllSensorsQuery;
import com.urbanGuard.safebus.iotmonitoring.domain.model.queries.GetSensorByIdQuery;
import com.urbanGuard.safebus.iotmonitoring.domain.model.queries.GetSensorsByBusUnitQuery;
import java.util.List;
import java.util.Optional;
public interface SensorQueryService {
    Optional<Sensor> handle(GetSensorByIdQuery query);
    List<Sensor> handle(GetAllSensorsQuery query);
    List<Sensor> handle(GetSensorsByBusUnitQuery query);
}
