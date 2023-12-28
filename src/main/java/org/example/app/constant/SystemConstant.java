package org.example.app.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum SystemConstant {
    ;

    private String logLevel;
    private String logFrom;;
    SystemConstant(String logLevel,String logFrom) {
    }

    LOG_INITIAL("[ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-d||hh:m:ss:SS")

    public String getLogFrom() {
        return logFrom;
    }) + " ] | level :: [ "+ logLevel +" ] | from :: [ "++" ] >>>");
}
