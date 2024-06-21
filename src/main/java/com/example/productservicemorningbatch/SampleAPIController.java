package com.example.productservicemorningbatch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//This controller supports REST API's http requests
@RestController
//the request coming to endpoint "/hello" -- transfer them to this controller
//endpoint of all apis' are written in RequestMapping
@RequestMapping("/hello")
public class SampleAPIController
{
    // since we are printing something at the localhost -- it is a GetAPI
    //You will type the name and number after / in localhost ,
    // it will take those params and give you output
    //by executing the below loop
    @GetMapping("/{name}/{number}")
    public String SayHello(@PathVariable("name") String name, @PathVariable("number") int number){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1;i<=number;i++){
            stringBuilder.append("Hello" + name);
        }
        return stringBuilder.toString();
    }


}
