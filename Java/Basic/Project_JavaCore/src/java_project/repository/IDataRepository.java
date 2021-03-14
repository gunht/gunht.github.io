package java_project.repository;

import java.util.List;

public interface IDataRepository<T> {
    T add(List<T> list, T t);
}
