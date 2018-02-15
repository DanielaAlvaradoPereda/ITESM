class ClaseGenerica<T>
{
	T obj;

	public ClaseGenerica(T o)
	{
		obj = o;
	}

	public void classType()
	{
		System.out.println("El tipo de T es " + obj.getClass().getName());
	}
}