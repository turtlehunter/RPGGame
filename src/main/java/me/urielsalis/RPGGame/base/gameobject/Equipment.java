package me.urielsalis.RPGGame.base.gameobject;

import me.urielsalis.RPGGame.base.gameobject.item.EquippableItem;

public class Equipment {
    private EquippableItem[] items;
    private Inventory inv;

    public Equipment(Inventory inv) {
        items = new EquippableItem[EquippableItem.NUM_SLOTS];
        this.inv = inv;
    }

    public boolean equip(EquippableItem item) {
        int index = item.getSlot();

        if (items[index] != null && !deEquip(index)) return false;

        inv.remove(item);
        items[index] = item;
        return true;
    }

    public boolean deEquip(int slot) {
        //Take current index and send it to the inventory
        if(inv.add(items[slot])) {
            items[slot] = null;
            return true;
        }
        return false;
    }
}
