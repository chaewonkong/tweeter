package cc.leon.tweeter.repository;

import cc.leon.tweeter.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
