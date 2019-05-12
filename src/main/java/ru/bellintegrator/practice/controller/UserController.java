package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.user.UserServiceImpl;

/**
 * User controller
 * This  rest controller is responsible for findAllByOrgNameAndInnAndIsActive the methods for the model: "User"
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    /*todo
    api/user/list
In (фильтр):
{
  “officeId”:””, //обязательный параметр
  “firstName”:””,
  “lastName”:””,
  “middleName”:””,
  “position”,””,
  “docCode”:””,
  “citizenshipCode”:””
}
Out:
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
}

10. api/user/{id}
method:GET
Out:
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipName”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true”
}

11. api/user/update
In:
{
  “id”:””, //обязательный параметр
  “officeId”:””,
  “firstName”:””, //обязательный параметр
  “secondName”:””,
  “middleName”:””,
  “position”:”” //обязательный параметр
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true” //пример
}

Out:
{
    “result”:”success”
}

12. api/user/save
In:
{
  “officeId”:””, //обязательный параметр
  “firstName”:””, //обязательный параметр
  “secondName”:””,
  “middleName”:””,
  “position”:”” //обязательный параметр
  “phone”,””,
  “docCode”:””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true” //пример
}
     */




//    /**
//     * This method returns findAllByOrgNameAndInnAndIsActive users
//     */
//    @GetMapping(value = "/user")
//    @ApiOperation(value = "Get user")
//    public ResponseEntity getUser() {
//        return ResponseEntity.ok(userService.getUser());
//    }

}
