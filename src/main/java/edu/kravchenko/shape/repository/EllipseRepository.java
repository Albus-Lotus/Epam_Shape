package edu.kravchenko.shape.repository;

import edu.kravchenko.shape.comparator.EllipseComparator;
import edu.kravchenko.shape.entity.Ellipse;
import edu.kravchenko.shape.exception.EllipseException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository {
    private static final EllipseRepository INSTANCE = new EllipseRepository();
    private final List<Ellipse> storage = new ArrayList<>();

    private EllipseRepository() {
    }

    public static EllipseRepository getInstance() {
        return INSTANCE;
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public boolean contains(Ellipse ellipse) {
        return storage.contains(ellipse);
    }

    public Ellipse get(int index) throws EllipseException {
        if (index < 0 || index >= storage.size()) {
            throw new EllipseException("Invalid index");
        }
        return storage.get(index);
    }

    public void set(int index, Ellipse ellipse) throws EllipseException {
        if (index < 0 || index >= storage.size()) {
            throw new EllipseException("Invalid index");
        }
        storage.set(index, ellipse);
    }

    public void add(Ellipse ellipse) {
        storage.add(ellipse);
    }

    public void remove(Ellipse ellipse) {
        storage.remove(ellipse);
    }

    public void clear() {
        storage.clear();
    }

    public List<Ellipse> sort(EllipseComparator comparator) {
        return storage.stream().
                sorted(comparator).
                collect(Collectors.toList());
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        return storage.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }
}
