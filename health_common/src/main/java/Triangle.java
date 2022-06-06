public class Triangle {
    public static void main(String[] args) {
        triangle(2, 3, 4);
        triangle(2, 3, 3);
        triangle(3, 4, 5);
        triangle(-1, -2, -2);
        triangle(3, 3, 3);

    }
    public static void triangle(double a, double b, double c) {
        // 三角形判定
        if (isTriAngle(a, b, c)) {
            if (a == b & b == c) {
                System.out.println("等边三角形");
            } else {
                boolean b1 = a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
                if ((a == b || b == c || a == c) && b1) {
                    System.out.println("等腰直角三角形");
                } else if (a == b || b == c || a == c) {
                    System.out.print("等腰三角形");
                } else if (b1) {
                    System.out.println("直角三角形");
                } else {
                    System.out.println("普通三角形");
                }
            }
        }

    }
    private static boolean isTriAngle(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("不是三角形");
            return false;
        }
        System.out.print("三角形--->进一步判定--->");
        return true;
    }
}