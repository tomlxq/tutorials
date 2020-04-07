package com.tom.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCell {
    private String content;
    private String textColor;
    private String bgColor;
    private String textSize;
    private String textWeight;


    public MyCell(String content) {
        this.content = content;
    }


}