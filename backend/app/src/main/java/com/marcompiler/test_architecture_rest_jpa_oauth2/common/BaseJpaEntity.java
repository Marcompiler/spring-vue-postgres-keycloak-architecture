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
 * Base for all {@link IAuditedEntity audited} entities with an {@link IIdentifiableEntity identity} and a {@link IVersionedEntity versioning}.
 * @param <T> Identity data type.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseJpaEntity<T> implements IIdentifiableEntity<T>, IVersionedEntity, IAuditedEntity {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "lastmodified_at")
    LocalDateTime lastModifiedAt;

    @Version
    Integer version;

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    @Override
    public Integer getVersion() {
        return version;
    }
}
