package Spotpack.mods.impl;

import Spotpack.gui.hud.ScreenPosition;
import Spotpack.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class ModFPS extends ModDraggable {
   public int getWidth() {
      return 40;
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public void render(ScreenPosition pos) {
      this.font.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS(), (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
   }
}
