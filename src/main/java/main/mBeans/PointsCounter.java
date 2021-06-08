package main.mBeans;

import main.models.Point;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

@Component
public class PointsCounter extends NotificationBroadcasterSupport implements PointsCounterMBean {
    private int allPoints;
    private int inArea;
    private int sequenceNumber;

    public void addPoint(Point point) {
        allPoints++;
        if (point.getHit()) inArea++;
        if (allPoints % 15 == 0) {
            sendNotification(new Notification("Notification!", this,
                    sequenceNumber++, System.currentTimeMillis(), "The number of set points is a multiple of 15"));
        }
    }

    @Override
    public int getAllPoints() {
        return allPoints;
    }

    @Override
    public int getInArea() {
        return inArea;
    }
}
