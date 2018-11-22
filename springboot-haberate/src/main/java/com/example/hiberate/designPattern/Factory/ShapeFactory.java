package com.example.hiberate.designPattern.Factory;

import com.example.hiberate.designPattern.Circle;
import com.example.hiberate.designPattern.Rectangle;
import com.example.hiberate.designPattern.Shape;
import com.example.hiberate.designPattern.Square;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
