/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upes.tickets.login;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alicia
 */
@WebServlet("/ServletInicioSesion")
public class InicioSesion extends HttpServlet {
/*
    Vector<Usuario> usuarios = null;
    Vector<Producto> productos = null;
    
    @Override
    public void init() {
       this.inicializarUsuarios();
       this.inicializarProductos();
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.init();
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        String direccion = "error.html";
        HttpSession sesion = request.getSession();
        String user = "vama", pass = "vama";
        if(sesion.isNew()){
            sesion = request.getSession(true);
            sesion.setAttribute("usuarioInicio", usuario);
        }else{
            
        }
        
        for (int i = 0; i < 1; i++){
            if((user.compareTo(usuario)) == 0 && (pass.compareTo(clave)) == 0){
                sesion.setAttribute("usuarioInicio", usuario);
                   direccion = "pages/listaTickets.xhtml";
                }else{
                   direccion = "login/index.xhtml"; 
                }
            break;            
        }       
        response.sendRedirect(direccion);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
/*
    public void inicializarUsuarios(){
        this.usuarios = new Vector<Usuario>();
        Usuario user1 = new Usuario(1, "Henry", "Wong", "hwong", "1234", "cliente");
        Usuario user2 = new Usuario(2, "Carmen", "Chavez", "cchavez", "1234", "empleado");
        this.usuarios.add(user1);
        this.usuarios.add(user2);
    }
    
    public void inicializarProductos(){
        this.productos = new Vector<Producto>();
        Producto prod1 = new Producto(1, "Televisor Samsung", 10, 12.50f);
        Producto prod2 = new Producto(2, "Usb kingston de 2Gb", 20, 40f);
        Producto prod3 = new Producto(3, "Laptop HP DV7000", 15, 7899.99f);
        this.productos.add(prod1);
        this.productos.add(prod2);
        this.productos.add(prod3);
    }*/
}
