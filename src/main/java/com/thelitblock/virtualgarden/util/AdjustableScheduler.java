package com.thelitblock.virtualgarden.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AdjustableScheduler {
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> scheduledFuture;
    private long taskStartTime;
    private final long originalDelayInMinutes;
    private long remainingDelayInMinutes;
    private long scheduledExecutionTimeMillis;

    public AdjustableScheduler(long delayInMinutes) {
        this.originalDelayInMinutes = delayInMinutes;
        this.remainingDelayInMinutes = delayInMinutes;
    }

    public void scheduleTask(Runnable task, long delay, TimeUnit timeUnit) {
        scheduledExecutionTimeMillis = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(delay, timeUnit);
        taskStartTime = System.currentTimeMillis();
        scheduledFuture = executorService.schedule(task, originalDelayInMinutes, TimeUnit.MINUTES);
    }

    public void adjustSchedule(long newDelayInMinutes) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false); // Cancel the current task
            long timePassed = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - taskStartTime);
            remainingDelayInMinutes = originalDelayInMinutes - timePassed;
            if (remainingDelayInMinutes > 0) {

                scheduledFuture = executorService.schedule(() -> {

                    System.out.println("Task executed after adjustment");
                }, remainingDelayInMinutes, TimeUnit.MINUTES);
            }
        }
    }

    public long getTimeLeftInMillis() {
        long currentTimeMillis = System.currentTimeMillis();
        long timeLeft = scheduledExecutionTimeMillis - currentTimeMillis;
        return Math.max(timeLeft, 0);
    }

    public void cancel() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}