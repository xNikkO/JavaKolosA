package com.westeros.diagnostics.controllers;

import com.westeros.diagnostics.runners.IRunDiagnoses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("diagnostics")
public class DiagnosticsController {

    private final IRunDiagnoses runDiagnoses;

    @GetMapping
    public ResponseEntity<String> checkStatus(){
        return ResponseEntity.ok("ALIVE");
    }

    @GetMapping("check")
    public ResponseEntity check(){
        return ResponseEntity.ok(runDiagnoses.runAll());
    }
}
