package com.basejava; /**
 * Array based storage for Resumes
 */
import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
        notNull = 0;
    }

    int notNull = 0; // after this index, the array contains zeros
    void save(Resume r) {
        for (; notNull < storage.length; notNull++) {
            if (storage[notNull] == null) {             // array check for null
                storage[notNull] = r;                   // adding to the array Resume
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
        for (int i = 0; i <= notNull; i++) {            // iterate elements to null
            if (storage[i].toString().equals(uuid)) {   // string comparison
                storage[i] = null;                      // delete Resume
                for (int j = i; j < notNull; j++) {
                    storage[j] = storage [j + 1];       // offset of array elements by one
                }
                storage[notNull] = null;                // delete last item
                // this expression prevents the notNull from becoming negative
                if (notNull == 0) {
                    notNull = 0;
                } else {
                    notNull--;
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (storage[0] == null) {
            return new com.basejava.Resume[0];
        } else {
            return Arrays.copyOf(storage, notNull + 1);
        }
    }

    int size() {
        if (storage[0] == null) {
            return 0;
        } else {
            return notNull + 1;
        }
    }
}
