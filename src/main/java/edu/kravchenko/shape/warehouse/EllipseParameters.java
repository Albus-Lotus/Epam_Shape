package edu.kravchenko.shape.warehouse;

public class EllipseParameters {
    private double area;
    private double perimeter;

    public EllipseParameters() {
    }

    public EllipseParameters(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EllipseParameters)) return false;
        EllipseParameters that = (EllipseParameters) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(area);
        result = 31 * result + Double.hashCode(perimeter);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EllipseParameters{");
        sb.append("area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append("}");
        return sb.toString();
    }
}
