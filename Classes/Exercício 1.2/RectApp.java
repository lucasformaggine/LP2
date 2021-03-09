public class RectApp {
    public static void main(String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
        r1.Print();
        System.out.format("Area do retangulo: %d\n", r1.Area());
        r1.Drag(5, 5);
        r1.Print();
    }
}
class Rect {
    int x, y;
    int w, h;

    Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void Print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    int Area() {
        return this.w * this.h;
    }

    void Drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}