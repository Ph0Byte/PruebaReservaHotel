package inicio.proyectoreserva.model;

public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String rol;

    public Usuario(int id, String nombre, String username, String password, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String nombre, String username, String password, String rol) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
