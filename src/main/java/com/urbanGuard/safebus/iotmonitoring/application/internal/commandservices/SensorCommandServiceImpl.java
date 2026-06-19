package com.urbanGuard.safebus.iotmonitoring.application.internal.commandservices;
import com.urbanGuard.safebus.iotmonitoring.application.commandservices.SensorCommandService;
import com.urbanGuard.safebus.iotmonitoring.domain.model.aggregates.Sensor;
import com.urbanGuard.safebus.iotmonitoring.domain.model.commands.RegisterSensorCommand;
import com.urbanGuard.safebus.iotmonitoring.domain.model.commands.UpdateSensorReadingCommand;
import com.urbanGuard.safebus.iotmonitoring.infrastructure.persistence.jpa.SensorRepository;
import com.urbanGuard.safebus.shared.application.result.Result;
import org.springframework.stereotype.Service;
@Service
public class SensorCommandServiceImpl implements SensorCommandService {
    private final SensorRepository repo;
    public SensorCommandServiceImpl(SensorRepository repo) { this.repo = repo; }
    @Override
    public Result<Sensor, String> handle(RegisterSensorCommand command) {
        if (repo.existsBySensorCode(command.sensorCode()))
            return Result.err("Sensor ya registrado: " + command.sensorCode());
        var sensor = new Sensor(command);
        repo.save(sensor);
        return Result.ok(sensor);
    }
    @Override
    public Result<Sensor, String> handle(UpdateSensorReadingCommand command) {
        var sensor = repo.findById(command.sensorId());
        if (sensor.isEmpty()) return Result.err("Sensor no encontrado: " + command.sensorId());
        sensor.get().updateReading(command.reading());
        repo.save(sensor.get());
        return Result.ok(sensor.get());
    }
}
