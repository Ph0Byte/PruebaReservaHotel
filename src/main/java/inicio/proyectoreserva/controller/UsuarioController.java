package inicio.proyectoreserva.controller;

import inicio.proyectoreserva.model.Usuario;
import inicio.proyectoreserva.service.UsuarioService;

import java.sql.SQLException;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(){
        usuarioService = new UsuarioService();
    }

    public Usuario autentificarUsuario(String username, String password) throws SQLException {
        return usuarioService.autenticarUsuario(username,password);
    }

    public boolean registrarNuevoUsuario(Usuario usuario) throws SQLException {
        Usuario nuevoUsuario = new Usuario(
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                "Cliente"
        );
        return usuarioService.registrarUsuario(nuevoUsuario);
    }
}
