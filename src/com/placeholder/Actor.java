package com.placeholder;

public class Actor
{
	private Coordinate coord;
	private float xVel;
	private float yVel;
	private static final float FRICTION = 0.001f;
	
	public Actor()
	{
		coord = new Coordinate(0, 0);
		xVel = 0;
		yVel = 0;
	}
	
	public Actor(float x, float y)
	{
		coord = new Coordinate(x, y);
		xVel = 0;
		yVel = 0;
	}
	
	public float getX()
	{
		return coord.getX();
	}
	
	public float getY()
	{
		return coord.getY();
	}
	
	public void setX(float x)
	{
		coord.setX(x);
	}
	
	public void setY(float y)
	{
		coord.setY(y);
	}
	
	public void setXVel(float xVel)
	{
		this.xVel = xVel;
	}
	
	public void setYVel(float yVel)
	{
		this.yVel = yVel;
	}
	
	public void incX(float inc)
	{
		coord.incX(inc);
	}
	
	public void incY(float inc)
	{
		coord.incY(inc);
	}
	
	public void setPos(float x, float y)
	{
		coord.setX(x);
		coord.setY(y);
	}
	
	public void setPos(Coordinate newPos)
	{
		coord.setX(newPos.getX());
		coord.setY(newPos.getY());
	}
	
	public void update(int i)
	{
		coord.incX(xVel * i);
		coord.incY(yVel * i);
		
		// Apply friction
		if (xVel > FRICTION * i)
		{
			xVel -= FRICTION * i;
		}
		else if (xVel < -1 * FRICTION * i)
		{
			xVel += FRICTION * i;
		}
		else
			xVel = 0;
	}
}
