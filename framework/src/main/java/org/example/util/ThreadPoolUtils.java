package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
public class ThreadPoolUtils {

//    @Value("${thread-pool.await-termination}")
    private static Integer awaitTermination;

    public static void printException(Runnable r, Throwable t) {
        if (Objects.isNull(t) && r instanceof Future<   ?> val) {
            try {
                if (val.isDone()) {
                    val.get();
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (Objects.nonNull(t)) {
            log.error(t.getMessage(), t);
        }
    }

    public static void shutdownAndAwaitTermination(ExecutorService pool) {
        if (Objects.nonNull(pool) && !pool.isShutdown()) {
            pool.shutdown();
            try {
                if (!pool.awaitTermination(awaitTermination, TimeUnit.SECONDS)) {
                    pool.shutdownNow();
                    if (!pool.awaitTermination(awaitTermination, TimeUnit.SECONDS)) {
                        log.info("Pool did not terminate");
                    }
                }
            } catch (InterruptedException ie) {
                pool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
