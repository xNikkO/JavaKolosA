package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DiskSpaceDiagnostics implements IDiagnose {

    @Override
    public String getName() {
        return "Dik space test";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Diagnostics run() {



        File disk = new File("C:\\");
        var resultBuilder = Diagnostics.builder()
                .name(getName())
                .description(getDescription());
        if (disk.exists() && disk.isDirectory()) {
            long totalSpace = disk.getTotalSpace();
            long freeSpace = disk.getFreeSpace();

            if (totalSpace > 0) {
                double freeSpacePercentage = ((double) freeSpace / totalSpace) * 100;
                if(freeSpacePercentage>5)
                    return resultBuilder
                            .isSuccess(true)
                            .build();
                else return resultBuilder.isSuccess(false)
                        .errorMessage("not enough disk space")
                        .build();
            }
        } else {
            return resultBuilder.isSuccess(false)
                    .errorMessage("not enough disk space")
                    .build();
        }
        return resultBuilder
                .isSuccess(false)
                .errorMessage("no c: disk drive")
                .build();
    }
}
