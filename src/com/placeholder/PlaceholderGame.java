package com.placeholder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class PlaceholderGame extends BasicGame
{
	private Input input;
	private Screen curScreen;
	private VarContainer varContainer;
	
	public PlaceholderGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException
	{
		input = gc.getInput();
		varContainer = new VarContainer();
		setScreen(new TitleScreen(this));
		curScreen.passVarContainer(varContainer);
	}


	@Override
	public void update(GameContainer gc, int i) throws SlickException
	{
		curScreen.update(gc, i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		curScreen.render(gc, g);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new PlaceholderGame("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(PlaceholderGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setScreen(Screen screen)
	{
		curScreen = screen;
		curScreen.passVarContainer(varContainer);
		curScreen.passInput(input);
	}
}