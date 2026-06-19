package com.urbanGuard.safebus.iotmonitoring.domain.model.commands;
public record UpdateSensorReadingCommand(Long sensorId, String reading) {}
