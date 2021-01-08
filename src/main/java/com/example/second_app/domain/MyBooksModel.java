package com.example.second_app.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class MyBooksModel {
    private Integer id;
    @NotBlank(message = "タイトルを入力ください")
    private String title;

    @NotBlank(message = "調子に乗らないでください")
    private String author;
}
