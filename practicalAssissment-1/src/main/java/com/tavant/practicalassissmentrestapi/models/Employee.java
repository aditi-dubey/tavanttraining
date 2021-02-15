package com.tavant.practicalassissmentrestapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="employee")
public class Employee {
      @Id
      public Long employeeId;
      public String firstName;
      public String lastName;
      public String extension;
      public String email;
      public Integer officeCode;
      public String jobTitle;
}
