package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.StringUtils;
import org.dgreen.projecteuler.utils.grid.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem15 {
    public static long numberOfRoutesThroughGrid(int gridSize) {
        var startPoint = new Point(0, 0);
        var endPoint = new Point(gridSize, gridSize);
        var pathsByBlock = new HashMap<String, Long>();

        return recurseThroughBlocks(pathsByBlock, startPoint, endPoint);
    }

    private static long recurseThroughBlocks(
            Map<String, Long> pathsByBlock,
            Point currentPoint,
            Point endPoint
    ) {
        var surface = currentPoint.surfaceOfBlockTo(endPoint);
        if (surface == 0) {
            return  1;
        }

        var blockSize = 0L;
        var blockKey = currentPoint.surfaceKey(endPoint);
        var blockKeyReversed = StringUtils.reverse(blockKey);

        if (pathsByBlock.containsKey(blockKeyReversed)) {
            return pathsByBlock.get(blockKeyReversed);
        }

        if (!pathsByBlock.containsKey(blockKey)) {
            var right = currentPoint.right(endPoint.x());
            var down = currentPoint.down(endPoint.y());

            if (right.isPresent()) {
                blockSize += recurseThroughBlocks(pathsByBlock, right.get(), endPoint);
            }
            if (down.isPresent()) {
                blockSize += recurseThroughBlocks(pathsByBlock, down.get(), endPoint);
            }

            pathsByBlock.put(blockKey, blockSize);
        }

        return pathsByBlock.get(blockKey);
    }

    // initial naive implementation
    private static long numberOfRoutes = 0;

    public static long numberOfRoutesThroughGridByTraversal(int gridSize) {
        var currentRoute = new Stack<Point>();
        currentRoute.push(new Point(0, 0));
        var endPoint = new Point(gridSize, gridSize);

        nextMove(currentRoute, gridSize, endPoint);

        return numberOfRoutes;
    }

    private static void nextMove(
            Stack<Point> currentRoute,
            int bound,
            Point endPoint
    ) {
        var currentPoint = currentRoute.peek();

        if (currentPoint.equals(endPoint)) {
            currentRoute.pop();
            numberOfRoutes++;
            return;
        }

        var right = currentPoint.right(bound);
        var down = currentPoint.down(bound);

        if (right.isPresent()) {
            currentRoute.push(right.get());
            nextMove(currentRoute, bound, endPoint);

            if (down.isEmpty()) {
                currentRoute.pop();
            }
        }
        if (down.isPresent()) {
            currentRoute.push(down.get());
            nextMove(currentRoute, bound, endPoint);

            currentRoute.pop();
        }
    }
}
