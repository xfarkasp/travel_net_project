package com.example.demo.game;

import java.util.*;
import com.example.demo.characters.Knight;
import com.example.demo.characters.Ogre;


// Strategy: differnet strategies of setting up a game
public interface GameSetup {
	void setup(List<Knight> knights, List<Ogre> ogres, int nKnights, int nBraveKnights, int nBadOgres);
}
