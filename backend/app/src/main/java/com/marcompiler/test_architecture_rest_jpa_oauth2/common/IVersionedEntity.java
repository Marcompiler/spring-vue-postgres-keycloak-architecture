package com.marcompiler.test_architecture_rest_jpa_oauth2.common;

/**
 * Defines a versioning for entities. Fed automatically by Spring JPA with Version annotation and used to manage concurrent access.
 */
public interface IVersionedEntity {
    /**
     * Returns the version number of this entity.
     */
    Integer getVersion();
}
