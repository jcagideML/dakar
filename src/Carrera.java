import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia; //En Km
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socAuto;
    private SocorristaMoto socMoto;

    public Carrera(double distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        listaDeVehiculos = new ArrayList<>();
        this.socAuto = new SocorristaAuto();
        this.socMoto = new SocorristaMoto();
    }

    //Se podría tener un unico metodo eliminar
    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.removeIf(v -> v.getPatente().equals(vehiculo.getPatente()));
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaDeVehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public Vehiculo ganador() {
        Vehiculo win = null;
        int max = 0;

        for (Vehiculo v : listaDeVehiculos) {
            int valor = (v.getVelocidad() / 2 * v.getAceleracion()) / v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100);
            if (valor > max) {
                win = v;
            }
        }

        return win;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v.getPatente().equals(patente)) {
                if (v instanceof Auto) {
                    socAuto.socorrer((Auto) v);
                }
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v.getPatente().equals(patente)) {
                if (v instanceof Moto) {
                    socMoto.socorrer((Moto) v);
                }
            }
        }
    }

    //Puede socorrer tanto motos como autos.
    //Se podría haber generalizado más pero intente respetar las
    //consignas de los ejercicios.
    public void socorrer(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v.getPatente().equals(patente)) {
                if (v instanceof Auto) {
                    socAuto.socorrer((Auto) v);
                } else if (v instanceof Moto) {
                    socMoto.socorrer((Moto) v);
                }
            }
        }
    }
}
