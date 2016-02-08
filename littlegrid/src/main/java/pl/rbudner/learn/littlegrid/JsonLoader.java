package pl.rbudner.learn.littlegrid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import pl.rbudner.learn.littlegrid.model.Entity;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JsonLoader {

    public NamedCache loadCache(Entity entity) throws IOException {
        NamedCache namedCache = CacheFactory.getCache(entity.getCacheName());
        List data = loadData(entity);
        KeyProvider keyProvider = entity.getKeyProvider();
        data.forEach(item -> namedCache.put(keyProvider.getKey(item), item));
        return namedCache;
    }

    private List loadData(Entity entity) throws IOException {
        Gson gson = new GsonBuilder().create();
        try (InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream(entity.getDataFilename()))) {
            return gson.fromJson(inputStreamReader, entity.getType());
        }
    }

}
