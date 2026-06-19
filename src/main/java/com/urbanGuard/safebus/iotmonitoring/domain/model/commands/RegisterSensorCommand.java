package com.urbanGuard.safebus.iotmonitoring.domain.model.commands;
public record RegisterSensorCommand(String sensorCode, String sensorType, Long busUnitId) {}
