package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Document view
 */
@ApiModel(description = "Document")
public class DocumentView {
    @Size(max = 15)
    @NotEmpty(message = "code cannot be null")
    @ApiModelProperty(value = "Code", example = "126")
    public String code;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Name", example = "Иван")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "date cannot be null")
    @ApiModelProperty(value = "Date", example = "03.03.2019")
    public String date;

    @Override
    public String toString() {
        return "{code:" + code + ";name:" + name + ";date:" + date + "}";
    }
}
