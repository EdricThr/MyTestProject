package com.THR.ThinkingInJava.��̬;

/**
 * ���Զ�̬�£��������еķ������в�ͬ�����
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
