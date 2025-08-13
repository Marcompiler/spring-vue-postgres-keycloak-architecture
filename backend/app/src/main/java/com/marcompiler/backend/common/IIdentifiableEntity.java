package com.marcompiler.backend.common;

/**
 * Defines the use of an identifier of a given type.
 * @param <T> The data type of the identifier.
 */
public interface IIdentifiableEntity<T> {
    /**
     * Returns the identifier of this entity.
     */
    T getId();
}
