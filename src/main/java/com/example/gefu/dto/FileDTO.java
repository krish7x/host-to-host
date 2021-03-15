package com.example.gefu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FileDTO implements Serializable {

    private static final long serialVersionUID = -5743894718565999220L;

    private Long id;
    private String fileName;
    private Character isValid;
    private String isGefuDone;
    private String gefuFile;
}
