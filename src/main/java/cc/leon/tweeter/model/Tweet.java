package cc.leon.tweeter.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name =  "tweets")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;

    @Column(nullable = false)
    private Long userId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    @PreRemove
    public void onDelete() {
        deletedAt = LocalDateTime.now();
    }

}
