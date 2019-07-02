package pl.rbudner.learn.littlegrid;

import com.tangosol.net.NamedCache;
import org.littlegrid.ClusterMemberGroup;
import org.littlegrid.ClusterMemberGroupUtils;
import pl.rbudner.learn.littlegrid.exercise.FilterExcercise;
import pl.rbudner.learn.littlegrid.model.Entity;

import java.io.IOException;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Application {

    private static final int NODES = 2;
    private final ClusterMemberGroup memberGroup;

    private Application() {
        memberGroup = ClusterMemberGroupUtils.newBuilder()
                .setAdditionalSystemProperty("tangosol.coherence.management", "all")
                .setStorageEnabledCount(NODES)
                .buildAndConfigureForStorageDisabledClient();
    }

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.instantiateAllCaches();
        app.runAllExercises();
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
    }

    public static void printSet(Set set) {
        set.forEach(System.out::println);
    }

    private void instantiateAllCaches() throws IOException {
        printCacheSize(new JsonLoader().loadCache(Entity.PERSON));
    }

    private void runAllExercises() {
        // TODO-RB: execute by getting all annotated classes from package pl.rbudner.learn.littlegrid.exercise
        new FilterExcercise().run();
    }

    private void printCacheSize(NamedCache cache) {
        System.out.println("W cache-u " + cache.getCacheName() + " jest " + cache.size() + " elementów.");
    }

}
