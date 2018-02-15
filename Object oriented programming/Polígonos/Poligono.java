import java.util.ArrayList;

public class Poligono
{
	// atributos
	private ArrayList<Punto> puntos;

	// constructores
	public Poligono(ArrayList<Punto> puntos)
	{
		this.puntos = puntos;
	}

	// sets
	private void setPuntos(ArrayList<Punto> puntos)
	{
		this.puntos = puntos;
	}

	// gets
	public ArrayList<Punto> getPuntos()
	{
		return puntos;
	}

	// metodos varios
	public void mover(double x, double y)
	{
		for(Punto punto : puntos)
		{
			punto.mover(x, y);
		}
	}
	public double calcularPerimetro()
	{
		double perimetro = 0;
		for(int i = 0; i < puntos.size(); i++)
		{
			Linea linea;
			if(i == puntos.size() - 1)
			{
				linea = new Linea(puntos.get(i), puntos.get(0));

			}
			else
			{
				linea = new Linea(puntos.get(i), puntos.get(i+1));
			}
			perimetro += linea.calcularLongitud();
		}
		return perimetro;
	}
	public String toString()
	{
		String cadena = "";
		for(int i = 0; i < puntos.size(); i++)
		{
			if(i == 0)
			{
				cadena += puntos.get(i).toString();
			}
			else
			{
				cadena += ", " + puntos.get(i).toString();
			}
		}
		return cadena;
	}
}