package dummyapp.miranda.william.rxpoc.framework;

import io.realm.Realm;

public class ResourceManager implements IResourceManager {

    private Realm realm;

    public ResourceManager(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void closeRealmResources() {
        this.realm.close();
    }
}
