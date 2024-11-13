package inicio.proyectoreserva.proxy;

public class ProbarProxy {
    public static void main(String[] args) {

        System.out.println("Usuario Comun: ");
        ServicioConfidencial usuarioComun =
                new ProxySeguridad("USER");
        usuarioComun.eliminarDatos();

        System.out.println("Usuario admin : ");
        ServicioConfidencial usuArioAdmin =
        new ProxySeguridad("ADMIN");
        usuArioAdmin.eliminarDatos();
    }
}
