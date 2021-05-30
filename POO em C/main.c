#include <stdlib.h>
#include "rect.h"

void main (void) {
    Color black = {0, 0, 0};
    Color white = {255, 255, 255};

    Rectangle* r1 = Rectangle_New(20, 20, 30, 30, black, white);
    Rectangle_Print(r1);

    Rectangle* r2 = Rectangle_New(20, 20, 30, 30, black, white);
    Rectangle_Drag(r2, 10, 100);
    Rectangle_Print(r2);

    free(r1);
    free(r2);
}