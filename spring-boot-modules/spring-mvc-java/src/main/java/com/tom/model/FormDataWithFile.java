package com.tom.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class FormDataWithFile {

    private String name;
    private String email;
    private MultipartFile file;
}
