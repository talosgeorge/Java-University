package isp.lab3.exercise4;

public class Exercise4 {
    public static class MyPoint {
        int x;
        int y;
        int z;

        public MyPoint() {
            this.x = 0;
            this.y = 0;
            this.z = 0;
        }

        public MyPoint(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        public void setXYZ(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + "," + z + ") ";
        }

        public double distance(int x, int y, int z) {
            int dx = this.x - x;
            int dy = this.y - y;
            int dz = this.z - z;
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }

        public double distance(MyPoint another) {
            int dx = this.x - another.x;
            int dy = this.y - another.y;
            int dz = this.z - another.z;
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }
    }

    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(4, 8, 1);
        MyPoint point2 = new MyPoint(3, 5, 2);
        System.out.println("Distance between point1 " + point1 + "and point2 " + point2 + "is:" + point1.distance(point2));
    }
}

