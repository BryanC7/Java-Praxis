package cl.praxis.proveedores.controllers;

import cl.praxis.proveedores.model.SupplierDTO;
import cl.praxis.proveedores.services.SupplierService;
import cl.praxis.proveedores.services.impl.SupplierServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SupplierServlet", value = "/supplier")
public class SupplierServlet extends HttpServlet {
    private SupplierService objSupplierService;

    public void init() {
        objSupplierService = new SupplierServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertSupplier(request, response);
                    break;
                case "delete":
                    deleteSupplier(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateSupplier(request, response);
                    break;
                case "view":
                    viewSupplier(request, response);
                    break;
                default:
                    listSuppliers(request, response);
                    break;
            }
        } catch(SQLException ex) {
            throw new ServletException(ex);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listSuppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SupplierDTO> listSuppliers = objSupplierService.selectAllSuppliers();
        request.setAttribute("listSuppliers", listSuppliers);
        request.getRequestDispatcher("supplier-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("supplier-form.jsp").forward(request, response);
    }

    private void insertSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int rut = Integer.parseInt(request.getParameter("rut"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String contact = request.getParameter("contact");
        int contactPhone = Integer.parseInt(request.getParameter("contactPhone"));
        SupplierDTO newSupplier = new SupplierDTO(name, rut, address, email, phoneNumber, contact, contactPhone);
        objSupplierService.insertSupplier(newSupplier);
        response.sendRedirect("supplier");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SupplierDTO supplierFound = objSupplierService.selectSupplier(id);
        request.setAttribute("supplier", supplierFound);
        request.getRequestDispatcher("supplier-form.jsp").forward(request, response);
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int rut = Integer.parseInt(request.getParameter("rut"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String contact = request.getParameter("contact");
        int contactPhone = Integer.parseInt(request.getParameter("contactPhone"));
        SupplierDTO supplier = new SupplierDTO(id, name, rut, address, email, phoneNumber, contact, contactPhone);
        objSupplierService.updateSupplier(supplier);
        response.sendRedirect("supplier");
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        objSupplierService.deleteSupplier(id);
        response.sendRedirect("supplier");
    }

    private void viewSupplier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SupplierDTO supplier = objSupplierService.selectSupplier(id);
        request.setAttribute("supplier", supplier);
        request.getRequestDispatcher("supplier-view.jsp").forward(request, response);
    }
}