package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;

import java.util.List;

public interface IRunDiagnoses {
    List<Diagnostics> runAll();
}
