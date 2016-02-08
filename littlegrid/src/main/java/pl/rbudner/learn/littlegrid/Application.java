package pl.rbudner.learn.littlegrid;

import com.tangosol.net.NamedCache;
import org.littlegrid.ClusterMemberGroup;
import org.littlegrid.ClusterMemberGroupUtils;
import pl.rbudner.learn.littlegrid.model.Entity;

import java.io.IOException;

public class Application {

    public static final int NODES = 2;
    private static ClusterMemberGroup memberGroup;

    public static void main(String[] args) throws IOException {
        memberGroup = ClusterMemberGroupUtils.newBuilder().setStorageEnabledCount(NODES).buildAndConfigureForStorageDisabledClient();
        NamedCache personCache = new JsonLoader().loadCache(Entity.PERSON);
        System.out.println(personCache.size());
    }

}
