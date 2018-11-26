package com.THR.ThinkingInJava.多态;

/**
 * 测试多态下，构造器中的方法会有不同的输出
 */
public class PolyConstructrors {


    static class Glyph {
        void draw() {
            System.out.println("Glyph draw()");
        }
        Glyph() {
            System.out.println(" Glyph() before draw() ");
            draw();
            System.out.println(" Glyph() after draw() ");
        }
    }
    static class RoundGlyph extends Glyph {
        private int radius = 1;
        RoundGlyph(int r) {
            radius = r;
            System.out.println("RoundGlyph.deaw(), radius = " + radius);
        }
        void draw() {
            System.out.println("RoundGlyph.draw().radius = " + radius);
        }
    }

    public static void main(String args[]){
        RoundGlyph roundGlyph = new RoundGlyph(5);
    }
}
