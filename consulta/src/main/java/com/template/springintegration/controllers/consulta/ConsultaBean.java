package com.template.springintegration.controllers.consulta;

import java.io.Serializable;
import java.util.List;

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
@ManagedBean("consulta")
public class ConsultaBean extends SpringBeanAutowiringSupport implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaBean.class);

    @Autowired
    private UserService userService;

    private List<UserInfo> userList;

    public void loadUsers() {
        try {
            LOGGER.info("Listing users");
            FacesContext context = FacesContext.getCurrentInstance();

            userList = userService.listUsers();
        } catch (Exception ex) {
            LOGGER.error("Error registering new user ");
            ex.printStackTrace();
        }
    }

    public List<UserInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }
}
