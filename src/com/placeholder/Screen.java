package com.placeholder;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public abstract class Screen
{
	protected PlaceholderGame host;
	protected VarContainer varContainer;
	protected Input input;
	
	public Screen(PlaceholderGame host)
	{
		this.host = host;
	}
	
	protected final void changeScreen(Screen screen)
	{
		host.setScreen(screen);
	}
	
	public abstract void update(GameContainer gc, int i);
	
	public abstract void render(GameContainer gc, Graphics g);
	
	// Initialization code specific to each screen that depends on the VarContainer should go here
	public void passVarContainer(VarContainer vc)
	{
		varContainer = vc;
	}
	
	public void passInput(Input i)
	{
		input = i;
	}
}
