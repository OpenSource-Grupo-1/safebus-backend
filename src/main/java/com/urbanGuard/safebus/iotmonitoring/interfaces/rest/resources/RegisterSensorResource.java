package com.urbanGuard.safebus.iotmonitoring.interfaces.rest.resources;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record RegisterSensorResource(@NotBlank String sensorCode, @NotBlank String sensorType, @NotNull Long busUnitId) {}
