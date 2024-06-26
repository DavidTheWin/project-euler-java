package org.dgreen.projecteuler.utils.grid;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    private static final Point middle = new Point(5, 5);
    private static final Point upperLeft = new Point(2, 2);

    @Test
    void canPrettyPrint() {
        assertThat(middle.toString()).isEqualTo("(5, 5)");
    }

    @Nested
    class Surface {
        @Test
        void theSamePointHasZeroSurface() {
            assertThat(middle.surfaceOfBlockTo(middle)).isEqualTo(0);
        }

        @Test
        void pointsOnALineHaveZeroSurface() {
            var zeroZero = new Point(0, 0);
            var zeroOne = new Point(0, 1);
            var oneZero = new Point(1, 0);

            assertThat(zeroZero.surfaceOfBlockTo(zeroOne)).isEqualTo(0);
            assertThat(zeroZero.surfaceOfBlockTo(oneZero)).isEqualTo(0);
        }

        @Test
        void surfaceOnePointAwayIsOne() {
            var zeroZero = new Point(0, 0);
            var oneOne = new Point(1, 1);

            assertThat(zeroZero.surfaceOfBlockTo(oneOne)).isEqualTo(1);
        }

        @Test
        void surfaceTwoPointsAwayIsFour() {
            var zeroZero = new Point(0, 0);
            var oneOne = new Point(2,2);

            assertThat(zeroZero.surfaceOfBlockTo(oneOne)).isEqualTo(4);
            assertThat(zeroZero.surfaceKey(oneOne)).isEqualTo("2x2");
        }
    }

    @Nested
    class GenerateQuads {
        @Test
        void canGenerateAllQuadPathsInTheMiddle() {
            var quads = middle.generateQuads(10, 10);

            assertThat(quads).hasSize(8);
        }

        @Test
        void canGenerateAllQuadPathsInACorner() {
            var quads = new Point(0, 0).generateQuads(10, 10);

            assertThat(quads).hasSize(3);
        }
    }

    @Nested
    class GoingUp {
        @Test
        void canCreateAListOfPointsGoingUp() {
            var upGroup = middle.upGroup();

            assertThat(upGroup.isPresent()).isTrue();
            assertThat(upGroup.get().d()).isEqualTo(new Point(5, 2));
        }

        @Test
        void doesNotGoUpIfItWouldGoOutOfBounds() {
            var upGroup = upperLeft.upGroup();

            assertThat(upGroup.isEmpty()).isTrue();
        }
    }

    @Nested
    class GoingDown {
        @Test
        void canCreateAListOfPointsGoingDown() {
            var downGroup = middle.downGroup(10);

            assertThat(downGroup.isPresent()).isTrue();
            assertThat(downGroup.get().d()).isEqualTo(new Point(5, 8));
        }

        @Test
        void doesNotGoDownIfItWouldGoOutOfBounds() {
            var downGroup = upperLeft.downGroup(4);
            assertThat(downGroup.isEmpty()).isTrue();

            var downOne = middle.down(5);
            assertThat(downOne).isEmpty();
        }

        @Test
        void canReturnTheNextPointDown() {
            var downOne = middle.down(10);
            assertThat(downOne.isPresent()).isTrue();
            assertThat(downOne.get()).isEqualTo(new Point(5, 6));
        }
    }

    @Nested
    class GoingLeft {
        @Test
        void canCreateAListOfPointsGoingLeft() {
            var leftGroup = middle.leftGroup();

            assertThat(leftGroup.isPresent()).isTrue();
            assertThat(leftGroup.get().d()).isEqualTo(new Point(2, 5));
        }

        @Test
        void doesNotGoLeftIfItWouldGoOutOfBounds() {
            var leftGroup = upperLeft.leftGroup();

            assertThat(leftGroup.isEmpty()).isTrue();
        }
    }

    @Nested
    class GoingRight {
        @Test
        void canCreateAListOfPointsGoingRight() {
            var rightGroup = middle.rightGroup(10);

            assertThat(rightGroup.isPresent()).isTrue();
            assertThat(rightGroup.get().d()).isEqualTo(new Point(8, 5));
        }

        @Test
        void doesNotGoRightIfItWouldGoOutOfBounds() {
            var rightGroup = upperLeft.rightGroup(4);
            assertThat(rightGroup.isEmpty()).isTrue();

            var rightOne = middle.right(5);
            assertThat(rightOne).isEmpty();
        }

        @Test
        void canReturnTheNextPointRight() {
            var rightOne = middle.right(10);
            assertThat(rightOne.isPresent()).isTrue();
            assertThat(rightOne.get()).isEqualTo(new Point(6, 5));
        }
    }

    @Nested
    class GoingNe {
        @Test
        void canCreateAListOfPointsGoingNe() {
            var neGroup = middle.neGroup(10);

            assertThat(neGroup.isPresent()).isTrue();
            assertThat(neGroup.get().d()).isEqualTo(new Point(8, 2));
        }

        @Test
        void doesNotGoNeIfItWouldGoOutOfBounds() {
            var neGroup = upperLeft.neGroup(4);

            assertThat(neGroup.isEmpty()).isTrue();
        }
    }

    @Nested
    class GoingSe {
        @Test
        void canCreateAListOfPointsGoingSe() {
            var seGroup = middle.seGroup(10, 10);

            assertThat(seGroup.isPresent()).isTrue();
            assertThat(seGroup.get().d()).isEqualTo(new Point(8, 8));
        }

        @Test
        void doesNotGoSeIfItWouldGoOutOfBounds() {
            var seGroup = upperLeft.seGroup(4, 4);

            assertThat(seGroup.isEmpty()).isTrue();
        }
    }

    @Nested
    class GoingSw {
        @Test
        void canCreateAListOfPointsGoingSw() {
            var swGroup = middle.swGroup(10);

            assertThat(swGroup.isPresent()).isTrue();
            assertThat(swGroup.get().d()).isEqualTo(new Point(2, 8));
        }

        @Test
        void doesNotGoSwIfItWouldGoOutOfBounds() {
            var swGroup = upperLeft.swGroup(4);

            assertThat(swGroup.isEmpty()).isTrue();
        }
    }

    @Nested
    class GoingNw {
        @Test
        void canCreateAListOfPointsGoingNw() {
            var nwGroup = middle.nwGroup();

            assertThat(nwGroup.isPresent()).isTrue();
            assertThat(nwGroup.get().d()).isEqualTo(new Point(2, 2));
        }

        @Test
        void doesNotGoNwIfItWouldGoOutOfBounds() {
            var nwGroup = upperLeft.nwGroup();

            assertThat(nwGroup.isEmpty()).isTrue();
        }
    }
}
