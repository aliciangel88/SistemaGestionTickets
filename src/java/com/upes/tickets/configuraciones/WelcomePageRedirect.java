/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upes.tickets.configuraciones;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alicia
 */
@ManagedBean(name = "WelcomePageRedirect")
@SessionScoped
public class WelcomePageRedirect {
    
    public void methodInManagedBean() throws IOException {
         System.out.println("vama");
    }
}
