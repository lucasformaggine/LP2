class Text {
    int x, y;
    int r, g, b;
    int size;
    double rotation;
    String fontFamily;
    String fontStyle;

    Text(int x, int y, int r, int g, int b, int size, double rotation, String fontFamily, String fontStyle) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.size = size;
        this.rotation = rotation;
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
    }

    void Print() {
        System.out.format("O texto se inicia no ponto (%d, %d), a coloracao RGB e do tipo [%d, %d, %d]\n", this.x, this.y, this.r, this.g, this.b);
        System.out.format("O tamanho e de %d pt. A rotacao e de angulacao %.2f graus.\n", this.size, this.rotation);
        System.out.format("A familia de fontes eh a %s. O estilo da fonte e %s.", this.fontFamily, this.fontStyle);
    }
}

public class ClassTextApp {
    public static void main(String[] args) {
        Text t = new Text(0, 0, 255, 255, 255, 36, 0, "Comic Sans", "Normal");
        t.Print();
    }
}