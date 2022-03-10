package com.openclassrooms.webapp.repository;

import com.openclassrooms.webapp.CustomProperties;
import com.openclassrooms.webapp.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class EmployeeProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all employes
     * @return An iterable of all employees
     */
   
     public Iterable <Employee> getEmployees(){
         
        String baseApiUrl = props.getApiUrl();
        System.out.println(baseApiUrl);
        String getEmployeesUrl = baseApiUrl + "/employees";


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Iterable<Employee>> response = restTemplate.exchange(getEmployeesUrl, HttpMethod.GET, null, new ParameterizedTypeReference() {});
        
        //log.debug("Get Employees call" + response.getStatusCode().toString());
        return response.getBody();
        
     }

}