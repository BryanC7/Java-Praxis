package cl.praxis.jeejsp.servlet;

import cl.praxis.jeejsp.utils.GeneralUtilities;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PairOdd", value = "/PairOdd")
public class PairOdd extends HttpServlet {
    public PairOdd() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("value"));

        GeneralUtilities utilities = new GeneralUtilities();
        String pairOdd = utilities.calculatePairOdd(number);

        response.getWriter().append("El numero " + number + " es: ").append(pairOdd);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}