package com.gonzobeans.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

/**
 * A single use timer for Java8+
 * @author David Lerner
 */
@SuppressWarnings("unused")
public final class TimerUtil {
    private final Instant startTime;
    private Instant endTime;

    private TimerUtil(Instant startTime) {
        this.startTime = startTime;
    }

    public static TimerUtil createAndStart() {
        return new TimerUtil(Instant.now());
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Optional<Instant> getEndTime() {
        return Optional.ofNullable(endTime);
    }

    public synchronized void stop() {
        this.endTime = (endTime == null) ? Instant.now() : endTime;
    }

    public Duration getDuration() {
        if (endTime != null) {
            return Duration.between(startTime, endTime);
        }
        return Duration.between(startTime, Instant.now());
    }

    public Long getMillis() {
        return getDuration().toMillis();
    }

    public Duration stopAndGetDuration() {
        stop();
        return Duration.between(startTime, endTime);
    }

    public Long stopAndGetMillis() {
        return stopAndGetDuration().toMillis();
    }
}
