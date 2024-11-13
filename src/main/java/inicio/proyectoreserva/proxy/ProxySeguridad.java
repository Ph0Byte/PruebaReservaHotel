package inicio.proyectoreserva.proxy;

public class ProxySeguridad implements ServicioConfidencial {
    private ServicioConfidencial servicioConfidencial;
    private String rolUsername;

    public ProxySeguridad(String rolUsername) {
        this.servicioConfidencial = new ServicioConfidencialImpl();
        this.rolUsername = rolUsername;
    }

    @Override
    public void eliminarDatos() {
        if (verificaAcceso()){
            servicioConfidencial.eliminarDatos();
        }else {
            System.out.println("Acceso denegado: no tienes acceso ");
        }
    }

    private boolean verificaAcceso(){
        return "ADMIN".equalsIgnoreCase(rolUsername);
    }
}
