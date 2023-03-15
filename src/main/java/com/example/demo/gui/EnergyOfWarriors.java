package com.example.demo.gui;

import com.example.demo.game.ClashFollower;
import com.example.demo.game.Game;
import javafx.scene.control.*;

public class EnergyOfWarriors extends TextField implements ClashFollower {
	private Game game;
	private int energy;

	public EnergyOfWarriors(Game game) {
		super();
		this.game = game;
	}
	
	public void inform() {
		energy = game.knightsEnergy() + game.ogresEnergy();
		setText(Integer.toString(energy));
	}
}
