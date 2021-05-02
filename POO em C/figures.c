#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int redColor, greenColor, blueColor;
} Color;

typedef struct {
    int x, y;
    int width, height;
    Color borderColor, fillColor;
    void (*print) (struct Figure*);
} Figure;

typedef struct {
    Figure super;
} Ellipse;

typedef struct {
    Figure super;
} Triangle;

Triangle* Triangle_New(int, int, int, int, Color, Color);
Ellipse* Ellipse_New(int, int, int, int, Color, Color);
void Triangle_Print(Triangle*);
void Ellipse_Print(Ellipse*);


int main() {
    Color red = {255, 0, 0};
    Color green = {0, 255, 0};
    Color blue = {0, 0, 255};
    Color black = {0, 0, 0};

    Figure* figures[2] = {
        (Figure*) Ellipse_New(20, 30, 40, 50, red, green),
        (Figure*) Triangle_New(20, 30, 40, 50, blue, black)
    };

    for (int i = 0; i < 2; i++) {
        figures[i]->print(figures[i]);
    }

    for (int i = 0; i < 2; i++) {
        free(figures[i]);
    }

    return 0;
}


Ellipse* Ellipse_New(int x, int y, int width, int height, Color borderColor, Color fillColor) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* super = (Figure*) this;

    super->x = x;
    super->y = y;
    super->width = width;
    super->height = height;
    super->borderColor = borderColor;
    super->fillColor = fillColor;
    super->print = Ellipse_Print;
}

void Ellipse_Print(Ellipse* this) {
    Figure* super = (Figure*) this;

    printf("Elipse de tamanho (%d, %d) na posicao (%d, %d).\n",
           super->width, super->height, super->x, super->y);

    printf("Cor de borda: (%d, %d, %d). Cor de fundo: (%d, %d, %d).\n",
        super->borderColor.redColor, super->borderColor.greenColor, super->borderColor.blueColor,
        super->fillColor.redColor, super->fillColor.greenColor, super->fillColor.blueColor);
}


Triangle* Triangle_New(int x, int y, int width, int height, Color borderColor, Color fillColor) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* super = (Figure*) this;

    super->x = x;
    super->y = y;
    super->width = width;
    super->height = height;
    super->borderColor = borderColor;
    super->fillColor = fillColor;
    super->print = Triangle_Print;
}

void Triangle_Print(Triangle* this) {
    Figure* super = (Figure*) this;

    printf("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
        super->x, super->y, super->x, super->y + super->height, super->x + super->width, super->y + super->height);

    printf("Cor de borda: (%d, %d, %d). Cor de fundo: (%d, %d, %d).\n",
        super->borderColor.redColor, super->borderColor.greenColor, super->borderColor.blueColor,
        super->fillColor.redColor, super->fillColor.greenColor, super->fillColor.blueColor);
}
