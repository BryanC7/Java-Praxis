package cl.praxis.reservassheraton.business;

import cl.praxis.reservassheraton.model.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionBusiness {
        public List<Habitacion> getHabitaciones() {
            ArrayList<Habitacion> habitaciones = new ArrayList<>();

            Habitacion habitacion1 = new Habitacion();
            habitacion1.setId(1);
            habitacion1.setNombre("Habitación 1 Simple");
            habitacion1.setDescripcion("Habitación Clásica con cama extragrande, vistas al océano y balcón");
            habitacion1.setImagen("https://cache.marriott.com/content/dam/marriott-renditions/SCLSI/sclsi-classic-room-9118-hor-wide.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1336px:*");
            habitacion1.setPrecio(10000);
            habitacion1.setHabitaciones(4);
            habitacion1.setMetraje(3);

            Habitacion habitacion2 = new Habitacion();
            habitacion2.setId(2);
            habitacion2.setNombre("Habitación 2 Simple - Doble");
            habitacion2.setDescripcion("Habitación Clásica con 2 camas extragrandes, vistas al océano y balcón");
            habitacion2.setImagen("https://cache.marriott.com/content/dam/marriott-renditions/SCLSI/sclsi-twin-guestroom-3682-hor-wide.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1336px:*");
            habitacion2.setPrecio(20000);
            habitacion2.setHabitaciones(3);
            habitacion2.setMetraje(3);

            Habitacion habitacion3 = new Habitacion();
            habitacion3.setId(3);
            habitacion3.setNombre("Habitación 3 Normal - Doble");
            habitacion3.setDescripcion("Habitación Superior en planta alta con vistas al océano y 2 camas dobles");
            habitacion3.setImagen("https://cache.marriott.com/content/dam/marriott-renditions/SCLSI/sclsi-classic-room-9118-hor-wide.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1336px:*");
            habitacion3.setPrecio(30000);
            habitacion3.setHabitaciones(2);
            habitacion3.setMetraje(3);

            Habitacion habitacion4 = new Habitacion();
            habitacion4.setId(4);
            habitacion4.setNombre("Habitación 4 King - Doble");
            habitacion4.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
            habitacion4.setImagen("https://cache.marriott.com/content/dam/marriott-renditions/SCLSI/sclsi-twin-guestroom-3682-hor-wide.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1336px:*");
            habitacion4.setPrecio(40000);
            habitacion4.setHabitaciones(5);
            habitacion4.setMetraje(3);

            Habitacion habitacion5 = new Habitacion();
            habitacion5.setId(5);
            habitacion5.setNombre("Habitación 5 King - Doble");
            habitacion5.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
            habitacion5.setImagen("https://cf.bstatic.com/xdata/images/hotel/max1024x768/470213577.jpg?k=e518e030cafa455eed6415b0a6d9e8b0b0c6b895ce3ad619aece3a4b7c33962b&o=&hp=1");
            habitacion5.setPrecio(50000);
            habitacion5.setHabitaciones(6);
            habitacion5.setMetraje(3);

            Habitacion habitacion6 = new Habitacion();
            habitacion6.setId(6);
            habitacion6.setNombre("Habitación 6 King - Doble");
            habitacion6.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
            habitacion6.setImagen("https://static11.com-hotel.com/uploads/hotel/10610/photo/sheraton-miramar-hotel-convention-center_15126747881.jpg");
            habitacion6.setPrecio(60000);
            habitacion6.setHabitaciones(5);
            habitacion6.setMetraje(3);

            Habitacion habitacion7 = new Habitacion();
            habitacion7.setId(7);
            habitacion7.setNombre("Habitación 7 King - Doble");
            habitacion7.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
            habitacion7.setImagen("https://cf.bstatic.com/xdata/images/hotel/max1024x768/470213577.jpg?k=e518e030cafa455eed6415b0a6d9e8b0b0c6b895ce3ad619aece3a4b7c33962b&o=&hp=1");
            habitacion7.setPrecio(70000);
            habitacion7.setHabitaciones(4);
            habitacion7.setMetraje(3);

            Habitacion habitacion8 = new Habitacion();
            habitacion8.setId(8);
            habitacion8.setNombre("Habitación 8 King - Doble");
            habitacion8.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
            habitacion8.setImagen("https://cache.marriott.com/content/dam/marriott-renditions/SCLSI/sclsi-classic-room-9118-hor-wide.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1336px:*");
            habitacion8.setPrecio(80000);
            habitacion8.setHabitaciones(2);
            habitacion8.setMetraje(3);

            habitaciones.add(habitacion1);
            habitaciones.add(habitacion2);
            habitaciones.add(habitacion3);
            habitaciones.add(habitacion4);
            habitaciones.add(habitacion5);
            habitaciones.add(habitacion6);
            habitaciones.add(habitacion7);
            habitaciones.add(habitacion8);

            return habitaciones;
        }

        public Habitacion getHabitacionbyID(Habitacion habitacion) {
            List<Habitacion> listaHabitaciones = getHabitaciones();
            for (Habitacion listaHabitacion : listaHabitaciones) {
                if (listaHabitacion.getId() == habitacion.getId()) {
                    habitacion = listaHabitacion;
                }
            }

            return habitacion;
        }

        public int calculaValorCompra(int valorHabitacion, int cantidadDias) {
            return valorHabitacion * cantidadDias;
        }

}
