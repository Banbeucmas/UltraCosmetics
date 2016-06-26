package be.isach.ultracosmetics.cosmetics.pets;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.MushroomCow;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.UUID;

/**
 * Created by ataranlen on 6/26/2016.
 */
public class PetMooshroom extends Pet {
    Random r = new Random();

    public PetMooshroom(UUID owner) {
        super(owner, PetType.MOOSHROOM);
    }

    @Override
    protected void onUpdate() {
        final Item ITEM = entity.getWorld().dropItem(((MushroomCow) entity).getEyeLocation(), ItemFactory.create(Material.RED_MUSHROOM, (byte) 0, UUID.randomUUID().toString()));
        ITEM.setPickupDelay(30000);
        ITEM.setVelocity(new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2.0 + 0.3, r.nextDouble() - 0.5).multiply(0.4));
        Bukkit.getScheduler().runTaskLater(UltraCosmetics.getInstance(), new Runnable() {
            @Override
            public void run() {
                ITEM.remove();
            }
        }, 5);
    }
}
