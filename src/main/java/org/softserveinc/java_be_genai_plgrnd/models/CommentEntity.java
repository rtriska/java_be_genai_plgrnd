package org.softserveinc.java_be_genai_plgrnd.models;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleEntity article;

    @Column(nullable = false)
    private String content;

    @Column(name = "creation_timestamp", nullable = false, updatable = false)
    @CreatedDate
    private ZonedDateTime creationTimestamp;

    @Column(name = "last_update_timestamp", nullable = false)
    @LastModifiedDate
    private ZonedDateTime lastUpdateTimestamp;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(ZonedDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public ZonedDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(ZonedDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommentEntity that)) {
            return false;
        }

        return Objects.equals(id, that.id)
            && Objects.equals(content, that.content)
            && Objects.equals(creationTimestamp, that.creationTimestamp)
            && Objects.equals(lastUpdateTimestamp, that.lastUpdateTimestamp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(content);
        result = 31 * result + Objects.hashCode(creationTimestamp);
        result = 31 * result + Objects.hashCode(lastUpdateTimestamp);
        return result;
    }
}