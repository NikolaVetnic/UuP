class SistemJednacina {
  public static void main(String[] args) {
    Svetovid.out.print("Unesite koeficijente prve jednacine: ");
    double a1 = Svetovid.in.readDouble(), 
           b1 = Svetovid.in.readDouble(), 
           c1 = Svetovid.in.readDouble();

    Svetovid.out.print("Unesite koeficijente druge jednacine: ");
    double a2 = Svetovid.in.readDouble(), 
           b2 = Svetovid.in.readDouble(), 
           c2 = Svetovid.in.readDouble();
    
    double d = a1 * b2 - a2 * b1,
           dx = c1 * b2 - c2 * b1,
           dy = a1 * c2 - a2 * c1;
    
    if (d != 0) {
      Svetovid.out.println("Resenja jednacine su: x = " + (d / dx) + ", y = " + (d / dy) + ".");
    }
    else if (dx == 0 && dy == 0) {
      Svetovid.out.println("Sistem jednacina je neodredjen.");
    }
    else {
      Svetovid.out.println("Sistem jednacina je protivrecan.");
    }
  }
}