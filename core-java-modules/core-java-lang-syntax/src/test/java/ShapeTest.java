import org.junit.Test;
import www.tom.com.oop.interfaceclass.polymorphism.Circle;
import www.tom.com.oop.interfaceclass.polymorphism.Shape;
import www.tom.com.oop.interfaceclass.polymorphism.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class ShapeTest {
    @Test

    public void test(){
        List<Shape> shapes = new ArrayList<>();
        Shape circleShape = new Circle();
        Shape squareShape = new Square();

        shapes.add(circleShape);
        shapes.add(squareShape);

        for (Shape shape : shapes) {
            System.out.println(shape.name());
        }
    }
}
