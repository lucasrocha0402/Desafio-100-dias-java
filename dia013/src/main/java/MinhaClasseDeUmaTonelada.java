import java.time.LocalDateTime;

public class MinhaClasseDeUmaTonelada {

    private final LocalDateTime creationDataTime;

    private MinhaClasseDeUmaTonelada(LocalDateTime creationDataTime) {
        this.creationDataTime = creationDataTime;
    }

    public LocalDateTime getCreationDataTime() {
        return creationDataTime;
    }

    public static MinhaClasseDeUmaTonelada getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static final class InstanceHolder {
        static final MinhaClasseDeUmaTonelada INSTANCE = new MinhaClasseDeUmaTonelada(LocalDateTime.now());
    }
}
