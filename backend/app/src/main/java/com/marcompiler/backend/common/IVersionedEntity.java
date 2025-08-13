package com.marcompiler.backend.common;

/**
 * Defines a versioning for entities. Fed automatically by Spring JPA with Version annotation and used to manage concurrent access.
 */
public interface IVersionedEntity {
    /**
     * Returns the version number of this entity.
     */
    Integer getVersion();
}
