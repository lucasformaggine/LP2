typedef struct Color {
    int redColor, greenColor, blueColor;
} Color;

typedef struct Figure Figure;

typedef void (*Figure_Print) (struct Figure*);

typedef struct Rectangle Rectangle;

Rectangle* Rectangle_New(int, int, int, int, Color, Color);
void Rectangle_Print(Rectangle*);
void Rectangle_Drag(Rectangle*, int dx, int dy);