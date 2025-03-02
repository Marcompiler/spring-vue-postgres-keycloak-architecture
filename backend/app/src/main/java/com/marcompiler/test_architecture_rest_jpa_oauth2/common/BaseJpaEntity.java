package com.marcompiler.test_architecture_rest_jpa_oauth2.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Base for all {@link AuditingEntityListener audited} entities with an {@link IdentifiableEntity identity} and a {@link VersionedEntity versioning}.
 * @param <T> Identity data type.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseJpaEntity<T> implements IdentifiableEntity<T>, VersionedEntity {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "lastmodified_at")
    LocalDateTime lastModifiedAt;

    @Version
    Integer version;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    @Override
    public Integer getVersion() {
        return version;
    }
}
