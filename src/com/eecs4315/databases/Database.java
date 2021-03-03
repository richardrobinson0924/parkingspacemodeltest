package com.eecs4315.databases;

import com.eecs4315.Identifiable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Database<Identifier, T extends Identifiable<Identifier>> {
    private final Map<Identifier, T> table;

    protected Database() {
        this.table = new HashMap<>();
    }

    public void insert(T object) {
        if (table.containsKey(object.getId())) {
            throw new IllegalArgumentException("id already exists");
        }

        table.put(object.getId(), object);
    }

    public Optional<T> findById(Identifier id) {
        return table.containsKey(id) ? Optional.of(table.get(id)) : Optional.empty();
    }

    public Collection<T> find(Predicate<T> condition) {
        if (condition == null) {
            return table.values();
        }

        return table.values()
                .stream()
                .filter(condition)
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<T> findOne(Predicate<T> condition) {
        return table.values()
                .stream()
                .filter(condition)
                .findFirst();
    }

    public void remove(Identifier id) {
        table.remove(id);
    }
}
