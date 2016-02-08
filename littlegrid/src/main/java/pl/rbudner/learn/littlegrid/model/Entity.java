package pl.rbudner.learn.littlegrid.model;

import com.google.gson.reflect.TypeToken;
import pl.rbudner.learn.littlegrid.KeyProvider;

import java.lang.reflect.Type;
import java.util.List;

public enum Entity {

    PERSON("clients.json", "CLIENTS", Person::getId, new TypeToken<List<Person>>() {}.getType());

    private final String dataFilename;
    private final String cacheName;
    private final KeyProvider keyProvider;
    private final Type type;

    <K, V> Entity(String filename, String cacheName, KeyProvider<K, V> keyProvider, Type type) {
        this.dataFilename = filename;
        this.cacheName = cacheName;
        this.keyProvider = keyProvider;
        this.type = type;
    }

    public String getDataFilename() {
        return dataFilename;
    }

    public String getCacheName() {
        return cacheName;
    }

    public KeyProvider getKeyProvider() {
        return keyProvider;
    }

    public Type getType() {
        return type;
    }
}
