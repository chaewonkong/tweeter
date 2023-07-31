package cc.leon.tweeter.controller;


import cc.leon.tweeter.exception.TweetNotFoundException;
import cc.leon.tweeter.model.Tweet;
import cc.leon.tweeter.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tweet")
@RequiredArgsConstructor
public class TweetController {
    private final TweetService tweetService;

    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> findOne(@PathVariable Long tweetId) {
       return tweetService.findById(tweetId)
               .map(tweet -> new ResponseEntity(tweet, HttpStatus.OK))
               .orElse(new ResponseEntity<>("Tweet not found", HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Tweet> save(@RequestBody Tweet tweet) {
        return tweetService.save(tweet)
                .map(savedTweet -> new ResponseEntity(savedTweet, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>("Creation Failed", HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> delete(@PathVariable Long tweetId) {
            this.tweetService.delete(tweetId);
            return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(TweetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTweetNotFoundException(TweetNotFoundException e) {
        return e.getMessage();
    }
}
