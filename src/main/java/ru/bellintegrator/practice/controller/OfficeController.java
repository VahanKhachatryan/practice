package ru.bellintegrator.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Office controller
 * This  rest controller is responsible for findAllByOrgNameAndInnAndIsActive the methods for the model: "Office"
 */
@RestController
@RequestMapping(value = "/api")
public class OfficeController {
/*todo
5. api/office/list
In (фильтр):
{
  “orgId”:””, //обязательный параметр
  “name”:””,
  “phone”:””,
  “isActive”
}

Out:
[
  {
    “id”:””,
    “name”:””,
    “isActive”:”true”
  },
  ...
]

6. api/office/{id}
method:GET
Out:
{
  “id”:””,
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}
7. api/office/update
In:
{
  “id”:””, //обязательный параметр
  “name”:””, //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”true” //пример
}

Out:
{
    “result”:”success”
}

8. api/office/save
In:
{
  “orgId”:””, //обязательный параметр
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:”true”
}

Out:
{
    “result”:”success”
}

 */



//
//    private OfficeService officeService = new OfficeService();
//
//    /**
//     * This method returns findAllByOrgNameAndInnAndIsActive offices
//     */
//    @GetMapping(value = "/office")
//    @ApiOperation(value = "Get office")
//    public ResponseEntity getOffice() {
//        return ResponseEntity.ok(officeService.getOffice());
//    }


}
