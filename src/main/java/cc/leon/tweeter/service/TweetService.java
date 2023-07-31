package cc.leon.tweeter.service;

import cc.leon.tweeter.exception.TweetNotFoundException;
import cc.leon.tweeter.model.Tweet;
import cc.leon.tweeter.model.User;
import cc.leon.tweeter.repository.TweetRepository;
import cc.leon.tweeter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public Optional<Tweet> save(Tweet tweet) {
        Long userId = tweet.getUserId();
        if (userRepository.existsById(userId)) {
            Tweet savedTweet = tweetRepository.save(tweet);

            return Optional.of(savedTweet);
        }

        return Optional.empty();
    }

    public Optional<Tweet> findById(Long tweetId) {
        return tweetRepository.findById(tweetId);
    }

    public void delete(Long tweetId) {
        if (tweetRepository.existsById(tweetId)) {
            tweetRepository.deleteById(tweetId);
        } else {
            throw new TweetNotFoundException("tweet id: " + tweetId +  " not found");
        }
    }
}
