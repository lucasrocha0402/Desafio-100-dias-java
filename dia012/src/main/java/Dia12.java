import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class Dia12 {

    private static final Logger LOGGER = Logger.getLogger(Dia12.class.getName());

    public static void main (String[] args) throws InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();

        try {
            Callable<Integer> callable = Dia12::doALongCalculation;
            Future<Integer> future = executorService.submit(callable);

            doOtherThingWhileCalculating();

            LOGGER.info("Obterá o valor calculado. Observe que o valor será obtido imediatamente.");
            LOGGER.info("Valor calculado:" + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static int doALongCalculation() throws InterruptedException {
        Thread.sleep(5000L);
        return 42;
    }

    private static void doOtherThingWhileCalculating() throws InterruptedException {
        Thread.sleep(7000L);
    }
}
