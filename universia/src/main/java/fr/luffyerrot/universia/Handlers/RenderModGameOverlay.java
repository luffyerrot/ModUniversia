package fr.luffyerrot.universia.Handlers;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class RenderModGameOverlay extends RenderGameOverlayEvent{

	public RenderModGameOverlay(float partialTicks, ScaledResolution resolution) {
		super(partialTicks, resolution);
	}

	public static enum ElementType
    {
        JOB;
    }
}
