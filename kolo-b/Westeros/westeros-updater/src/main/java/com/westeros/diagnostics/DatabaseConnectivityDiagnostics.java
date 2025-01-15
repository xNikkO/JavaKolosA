package com.westeros.diagnostics;

import com.westeros.data.repositories.ICatalogData;
import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.services.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseConnectivityDiagnostics implements IDiagnose
{
    private final ICatalogData catalog;

    @Override
    public String getName() {
        return "Database test";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public Diagnostics run() {
        try{
            catalog.getMovies().findBySourceId(1L).or(null);
        }
        catch (Exception ex){
            return Diagnostics.builder()
                    .name(getName())
                    .description(getDescription())
                    .isSuccess(false)
                    .errorMessage(ex.getMessage())
                    .build();
        }

        return Diagnostics.builder()
                .isSuccess(true)
                .name(getName())
                .description(getDescription())
                .build();
    }
}
