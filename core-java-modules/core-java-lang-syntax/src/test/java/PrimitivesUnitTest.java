import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */

    public  class PrimitivesUnitTest {

        @Test
        public void whenModifyingPrimitives_thenOriginalValuesNotModified() {

            int x = 1;
            int y = 2;

            // Before Modification
            assertEquals(x, 1);
            assertEquals(y, 2);

            modify(x, y);

            // After Modification
            assertEquals(x, 1);
            assertEquals(y, 2);
        }

        public static void modify(int x1, int y1) {
            x1 = 5;
            y1 = 10;
        }
    }

