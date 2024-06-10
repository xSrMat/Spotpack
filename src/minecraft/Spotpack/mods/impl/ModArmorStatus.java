package Spotpack.mods.impl;

import org.lwjgl.opengl.GL11;

import Spotpack.gui.hud.ScreenPosition;
import Spotpack.mods.ModDraggable;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModArmorStatus extends ModDraggable {
   public int getWidth() {
      return 45;
   }

   public int getHeight() {
      return 64;
   }

   public void render(ScreenPosition pos) {
      for(int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
         ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
         this.renderItemStack(pos, i, itemStack);
      }

   }

   public void renderDummy(ScreenPosition pos) {
      String s = "ArmorStatus";
      this.font.drawStringWithShadow(s, (float)(this.getWidth() / 2 + 1 - this.font.getStringWidth(s) / 2 + pos.getAbsoluteX()), (float)(pos.getAbsoluteY() + 55 + 13), 16777215);
      this.renderItemStack(pos, 3, new ItemStack(Items.diamond_helmet));
      this.renderItemStack(pos, 2, new ItemStack(Items.diamond_chestplate));
      this.renderItemStack(pos, 1, new ItemStack(Items.diamond_leggings));
      this.renderItemStack(pos, 0, new ItemStack(Items.diamond_boots));
   }

   private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
      if (is != null) {
         GL11.glPushMatrix();
         int yAdd = -16 * i + 48;
         if (is.getItem().isDamageable()) {
            double damage = (double)is.getMaxDamage() / (double)is.getMaxDamage() * 100.0D;
            this.font.drawStringWithShadow("%" + String.format("%.0f", damage), (float)(pos.getAbsoluteX() + 20), (float)(pos.getAbsoluteY() + yAdd + 5), -1);
         }

         RenderHelper.enableGUIStandardItemLighting();
         this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
         GL11.glPopMatrix();
      }
   }
}
