package com.placeholder;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class TitleScreen extends Screen
{
	private int cursorPos;
	private float cursorAnimPos;
	private int inputDelay;
	private int lastKeyPressed;
	private final static Color TEXT_COLOR = new Color(255, 255, 255);
	private final static Color CURSOR_COLOR = new Color(128, 128, 255, 128);
	private final static int defaultDelay = 750;
	
	public TitleScreen(PlaceholderGame host)
	{
		super(host);
		cursorPos = 0;
		cursorAnimPos = 400;  
		lastKeyPressed = 0;
	}
	
	@Override
	public void update(GameContainer gc, int i) {
		// Reset input delay if last key pressed has been released
		if (!input.isKeyDown(lastKeyPressed))
			lastKeyPressed = 0;
		if (input.isKeyDown(Input.KEY_W) && canPress(Input.KEY_W))
		{
			cursorPos += 3;
			cursorPos %= 2;
			inputDelay = defaultDelay;
			lastKeyPressed = Input.KEY_W;
		}
		if (input.isKeyDown(Input.KEY_S) && canPress(Input.KEY_S))
		{
			cursorPos++;
			cursorPos %= 2;
			inputDelay = defaultDelay;
			lastKeyPressed = Input.KEY_S;
		}
		if (input.isKeyDown(Input.KEY_SPACE))
		{
			switch (cursorPos)
			{
			// Start game
			case 0:
				host.setScreen(new GameScreen(host));
				break;
			}
		}
		if (inputDelay > 0);
			inputDelay -= i;
		
		cursorAnimPos += ((cursorPos * 40 + 400) - cursorAnimPos) / (100);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(TEXT_COLOR);
		g.drawString("Start game", 10, 400);
		g.drawString("Options", 10, 440);
		g.setColor(CURSOR_COLOR);
		g.fillRect(10, cursorAnimPos, 100, 18);
	}
	
	private boolean canPress(int key)
	{
		return inputDelay <= 0 || lastKeyPressed != key;
	}
}
