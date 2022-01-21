//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2020 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: RampBlock
// Model Creator: 
// Created on: 04.11.2020 - 19:23:08
// Last changed on: 04.11.2020 - 19:23:08

package fr.luffyerrot.universia.Model;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class RampBlock extends ModelVehicle
{
	ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[1];

	int textureX = 64;
	int textureY = 32;

	public RampBlock() //Same as Filename
	{
		bodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 0

		bodyModel[0].addShapeBox(0F, 0F, 0F, 16, 16, 16, 0F, 0F, 0F, 0F, 0F, -16F, 0F, 0F, -16F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 0
		bodyModel[0].setRotationPoint(0F, 0F, 0F);



		translateAll(0F, 0F, 0F);


		flipAll();
	}
	
	public void renderAll() {
		bodyModel[0].render(0.0625F);
	}
}
