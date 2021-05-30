#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

struct Figure {
    int x, y;
    int width, height;
    Color borderColor, fillColor;
    void (*print) (struct Figure*);
};

typedef void (*Figure_Print) (struct Figure*);

struct Rectangle {
    Figure super;
};

Rectangle* Rectangle_New(int x, int y, int width, int height, Color borderColor, Color fillColor) {
    Rectangle* this = malloc(sizeof(Rectangle));
    Figure* super = (Figure*) this;

    super->x = x;
    super->y = y;
    super->width = width;
    super->height = height;
    super->borderColor = borderColor;
    super->fillColor = fillColor;
    super->print = (Figure_Print) Rectangle_Print;
}

void Rectangle_Print(Rectangle* this) {
    Figure* super = (Figure*) this;

    printf("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
           super->width, super->height, super->x, super->y);

    printf("Cor de borda: (%d, %d, %d). Cor de fundo: (%d, %d, %d).\n",
        super->borderColor.redColor, super->borderColor.greenColor, super->borderColor.blueColor,
        super->fillColor.redColor, super->fillColor.greenColor, super->fillColor.blueColor);
}

void Rectangle_Drag(Rectangle* this, int dx, int dy) {
    Figure* super = (Figure*) this;

    super->x += dx;
    super->y += dy;
}