package com.urbanGuard.safebus.iotmonitoring.infrastructure.persistence.jpa;
import com.urbanGuard.safebus.iotmonitoring.domain.model.aggregates.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    boolean existsBySensorCode(String sensorCode);
    List<Sensor> findByBusUnitId(Long busUnitId);
}
