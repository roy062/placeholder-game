package com.placeholder;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GameScreen extends Screen
{
	private Actor player;
	private Coordinate cameraPos;
	private static final Color PLAYER_COLOR = new Color(255, 0, 0);
	private static final Color GROUND_COLOR = new Color(0, 255, 0);
	private static final float WALK_SPEED = 0.1f;
	private static final float RUN_MOD = 2.0f;

	public GameScreen(PlaceholderGame host)
	{
		super(host);
		player = new Actor(310, 400);
		cameraPos = new Coordinate(0, 0);
	}
	
	@Override
	public void update(GameContainer gc, int i) {
		// TODO Auto-generated method stub
		cameraPos.incX(i / 1000.0f);
		float speedMod = 1.0f;
		if (input.isKeyDown(Input.KEY_LSHIFT))
				speedMod = RUN_MOD;
		if (input.isKeyDown(Input.KEY_D))
		{
			player.setXVel(WALK_SPEED * speedMod);
		}
		if (input.isKeyDown(Input.KEY_A))
		{
			player.setXVel(-1 * WALK_SPEED * speedMod);
		}
		player.update(i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		// Render player
		g.setColor(PLAYER_COLOR);
		g.fillRect(player.getX() - cameraPos.getX(), player.getY() - cameraPos.getY(), 20, 40);
		g.setColor(GROUND_COLOR);
		g.fillRect(0,  440,  640,  20);
	}

}
