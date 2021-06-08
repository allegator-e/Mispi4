package main.mBeans;

import main.models.Point;
import org.springframework.stereotype.Component;

@Component
public class AreaFigure implements AreaFigureMBean {
    private double area;

    public void setArea(Point point) {
        double r = point.toPointDto().getR();
        area = r*r/2 + r*r/8 + Math.PI*r*r/4;
    }

    @Override
    public double getArea() {
        return area;
    }
}
