package com.gonzobeans.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

    /**
     * Static factory method for the TimerUtil class
     * @return a new instance of TimerUtil with the timer set to its creation time
     */
    @Contract(" -> new")
    public static @NotNull TimerUtil createAndStart() {
        return new TimerUtil(Instant.now());
    }

    /**
     * Standard getter for startTime
     * @return the Instant representing when the object was created
     */
    public Instant getStartTime() {
        return startTime;
    }

    /**
     * Null safe getter for the endTime
     * @return an Optional of the endTime if it exists, or else Optional.empty()
     */
    public Optional<Instant> getEndTime() {
        return Optional.ofNullable(endTime);
    }

    /**
     * Stops the timer at the instant of method execution.  Once stopped the timer may not be started again.
     */
    public synchronized void stop() {
        this.endTime = (endTime == null) ? Instant.now() : endTime;
    }

    /**
     * Get the duration without stopping the timer
     * @return the duration between the start and stop time if it exists, or else between the start time and method
     * execution.
     */
    public Duration getDuration() {
        if (endTime != null) {
            return Duration.between(startTime, endTime);
        }
        return Duration.between(startTime, Instant.now());
    }

    /**
     * Get the duration in milliseconds without stopping the timer
     * @return a long representing the duration, as described in getDuration(), in milliseconds
     */
    public @NotNull Long getMillis() {
        return getDuration().toMillis();
    }

    /**
     * Stop the timer and return a duration.  Only the stop time of the first method execution is captured.
     * @return the duration between the start and stop time
     */
    public Duration stopAndGetDuration() {
        stop();
        return Duration.between(startTime, endTime);
    }

    /**
     * Stop the timer and return a duration in milliseconds.  Only the stop time of the first method execution is
     * captured.
     * @return the duration between the start and stop time in milliseconds
     */
    public @NotNull Long stopAndGetMillis() {
        return stopAndGetDuration().toMillis();
    }
}
