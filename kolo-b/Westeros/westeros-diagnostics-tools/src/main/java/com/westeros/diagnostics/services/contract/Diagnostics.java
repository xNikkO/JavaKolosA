package com.westeros.diagnostics.services.contract;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
//@Accessors(chain = true, fluent = true)
public class Diagnostics {
    private boolean isSuccess;
    private String name;
    private String errorMessage;
    private String description;

    private void dosomething(){
//        var tmp = new Diagnostics()
//                .name("name")
//                .isSuccess(true);

//        var tmp = Diagnostics.builder()
//                .name("")
//                .isSuccess(true)
//                .build();
    }

}
