package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;

public interface IDiagnose {
    String getName();
    String getDescription();
    Diagnostics run();
}
