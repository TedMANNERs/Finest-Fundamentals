package com.binarytenshi.fundamentals.blocks;

import java.util.ArrayList;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.Fundamentals;
import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.RenderIds;
import com.binarytenshi.fundamentals.lib.Strings;
import com.binarytenshi.fundamentals.tileentity.TileEntityDistillery;

import cpw.mods.fml.common.network.FMLNetworkHandler;

/**
 * Basic tool which splits {@link Molecule}s into {@link Element}s with
 * temperature
 * 
 * @author BinaryTENSHi
 */
public class BlockDistillery extends FundamentalsBlock implements ITileEntityProvider {

    public BlockDistillery(int id, Material material) {
        super(id, material);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + BlockInfo.DISTILLERY_UNLOCALIZED_NAME);
    }

    @Override
    public void addStacksDroppedOnBlockBreak(TileEntity tileEntity, ArrayList<ItemStack> stackList) {
        TileEntityDistillery distillery = (TileEntityDistillery) tileEntity;

        for (int slot = 0; slot < distillery.getSizeInventory(); slot++) {
            ItemStack itemStack = distillery.getStackInSlot(slot);

            if (itemStack != null) {
                stackList.add(itemStack);
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityDistillery();
    }

    @Override
    public int getRenderType() {
        return RenderIds.distillery;
    }

    @Override
    public String getUnlocalizedName() {
        StringBuilder unlocalizedName = new StringBuilder();

        unlocalizedName.append("tile.");
        unlocalizedName.append(Strings.RESOURCE_PREFIX);
        unlocalizedName.append(BlockInfo.DISTILLERY_UNLOCALIZED_NAME);

        return unlocalizedName.toString();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity entity = world.getBlockTileEntity(x, y, z);

            if (entity == null || player.isSneaking()) {
                return false;
            }

            FMLNetworkHandler.openGui(player, Fundamentals.instance, 0, world, x, y, z);
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        super.onBlockPlacedBy(world, x, y, z, entity, itemstack);

        int facing = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, facing, 2);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
        setBlockBounds(0, 0, 0, 1, .81f, 1);
    }
}
