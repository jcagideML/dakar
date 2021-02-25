public class Auto extends Vehiculo {

    public Auto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPatente(patente);
        this.setPeso(1000);
        this.setRuedas(4);
    }
}
