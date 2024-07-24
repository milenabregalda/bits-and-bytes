package com.example.senac;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.example.senac.controller.UsuarioController;
import com.example.senac.exception.UsuarioComCPFJaCadastradoException;
import com.example.senac.exception.UsuarioComEmailJaCadastradoException;
import com.example.senac.exception.UsuarioComNomeJaCadastradoException;
import com.example.senac.model.Usuario;

public class AppTest {

    @Test
    public void deveLancarExcecaoQuandoCadastrarUsuarioComNomeJaCadastrado() {
        final UsuarioController usuarioController = new UsuarioController();
        final Usuario usuario = new Usuario("Nome", "CPF", "E-mail", "Senha", "Telefone");

        // Cadastra o usuário pela primeira vez 
        try {
            usuarioController.cadastrarUsuario(usuario);
        } catch (UsuarioComNomeJaCadastradoException | UsuarioComCPFJaCadastradoException | UsuarioComEmailJaCadastradoException e) {
            // Se tiver exceção porque o usuário já foi cadastrado antes do teste, ela é simplesmente ignorada
        }

        // Cadastra o usuário novamente, aqui deve gerar a exceção do nome já cadastrado (UsuarioComNomeJaCadastradoException)
        try {
            usuarioController.cadastrarUsuario(usuario);
            fail("Expected UsuarioComNomeJaCadastradoException to be thrown");
            // Se a exceção não acontecer, o teste falhou
        } catch (UsuarioComNomeJaCadastradoException e) {
            assertTrue(e.getMessage().contains("Usuário com o nome")); // Para o teste ser bem sucedido, a mensagem de erro deve conter este texto
        } catch (UsuarioComCPFJaCadastradoException | UsuarioComEmailJaCadastradoException e) { // Se uma das outras duas exceções acontecerem, o teste também falhou
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }
}

