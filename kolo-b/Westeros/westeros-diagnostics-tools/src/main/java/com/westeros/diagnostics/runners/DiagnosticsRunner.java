package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DiagnosticsRunner implements IRunDiagnoses {

    private final List<IDiagnose> diagnoses;

    @Override
    public List<Diagnostics> runAll() {
        return diagnoses.stream().map(IDiagnose::run).toList();
    }
}
