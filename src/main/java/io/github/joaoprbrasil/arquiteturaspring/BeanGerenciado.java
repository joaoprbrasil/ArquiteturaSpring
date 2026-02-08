package io.github.joaoprbrasil.arquiteturaspring;

import io.github.joaoprbrasil.arquiteturaspring.todos.TodoEntity;
import io.github.joaoprbrasil.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    @Autowired // para injeção de dependencia
    private TodoValidator validator;

    // Formas de fazer a injeção de dependencia
    public BeanGerenciado(TodoValidator validator) { // Maneira de IoD recomendada pelo spring
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
