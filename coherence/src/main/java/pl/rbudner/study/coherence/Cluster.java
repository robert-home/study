package pl.rbudner.study.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;

public class Cluster {

    public static void main(String[] args) throws IOException {
        NamedCache currencyCache = CacheFactory.getCache("currency");
        currencyCache.put("USD", new Ccy("US Dollar", 4));
        currencyCache.put("PLN", new Ccy("Polish Zloty", 1));
        currencyCache.put("GBP", new Ccy("UK Pound", 5));
        ((Ccy) currencyCache.get("GBP")).setDate(GregorianCalendar.getInstance().getTime());
        System.out.println("coherence study started");
        Set<Map.Entry> entrySet = currencyCache.entrySet(null, null);
        for (Map.Entry entry : entrySet) {
            System.out.println(entry.getKey() + "[" + entry.getValue() + "]");
        }
    }

}
