package com.example.senac;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;

import com.example.senac.controller.UsuarioController;
import com.example.senac.model.Usuario;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testaAGravacaoDeUmUsuarioJaCadastrado() {
        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario = new Usuario ("Nome", "CPF", "E-mail", "Senha", "Telefone");
        //assertThrows(usuarioController.cadastrarUsuario(usuario), UsuarioComNomeJaCadastradoException.class);
    }
}