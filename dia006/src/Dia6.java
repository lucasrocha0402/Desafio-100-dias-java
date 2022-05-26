import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Dia6 {

    private static final Logger LOGGER = Logger.getLogger(Dia6.class.getName());

    public static void main(String[] args) {
        CompletableFuture.runAsync(Dia6::task);

        LOGGER.info("Mensagem do tópico principal. Observe que esta mensagem é registrada antes do término da tarefa assíncrona");

        LOGGER.info("Aguardando o término da tarefa assíncrona");
        boolean isQuiecent = ForkJoinPool.commonPool().awaitQuiescence(5, SECONDS);
        if (isQuiecent) {
            LOGGER.info("Async task ended.");
        } else {
            LOGGER.log(Level.SEVERE, "A tarefa assíncrona está demorando muito para ser concluída. Este programa vai acabar de qualquer maneira");
        }
    }

    private static void task() {
        LOGGER.info("Iniciando a tarefa assíncrona. Esta mensagem é registrada pelo encadeamento de tarefas assíncronas");
        try {
            Thread.sleep(1000);
            LOGGER.info("A tarefa assíncrona está terminando. Esta mensagem é registrada pelo encadeamento de tarefas assíncronas");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, "O encadeamento de tarefas assíncronas foi interrompido", e);
        }
    }
}
