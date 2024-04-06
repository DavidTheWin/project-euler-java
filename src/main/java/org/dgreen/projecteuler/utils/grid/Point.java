package org.dgreen.projecteuler.utils.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record Point(int x, int y) {
    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    public int surfaceOfBlockTo(Point other) {
        return (other.x - x) * (other.y - y);
    }

    public String surfaceKey(Point other) {
        return ( other.x - x) + "x" + (other.y - y);
    }

    public Optional<Point> down(int yMax) {
        if (y + 1 > yMax) {
            return Optional.empty();
        } else {
            return Optional.of(new Point(x, y + 1));
        }
    }

    public Optional<Point> right(int xMax) {
        if (x + 1 > xMax) {
            return Optional.empty();
        } else {
            return Optional.of(new Point(x + 1, y ));
        }
    }

    public List<PointQuad> generateQuads(int xMax, int yMax) {
        var groups = new ArrayList<PointQuad>();

        upGroup().ifPresent(groups::add);
        downGroup(yMax).ifPresent(groups::add);
        leftGroup().ifPresent(groups::add);
        rightGroup(xMax).ifPresent(groups::add);
        neGroup(xMax).ifPresent(groups::add);
        seGroup(xMax, yMax).ifPresent(groups::add);
        swGroup(yMax).ifPresent(groups::add);
        nwGroup().ifPresent(groups::add);

        return groups;
    }

    public Optional<PointQuad> upGroup() {
        if (y - PointQuad.INDEX_MAX_CHANGE < 0) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x, y - 1),
                    new Point(x, y - 2),
                    new Point(x, y - 3)
            ));
        }
    }

    public Optional<PointQuad> downGroup(int yMax) {
        if (y + PointQuad.INDEX_MAX_CHANGE > yMax) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x, y + 1),
                    new Point(x, y + 2),
                    new Point(x, y + 3)
            ));
        }
    }

    public Optional<PointQuad> leftGroup() {
        if (x - PointQuad.INDEX_MAX_CHANGE < 0) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x - 1, y),
                    new Point(x - 2, y),
                    new Point(x - 3, y)
            ));
        }
    }

    public Optional<PointQuad> rightGroup(int xMax) {
        if (x + PointQuad.INDEX_MAX_CHANGE > xMax) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x + 1, y),
                    new Point(x + 2, y),
                    new Point(x + 3, y)
            ));
        }
    }

    public Optional<PointQuad> neGroup(int xMax) {
        if (x + PointQuad.INDEX_MAX_CHANGE > xMax || y - PointQuad.INDEX_MAX_CHANGE < 0) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x + 1, y - 1),
                    new Point(x + 2, y - 2),
                    new Point(x + 3, y - 3)
            ));
        }
    }

    public Optional<PointQuad> seGroup(int xMax, int yMax) {
        if (x + PointQuad.INDEX_MAX_CHANGE > xMax || y + PointQuad.INDEX_MAX_CHANGE > yMax) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x + 1, y + 1),
                    new Point(x + 2, y + 2),
                    new Point(x + 3, y + 3)
            ));
        }
    }

    public Optional<PointQuad> swGroup(int yMax) {
        if (x - PointQuad.INDEX_MAX_CHANGE < 0 || y + PointQuad.INDEX_MAX_CHANGE > yMax) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x - 1, y + 1),
                    new Point(x - 2, y + 2),
                    new Point(x - 3, y + 3)
            ));
        }
    }

    public Optional<PointQuad> nwGroup() {
        if (x - PointQuad.INDEX_MAX_CHANGE < 0 || y - PointQuad.INDEX_MAX_CHANGE < 0) {
            return Optional.empty();
        } else {
            return Optional.of(new PointQuad(
                    new Point(x, y),
                    new Point(x - 1, y - 1),
                    new Point(x - 2, y - 2),
                    new Point(x - 3, y - 3)
            ));
        }
    }
}
