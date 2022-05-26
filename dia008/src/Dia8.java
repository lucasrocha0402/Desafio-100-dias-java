import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Dia8 {

    private static final Logger LOGGER = Logger .getLogger(Dia8.class.getName());

    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        LOGGER.info("Creating a thread pool with 5 threads");
        ExecutorService executor = Executors.newFixedThreadPool(5);

        LOGGER.info("Iniciando envios de tarefas.");
        try {
            for (var i = 1; i <= 15; i++) {
                int taskId = i;
                LOGGER.info(() -> MessageFormat.format("Vai enviar a tarefa {0}.", taskId));
                executor.submit(() -> task(taskId));
            }
        } finally {
            executor.shutdown();
        }
    }

    private static void task(int taskId) {
        LOGGER.info(() -> MessageFormat.format("Rodando tarefa {0}.", taskId));
        simulateLongProcessing();
        LOGGER.info(() -> MessageFormat.format("Tarefa {0} foi concluida.", taskId));
    }

    private static void simulateLongProcessing() {
        try {
            Thread.sleep((RANDOM.nextInt(3) + 10) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(MessageFormat.format("O topico {0} foi interrompido.", Thread.currentThread().getName()), e);
        }
    }
}
