package isp.lab3.exercise1;

public class Exercise1 {
    public static class Tree {
        private int height;

        public Tree() {
            this.height = 15;
        }

        public Tree(int height) {
            this.height = height;
        }

        public int grow(int meters) {
            if (meters >= 1) {
                height = height + meters;
            }
            return height;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) {
        Tree stejar = new Tree();
        System.out.println("Inaltime initiala:" + stejar.toString());
        stejar.grow(10);
        System.out.println("Inaltime finala:" + stejar.toString());
    }
}
