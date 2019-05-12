package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Office view
 */
public class OfficeView {
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "126")
    public String code;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String name;

    @Override
    public String toString() {
        return "{id:" + id + ";code:" + code + ";name:" + name + "}";
    }
}
