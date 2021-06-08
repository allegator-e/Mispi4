package main.models;

public class PointDto {
    private Double x;
    private Double y;
    private Double r;
    private Boolean hit;

    public PointDto(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        setHit();
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit() {
        if (x>=0 && x<=r && y<=0 && y>=-r/2) this.hit = true;
        else if (x<=0 && y>=0 && x*x+y*y<=r*r) this.hit = true;
        else this.hit = (x >= 0 && y >= 0 && y <= -x + r / 2);
    }

    public Point toPoint() {
        return new Point(this.x, this.y, this.r, this.hit);
    }

    @Override
    public String toString() {
        return "PointDto{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", hit=" + hit +
                '}';
    }
}
