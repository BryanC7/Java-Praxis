package cl.praxis.calculadora;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Calculadora", value = "/Calculadora")
public class Calculadora extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float numero1 = Integer.parseInt(request.getParameter("nro1"));
        float numero2 = Integer.parseInt(request.getParameter("nro2"));
        String opcion = request.getParameter("opcion");
        response.getWriter().append(calculo(numero1, numero2, opcion));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public String calculo(float n1, float n2, String opcion) {
        switch (opcion) {
            case "1":
                return "La suma de los numeros es: " + (int)(n1 + n2);
            case "2":
                return "La resta de los numeros es: " + (int)(n1 - n2);
            case "3":
                return "La multiplicacion de los numeros es: " + (int)(n1 * n2);
            case "4":
                if(n2 == 0) {
                    return "No es posible dividir por cero";
                }
                return "La division de los numeros es: " + (n1 / n2);
            case "5":
                int menor = (int) Math.min(n1, n2);
                int mayor = (int) Math.max(n1, n2);
                return "Los numeros ordenados son: " + menor + ", " + mayor;
            case "6":
                int numero1 = (int) n1;
                int numero2 = (int) n2;

                if(n1 % 2 == 0 && n2 % 2 == 0) {
                    return numero1 + " y " + numero2 + " son pares";
                } else if (n1 % 2 == 0 && n2 % 2 == 1) {
                    return numero1 + " es par y " + numero2 + " es impar";
                } else if (n1 % 2 == 1 && n2 % 2 == 0) {
                    return numero1 + " es impar y " + numero2 + " es par";
                } else {
                    return numero1 + " y " + numero2 + " son impares";
                }
            default:
                return "Opcion no valida";
        }
    }
}