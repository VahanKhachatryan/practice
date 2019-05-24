package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Office view
 */
public class OfficeView {
    @NotEmpty
    @ApiModelProperty(value = "Id", hidden = true, example = "1")
    public int id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Name", example = "Aleksandr")
    public String name;

    @Size(max = 90)
    @NotEmpty(message = "address cannot be null")
    @ApiModelProperty(value = "Address", example = "Str 1")
    public String address;

    @Size(max = 20)
    @NotEmpty(message = "phone cannot be null")
    @ApiModelProperty(value = "Phone", example = "89854478954")
    public String phone;

    @NotEmpty(message = "isActive cannot be null")
    @ApiModelProperty(value = "IsActive", example = "true")
    public Boolean isActive;

    @NotEmpty(message = "office cannot be null")
    @ApiModelProperty(value = "organizations", example = "IBM")
    public Set<Organization> organizations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address:" + address +";phone:" + phone +";isActive:" + isActive + "}";
    }
}
