package com.urbanGuard.safebus.iotmonitoring.interfaces.rest.resources;
public record SensorResource(Long id, String sensorCode, String sensorType, Long busUnitId, String status, String lastReading) {}
