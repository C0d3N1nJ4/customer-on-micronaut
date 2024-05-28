package com.naiomi;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;

@Introspected(packages = "com.naiomi.customer, com.naiomi.address, com.naiomi.contact", includedAnnotations = jakarta.persistence.Entity.class)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}