import java.util.*;

public class Repository_13<T> {
    private List<T> data = new ArrayList<>();

    public void save(T item) {
        data.add(item);
    }

    @SafeVarargs
    public final void saveAll(T... items) {
        for (T item : items)
            save(item);
    }

    public T findById(String id) {
        for (T item : data) {
            if (item instanceof Account_13) {
                Account_13 a = (Account_13) item;
                if (a.getId().equalsIgnoreCase(id))
                    return item;
            }
        }
        return null;
    }

    public List<T> findAll() {
        return data;
    }

    public int size() {
        return data.size();
    }
}