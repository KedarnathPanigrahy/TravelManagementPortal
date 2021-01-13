package com.kd.microservices.tmp.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custId;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true, length = 25)
    private String userName;
    private String password;
    @Column(nullable = false, unique = true, length = 50)
    private String emailId;
    @Column(nullable = false, unique = true, length = 10)
    private String mobileNumber;
    private String address;
    private String pinCode;
    private Date createdDate = new Date();
    private Date updatedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (custId != null ? !custId.equals(customer.custId) : customer.custId != null) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (userName != null ? !userName.equals(customer.userName) : customer.userName != null) return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;
        if (emailId != null ? !emailId.equals(customer.emailId) : customer.emailId != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(customer.mobileNumber) : customer.mobileNumber != null)
            return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (pinCode != null ? !pinCode.equals(customer.pinCode) : customer.pinCode != null) return false;
        if (createdDate != null ? !createdDate.equals(customer.createdDate) : customer.createdDate != null)
            return false;
        return updatedDate != null ? updatedDate.equals(customer.updatedDate) : customer.updatedDate == null;
    }

    @Override
    public int hashCode() {
        int result = custId != null ? custId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (emailId != null ? emailId.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pinCode != null ? pinCode.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
