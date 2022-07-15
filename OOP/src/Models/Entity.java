package Models;

import java.time.LocalDateTime;

public abstract class Entity {

    static {
        staticDateTime = LocalDateTime.now();
        staticFinalDateTime = LocalDateTime.now();
    }

    {
        dateTime = LocalDateTime.now();
        finalDateTime = LocalDateTime.now();
    }
    public int id;

    public Entity() {
    }

    private LocalDateTime dateTime;
    private static LocalDateTime staticDateTime;
    private final LocalDateTime finalDateTime;
    private static final LocalDateTime staticFinalDateTime;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public static LocalDateTime getStaticDateTime() {
        return staticDateTime;
    }
}
