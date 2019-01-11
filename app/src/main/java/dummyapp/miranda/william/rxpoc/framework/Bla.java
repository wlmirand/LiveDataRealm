package dummyapp.miranda.william.rxpoc.framework;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Bla extends RealmObject {

    @PrimaryKey
    private long id;

    private String name;

    public Bla() {

    }

    public Bla(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
