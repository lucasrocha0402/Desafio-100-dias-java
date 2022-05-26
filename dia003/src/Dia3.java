import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Dia3 {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {
        var dia3 =  new Dia3();
        dia3.printCurrentTimeEvery25seconds();
        Thread.sleep(15_000);
        dia3.stopPriting();
    }

    public void printCurrentTimeEvery25seconds() {
        Runnable task = () -> System.out.println(LocalTime.now());
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }

    public void stopPriting() {
        scheduledExecutorService.shutdown();
    }
}
