package isp.lab3.exercise2;

public class Exercise2 {
    public static class Rectangle {
        private int length = 2;
        private int width = 1;
        private String color = "red";

        public Rectangle(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public Rectangle(int length, int width, String color) {
            this.length = length;
            this.width = width;
            this.color = color;
        }

        public int getLength() {
            return length;
        }

        public int getWidth() {
            return width;
        }

        public String getColor() {
            return color;
        }

        public int getPerimeter(int width, int length) {
            return width + length;
        }

        public int getArea(int width, int length) {
            return width * length;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "length=" + getLength() +
                    ", width=" + getWidth() +
                    ", color='" + getColor() + "'" +
                    ", perimeter=" + getPerimeter(width, length) +
                    ", area=" + getArea(width, length) + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(3, 4);
        System.out.println(rectangle1);
        Rectangle rectangle2 = new Rectangle(8, 11, "blue");
        System.out.println(rectangle2);
    }
}
