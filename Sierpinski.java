/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }

    // Draws a Sierpinski triangle of depth n on the standard canvass.
    public static void sierpinski(int n) {
        StdDraw.setCanvasSize(700, 700);
        StdDraw.setScale(0.0, 1.0);
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);

        double side = 0.90;
        double xLeft = 0.05;
        double xRight = xLeft + side;
        double yBottom = 0.05;

        double height = Math.sqrt(3) / 2.0 * side;

        double x1 = (xLeft + xRight) / 2.0;
        double y1 = yBottom + height;

        double x2 = xLeft;
        double y2 = yBottom;

        double x3 = xRight;
        double y3 = yBottom;

        sierpinski(n, x1, x2, x3, y1, y2, y3);
    }

    // Does the actual drawing, recursively.
    private static void sierpinski(int n, double x1, double x2, double x3,
                                   double y1, double y2, double y3) {

        if (n == 0) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(x1, y1, x2, y2);
            StdDraw.line(x2, y2, x3, y3);
            StdDraw.line(x3, y3, x1, y1);
            return;
        }

        double mx12 = (x1 + x2) / 2.0;
        double my12 = (y1 + y2) / 2.0;

        double mx23 = (x2 + x3) / 2.0;
        double my23 = (y2 + y3) / 2.0;

        double mx31 = (x3 + x1) / 2.0;
        double my31 = (y3 + y1) / 2.0;

        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.line(mx12, my12, mx23, my23);
        StdDraw.line(mx23, my23, mx31, my31);
        StdDraw.line(mx31, my31, mx12, my12);

        sierpinski(n - 1, x1,  mx12, mx31, y1,  my12, my31);
        sierpinski(n - 1, mx12, x2,  mx23, my12, y2,  my23);
        sierpinski(n - 1, mx31, mx23, x3,  my31, my23, y3);
    }
}
