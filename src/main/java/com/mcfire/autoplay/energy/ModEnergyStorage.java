package com.mcfire.autoplay.energy;

import net.minecraftforge.energy.EnergyStorage;

public abstract class ModEnergyStorage extends EnergyStorage {
    public ModEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }
    @Override
    public int extractEnergy(int maxExtract, boolean simulate) { // decrease energy
        int extractEnergy=super.extractEnergy(maxExtract, simulate);
        if(extractEnergy!=0) onEnergyChange();
        return extractEnergy;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) { // increase energy
        int receiveEnergy=super.receiveEnergy(maxReceive, simulate);
        if(receiveEnergy!=0) onEnergyChange();
        return receiveEnergy;
    }

    public void setEnergy(int energy){
        this.energy=energy;
    }

    public abstract void onEnergyChange();
}
