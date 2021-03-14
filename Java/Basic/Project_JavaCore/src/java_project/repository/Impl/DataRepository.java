package java_project.repository.Impl;

import java_project.repository.IDataRepository;

import java.util.List;

public class DataRepository<T> implements IDataRepository<T> {
    @Override
    public T add(List<T> list, T t) {
        list.add(t);
        return t;
    }
}
