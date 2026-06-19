package com.urbanGuard.safebus.iotmonitoring.interfaces.rest.transform;
import com.urbanGuard.safebus.iotmonitoring.domain.model.commands.RegisterSensorCommand;
import com.urbanGuard.safebus.iotmonitoring.interfaces.rest.resources.RegisterSensorResource;
public class RegisterSensorCommandFromResourceAssembler {
    public static RegisterSensorCommand toCommandFromResource(RegisterSensorResource r) {
        return new RegisterSensorCommand(r.sensorCode(), r.sensorType(), r.busUnitId());
    }
}
