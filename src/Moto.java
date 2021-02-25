public class Moto extends Vehiculo {

    public Moto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPatente(patente);
        this.setPeso(300);
        this.setRuedas(2);
    }
}
