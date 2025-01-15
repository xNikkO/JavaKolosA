package com.westeros.diagnostics.services.contract;

import lombok.Data;

import java.util.List;

@Data
public class DiagnosticsResultsDto {
    private String serviceName;
    private boolean isAlive;
    private List<Diagnostics> results;
}
