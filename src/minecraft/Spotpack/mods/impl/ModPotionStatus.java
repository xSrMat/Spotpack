package Spotpack.mods.impl;

import java.util.Collection;
import java.util.Iterator;

import Spotpack.gui.hud.ScreenPosition;
import Spotpack.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class ModPotionStatus extends ModDraggable {
   protected FontRenderer fontRendererObj;
   protected float zLevelFloat;
   int offset = 13;

   public int getX() {
      return this.pos.getAbsoluteX();
   }

   public int getWidth() {
      return 101;
   }

   public int getHeight() {
      return 154;
   }

   public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer worldrenderer = tessellator.getWorldRenderer();
      worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
      worldrenderer.pos((double)(x + 0), (double)(y + height), (double)this.zLevelFloat).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + height) * f1)).endVertex();
      worldrenderer.pos((double)(x + width), (double)(y + height), (double)this.zLevelFloat).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + height) * f1)).endVertex();
      worldrenderer.pos((double)(x + width), (double)(y + 0), (double)this.zLevelFloat).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + 0) * f1)).endVertex();
      worldrenderer.pos((double)(x + 0), (double)(y + 0), (double)this.zLevelFloat).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + 0) * f1)).endVertex();
      tessellator.draw();
   }

   public void render(ScreenPosition pos) {
      int offsetX = 21;
      int offsetY = 14;
      boolean i = true;
      int i2 = 16;
      Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();
      if (!collection.isEmpty()) {
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableLighting();
         int l = 33;
         if (collection.size() > 5) {
            l = 132 / (collection.size() - 1);
         }

         for(Iterator var9 = this.mc.thePlayer.getActivePotionEffects().iterator(); var9.hasNext(); i2 += l) {
            PotionEffect potioneffect = (PotionEffect)var9.next();
            Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            if (potion.hasStatusIcon()) {
               Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
               int i1 = potion.getStatusIconIndex();
               this.drawTexturedModalRect(pos.getAbsoluteX() + offsetX - 20, pos.getAbsoluteY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
            }

            String s1 = I18n.format(potion.getName());
            if (potioneffect.getAmplifier() == 1) {
               s1 = s1 + " " + I18n.format("enchantment.level.2");
            } else if (potioneffect.getAmplifier() == 2) {
               s1 = s1 + " " + I18n.format("enchantment.level.3");
            } else if (potioneffect.getAmplifier() == 3) {
               s1 = s1 + " " + I18n.format("enchantment.level.4");
            }

            this.font.drawString(s1, (float)(pos.getAbsoluteX() + offsetX), (float)(pos.getAbsoluteY() + i2 - offsetY), 16777215, true);
            String s = Potion.getDurationString(potioneffect);
            this.font.drawString(s, (float)(pos.getAbsoluteX() + offsetX), (float)(pos.getAbsoluteY() + i2 + 10 - offsetY), 8355711, true);
         }
      }

   }

   public void renderDummy(ScreenPosition pos) {
      String s = "Potion Status";
      this.font.drawStringWithShadow(s, (float)(this.getWidth() / 2 - this.font.getStringWidth(s) / 2 + pos.getAbsoluteX()), (float)(pos.getAbsoluteY() - 25 + this.offset), 16777215);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
