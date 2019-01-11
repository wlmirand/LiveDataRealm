package dummyapp.miranda.william.rxpoc.framework;

public interface IRepository<T> {

    void add(T t);
    LiveRealmResults<Bla> getAll();
}
