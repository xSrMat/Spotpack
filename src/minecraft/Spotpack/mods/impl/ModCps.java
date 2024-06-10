package Spotpack.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import Spotpack.gui.hud.ScreenPosition;
import Spotpack.mods.ModDraggable;

public class ModCps extends ModDraggable {
   private List<Long> clicks = new ArrayList();
   private boolean wasPressed;
   private long lastPressed;
   private List<Long> clicks2 = new ArrayList();
   private boolean wasPressed2;
   private long lastPressed2;
   String text = "" + this.getCPS();

   public int getWidth() {
      return 55;
   }

   public int getHeight() {
      return this.font.FONT_HEIGHT;
   }

   public void render(ScreenPosition pos) {
      boolean lpressed = Mouse.isButtonDown(0);
      boolean rpressed = Mouse.isButtonDown(1);
      if (lpressed != this.wasPressed) {
         this.lastPressed = System.currentTimeMillis() + 10L;
         this.wasPressed = lpressed;
         if (lpressed) {
            this.clicks.add(this.lastPressed);
         }
      }

      if (rpressed != this.wasPressed2) {
         this.lastPressed2 = System.currentTimeMillis() + 10L;
         this.wasPressed2 = rpressed;
         if (rpressed) {
            this.clicks2.add(this.lastPressed2);
         }
      }

      this.font.drawStringWithShadow("[CPS: " + this.getCPS() + " | " + this.getCPS2() + "]", (float)(pos.getAbsoluteX() + 1), (float)(pos.getAbsoluteY() + 1), -1);
   }

   public void renderDummy(ScreenPosition pos) {
      this.font.drawStringWithShadow("[CPS: " + this.getCPS() + " | " + this.getCPS2() + "]", (float)(pos.getAbsoluteX() + 1), (float)(pos.getAbsoluteY() + 1), -1);
   }

   private int getCPS() {
      long time = System.currentTimeMillis();
      this.clicks.removeIf((aLong) -> {
         return aLong + 1000L < time;
      });
      return this.clicks.size();
   }

   private int getCPS2() {
      long time2 = System.currentTimeMillis();
      this.clicks2.removeIf((aLong2) -> {
         return aLong2 + 1000L < time2;
      });
      return this.clicks2.size();
   }
}
