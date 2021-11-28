package edu.kravchenko.shape.repository;

import edu.kravchenko.shape.comparator.EllipseComparator;
import edu.kravchenko.shape.entity.Ellipse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository {
    private static final EllipseRepository INSTANCE = new EllipseRepository();
    private final List<Ellipse> storage = new ArrayList<>();

    private EllipseRepository() {
    }

    public EllipseRepository getInstance() {
        return INSTANCE;
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public void contains(Ellipse ellipse) {
        storage.contains(ellipse);
    }

    public Ellipse get(int index) {
        return storage.get(index);
    }

    public void set(int index, Ellipse ellipse) {
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
