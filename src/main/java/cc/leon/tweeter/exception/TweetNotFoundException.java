package cc.leon.tweeter.exception;

public class TweetNotFoundException extends RuntimeException{
    public TweetNotFoundException(String message) {
        super(message);
    }
}
