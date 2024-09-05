package clase23;

import java.util.ArrayList;
import java.util.List;

public class MainObjetos {
    public static void main(String[] args) {
        Cerveza cerveza1 = new Cerveza("Transparente", "Corona", 2590);
        Cerveza cerveza2 = new Cerveza("Verde", "Stella Artois", 1990);
        Cerveza cerveza3 = new Cerveza("Marrón", "Modelo Especial", 4590);

        List<Cerveza> listaCervezas = new ArrayList<>();
        listaCervezas.add(cerveza1);
        listaCervezas.add(cerveza2);
        listaCervezas.add(cerveza3);

        Botilleria botilleria1 = new Botilleria(listaCervezas, "Botillería Praxis");
        System.out.println(botilleria1);

    }
}
