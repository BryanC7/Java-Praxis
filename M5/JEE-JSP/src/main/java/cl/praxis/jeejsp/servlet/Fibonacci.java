package cl.praxis.jeejsp.servlet;

import cl.praxis.jeejsp.utils.GeneralUtilities;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Fibonacci", value = "/Fibonacci")
public class Fibonacci extends HttpServlet {

    public Fibonacci() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("value"));

        GeneralUtilities utilities = new GeneralUtilities();
        String factorial = String.valueOf(utilities.calculateFibonacci(number));

        response.getWriter().append("El factorial de " + number + " es: ").append(factorial + "\n");

        int num = 1;
        int resultado = 1;
        for (int i = 1; i <= number; i++) {
            resultado *= i;
            response.getWriter().append(num + "*" + i + " = " + resultado + "\n");
            num = resultado;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}