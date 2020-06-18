package com.basejava; /**
 * Array based storage for Resumes
 */
import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[5];

    void clear() {
        Arrays.fill(storage, null);
        notNull = 0;
    }

    int notNull = 0;
    void save(Resume r) {
        for (; notNull < storage.length; notNull++) {
            if (storage[notNull] == null) {
                storage[notNull] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i = 0; i <= (notNull); i++) {
            if (storage[i].toString().equals(uuid)) {
                r = storage[i];
                break;
            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i = 0; i <= (notNull); i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
                for (int j = i; j < notNull; j++) {
                    storage[j] = storage [j + 1];
                }
                storage[notNull] = null;
                notNull--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        // return new com.basejava.Resume[0];
        // return Arrays.copyOf(storage, notNull + 1);
        return storage;
    }

    int size() {
        if (storage[0] == null) {
            return 0;
        } else {
            return notNull + 1;
        }
    }
}
