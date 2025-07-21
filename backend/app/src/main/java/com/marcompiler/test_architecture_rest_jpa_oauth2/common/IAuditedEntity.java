package com.marcompiler.test_architecture_rest_jpa_oauth2.common;

import java.time.LocalDateTime;

/**
 * Defines methods to audit creation and modification for entities. Fed automatically by Spring JPA with EntityListeners(AuditingEntityListener.class), CreatedDate and LastModifiedDate annotations.
 */
public interface IAuditedEntity {
    /**
     * Returns the creation date of this entity.
     */
    LocalDateTime getCreatedAt();

    /**
     * Returns the date on which this entity was last modified.
     */
    LocalDateTime getLastModifiedAt();
}