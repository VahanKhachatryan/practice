package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Country;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * User view
 */
public class UserView {
    @NotEmpty
    @ApiModelProperty(value = "Id", hidden = true, example = "1")
    public int id;

    @NotEmpty(message = "country cannot be null")
    @ApiModelProperty(value = "Country", example = "Russia")
    public Country country;

    @NotEmpty(message = "document cannot be null")
    @ApiModelProperty(value = "document", example = "birth certificate")
    public Document document;

    @NotEmpty(message = "office cannot be null")
    @ApiModelProperty(value = "office", example = "Oracle")
    public Office office;

    @NotEmpty(message = "firstName cannot be null")
    @ApiModelProperty(value = "firstName", example = "Aleksandr")
    public String firstName;

    @NotEmpty(message = "middleName cannot be null")
    @ApiModelProperty(value = "middleName", example = "Aleksandrov")
    public String middleName;

    @NotEmpty(message = "secondName cannot be null")
    @ApiModelProperty(value = "secondName", example = "Aleksandrovich")
    public String secondName;

    @NotEmpty(message = "position cannot be null")
    @ApiModelProperty(value = "position", example = "Java developer")
    public String position;

    @Size(max = 20)
    @NotEmpty(message = "phone cannot be null")
    @ApiModelProperty(value = "phone", example = "89857768543")
    public String phone;

    @NotEmpty(message = "isIdentified cannot be null")
    @ApiModelProperty(value = "isIdentified", example = "true")
    public Boolean isIdentified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";country:" + country + ";document:" + document + ";office:" + office + ";firstName:"
                + firstName + ";middleName:" + middleName + ";secondName:" + secondName + ";position:" + position +
                ";phone:" + phone + ";isIdentified:" + isIdentified + "}";
    }
}
