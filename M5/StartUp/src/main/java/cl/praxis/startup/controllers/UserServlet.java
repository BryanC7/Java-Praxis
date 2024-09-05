package cl.praxis.startup.controllers;

import cl.praxis.startup.model.AddressDTO;
import cl.praxis.startup.model.UserDTO;
import cl.praxis.startup.model.UserRolDTO;
import cl.praxis.startup.services.AddressService;
import cl.praxis.startup.services.UserRolService;
import cl.praxis.startup.services.UserService;
import cl.praxis.startup.services.impl.AddressServiceImpl;
import cl.praxis.startup.services.impl.UserRolServiceImpl;
import cl.praxis.startup.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserService objUserService;
    private AddressService objAddressService;
    private UserRolService objUserRolService;

    public void init() {
        objUserService = new UserServiceImpl();
        objAddressService = new AddressServiceImpl();
        objUserRolService = new UserRolServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "view";
        }

        switch (action) {
            case "login":
                loginUser(request, response);
                break;
            case "register":
                registerView(request, response);
                break;
            case "insert":
                registerUser(request, response);
                registerAddress(request);
                registerUserRol();
                break;
            default:
                loginView(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void loginView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Optional<UserDTO> userFound = objUserService.filterUser(email, password);
        List<UserDTO> usersList = objUserService.selectUsersWithAddresses();

        if(userFound.isPresent()) {
            if(userFound.get().getRolId() == 1) {
                request.setAttribute("admin", userFound.get());
                request.setAttribute("usersList", usersList);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                printMessage("msgNoAdmin",
                        "login.jsp",
                        "Usuario no posee el rol administrador",
                        request, response);
            }
        } else {
            printMessage("msgError",
                    "login.jsp",
                    "Usuario no encontrado, intente nuevamente",
                    request, response);
        }
    }

    private void registerView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Date createdAt = new Date();
        String nick = request.getParameter("nick");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int weight = Integer.parseInt(request.getParameter("weight"));
        Date updatedAt = new Date();
        int rolId = 2;

        Optional<UserDTO> userFound = objUserService.filterUserRegister(email, nick);

        if(userFound.isEmpty()) {
            UserDTO newUser = new UserDTO(email, createdAt, nick, name, password, weight, updatedAt, rolId);
            objUserService.insertUser(newUser);
            printMessage("msgSuccess",
                        "login.jsp",
                        "Usuario registrado exitósamente",
                        request, response);
        } else {
            printMessage("msgError",
                        "register.jsp",
                        "Correo y/o apodo ya registrados, intenta con uno nuevo",
                        request, response);
        }
    }

    private void registerAddress(HttpServletRequest request) {
        String address = request.getParameter("address");
        String numbering = request.getParameter("numbering");
        int userId = objUserService.searchLastUser().getUserId();

        AddressDTO newAddress = new AddressDTO(address, numbering, userId);
        objAddressService.insertAddress(newAddress);
    }

    private void registerUserRol() {
        int userId = objUserService.searchLastUser().getUserId();
        int rolId = objUserService.selectUser(userId).getRolId();

        UserRolDTO newUserRol = new UserRolDTO(userId, rolId);
        objUserRolService.insertUserRol(newUserRol);
    }

    private void printMessage(String attribute, String dispatcher, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(attribute, message);
        request.getRequestDispatcher(dispatcher).forward(request, response);
    }
}