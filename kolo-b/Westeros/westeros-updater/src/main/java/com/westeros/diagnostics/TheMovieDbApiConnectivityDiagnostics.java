package com.westeros.diagnostics;


import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.services.contract.Diagnostics;
import com.westeros.moviesclient.IMoviesClient;
import com.westeros.moviesclient.IMoviesDictionariesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TheMovieDbApiConnectivityDiagnostics implements IDiagnose
{

    private final IMoviesDictionariesClient moviesClient;

    @Override
    public String getName() {
        return "TheMovieDb test";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public Diagnostics run() {

        try{
            if(moviesClient.getCountries().isEmpty())
                return Diagnostics.builder()
                        .name(getName())
                        .description(getDescription())
                        .isSuccess(false)
                        .errorMessage("No data received")
                        .build();
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
                .description(getDescription())
                .name(getName())
                .isSuccess(true)
                .build();
    }
}
