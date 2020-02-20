package com.tom.exceptions.exceptionhandling;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
@Slf4j
public class Exceptions {
    /**
     * The simplest way to “handle” an exception is to rethrow it:
     *
     * @param playerFile
     * @return
     * @throws FileNotFoundException
     */
    public int getPlayerScore(String playerFile)
            throws FileNotFoundException {

        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    }


    /**
     * If we want to try and handle the exception ourselves, we can use a try-catch block.
     * We can handle it by rethrowing our exception
     *
     * @param playerFile
     * @return
     */
    public int getPlayerScoreTryCatch(String playerFile) {
        try {
            Scanner contents = new Scanner(new File(playerFile));
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException noFile) {
            throw new IllegalArgumentException("File not found");
        }
    }

    /**
     * by performing recovery steps
     *
     * @param playerFile
     * @return
     */
    public int getPlayerScoreRecoveryException(String playerFile) {
        try {
            Scanner contents = new Scanner(new File(playerFile));
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException noFile) {
            log.warn("File not found, resetting score.");
            return 0;
        }
    }

    /**
     * whether we can read the file or not, we want to make sure that we do the appropriate cleanup!
     * <p>
     * Let's try this the “lazy” way first:
     *
     * @param playerFile
     * @return
     * @throws FileNotFoundException
     */
    public int getPlayerScoreFinallyLazyWay(String playerFile)
            throws FileNotFoundException {
        Scanner contents = null;
        try {
            contents = new Scanner(new File(playerFile));
            return Integer.parseInt(contents.nextLine());
        } finally {
            if (contents != null) {
                contents.close();
            }
        }
    }

    /**
     * handle the exception and make sure that our resources get closed
     *
     * @param playerFile
     * @return
     */
    public int getPlayerScore2(String playerFile) {
        Scanner contents = null;
        try {
            contents = new Scanner(new File(playerFile));
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException noFile) {
            log.warn("File not found, resetting score.");
            return 0;
        } finally {
            //try {
            if (contents != null) {
                contents.close();
            }
            //} catch (IOException io) {
            //    log.error("Couldn't close the reader!", io);
            //}
        }
    }

    /**
     * try-with-resources
     * Fortunately, as of Java 7, we can simplify the above syntax when working with things that extend AutoCloseable
     */
    public int getPlayerScoreTryWithResource(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException e) {
            log.warn("File not found, resetting score.");
            return 0;
        }
    }

    /**
     * Multiple catches give us the chance to handle each exception differently, should the need arise.
     * <p>
     * Also note here that we didn't catch FileNotFoundException, and that is because it extends IOException.
     * Because we're catching IOException, Java will consider any of its subclasses also handled.
     * <p>
     * Let's say, though, that we need to treat FileNotFoundException differently from the more general IOException
     *
     * @param playerFile
     * @return
     */
    public int getPlayerScoreMultiCatchBlock(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException e) {
            log.warn("Player file not found!", e);
            return 0;
        } catch (IOException e) {
            log.warn("Player file wouldn't load!", e);
            return 0;
        } catch (NumberFormatException e) {
            log.warn("Player file was corrupted!", e);
            return 0;
        }
    }

    /**
     * When we know that the way we handle errors is going to be the same, though,
     * Java 7 introduced the ability to catch multiple exceptions in the same block
     *
     * @param playerFile
     * @return
     */
    public int getPlayerScoreUnionCatchBlock(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (IOException | NumberFormatException e) {
            log.warn("Failed to load score!", e);
            return 0;
        }
    }

    /**
     * Throwing a Checked Exception
     *
     * @param playersFile
     * @return
     * @throws TimeoutException
     */
    public List<Player> loadAllPlayersThrowingChecked(String playersFile) throws TimeoutException {
        boolean tooLong = true;

        while (!tooLong) {
            // ... potentially long operation
        }
        throw new TimeoutException("This operation took too long");
    }

    /**
     * Throwing an Unchecked Exception
     *
     * @param playersFile
     * @return
     * @throws TimeoutException
     */
    public List<Player> loadAllPlayersThrowingUnchecked(String playersFile) throws TimeoutException {
        if (!isFilenameValid(playersFile)) {
            throw new IllegalArgumentException("Filename isn't valid!");
        }
        return null;

        // ...
    }

    private boolean isFilenameValid(String name) {
        return false;
    }

    /**
     * We can also choose to rethrow an exception we've caught
     * @param playersFile
     * @return
     * @throws IOException
     */
    public List<Player> loadAllPlayersRethrowException(String playersFile)
            throws IOException {
        try {
            // ...
            throw new IOException();
        } catch (IOException io) {
            throw io;
        }
    }

    /**
     * do a wrap and rethrow
     * This can be nice for consolidating many different exceptions into one
     * @param playersFile
     * @return
     * @throws PlayerLoadException
     */
    public List<Player> loadAllPlayersWrapAndRethrowException(String playersFile)
            throws PlayerLoadException {
        try {
            // ...
            throw new IOException();
        } catch (IOException io) {
            throw new PlayerLoadException(io);
        }
    }

    /**
     * Now for a special case.
     *
     * If the only possible exceptions that a given block of code could raise are unchecked exceptions,
     * then we can catch and rethrow Throwable or Exception without adding them to our method signature:
     * @param playersFile
     * @return
     */
    public List<Player> loadAllPlayers(String playersFile) throws MyCheckedException {
        try {
            throw new NullPointerException();
        } catch (Throwable t) {
            throw t;
        }


    }

    class FewerExceptions extends Exceptions {
        @Override
        public List<Player> loadAllPlayers(String playersFile) {  //can't add "throws MyCheckedException
            return null;
            // overridden
        }
    }

    public int getPlayerScoreSwallowException(String playerFile) {
        try {
            // ...
        } catch (Exception e) {} // <== catch and swallow
        return 0;
    }

    public int getPlayerScore3(String playerFile) {
        try {
            // ...
            throw new IOException();
        } catch (IOException e) {
            log.error("Couldn't load the score", e);
            return 0;
        }
    }

    public int getPlayerScore4(String playerFile) throws PlayerScoreException {
        try {
            // ...
            throw new IOException();
        } catch (IOException e) {
            throw new PlayerScoreException(e);
        }
    }

    /**
     * Using return in a finally Block
     * Another way to swallow exceptions is to return from the finally block. This is bad because, by returning abruptly,
     * the JVM will drop the exception, even if it was thrown from by our code
     * @param playerFile
     * @return
     */
    public int getPlayerScoreReturnInFinally(String playerFile) {
        int score = 0;
        try {
            throw new IOException();
        } finally {
            // <== the IOException is dropped
            return score;
        }


    }

    public int getPlayerScoreEatenByFinally(String playerFile) {
        try {
            // ...
            throw new IOException();
        } catch ( IOException io ) {
            // <== eaten by the finally
            throw new IllegalStateException(io);
        } finally {
            throw new OtherException();
        }
    }
}
