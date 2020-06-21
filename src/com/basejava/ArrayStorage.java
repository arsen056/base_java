package com.basejava; /**
 * Array based storage for Resumes
 */
import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResume = 0; // after this index, the array contains zeros

    void clear() {
        for (int i = 0; i < countResume; i++) {
            storage[i] = null;
        }
        countResume = 0;
    }

    void save(Resume r) {
        storage[countResume] = r;                           // adding to the array Resume
        countResume++;
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i = 0; i <= countResume; i++) {
            if (storage[i].toString().equals(uuid)) {
                r = storage[i];
                break;
            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i = 0; i < countResume; i++) {             // iterate elements to null
            if (storage[i].toString().equals(uuid)) {       // string comparison
                for (int j = i; j < countResume - 1; j++) {
                    storage[j] = storage [j + 1];           // offset of array elements by one
                }
                storage[countResume] = null;                // delete last item
                // this expression prevents the countResume from becoming negative
                storage[countResume] = null;
                countResume--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    int size() {
        return countResume;
    }
}