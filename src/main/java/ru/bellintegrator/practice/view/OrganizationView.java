package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Organization view
 */
@ApiModel(description = "Organization")
public class OrganizationView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "name", example = "Jon")
    public String name;
    @Size(max = 80)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "FullName", example = "Jonathan")
    public String fullName;
    @Size(max = 30)
    @NotEmpty(message = "inn cannot be null")
    @ApiModelProperty(value = "Inn", example = "35688")
    public String inn;
    @Size(max = 30)
    @NotEmpty(message = "kpp cannot be null")
    @ApiModelProperty(value = "Kpp", example = "2544")
    public String kpp;
    @Size(max = 90)
    @NotEmpty(message = "address cannot be null")
    @ApiModelProperty(value = "address", example = "Wall street")
    public String address;
    @Size(max = 20)
    @NotEmpty(message = "phone cannot be null")
    @ApiModelProperty(value = "phone", example = "89554872456")
    public String phone;

    public Boolean isActive;
    @NotEmpty(message = "office cannot be null")
    @ApiModelProperty(value = "office", example = "IBM office")
    public Set<Office> offices;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";fullName:" + fullName + ";inn:" + inn + ";kpp:" + kpp + ";address:" + address + ";phone:" + phone + ";isActive:" + isActive + ";offices:" + offices + "}";
    }

//    public String getList() {
//        return "{id:" + id + ";name:" + name + ";isActive:" + isActive +"}";
//    }
}
