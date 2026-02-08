package io.github.joaoprbrasil.arquiteturaspring;

import io.github.joaoprbrasil.arquiteturaspring.todos.TodoEntity;
import io.github.joaoprbrasil.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Lazy // vai ser instanciado apenas quando o codigo for ativado
@Component
@Scope("singleton") // instanciado apenas uma vez para toda a aplicação
//@Scope(BeanDefinition.SCOPE_SINGLETON)

//@Scope(WebApplicationContext.SCOPE_APPLICATION)
//@Scope("request") // é instanciado apenas na hora da requisição temporariamente, 1 instancia para cada req
//@Scope("session") // dura enquanto a sessão do usuario durar
//@Scope("application") // dura enquanto a sessão durar para todos os usuários
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
