package pl.rbudner.learn.littlegrid.exercise;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.filter.EqualsFilter;
import pl.rbudner.learn.littlegrid.Application;
import pl.rbudner.learn.littlegrid.model.Entity;
import pl.rbudner.learn.littlegrid.model.Gender;

import java.util.Set;

public class FilterExcercise implements Runnable {

    @Override
    public void run() {
        NamedCache personCache = CacheFactory.getCache(Entity.PERSON.getCacheName());
        EqualsFilter<String, String> equalsFilter = new EqualsFilter<>("getGender", Gender.FEMALE.getGender());
        Set females = personCache.entrySet(equalsFilter);
        System.out.println(equalsFilter);
        Application.printSet(females);

        //ReflectionExtractor
    }

}
