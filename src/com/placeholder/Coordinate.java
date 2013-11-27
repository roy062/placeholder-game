package com.placeholder;

public class Coordinate
{
	private float x, y;
	
	public Coordinate()
	{
		x = 0;
		y = 0;
	}
	
	public Coordinate(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public void incX(float inc)
	{
		x += inc;
	}
	
	public void incY(float inc)
	{
		y += inc;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
}
