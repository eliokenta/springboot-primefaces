package com.template.springintegration.controllers.cadastro;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.template.springintegration.entity.UserInfo;
import com.template.springintegration.service.UserService;

@ViewScoped
@ManagedBean("registration")
public class CadastroBean extends SpringBeanAutowiringSupport implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CadastroBean.class);

    @Autowired
    private UserService userService;

    private String firstName;
    private String lastName;
    private String operationMessage;

    public void createNewUser() {
        try {
            LOGGER.info("Creating new user");
            FacesContext context = FacesContext.getCurrentInstance();

            UserInfo user = new UserInfo();
            user.setFirstName(firstName);
            user.setLastName(lastName);

            user = userService.createUser(user);
            context.isValidationFailed();
            if (user != null) {
                operationMessage = "User " + firstName + " " + lastName + " created";
            }
        } catch (Exception ex) {
            LOGGER.error("Error registering new user ");
            ex.printStackTrace();
            operationMessage = "Error User " + firstName + " " + lastName + " not created";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

}
