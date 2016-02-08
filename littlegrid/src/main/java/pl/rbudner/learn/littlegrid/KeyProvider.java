package pl.rbudner.learn.littlegrid;

@FunctionalInterface
public interface KeyProvider<K, V>  {

    K getKey(V value);

}
