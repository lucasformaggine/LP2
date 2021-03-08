#include <stdio.h>

typedef struct {
    double xCentral;
    double yCentral;
    double turns;
    double divergence;
    double innerRadius;
} Spiral;

void Print(Spiral* sp);


int main() {
    Spiral sp = {2, 2, 1.5, 3.5, 0.4};
    Print(&sp);
}


void Print(Spiral* sp) {
    printf("O espiral esta centrado no ponto (%.3lf, %.3lf).\n", sp->xCentral, sp->yCentral);
    printf("Ele da %.3lf voltas, tem %.3lf de divergencia e seu raio interno e %.3lf.\n", sp->turns, sp->divergence, sp->innerRadius);
}
