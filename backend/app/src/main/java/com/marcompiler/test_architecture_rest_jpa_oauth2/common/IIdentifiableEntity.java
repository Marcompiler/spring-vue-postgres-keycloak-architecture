package com.marcompiler.test_architecture_rest_jpa_oauth2.common;

/**
 * Defines the use of an identifier of a given type.
 * @param <T> The data type of the identifier.
 */
public interface IIdentifiableEntity<T> {
    T getId();
}
