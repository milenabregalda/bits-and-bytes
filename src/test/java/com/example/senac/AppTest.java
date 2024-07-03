package com.example.senac;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;

import com.example.senac.controller.UsuarioController;
import com.example.senac.exception.UsuarioComNomeJaCadastradoException;
import com.example.senac.model.Usuario;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws UsuarioComNomeJaCadastradoException 
     */
      
    @Test
    public void testaAGravacaoDeUmUsuarioJaCadastrado() throws UsuarioComNomeJaCadastradoException {
        UsuarioController usuarioController = new UsuarioController(); 
        Usuario usuario = new Usuario ("Nome", "CPF", "E-mail", "Senha", "Telefone");
        assertThrows(usuarioController.cadastrarUsuario(usuario), UsuarioComNomeJaCadastradoException.class);
    }

    private void assertThrows(boolean cadastrarUsuario, Class<UsuarioComNomeJaCadastradoException> class1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertThrows'");
    }
}