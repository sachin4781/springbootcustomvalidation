package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue

    private int empid;

    @Size(min = 5, message = "Employee First Name Should be at least 5 Character..")
    private String empfirstname;

    @Pattern(regexp = "[A-Za-z]*", message = "Employee Last Name Should Not Contain Space and special Character..")
    private String emplastname;

    private String empaddress;

    private double empsalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    @Column(unique = true)
    private long empcontactnumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empdob;

    @Email(message = "Email Id Must Be Valid..")
    @Column(unique = true)
    private String empemailid;

    @Size(min = 4, message = "Password Should be At Least 4 Character..")
    private String emppassword;


}
